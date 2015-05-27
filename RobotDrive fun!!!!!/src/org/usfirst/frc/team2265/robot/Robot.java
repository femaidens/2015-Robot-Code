package org.usfirst.frc.team2265.robot;  

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	public static int leftJoyPort = 0;
	public static int rightJoyPort = 1;
	public static int atkJoyPort = 2;
	public static int frontLeftPort = 1;
	public static int rearLeftPort = 2;
	public static int frontRightPort = 3;
	public static int rearRightPort = 4;
	public static int pulleyRightPort = 11;
	public static int pulleyLeftPort = 10;
	public static int gyroPort = 0;
	public static int lowerLimPort = 0;
	
	Joystick leftJoy = new Joystick(leftJoyPort);
	Joystick rightJoy = new Joystick(rightJoyPort);
	Joystick xbox = new Joystick(atkJoyPort);

	double X;
	double Y;
	double Z;
	double driveX, driveY, driveZ;

	private Compressor compressor = new Compressor();
    private DoubleSolenoid Gripper = new DoubleSolenoid(0,1);
    
    
	CANTalon frontLeft = new CANTalon(frontLeftPort);
	CANTalon rearLeft = new CANTalon(rearLeftPort);
	CANTalon frontRight = new CANTalon(frontRightPort);
	CANTalon rearRight = new CANTalon(rearRightPort);
	CANTalon pulleyLeft = new CANTalon(pulleyLeftPort);
	CANTalon pulleyRight = new CANTalon(pulleyRightPort);
	Timer watcher= new Timer(); 
	RobotDrive mecanumDrive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
	Gyro gyroscope = new Gyro(gyroPort);
	DigitalInput lowerLim= new DigitalInput(lowerLimPort);
	
	boolean isAuton= true;
	int angle;
	double timedelay=5;
	
	public void robotInit() {
		angle=0;
		frontLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		rearLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		frontRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		rearRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		pulleyRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		pulleyLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		
		pulleyLeft.changeControlMode(CANTalon.ControlMode.Follower); 
    	pulleyLeft.set(pulleyRight.getDeviceID());
		
		mecanumDrive.setInvertedMotor(MotorType.kFrontRight, true);
        mecanumDrive.setInvertedMotor(MotorType.kRearRight, true);
        
		gyroscope.reset();
		SmartDashboard.putNumber("right throttle vals ", rightJoy.getRawAxis(3));
    	}

	public void autonomousPeriodic() {
		while (isAuton && isEnabled() && isAutonomous()){
			stab2x();
		isAuton = false;                     
		}
		drive(0,0,0);
	}
	
	public void stab2x(){
		stab();
    	
		forklift(.5);
		Timer.delay(.2);
		forklift(0);
		Timer.delay(.5);
    	
		side(3);
    	
		Timer.delay(.5);
		forward(2.6);
		Timer.delay(1);
		stabish();
		Timer.delay(.5);
		backward(2.2);
    	
		Timer.delay(1);
		forklift(.5);
		Timer.delay(.5);
		forklift(0);
		Gripper.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void stab(){
		forward(2.3);
		Timer.delay(1);
		stabish();
		Timer.delay(.5);
		backward(2.2);
	}
	
	public void stabish(){
		forklift(-.5);
		Timer.delay(.2);
		forklift(0);
	}
    	 
	public void autonomousInit() {
		isAuton = true;
		gyroscope.reset();
	}
	
	public void turn(int degrees){
		double angle1 =(degrees+gyroscope.getAngle())%360;
		while (gyroscope.getAngle()%360 != angle1){
			drive(0,0,0.5);
		}
		drive(0,0,0);
	}
	
	public void turn(double time){
		watcher.start(); 
		while (watcher.get() < time){
			System.out.println(watcher); 
			drive(0,0,-0.5);
		}
		drive(0,0,0);
	}
    
	public void toteSide(){
		Gripper.set(DoubleSolenoid.Value.kForward);
		Timer.delay(.5);
		forklift(.5);
		Timer.delay(.2);
		forklift(0);
	}
	
	public void backward(double time){
		watcher.start(); 
		while (watcher.get() < time){
			System.out.println(watcher); 
			drive(0,0.7,0);
		}
		drive(0,0,0);
	}
	
	public void side(double time){
		watcher.start(); 
		while (watcher.get() < time){
			System.out.println(watcher); 
			drive(0.3,0,0);
		}
		drive(0,0,0);
	}
	
	public void forward(double time){
		watcher.start(); 
		while (watcher.get() < time){
			System.out.println(watcher); 
			drive(0,-0.25,0);
		}
		
		drive(0,0,0);
	}
    
	public void teleopinit(){
		angle=0;
	}
	
	public void teleopPeriodic() {
		while (isOperatorControl() && isEnabled()){
			forklift();
			buttons();
			SmartDashboard.putNumber("gyro vals= ", gyroscope.getAngle());
			drive();
			Timer.delay(.001);
		}
	}
	
	public void buttons(){
		if (xbox.getRawButton(2)){
		Gripper.set(DoubleSolenoid.Value.kForward);
		}
		
		if (xbox.getRawButton(6)){
			gyroscope.reset();
		}
		
		if (xbox.getRawButton(3)){
			Gripper.set(DoubleSolenoid.Value.kReverse);
		}
		
		if (leftJoy.getRawButton(5)){
			gyroscope.reset();		
		}
		
		if(xbox.getRawButton(1)){
			drive(0,-0.25,0);
		}
	}
	
	public void testinit() {
		boolean test = true;
	}
	
	public void testPeriodic() {
		buttons();
	}
    
	public void drive(){
		double driveX = leftJoy.getX();
		double driveY = leftJoy.getY();
		double driveZ = rightJoy.getX();
		
		double X = driveX;
		double Y= driveY/2;
		double Z = driveZ/2;
		
		drive(X, Y, Z); 
	}
	
	public void drive(double X, double Y, double Z){
		System.out.println("gyroscope.getAngle()="+gyroscope.getAngle());
		mecanumDrive.mecanumDrive_Cartesian(X, Y, Z, gyroscope.getAngle()+angle); 
	}
	
	public void forklift(){
		double c= -1*xbox.getRawAxis(1);
		if(c<0){
			c= c*.5;
		}
		if(c>0){
			c= c*.75;
		}
		forklift(c);
	}
	
	public void forklift(double c){
		pulleyRight.set(c);	
	}

	public void printEncVals(){
		SmartDashboard.putNumber("Encoder Values pr", pulleyRight.getEncPosition());
		SmartDashboard.putNumber("Rear Left Encoder Values", rearLeft.getEncPosition());
		SmartDashboard.putNumber("Rear Right Encoder Values", rearRight.getEncPosition());
		SmartDashboard.putNumber("Front Left Encoder Values", frontLeft.getEncPosition());
		SmartDashboard.putNumber("Front Right Encoder Values", frontRight.getEncPosition());
		
		System.out.println();
		System.out.println("Pulley Right Encoders: " + pulleyRight.getEncPosition());
		System.out.println("Rear Left ENcoders: " + rearLeft.getEncPosition()); 
		System.out.println("Front Left ENcoders: " + frontLeft.getEncPosition());
		System.out.println("Rear right ENcoders: " + rearRight.getEncPosition());
		System.out.println("Front right ENcoders: " + frontRight.getEncPosition());
	}
}
