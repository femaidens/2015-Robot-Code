package org.usfirst.frc.team2265.robot.subsystems;

//import edu.wpi.first.wpilibj.*;
//import java.lang.reflect.Array;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;


//import edu.wpi.first.wpilibj.PIDController;

/**
 *
 */

public class DriveControl extends PIDSubsystem {
	// Subsystem devices
	// makes comment
	public CANTalon frontLeft;
	public CANTalon rearLeft;
	public CANTalon frontRight;
	public CANTalon rearRight;
	public Gyro gyroscope;
	public Joystick driveJoystick;

	public DriveControl() {
		super("DriveControl", 7.0, 0.0, 8.0, 0.0); // The three doubles are the
													// PID values, need to test
													// for them later
		setAbsoluteTolerance(0.2);
		// getPIDController().setPID(0.05, 0, 0, 0); // Need to test for value
		getPIDController().setContinuous(true); // Always run PID
		getPIDController().setSetpoint(driveJoystick.getRawAxis(4));
		// Allows LiveWindow to be used with components
		// Puts the PID Controller on the subsystem for testing PID (and f)
		// values
		LiveWindow.addActuator("DriveControl", "PID Controller", getPIDController());
		
		/* frontLeft.set(driveJoystick.getRawAxis(4));
		rearLeft.set(driveJoystick.getRawAxis(4));
		frontRight.set(driveJoystick.getRawAxis(4));
		rearRight.set(driveJoystick.getRawAxis(4)); */
		

		// Allows us to test for PID and F values
		// should be 'isTest' not isSimulation
		/*
		 * if (Robot.isTest()) { getPIDController().setPID(0.5, 0.001, 2, 0.0);
		 * setAbsoluteTolerance(5); }
		 */
	}
	
	// No default commands
	public void initDefaultCommand() {
	}

	protected double returnPIDInput() {
		System.out.println(gyroscope.pidGet());
		return gyroscope.pidGet();
		
	/*	double[] outputVoltage = new double[4];
		outputVoltage[1] = frontLeft.getOutputVoltage();
		outputVoltage[2] = rearLeft.getOutputVoltage();
		outputVoltage[3] = frontRight.getOutputVoltage();
		outputVoltage[4] = rearRight.getOutputVoltage();
		return outputVoltage; */
		
		/*
		 * return rearLeft.getOutputVoltage(); return
		 * frontRight.getOutputVoltage(); return rearRight.getOutputVoltage();
		 */
	}

	// Sets the motor speed based off of the PID output
	protected void usePIDOutput(double output) {
		frontLeft.pidWrite(output);
		rearLeft.pidWrite(output);
		frontRight.pidWrite(output);
		rearRight.pidWrite(output);
	}

	/*
	 * @Override protected double returnPIDInput() { // TODO Auto-generated
	 * method stub return 0; }
	 */

}