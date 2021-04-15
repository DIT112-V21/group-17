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
  const long NORMAL_SPEED = 1.5;
  
  
  DirectionalOdometer leftOdometer{
    arduinoRuntime, 
    smartcarlib::pins::v2::leftOdometerPins, []() { 
      leftOdometer.update(); 
      }, 
      pulsesPerMeter};
  DirectionalOdometer rightOdometer{
    arduinoRuntime, 
    smartcarlib::pins::v2::rightOdometerPins, []() { 
      rightOdometer.update(); }, 
      pulsesPerMeter};
  
  
  
  SmartCar car(arduinoRuntime, control, gyroscope, leftOdometer, rightOdometer);
  SR04 front(arduinoRuntime, TRIGGER_PIN, ECHO_PIN, MAX_DISTANCE);
  void setup()
  {
      Serial.begin(9600);
      car.enableCruiseControl();
      car.setSpeed(NORMAL_SPEED); // Maintain a speed of 1.5 m/sec
  }
  
  void loop()
  {
     // Maintain the speed and update the heading
      car.update();
      int distance = front.getDistance();
     // car.enableCruiseControl();
      //car.disableCruiseControl();
      obstacleAvoidance(distance);
      car.enableCruiseControl();
      
  }
  
  void obstacleAvoidance(int distance){
        // Stop after moving 1 meter
      if (distance > 0 && distance< 200)
      {
          Serial.println("Stopping car");
          car.setSpeed(0);
          Serial.println("Rotating car");
      rotateOnSpot(90); // rotate clockwise 90 degrees on spot
         // car.setSpeed(NORMAL_SPEED);
      }
      Serial.println("There is an obstacle in a distance of ");
      Serial.print(front.getDistance());
      Serial.println(" Stop and rotate");
    }
  
  void rotateOnSpot(int targetDegrees) {
      int speed = smartcarlib::utils::getAbsolute(NORMAL_SPEED);
      targetDegrees %= 360; /* puts it on a (-360,360) scale */
      
      if (!targetDegrees)
          return; /* if the target degrees is 0, don't bother doing anything */
      
      /* Let's set opposite speed for the motors on opposite sides, so it rotates on spot */
      if (targetDegrees > 0) { /* positive value means we should rotate clockwise */
          car.overrideMotorSpeed(speed, -speed); /* left motors spin forward, right motors spin backward */
      } else { /* rotate counter clockwise */
          car.overrideMotorSpeed(-speed, speed); /* left motors spin backward, right motors spin forward */
      }
      
      const auto initialHeading = car.getHeading(); /* the initial heading we'll use as offset to calculate the absolute displacement */
      int degreesTurnedSoFar = 0; /* this variable will hold the absolute displacement from the beginning of the rotation */
      
      while (abs(degreesTurnedSoFar) < abs(targetDegrees)) { /* while absolute displacement hasn't reached the (absolute) target, keep turning */
          car.update(); /* update to integrate the latest heading sensor readings */
          auto currentHeading = car.getHeading(); /* in the scale of 0 to 360 */
          
          if ((targetDegrees < 0) && (currentHeading > initialHeading)) { /* if we are turning left and the current heading is larger than the initial one 
                                                                          (e.g. started at 10 degrees and now we are at 350), we need to substract 360, 
                                                                          so to eventually get a signed displacement from the initial heading (-20) */
              currentHeading -= 360; 
          } else if ((targetDegrees > 0) && (currentHeading < initialHeading)) { /* if we are turning right and the heading is smaller than the initial one 
                                                                                 (e.g. started at 350 degrees and now we are at 20), 
                                                                                 so to get a signed displacement (+30) */
              currentHeading += 360;
          }
          
          degreesTurnedSoFar = initialHeading - currentHeading; /* degrees turned so far is initial heading minus current 
                                                                (initial heading is at least 0 and at most 360. To handle the "edge" cases we substracted or added 
                                                                360 to currentHeading) */
      }
      car.setSpeed(0); /* we have reached the target, so stop the car */
  }
