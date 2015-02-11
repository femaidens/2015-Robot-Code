package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.TalonSRX;
//import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Encoder;


/**
 * The Forklift subsystems is to move the physical forklift up and down with the pulley in order to
 * carry the totes and bins. The up(), down(), and stop() methods are for controlling
 * the motors attached to the pulley.
 */
public class Forklift extends Subsystem {
	// Constants for some useful constants
	private static final double UP = 0.75;
	private static final double DOWN = -0.75;
	private static final double STOP = 0.0;
	private final int SAMPLESTOAVG = 127;
	public final double TOTEHEIGHT = 12;
	public final double BINHEIGHT = 29;
	public final double PLATHEIGHT = 2;
	
	//Subsystem devices
	public Timer clock = new Timer();
	TalonSRX topMotor = new TalonSRX(RobotMap.topForkPort); 
	TalonSRX bottomMotor = new TalonSRX(RobotMap.bottomForkPort);
	public static DigitalInput limitSwitchTop = new DigitalInput(RobotMap.limitSwitchPortTop);
	public static DigitalInput limitSwitchBottom = new DigitalInput(RobotMap.limitSwitchPortBottom);
	public static Counter counterTop = new Counter(limitSwitchTop);
	public static Counter counterBottom = new Counter(limitSwitchBottom);
	public Encoder encoder = new Encoder(RobotMap.encoderPortOne, RobotMap.encoderPortTwo, true, Encoder.EncodingType.k4X);
	//Ultrasonic ultrasonicSensor = new Ultrasonic(RobotMap.sonicPortOne, RobotMap.sonicPortTwo);
 
	/**
	 * Contructor to set encoder settings.
	 */
	public Forklift() {
		//encoder.setReverseDirection(true);
		encoder.setSamplesToAverage(SAMPLESTOAVG);
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
	public void setForkliftDisplay(int lvl) {
		//SmartDashboard.putNumber("Forklift Level", ((ultrasonicSensor.getRangeInches()*NUMLEVELS)/FORKLIFTHEIGHT));
		SmartDashboard.putNumber("Forklift Level", lvl);
	}
	
	/**
	 * Check if the switch has been set by checking if the counter is above 0.
	 */
	public boolean isSwitchSet() {
		return counterTop.get() > 0 || counterBottom.get() > 0;
	}
	
	/**
	 * Reset counter for limit switch.
	 */
	public void resetCounter() {
        	counterTop.reset();
        	counterBottom.reset();
	}
	
	/**
	 * Reset encoder. 
	 */
	public void resetEncoder() {
		encoder.reset();
	}
	
	/*
	 * 
	 */
	public void setEncoderValue() {
		SmartDashboard.putNumber("Encoder Value", encoder.get());
	}
	
	/**
	 * Get distance moved from Home by encoder.
	 */
	public double getEncoderValue() {
		return encoder.get();
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
