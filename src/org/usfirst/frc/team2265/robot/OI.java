package org.usfirst.frc.team2265.robot;

 import edu.wpi.first.wpilibj.buttons.Button; //These are class imports  
 import edu.wpi.first.wpilibj.buttons.JoystickButton;
 import edu.wpi.first.wpilibj.Joystick;
 //import org.usfirst.frc.team2265.robot.commands.ExampleCommand;
 import org.usfirst.frc.team2265.robot.commands.ForkliftUp;
 import org.usfirst.frc.team2265.robot.commands.ForkliftDown;
 import org.usfirst.frc.team2265.robot.commands.ToteMode;
 import org.usfirst.frc.team2265.robot.commands.BinMode;
  /**This is for the Fork lift command and made by other people so we must combine the other codes together to make
   * sense for this
   */

  /**
   * This class is the glue that binds the controls on the physical operator
   * interface to the commands and command groups that allow control of the robot.
   */
 
 //OI's back. tell a friend.
 
  public class OI {
      //// CREATING BUTTONS
	  private final int ATTACK_CONTROLLER_PORT= 3;
	  private final int LEFT_CONTROLLER_PORT=1;
	  private final int RIGHT_CONTROLLER_PORT=2;
	    // Ports to connect the robot to other stuff and stuff
	  private final int FORKLIFT_UP_BUTTON = 6; //When button 6 is pressed, then the fork lift will move up
	  private final int FORKLIFT_DOWN_BUTTON = 7; 
	    //When button 7 is pressed then the fork lift will move down. 
	    //When either button is let go, the fork lift will stop moving
	  Joystick attackJoy = new Joystick(3);
	  Joystick leftJoy= new Joystick(1);
	  Joystick rightJoy=new Joystick(2);
	  Button pistonOutButton = new JoystickButton(attackJoy,LEFT_CONTROLLER_PORT),
		   pistonInButton = new JoystickButton(attackJoy,RIGHT_CONTROLLER_PORT),
	       forkliftUpButton = new JoystickButton(attackJoy,FORKLIFT_UP_BUTTON),
	       forkliftDownButton = new JoystickButton(attackJoy,FORKLIFT_DOWN_BUTTON);

		public OI (){
		//pistonOutButton.whenPressed(new PistonOut());
		//pistonInButton.whenPressed(new PistonIn());
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