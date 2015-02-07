package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
 
/**
 * The Manipulator subsystem is for the piston which will change the size of the forklift
 * to fit either the bin or totes. The extend(), retract(), and off() methods
 * are for controlling the piston.
 */

public class Manipulator extends Subsystem {
	//Subsystem device
	DoubleSolenoid piston = new DoubleSolenoid(RobotMap.pistonPortOne, RobotMap.pistonPortTwo);
	Compressor compressor = new Compressor();
	
	/**
	 * Starts the compressor for pneumatics.
	 */
	public void start() {
		if (Robot.isReal()) {
			compressor.start();
		}
	}
	
	/**
	 * Gets the pressure of the compressor.
	 * @return 
	 */	
	public double findPressure(){
		double pressure = compressor.getCompressorCurrent();
		return pressure;
	}
	
	/*
	 * method used to extend the pistons
	 * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
	 */
	public void extend(){
		piston.set(DoubleSolenoid.Value.kForward);
	}
	
	/*
	 * method used to retract the pistons
	 * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
	 */
	public void retract(){
		piston.set(DoubleSolenoid.Value.kReverse);
	}
	
	/*
	 * method used stop piston movement through movement of air
	 * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
	 */
	public void off(){
		piston.set(DoubleSolenoid.Value.kOff);
	}
	
	/*
	 * method used check the mode of the piston
	 * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
	 */
	public Value get(){
		return piston.get();
	}

	/*
	 * no default command
	 * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
	 */
	protected void initDefaultCommand() {}
}
