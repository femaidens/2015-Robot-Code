package org.usfirst.frc.team2265.robot.subsystems;


import org.usfirst.frc.team2265.robot.Robot;


//import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
//import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.hal.CanTalonJNI;
//import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
 
public class DriveControl extends PIDSubsystem {
	// I just changed the file lOL
	// Subsystem devices
	private CANTalon frontLeft = new CANTalon(1);
	private CANTalon rearLeft = new CANTalon(2);
	private CANTalon frontRight = new CANTalon(3);
	private CANTalon rearRight = new CANTalon(4); 
	
	

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
	// LiveWindow.addActuator("DriveControl", "DriveControlController", getPIDController());		// CANTalons aren't livewindow sendable, use encoders instead?
	// LiveWindow has to do with testing on the SmartDashboard
	//LiveWindow.add
	
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
