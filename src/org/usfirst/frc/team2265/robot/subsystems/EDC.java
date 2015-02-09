package org.usfirst.frc.team2265.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */

public class EDC extends Subsystem {
 /* point at which exp function becomes log function! */
 private final double CROSSOVER = 0.5;
 
 /* base of log function 
  * higher base makes gentler average rate of change */
  private final double BASE = 10; 
    
 /* create Joystick leftJoy */
  Joystick driveJoy; 
  
  public EDC(){
  }
 
 /* change of base formula for log function*/
 private double logN(double base, double n){
  return Math.log(n)/Math.log(base);
  }
 
 /* method converts y-value to drive value */
 public double convertDriveVal(){
  
   /* get y-value of given joystick and intialize driveVal */ 
   //double yVal = leftJoy.getY();
  double yVal = driveJoy.getRawAxis(2);
  double driveVal = 1; // TODO this might not be correct
     
   /* return 0 when joystick isn't moving */
   if (yVal == 0){
     return 0.0;
   }
     
   /* convert y-value to positive by making it the absolute value */
   double y = Math.abs(yVal);
     
   /* convert to drive value with f(x) = log(b, 1-c+x)*/
   if ( y >= CROSSOVER ){
     double h = (1 - CROSSOVER) / (this.logN(BASE, 2 - CROSSOVER));
     driveVal = this.logN(BASE, y + 1 - CROSSOVER) * h + CROSSOVER; 
   }
     
   /* y value between 0 and 0.5, convert with f(x) = (b^c-1)h+c */
   else if ( y < CROSSOVER && y > 0 ){
     double h = this.logN(BASE, CROSSOVER + 1) / CROSSOVER;
     driveVal = Math.pow(BASE, (y * h)) - 1;
   }
   
   /* make drive value negative if y-value was originally negative */
   else if( yVal < 0 ){
     driveVal = driveVal * -1;
   }
    return driveVal;
 }

 public void initDefaultCommand() {
   // Set the default command for a subsystem here.
   //setDefaultCommand(new MySpecialCommand());
 }
}