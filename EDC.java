/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* VARIABLE NAMES:
 * b = base
 * c = crosspoint
 * h = vertical dilation of exp function 
 * k = vertical dilation of log function
 */

import edu.wpi.first.wpilibj.Joystick;
import java.lang.Math;

public class EDC{
  private final double CROSSOVER = 0.5;
  private final double BASE = 10;
  
  private double logN(double base, double n){
   return Math.log(n)/Math.log(base);
  }

  public double convertDriveVal(double yValue){
    // get y-value of given joystick and intialize driveVal
    double yVal = yValue;
    double driveVal;
    
    //return 0 when joystick isn't moving
    if (yVal == 0){
      return 0.0;
    }
    
    //convert y-value to positive by making it the absolute value
    double y = Math.abs(yVal);
    
    //convert to drive value with f(x) = log(b, 1-c+x)
    if ( y >= CROSSOVER ){
      double k = (1 - CROSSOVER) / (logN(BASE, 2 - CROSSOVER) - 1);
      driveVal = Math.log(yVal + 1 - CROSSOVER) * k + CROSSOVER; 
    }
    
    //y value between 0 and 0.5, convert with f(x) = (b^c-1)h+c
    else if ( y < CROSSOVER && y > 0 ){
      double h = (CROSSOVER) / (Math.pow(BASE, CROSSOVER) - 1);
      driveVal = (Math.pow(BASE, CROSSOVER) - 1 * h);
    }
    
    //make drive value negative if y-value was originally negative
    if( yVal < 0 ){
      driveVal = driveVal * -1;
    }
    
    return driveVal;
  }
}  
  

