package org.usfirst.frc.team2265.robot;

//These are class imports  
import edu.wpi.first.wpilibj.buttons.Button;
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
 
public class OI {
	//public static Joystick leftJoy = new Joystick(RobotMap.leftJoyPort);
	//public static Joystick rightJoy = new Joystick(RobotMap.rightJoyPort);
	public static Joystick attackJoy = new Joystick(RobotMap.atkJoyPort);
 
	Button pistonOutButton = new JoystickButton(attackJoy, RobotMap.pistonOutNum),
		pistonInButton = new JoystickButton(attackJoy, RobotMap.pistonInNum),
		forkliftUpButton = new JoystickButton(attackJoy, RobotMap.forkliftUpNum),
		forkliftDownButton = new JoystickButton(attackJoy, RobotMap.forkliftDownNum);

	public OI (){
		// When the piston out button is pressed, the robot switches to Tote Mode.
		pistonOutButton.whenPressed(new ToteMode());
		// When the piston in button is pressed, the robot swicthes to Bin Mode.
		pistonInButton.whenPressed(new BinMode());
		// When the forklift up button is pressed, the forklift moves up.
		forkliftUpButton.whenPressed(new ForkliftUp());
		// When the forklift down button is pressed, the forklift moves down.
		forkliftDownButton.whenPressed(new ForkliftDown());
	}
}
