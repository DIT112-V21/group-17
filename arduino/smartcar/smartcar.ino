#include <Smartcar.h>

const unsigned long PRINT_INTERVAL = 100;
unsigned long previousPrintout     = 0;

ArduinoRuntime arduinoRuntime;
BrushedMotor leftMotor(arduinoRuntime, smartcarlib::pins::v2::leftMotorPins);
BrushedMotor rightMotor(arduinoRuntime, smartcarlib::pins::v2::rightMotorPins);
DifferentialControl control(leftMotor, rightMotor);

GY50 gyroscope(arduinoRuntime, 37);

const auto pulsesPerMeter = 600;
const int TRIGGER_PIN           = 6; // D6
const int ECHO_PIN              = 7; // D7
const unsigned int MAX_DISTANCE = 400;


DirectionalOdometer leftOdometer{arduinoRuntime, smartcarlib::pins::v2::leftOdometerPins, []() { leftOdometer.update(); }, pulsesPerMeter};
DirectionalOdometer rightOdometer{arduinoRuntime, smartcarlib::pins::v2::leftOdometerPins, []() { leftOdometer.update(); }, pulsesPerMeter};



SmartCar car(arduinoRuntime, control, gyroscope, leftOdometer, rightOdometer);
SR04 front(arduinoRuntime, TRIGGER_PIN, ECHO_PIN, MAX_DISTANCE);
void setup()
{
    Serial.begin(9600);
    car.enableCruiseControl();
    car.setSpeed(0.5); // Maintain a speed of 1.5 m/sec
}

void loop()
{
   // Maintain the speed and update the heading
    car.update();
    int distance = front.getDistance();
    // Stop after moving 1 meter
    if (distance != 0 && distance< 200)
    {
        Serial.println("Stopping car");
        car.setSpeed(0);
    }

    Serial.print("Distance: ");
    Serial.println(front.getDistance());
}
