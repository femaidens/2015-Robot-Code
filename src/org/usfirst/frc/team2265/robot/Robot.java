package org.usfirst.frc.team2265.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
//import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team2265.robot.subsystems.Forklift;
import org.usfirst.frc.team2265.robot.subsystems.Manipulator;
import org.usfirst.frc.team2265.robot.subsystems.DriveControl;
import org.usfirst.frc.team2265.robot.subsystems.MecanumDrive;
import org.usfirst.frc.team2265.robot.OI;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	//private static TalonSRX frontLeft;
	//private static TalonSRX rearLeft;
	//private static TalonSRX frontRight;
	//private static TalonSRX rearRight; 
	public static MecanumDrive mecanumDrive; 
	public static OI oi;
	public static DriveControl DriveControl;
	public static Forklift forklift;
	public static Manipulator manipulator; 

	Command autonomousCommand;
 
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
		DriveControl = new DriveControl();	
		forklift = new Forklift();
		manipulator = new Manipulator();
		mecanumDrive = new MecanumDrive();
		manipulator.start();
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		if (autonomousCommand != null) autonomousCommand.start();
	} 

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	} 

	public void teleopInit() {
        	if (autonomousCommand != null) autonomousCommand.cancel();
	}

	/**
	 * This function is called when the disabled button is hit.
	 * You can use it to reset subsystems before shutting down.
	 */
	public void disabledInit(){
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
    
	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	} 
}
