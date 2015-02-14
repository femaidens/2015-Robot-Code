package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team2265.robot.commands.ForkliftUp;
import org.usfirst.frc.team2265.robot.commands.ForkliftDown;

/**
 *
 */
public class EncoderTest extends CommandGroup {
    
	Encoder encoder;
	
    public EncoderTest() {
        addSequential(new ForkliftUp());
        addSequential(new ForkliftDown());
        System.out.println(encoder.get());
    }
}
