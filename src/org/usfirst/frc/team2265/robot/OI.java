package org.usfirst.frc.team2265.robot;

import edu.wpi.first.wpilibj.buttons.Button; //These are class imports  
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team2265.robot.commands.BinMode;
import org.usfirst.frc.team2265.robot.commands.ForkliftUp;
import org.usfirst.frc.team2265.robot.commands.ForkliftDown;
import org.usfirst.frc.team2265.robot.commands.ToteMode;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

//OI's back. tell a friend.
//another random edit

public class OI {
	//public static Joystick leftJoy= new Joystick(RobotMap.leftJoyPort);
	//public static Joystick rightJoy=new Joystick(RobotMap.rightJoyPort);
	public static Joystick attackJoy = new Joystick(RobotMap.atkJoyPort);
 
	Button pistonOutButton = new JoystickButton(attackJoy, RobotMap.pistonOutNum),
		pistonInButton = new JoystickButton(attackJoy, RobotMap.pistonInNum),
		forkliftUpButton = new JoystickButton(attackJoy, RobotMap.forkliftUpNum),
		forkliftDownButton = new JoystickButton(attackJoy, RobotMap.forkliftDownNum);

	public OI (){
		pistonOutButton.whenPressed(new ToteMode());
		pistonInButton.whenPressed(new BinMode());
		forkliftUpButton.whenPressed(new ForkliftUp());
		forkliftDownButton.whenPressed(new ForkliftDown());

		//So the code is for buttons
		//

	}
}
// One type of button is a joy stick button which is any button on a joy stick.
// You create one by telling it which joy stick it's on and which button
// number it is.
// Joy stick stick = new Joy stick(port);
// Button button = new JoystickButton(stick, buttonNumber);

// There are a few additional built in buttons you can use. Additionally,
// by sub-classing Button you can create custom triggers and bind those to
// commands the same as any other Button.

//// TRIGGERING COMMANDS WITH BUTTONS
// Once you have a button, it's trivial to bind it to a button in one of
// three ways:

// Start the command when the button is pressed and let it run the command
// until it is finished as determined by it's isFinished method.
// button.whenPressed(new ExampleCommand());

// Run the command while the button is being held down and interrupt it once
// the button is released.
// button.whileHeld(new ExampleCommand());

// Start the command when the button is released  and let it run the command
// until it is finished as determined by it's isFinished method.
// button.whenReleased(new ExampleCommand());