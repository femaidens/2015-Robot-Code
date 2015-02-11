package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.RobotMap;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
  
public class AutoDriver extends Subsystem {
	//creation of talon motors, mecDrive, and gyroscope
	public CANTalon frontLeft = new CANTalon(RobotMap.frontLeftPort);
	public CANTalon rearLeft = new CANTalon(RobotMap.rearLeftPort);
	public CANTalon frontRight = new CANTalon(RobotMap.frontRightPort);
	public CANTalon rearRight = new CANTalon(RobotMap.rearRightPort);
	RobotDrive autonDrive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
	Gyro gyroscope = new Gyro(RobotMap.gyroPort);
	Encoder frontLeftEnco = new Encoder(RobotMap.frontLeftEncoPortOne, RobotMap.frontLeftEncoPortTwo);
	Encoder frontRightEnco = new Encoder(RobotMap.frontRightEncoPortOne, RobotMap.frontRightEncoPortTwo);
	Encoder rearLeftEnco = new Encoder(RobotMap.rearLeftEncoPortOne, RobotMap.rearLeftEncoPortTwo);
	Encoder rearRightEnco = new Encoder(RobotMap.rearRightEncoPortOne, RobotMap.rearRightEncoPortTwo);
	public int frontLeftEnCount = frontLeftEnco.getRaw();
	public int frontRightEnCount = frontRightEnco.getRaw();
	

	// Put methods for controlling this subsystem here. Call these from Commands.
	public void driveForward() {
		autonDrive.mecanumDrive_Cartesian(0, 0.75, 0, gyroscope.getAngle());
		frontRightEnCount = frontRightEnco.getRaw();
		frontLeftEnCount = frontLeftEnco.getRaw();
	}
	// Put methods for controlling this subsystem here. Call these from Commands.
	public void driveRight() {
		autonDrive.mecanumDrive_Cartesian(0.75, 0, 0, gyroscope.getAngle());
		frontRightEnCount = frontRightEnco.getRaw();
		frontLeftEnCount = frontLeftEnco.getRaw();
	}
	// Put methods for controlling this subsystem here. Call these from Commands.
	public void driveLeft() {
		autonDrive.mecanumDrive_Cartesian(-0.75, 0, 0, gyroscope.getAngle());
		frontRightEnCount = frontRightEnco.getRaw();
		frontLeftEnCount = frontLeftEnco.getRaw();
	}

	public void initDefaultCommand() {
		//the default command that is used when MecanumDrive is initialized; it just shuts off all the motors.
	}
}