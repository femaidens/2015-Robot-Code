package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.RobotMap;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
  
public class MecanumDrive extends Subsystem {
	//creation of talon motors, mecDrive, and gyroscope
	CANTalon frontLeft = new CANTalon(RobotMap.frontLeftPort);
	CANTalon rearLeft = new CANTalon(RobotMap.rearLeftPort);
	CANTalon frontRight = new CANTalon(RobotMap.frontRightPort);
	CANTalon rearRight = new CANTalon(RobotMap.rearRightPort);
	RobotDrive mecanumDrive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
	Gyro gyroscope = new Gyro(RobotMap.gyroPort);
	
	public Joystick driveJoystick = new Joystick(RobotMap.driveJoyPort);
	double driveX = driveJoystick.getRawAxis(1);
	double driveY = driveJoystick.getRawAxis(2);
	double rotate = driveJoystick.getRawAxis(4);

	// Put methods for controlling this subsystem here. Call these from Commands.
	public void drive() {
		driveX = driveJoystick.getRawAxis(1);
		driveY = driveJoystick.getRawAxis(2);
		rotate = driveJoystick.getRawAxis(4);
		mecanumDrive.mecanumDrive_Cartesian(driveX, driveY, rotate, gyroscope.getAngle());
		//mecanum cartesian drive command
	}

	public void initDefaultCommand() {
		//the default command that is used when MecanumDrive is initialized; it just shuts off all the motors.
	}
}