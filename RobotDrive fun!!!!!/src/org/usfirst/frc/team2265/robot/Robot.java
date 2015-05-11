
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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard.*;  
import edu.wpi.first.wpilibj.CameraServer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     * 
     */
	Joystick leftJoy = new Joystick(0);
	Joystick rightJoy = new Joystick(1);
	Joystick xbox = new Joystick(2);

	double X;
	double Y;
	double Z;
	double driveX, driveY, driveZ;

	private Compressor compressor = new Compressor();
    private DoubleSolenoid Gripper = new DoubleSolenoid(0,1);
    
    public static int frontLeftPort = 1;
	public static int rearLeftPort = 2;
	public static int frontRightPort = 3;
	public static int rearRightPort = 4;
	public static int pulleyRightPort = 11;
	public static int pulleyLeftPort = 10;
	
	CANTalon frontLeft = new CANTalon(frontLeftPort);
	CANTalon rearLeft = new CANTalon(rearLeftPort);
	CANTalon frontRight = new CANTalon(frontRightPort);
	CANTalon rearRight = new CANTalon(rearRightPort);
	CANTalon pulleyLeft = new CANTalon(pulleyLeftPort);
	CANTalon pulleyRight = new CANTalon(pulleyRightPort);
	//Talon pulleyLeft = new Talon(0);
	Timer watcher= new Timer(); 
	
	RobotDrive mecanumDrive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
	
	public static int gyroPort = 0;
	Gyro gyroscope = new Gyro(gyroPort);
	DigitalInput lowerLim= new DigitalInput(0); 
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
		//gyroscope.setSensitivity(.00965);
		//gyroscope.setDeadband(.005);
		
		//compressor.start();
		
		SmartDashboard.putNumber("right throttle vals ", rightJoy.getRawAxis(3));
		
		/*CameraServer cammy= CameraServer.getInstance(); 
		cammy.setQuality(50); 
		cammy.startAutomaticCapture("cam0");  */
		//Gripper.set(DoubleSolenoid.Value.kForward);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	
    	while (isAuton && isEnabled() && isAutonomous()){
    		
    		//if(-1*rightJoy.getRawAxis(3)<=-.80){//if symbol is pos then tote side
    			stab2x();
    		//toteSide(); 
    		//}
    		//else if(-1*rightJoy.getRawAxis(3)>=.80){//if symbol is pos then tote side
    			//stabish();
    		//}
    		//System.out.println("slider "+rightJoy.getRawAxis(3));
        	//timedelay=(leftJoy.getRawAxis(3)*5)+5;
    		//toteSide();
        	/*if(-1*rightJoy.getRawAxis(3)<=-.80){//if symbol is pos then tote side
    			toteSide();
    			Timer.delay(.5);
    			turn(90);
    			forward(timedelay);
    		}
    		else if (rightJoy.getRawAxis(3)<=.8 && rightJoy.getRawAxis(3)>=-.8){
    			isAuton=false;
    			return;
    		}
    		else{
    			forward(timedelay);
    		}*/
    		isAuton = false;                     
    	}
        	/*System.out.println("before");
        	Timer.delay(timedelay);
        	System.out.println("after"); */
    		drive(0,0,0); 
    		
    }
    public void stab2x(){//finish this
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
    	
    	/*Timer.delay(1);
    	forklift(.5);
    	Timer.delay(.5);
    	forklift(0);
    	Gripper.set(DoubleSolenoid.Value.kReverse);*/
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
			//System.out.println(watcher); 
			drive(0,0,0.5);
		}
		drive(0,0,0);
    }
    public void turn(double time){
    	//angle=180;
    	watcher.start(); 
    	while (watcher.get() < time){
			System.out.println(watcher); 
			drive(0,0,-0.5);
		}
		drive(0,0,0);
    }
    
    public void toteSide(){
    	//angle=90;
    	Gripper.set(DoubleSolenoid.Value.kForward);
		Timer.delay(.5);
		forklift(.5);
		Timer.delay(.2);
		forklift(0);
    }
    public void backward(double time){
    	//angle=180;
    	watcher.start(); 
    	while (watcher.get() < time){
			System.out.println(watcher); 
			drive(0,0.7,0);
		}
		drive(0,0,0);
    }
    public void side(double time){
    	//angle=180;
    	watcher.start(); 
    	while (watcher.get() < time){
			System.out.println(watcher); 
			drive(0.3,0,0);
		}
		drive(0,0,0);
    }
    public void forward(double time){
    	//angle=180;
    	watcher.start(); 
    	while (watcher.get() < time){
			System.out.println(watcher); 
			drive(0,-0.25,0);
		}
		drive(0,0,0);
    }
    
    /**
     * This function is called periodically during operator control
     */
    public void teleopinit(){
    	angle=0;
    }
    public void teleopPeriodic() {
    	//gyroscope.reset();
    	//cam0.startCapture(); 
    	//angle=0;
    	while (isOperatorControl() && isEnabled()){
    		
    		forklift();
    		buttons();
        	
        	//System.out.println("slider"+rightJoy.getRawAxis(3));
        	//timedelay=(rightJoy.getRawAxis(3)*5)+5;
        	
        	//System.out.println("gyro vals= "+ gyroscope.getAngle());
        	SmartDashboard.putNumber("gyro vals= ", gyroscope.getAngle());
        	//System.out.println("gyro vals= "+gyroscope.getAngle());
        	//printEncVals();
        	drive();
        	//System.out.println("drive");
        	Timer.delay(.001);
    	
    	}
        
    }
    public void buttons(){

    	if (xbox.getRawButton(2)){//close
    		Gripper.set(DoubleSolenoid.Value.kForward);
    	}
    	if (xbox.getRawButton(6)){
    		gyroscope.reset();
    	}
    	if (xbox.getRawButton(3)){//open
    		Gripper.set(DoubleSolenoid.Value.kReverse);
    	}
    	
    	if (leftJoy.getRawButton(5)){
    		gyroscope.reset();		
    	}
    	if(xbox.getRawButton(4)){
    		//stabish();
    		
    	}
    	if(xbox.getRawButton(1)){
    		//Timer.delay(1);
        	//forklift(.5);
        	//Timer.delay(.5);
    		drive(0,-0.25,0);
    	}
    	
    	
    }
    /**
     * This function is called periodically during test mode
     */
    public void testinit(){
    	boolean test=true;
    }
    public void testPeriodic() {
    	/*angle=0;
    	if (xbox.getRawButton(11)){
    		pulleyRight.setPosition(0);
    		
    	}
    	drive();
    	forklift();
    	printEncVals();*/
    	///if (test==true){
    	
    	///.forklift(0);test=false;}
    	///return;
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
    	/*System.out.println("drive");
    	System.out.println("X"+X);
    	System.out.println("Y"+Y);
    	System.out.println("Z"+Z);*/
    	System.out.println("gyroscope.getAngle()= "+gyroscope.getAngle());
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
	   // SmartDashboard.putNumber("Encoder Values pl", pulleyLeft.getEncPosition());
	    SmartDashboard.putNumber("Rear Left Encoder Values", rearLeft.getEncPosition());
	    SmartDashboard.putNumber("Rear Right Encoder Values", rearRight.getEncPosition());
	    SmartDashboard.putNumber("Front Left Encoder Values", frontLeft.getEncPosition());
	    SmartDashboard.putNumber("Front Right Encoder Values", frontRight.getEncPosition());
	    
	    System.out.println();
	    System.out.println("Pulley Right Encoders: " + pulleyRight.getEncPosition());
	   // System.out.println("Pulley Left Encoders: " + pulleyLeft.getEncPosition());
	    System.out.println("Rear Left ENcoders: " + rearLeft.getEncPosition()); 
	    System.out.println("Front Left ENcoders: " + frontLeft.getEncPosition());
	    System.out.println("Rear right ENcoders: " + rearRight.getEncPosition());
	    System.out.println("Front right ENcoders: " + frontRight.getEncPosition());
	}
}
