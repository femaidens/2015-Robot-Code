package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.TalonSRX;
//import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Encoder;


/**
 * The Forklift subsystems is to move the physical forklift up and down with the pulley in order to
 * carry the totes and bins. The up(), down(), and stop() methods are for controlling
 * the motors attached to the pulley.
 */
public class Forklift extends Subsystem {
	// Constants for some useful speeds
	private static final double UP = 0.75;
	private static final double DOWN = -0.75;
	private static final double STOP = 0.0;
	private final double NUMLEVELS = 5.0; //these values are open to changes
	private final double FORKLIFTHEIGHT = 60.0;
	
	//Subsystem devices
	TalonSRX topMotor = new TalonSRX(RobotMap.topForkPort); 
	TalonSRX bottomMotor = new TalonSRX(RobotMap.bottomForkPort);
	DigitalInput limitSwitch = new DigitalInput(RobotMap.limitSwitchPort);
	Counter counter = new Counter(limitSwitch);
	Encoder encoder = new Encoder(RobotMap.encoderPortOne, RobotMap.encoderPortTwo, true, Encoder.EncodingType.k4X);
	//Ultrasonic ultrasonicSensor = new Ultrasonic(RobotMap.sonicPortOne, RobotMap.sonicPortTwo);
 
	/**
	 * Contructor to set encoder settings.
	 */
	public Forklift() {
		encoder.setMaxPeriod(.1);
		encoder.setMinRate(10);
		encoder.setDistancePerPulse(5);
		encoder.setReverseDirection(true);
		encoder.setSamplesToAverage(7);
	}
	
	/**
	 * method used to make the forklift go up
	 * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
	 */
	public void up() {
		topMotor.set(UP);
		bottomMotor.set(UP);
	}
	
	/**
	 * method used to make the forklift go down
	 * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
	 */
	public void down() {
		topMotor.set(DOWN);
		bottomMotor.set(DOWN);
	}
	
	/**
	 * method to stop the forklift
	 * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
	 */
	public void stop() {
		topMotor.set(STOP);
		bottomMotor.set(STOP);
	}
	
	/**
	 * method to set the forklift display on the SmartDashboard
	 * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
	 */
	public void setForkliftDisplay() {
		//SmartDashboard.putNumber("Forklift Level", ((ultrasonicSensor.getRangeInches()*NUMLEVELS)/FORKLIFTHEIGHT));
		SmartDashboard.putNumber("Forklift Level", ((this.getDistance()*NUMLEVELS)/FORKLIFTHEIGHT));
	}
	
	/**
	 * Check if the switch has been set by checking if the counter is above 0.
	 */
	public boolean isSwitchSet() {
		return counter.get() > 0;
	}
	
	/**
	 * Reset counter for limit switch.
	 */
	public void resetCounter() {
        	counter.reset();
	}
	
	/**
	 * Reset encoder. 
	 */
	public void resetEncoder() {
		encoder.reset();
	}
	
	/**
	 * Get distance moved from Home by encoder.
	 */
	public double getDistance() {
		return encoder.getDistance();
	}

	/**
	 * no default command
	 * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
	 */
	@Override protected void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
