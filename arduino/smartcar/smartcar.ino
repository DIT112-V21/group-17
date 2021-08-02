#include <Smartcar.h>
#include <vector>
#include <MQTT.h>
#include <WiFi.h>

#ifdef __SMCE__
#include <OV767X.h>
#endif
const unsigned long PRINT_INTERVAL = 100;
unsigned long previousPrintout     = 0;
ArduinoRuntime arduinoRuntime;
BrushedMotor leftMotor(arduinoRuntime, smartcarlib::pins::v2::leftMotorPins);
BrushedMotor rightMotor(arduinoRuntime, smartcarlib::pins::v2::rightMotorPins);
DifferentialControl control(leftMotor, rightMotor);

GY50 gyroscope(arduinoRuntime, 37);
typedef GP2Y0A02 IR;
IR frontIR(arduinoRuntime, 0);
IR leftIR(arduinoRuntime, 1);
IR rightIR(arduinoRuntime, 2);
IR backIR(arduinoRuntime, 3);

const auto pulsesPerMeter = 600;
const int TRIGGER_PIN           = 6; // D6
const int ECHO_PIN              = 7; // D7
const unsigned int MAX_DISTANCE = 400;
const auto oneSecond = 1000UL;
const auto maxDistance = 400;
const auto redFrontPin = 0;
const int NORMAL_SPEED = 10; // 30% of the motor capacity

MQTTClient mqtt;
#ifndef __SMCE__
WiFiClient net;
#endif

std::vector<char> frameBuffer;

DirectionalOdometer leftOdometer{arduinoRuntime, smartcarlib::pins::v2::leftOdometerPins, []() { leftOdometer.update(); }, pulsesPerMeter};
DirectionalOdometer rightOdometer{arduinoRuntime, smartcarlib::pins::v2::rightOdometerPins, []() { rightOdometer.update(); }, pulsesPerMeter};
SmartCar car(arduinoRuntime, control, gyroscope, leftOdometer, rightOdometer);
SR04 front(arduinoRuntime, TRIGGER_PIN, ECHO_PIN, MAX_DISTANCE);

void setup(){
  
  Serial.begin(9600);
  car.setSpeed(NORMAL_SPEED); // Maintain a speed of 1.5 m/sec
  
  #ifdef __SMCE__
  Camera.begin(QVGA, RGB888, 15);
  frameBuffer.resize(Camera.width() * Camera.height() * Camera.bytesPerPixel());
  mqtt.begin("aerostun.dev", 1883, WiFi);
  // mqtt.begin(WiFi); // Will connect to localhost
  #else
  mqtt.begin(net);
  #endif
  
  if (mqtt.connect("arduino", "public", "public")) {
    mqtt.subscribe("/smartcar/control/#", 1);
    mqtt.onMessage([](String topic, String message) {
      if (topic == "/smartcar/control/throttle") {
        car.setSpeed(message.toInt());
        } else if (topic == "/smartcar/control/steering") {
          car.setAngle(message.toInt());
          } else {
            Serial.println(topic + " " + message);
            }
      });
      
      Serial.println("Mqtt connection established successfully to the broker!");
  }
}


void loop() {
  
  // Test MQTT connection to the broker
  if (mqtt.connected()) {
    
    // car movement
    //car.setSpeed(30);
    //obstacleAvoidance(); 
    
    mqtt.loop();
    const auto currentTime = millis();
    #ifdef __SMCE__
        static auto previousFrame = 0UL;
        if (currentTime - previousFrame >= 65) {
          previousFrame = currentTime;
		  		  
		  // Publish Camera data
          Camera.readFrame(frameBuffer.data());
          mqtt.publish("/smartcar/camera", frameBuffer.data(), frameBuffer.size(),false, 0);
          const auto totalDistance = String(travelledDistance());
          mqtt.publish("/smartcar/odometer", totalDistance);
          const auto distance = String(measureDistance());
          mqtt.publish("/smartcar/ultrasound/front", distance);
        }
    #endif		
      } 
  
  #ifdef __SMCE__
  // Avoid over-using the CPU if we are running in the emulator
  delay(35);
  #endif
}


// ObstacleAvoidance: stops and rotate (calls rotateOnSpot to rotate)
void obstacleAvoidance() {
  int distance = front.getDistance();
  int rotationDegree = 90;
  // Stop after moving 1 meter 
  if (distance > 0 && distance < 200){
    Serial.println("Stopping car");
    car.setSpeed(0);
    // Rotate
    rotateOnSpot(rotationDegree);
    car.setSpeed(NORMAL_SPEED);
  }
  
  Serial.print("Distance: ");
  Serial.println(front.getDistance());
}


void rotateOnSpot(int targetDegrees) {
  car.disableCruiseControl();
  int speed = smartcarlib::utils::getAbsolute(40);
  targetDegrees %= 360;
  if (!targetDegrees)
  return; 
  
  if (targetDegrees > 0) { 
    car.overrideMotorSpeed(40, -40); 
    } else {
      car.overrideMotorSpeed(-40,40);
    }
    
    const auto initialHeading = car.getHeading();
    int degreesTurnedSoFar = 0;
    
    while (abs(degreesTurnedSoFar) < abs(targetDegrees)) {
      car.update();
      auto currentHeading = car.getHeading();
      if ((targetDegrees < 0) && (currentHeading > initialHeading)) {
        currentHeading -= 360; 
        } else if ((targetDegrees > 0) && (currentHeading < initialHeading)) {
          currentHeading += 360;
        }
        degreesTurnedSoFar = initialHeading - currentHeading;
   }
   car.setSpeed(0); /* we have reached the target, so stop the car */
}
int measureDistance() {
      return front.getDistance();
}

int travelledDistance() {
      return car.getDistance();
}
