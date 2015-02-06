package org.usfirst.frc.team2265.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.CANTalon;

/**
 *
 */
 
public class DriveControl extends PIDSubsystem {
	// Subsystem devices
	private CANTalon frontLeft;
	private CANTalon rearLeft;
	private CANTalon frontRight;
	private CANTalon rearRight; 

	public DriveControl(){
		super("PID", 7.0, 0.0, 8.0, 0.0);			
		// The three doubles are the PID values, need to test for them later
		setAbsoluteTolerance(0.2);					
		// Need to test for values
		getPIDController().setContinuous(true);		
		// Always run PID
		
		// Allows us to test for PID and F values
		//if (!Robot.isReal() && !Robot.isSimulation()) { 						
		//	getPIDController().setPID(0.5, 0.001, 2, 0.0);
		//	setAbsoluteTolerance(5);
		//}
	}
	
    // No default commands
    public void initDefaultCommand() {}	   
    
    protected double returnPIDinput() {
    	return frontLeft.getOutputVoltage();
    }
	
	//Sets the motor speed based off of the PID output
	protected void usePIDOutput(double output){
		frontLeft.pidWrite(output);
		rearLeft.pidWrite(output);
		frontRight.pidWrite(output);
		rearRight.pidWrite(output);
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return 0;
	}
   
}
