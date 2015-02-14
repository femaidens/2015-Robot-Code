package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.subsystems.EDC;
import org.usfirst.frc.team2265.robot.RobotMap;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
  
public class MecanumDrive extends Subsystem {
	//creation of talon motors, mecDrive, and gyroscope
	public CANTalon frontLeft = new CANTalon(RobotMap.frontLeftPort);
	public CANTalon rearLeft = new CANTalon(RobotMap.rearLeftPort);
	public CANTalon frontRight = new CANTalon(RobotMap.frontRightPort);
	public CANTalon rearRight = new CANTalon(RobotMap.rearRightPort);
	RobotDrive mecanumDrive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
	Gyro gyroscope = new Gyro(RobotMap.gyroPort);
	EDC ed = new EDC();
	
	public Joystick leftJoystick = new Joystick(RobotMap.leftJoyPort);
	public Joystick rightJoystick= new Joystick(RobotMap.rightJoyPort);
	double X;
	double Y;
	double Z;
	double driveX, driveY, driveZ;
	//double driveX = rightJoystick.getRawAxis(1);
	//double driveY = leftJoystick.getRawAxis(2);
	//double rotate = rightJoystick.getRawAxis(4);

	// Put methods for controlling this subsystem here. Call these from Commands.
	public void drive() {
		//driveX = leftJoystick.getRawAxis(1);
		//driveY = rightJoystick.getRawAxis(2);
		//rotate = rightJoystick.getRawAxis(4);
		//mecanumDrive.mecanumDrive_Cartesian(driveX, driveY, rotate, gyroscope.getAngle());
		X = leftJoystick.getX();
    	Y = ed.convertDriveVal();
    	Z = rightJoystick.getX();
    	driveX = X/-2;
    	driveY = Y/-2;
    	driveZ = Z/-2; 
    	
    	
    	//gyroscope.reset();
    	mecanumDrive.mecanumDrive_Cartesian(driveZ, driveY, driveX, gyroscope.getAngle());    	
		//mecanum cartesian drive command
	}

	public void initDefaultCommand() {
		//the default command that is used when MecanumDrive is initialized; it just shuts off all the motors.
	}
}