package org.usfirst.frc.team2265.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;

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
	
	//Subsystem devices
	private Talon topMotor;
	private Talon bottomMotor;
	
	public Forklift() {
		topMotor = new Talon(1); //ADD PORTS
		bottomMotor = new Talon(2);
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
	 * no default command
	 * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
	 */
	@Override protected void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

