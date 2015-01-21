package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Timer;

public class ForkliftDisplay extends JFrame
{
  private Ultrasonic ultrasonicSensor = new Ultrasonic(1,2); //add ports
  private Timer clock = new Timer();
  private final double NUMLEVELS = 5.0; //these values are open to changes
  private final double FORKLIFTHEIGHT = 65.0;
  
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
    SmartDashboard.putNumber("Forklift Level", ((ultrasonicSensor.getRangeInches()*NUMLEVELS)/FORKLIFTHEIGHT));
    clock.delay(1.0);
  }
}
