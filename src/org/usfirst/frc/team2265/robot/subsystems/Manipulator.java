package org.usfirst.frc.team2265.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * The Manipulator subsystem is for the piston which will change the size of the forklift
 * to fit either the bin or tote. The extend(), retract(), and off() methods
 * are for controlling the piston.
 */
public class Manipulator extends Subsystem {
	//Subsystem device
	private DoubleSolenoid piston;

	public Manipulator() {
		piston = new DoubleSolenoid(1, 2); //ADD PORTS
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
	@Override protected void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

