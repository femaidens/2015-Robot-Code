package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousTwoTotes extends CommandGroup {
    
    public  AutonomousTwoTotes() {
    	addSequential(new ForkliftHome());
    	addSequential(new ForkliftUp());
    	addSequential(new AutonomousForward());
    	//AutonomousLeftStrafe goes for 40 encoder clicks, not 25!!
    	addSequential(new AutonomousLeftStrafe());
    	addSequential (new AutonomousBackwards());
    	addSequential(new ForkliftHome());
    	addSequential(new ForkliftUp());
      	addSequential (new AutonomousForward());
    	/*addSequential(new ForkliftHome());
    	addSequential(new AutonomousRightStrafe());
    	addSequential(new ForkliftUp());
    	addSequential(new AutonomousBackwards());
    	addSequential(new AutonomousBackwards());
    	addSequential(new ForkliftHome());
    	addSequential(new ForkliftUp());
    	addSequential(new AutonomousForward());
    	addSequential(new AutonomousForward());
    	*/

    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
