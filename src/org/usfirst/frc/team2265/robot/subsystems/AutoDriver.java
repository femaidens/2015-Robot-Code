package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.RobotMap;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Timer;
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
	Timer timer = new Timer();
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
	// Put methods for controlling this subsystem here. Call these from Commands.
	private double getVelocity(double x){
	    frontLeftEnco.setDistancePerPulse(x);
	    frontRightEnco.setDistancePerPulse(x);
	    rearLeftEnco.setDistancePerPulse(x);
	    rearRightEnco.setDistancePerPulse(x);
	    
	    double velocityY1 = frontLeftEnco.getRate();
	    double velocityY2 = frontRightEnco.getRate();
	    double velocityY3 = rearLeftEnco.getRate();
	    double velocityY4 = rearRightEnco.getRate();
	    double totalVelocityY = velocityY1 + velocityY2 + velocityY3 + velocityY4;
	    
	    double velocityX1 = velocityY1 * -1;
	    double velocityX2 = velocityY2;
	    double velocityX3 = velocityY3;
	    double velocityX4 = velocityY4 * -1;
	    double totalVelocityX = velocityX1 + velocityX2 + velocityX3 + velocityX4;
	    
	    double totalVelocity = Math.pow(Math.pow(totalVelocityY, 2) + Math.pow(totalVelocityX, 2), 1/2);
	    return totalVelocity;
	  }
	
	// Put methods for controlling this subsystem here. Call these from Commands.	
	public double getDistance(double x){ //x is the number of ticks from getVelocity
		double totalVelocity = this.getVelocity(x);
		double time = timer.get();
		double totalDistance = totalVelocity * time;
		return totalDistance;
	}
	
	public void initDefaultCommand() {
		//the default command that is used when MecanumDrive is initialized; it just shuts off all the motors.
	}
}
