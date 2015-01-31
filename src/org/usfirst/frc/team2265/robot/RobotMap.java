package org.usfirst.frc.team2265.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//joystick ports
	//public static int leftJoyPort = 1;
	//public static int rightJoyPort = 2;
	public static int driveJoyPort = 1;
	public static int atkJoyPort = 3;
	 
	//button numbers
	public static int pistonOutNum = 1;
	public static int pistonInNum = 2;
	public static int forkliftUpNum = 6;
	public static int forkliftDownNum = 7;
	
	// talon ports
	public static int frontLeftPort = 0;
	public static int rearLeftPort = 1;
	public static int frontRightPort = 2;
	public static int rearRightPort = 3;
	public static int topForkPort = 4; 
	public static int bottomForkPort = 5; 
	
	//sensor ports
	public static int gyroPort = 6;
	public static int limitSwitchPort = 0;
	public static int sonicPortOne = 7;
	public static int sonicPortTwo = 8;
	
	//solenoid/piston ports
	public static int pistonPortOne = 1;
	public static int pistonPortTwo = 2;
	
	
	
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}