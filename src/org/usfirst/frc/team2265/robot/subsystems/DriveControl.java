package org.usfirst.frc.team2265.robot.subsystems;

//import edu.wpi.first.wpilibj.*;
//import java.lang.reflect.Array;

import org.usfirst.frc.team2265.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


//import edu.wpi.first.wpilibj.PIDController;

/**
 *
 */

public class DriveControl extends PIDSubsystem {
	// Subsystem devices
	// makes comment
	public CANTalon frontLeft = new CANTalon(RobotMap.frontLeftPort);
	public CANTalon rearLeft = new CANTalon(RobotMap.rearLeftPort);
	public CANTalon frontRight = new CANTalon(RobotMap.frontRightPort);
	public CANTalon rearRight = new CANTalon(RobotMap.rearRightPort);
	public Gyro gyroscope = new Gyro(RobotMap.gyroPort);
	public Joystick driveJoystick = new Joystick(4);

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

	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	public void log() {
		//not entirely sure which of these we want, so i wanted to account for both just in case
        SmartDashboard.putNumber("Gyro PID Out", gyroscope.pidGet());
        SmartDashboard.putData("Rotation", (Gyro) gyroscope);
    }
	
	protected double returnPIDInput() {
		System.out.println(gyroscope.pidGet());
		return gyroscope.pidGet();
	}

	// Sets the motor speed based off of the PID output
	protected void usePIDOutput(double output) {
		frontLeft.pidWrite(output);
		rearLeft.pidWrite(output);
		frontRight.pidWrite(output);
		rearRight.pidWrite(output);
	}
}
