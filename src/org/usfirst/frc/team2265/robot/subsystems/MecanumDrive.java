package org.usfirst.frc.team2265.robot.subsystems;

//import org.usfirst.frc.team2265.robot.OI;
import org.usfirst.frc.team2265.robot.RobotMap;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
  
/**
 *
 */
public class MecanumDrive extends Subsystem {
	//creation of talon motors, mecDrive, and gyroscope
	TalonSRX frontLeft = new TalonSRX(RobotMap.frontLeftPort);
	TalonSRX rearLeft = new TalonSRX(RobotMap.rearLeftPort);
	TalonSRX frontRight = new TalonSRX(RobotMap.frontRightPort);
	TalonSRX rearRight = new TalonSRX(RobotMap.rearRightPort);
	RobotDrive mecDrive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
	Gyro gyroscope = new Gyro(RobotMap.gyroPort);
	
	public Joystick driveJoystick = new Joystick(1);
	double driveX = driveJoystick.getRawAxis(1);
	double driveY =driveJoystick.getRawAxis(2);
	double rotate = driveJoystick.getRawAxis(4);

	// Put methods for controlling this subsystem here. Call these from Commands.
	public void drive() {
		mecDrive.mecanumDrive_Cartesian(driveX, driveY, rotate, gyroscope.getAngle());
		//mecanum cartesian drive command
	}

	public void initDefaultCommand() {
		//the default command that is used when MecanumDrive is initialized; it just shuts off all the motors.
		frontLeft.set(0.0);
		frontRight.set(0.0);
		rearLeft.set(0.0);
		rearRight.set(0.0);
	}
}