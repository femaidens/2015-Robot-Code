package org.usfirst.frc.team2265.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	private final double FORKLIFTHEIGHT = 65.0;
	
	//Subsystem devices
	private DigitalInput limitSwitch;
	private Ultrasonic ultrasonicSensor;
	private Counter counter;
	private Talon topMotor;
	private Talon bottomMotor;
	
	public Forklift() {
		topMotor = new Talon(1); //ADD PORTS
		bottomMotor = new Talon(2);
		limitSwitch = new DigitalInput(1);
		counter = new Counter(limitSwitch);
		ultrasonicSensor = new Ultrasonic(1,2);
	}

	/*
	 * method used to make the forklift go up
	 * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
	 */
	public void up() {
		topMotor.set(UP);
		bottomMotor.set(UP);
	}
	
	/*
	 * method used to make the forklift go down
	 * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
	 */
	public void down() {
		topMotor.set(DOWN);
		bottomMotor.set(DOWN);
	}
	
	/*
	 * method to stop the forklift
	 * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
	 */
	public void stop() {
		topMotor.set(STOP);
		bottomMotor.set(STOP);
	}
	
	/*
	 *  method to set the forklift display on the SmartDashboard
	 * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
	 */
	public void setForkliftDisplay() {
		SmartDashboard.putNumber("Forklift Level", ((ultrasonicSensor.getRangeInches()*NUMLEVELS)/FORKLIFTHEIGHT));
	}
	
	/*
	 * 
	 */
	public boolean isSwitchSet() {
		return counter.get() > 0;
	}
	
	/*
	 * Initialize counter for limit switch.
	 */
	public void initializeCounter() {
        counter.reset();
    }

	/*
	 * no default command
	 * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
	 */
	@Override protected void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
