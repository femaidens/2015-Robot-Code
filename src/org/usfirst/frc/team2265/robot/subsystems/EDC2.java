package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;

public class EDC2 extends Subsystem{
	
	/* create Joystick leftJoy */
	  Joystick leftJoy  = new Joystick(RobotMap.driveJoyPort); 
	  
	/* constructor */  
	  public EDC2(){
	  }
	 
	/* method converts y-value to drive value */
	  public double convertDriveVal(){
		  double driveVal = 1; 
		  
		  /* get y-value of given joystick and initialize driveVal */ 
		   double yVal = leftJoy.getY();
	      
		  /* return 0 when joystick isn't moving */
		  if (yVal == 0){ 
			  return 0.0; 
			  }
	      
		  /* convert y-value to positive by making it the absolute value */
		  double y = Math.abs(yVal);

		  /* convert to drive value with f(x) = 1/2(1-(1-2x)^(1/3), where x = y-val)*/
		  driveVal = 0.5 * (1 - Math.cbrt(1 - 2 * y ));
	     
		  /* make drive value negative if y-value was originally negative */ 
		  if( yVal < 0 ){ 
			  driveVal = driveVal * -1; 
			  } 
		  return driveVal; 
		  }

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
