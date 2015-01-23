package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.Robot;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MecanumDrive extends Subsystem {
	//creation of talon motors, mecDrive, and gyroscope
		TalonSRX frontLeft = new TalonSRX(1);
		TalonSRX rearLeft = new TalonSRX(2);
		TalonSRX frontRight = new TalonSRX(3);
		TalonSRX rearRight = new TalonSRX(4);
		RobotDrive mecDrive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
		Gyro gyroscope = new Gyro(1);
	
    // Put methods for controlling this subsystem here. Call these from Commands.
     public void drive() {
    	 double xValue = 0.0;
    	 double yValue = 0.0;
    	 double rotation = 0.0;
    	 double gyroAngle = 0.0;
        
    	 mecDrive.mecanumDrive_Cartesian(oi.leftJoystick.getX(), oi.rightJoystick.getY(), oi.leftJoystick.getX(), gyroscope.getAngle());
    //mecanum cartesian drive command
     }

    public void initDefaultCommand() {
    	//the default command that is used when MecanumDrive is initialized
    	frontLeft.set(0.0);
    	frontRight.set(0.0);
    	rearLeft.set(0.0);
    	rearRight.set(0.0);
    }
}

