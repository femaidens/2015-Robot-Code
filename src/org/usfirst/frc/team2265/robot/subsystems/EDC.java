package org.usfirst.frc.team2265.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */

public class EDC extends Subsystem {
 /* point at which exp function becomes log function */
 private final double CROSSOVER = 0.5;
 
 /* base of log function 
  * higher base makes gentler average rate of change */
  private final double BASE = 10; 
    
 /* create left joystick */ 
  private final Joystick leftJoystick = new Joystick(/*insert port # */);
 
 /* change of base formula for log function */
 private double logN(double base, double n){
  return Math.log(n)/Math.log(base);
  }
 
 /* method converts y-value to drive value */
 public double convertDriveVal(double yValue){
  
   /* get y-value of given joystick and intialize driveVal */ 
   double yVal = leftJoystick.getY();
   double driveVal;
     
   /* return 0 when joystick isn't moving */
   if (yVal == 0){
     return 0.0;
   }
     
   /* convert y-value to positive by making it the absolute value */
   double y = Math.abs(yVal);
     
   /* convert to drive value with f(x) = log(b, 1-c+x)*/
   if ( y >= CROSSOVER ){
     double k = (1 - CROSSOVER) / (logN(BASE, 2 - CROSSOVER) - 1);
     driveVal = Math.log(yVal + 1 - CROSSOVER) * k + CROSSOVER; 
   }
     
   /* y value between 0 and 0.5, convert with f(x) = (b^c-1)h+c */
   else if ( y < CROSSOVER && y > 0 ){
     double h = (CROSSOVER) / (Math.pow(BASE, CROSSOVER) - 1);
     driveVal = (Math.pow(BASE, CROSSOVER) - 1 * h);
   }
     
   /* make drive value negative if y-value was originally negative */
   if( yVal < 0 ){
     driveVal = driveVal * -1;
   }
   
   return driveVal;
 }

 public void initDefaultCommand() {
   // Set the default command for a subsystem here.
   //setDefaultCommand(new MySpecialCommand());
 }
}
