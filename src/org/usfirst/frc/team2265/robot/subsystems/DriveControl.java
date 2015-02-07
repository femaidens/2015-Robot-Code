package org.usfirst.frc.team2265.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.CANTalon;

/**
 *
 */
 
public class DriveControl extends PIDSubsystem {
	// Subsystem devices
	// makes a comment
	public CANTalon frontLeft;
	public CANTalon rearLeft;
	public CANTalon frontRight;
	public CANTalon rearRight; 
	
	

	public DriveControl(){
		super("PID", 7.0, 0.0, 8.0, 0.0);			// The three doubles are the PID values, need to test for them later
		setAbsoluteTolerance(0.2);					// Need to test for value
		getPIDController().setContinuous(true);		// Always run PID
		
		// Allows us to test for PID and F values
		// should be 'isTest' not isSimulation
		//if (Robot.isTest()) { 						
		//	getPIDController().setPID(0.5, 0.001, 2, 0.0);
		//	setAbsoluteTolerance(5);
		//}
	}
	
	// Allows LiveWindow to be used with components
	// LiveWindow.addActuator("DriveControl", "DriveControlController", getPIDController());		
	// LiveWindow has to do with testing on the SmartDashboard
	// LiveWindow.addActuator("drivetrain", "Drivetrain", Robot.drivetrain.getPIDController());
	
	//Puts the PID Controller on the subsystem for testing PID (and f) values
    //  LiveWindow.addActuator("DriveControl", "FrontLeft", frontLeft);
	// LiveWindow.addActuator("DriveControl", "PID Controller", getPIDController());
	
	//LiveWindow.addActuator (String subsystem, String name, LiveWindowSendable component)
	//LiveWindow.addActuator("DriveControl", "PIDSubsystem Controller", getPIDController());
	//LiveWindow.addActuator("Pivot", "PIDSubsystem Controller", getPIDController());
    //LiveWindow.addActuator("Wrist", "PID", getPIDController());



    // No default commands
    public void initDefaultCommand() {}	   
    
    protected double returnPIDInput() {
    	return frontLeft.getOutputVoltage();
	}
    
	//Sets the motor speed based off of the PID output
	protected void usePIDOutput(double output){
		frontLeft.pidWrite(output);
		rearLeft.pidWrite(output);
		frontRight.pidWrite(output);
		rearRight.pidWrite(output);
	}

	/* @Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return 0;
	} */
  
}