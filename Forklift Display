package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Timer;

public class ForkliftDisplay extends JFrame
{
  private Ultrasonic ultrasonicSensor = new Ultrasonic(1,2); //add ports
  private Timer clock = new Timer();
  
  public static void ForkliftDiplay()
  {
    clock.start();
    
    while (true)
    {
      setLevel();
    }
  }
  
  public void setLevel()
  {
    SmartDashboard.putNumber("Forklift Level", ultrasonicSensor.getRangeInches());
    //we do not know how tall the forklift is so the inches will be 
    //configured to the numerical level on the Smart Dashboard
    clock.delay(1.0);
  }
}
