package org.usfirst.frc.team2265.robot.subsystems;

//import org.usfirst.frc.team2265.robot.OI;
//import org.usfirst.frc.team2265.robot.Robot;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button; //These are class imports  
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.TalonSRX;
//import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MecanumDrive extends Subsystem {
  TalonSRX frontLeft = new TalonSRX(1);
  TalonSRX rearLeft = new TalonSRX(2);
  TalonSRX frontRight = new TalonSRX(3);
  TalonSRX rearRight = new TalonSRX(4);
  RobotDrive mecDrive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
  Gyro gyroscope = new Gyro(1);
  public Joystick driveJoystick = new Joystick(1);
  double driveX = driveJoystick.getRawAxis(1);
  double driveY =driveJoystick.getRawAxis(2);
  double rotate = driveJoystick.getRawAxis(4);
  

  
 
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
     public void drive() {
    
    mecDrive.mecanumDrive_Cartesian(driveX, driveY, rotate, gyroscope.getAngle());
     }

    public void initDefaultCommand() {
     frontLeft.set(0.0);
     frontRight.set(0.0);
     rearLeft.set(0.0);
     rearRight.set(0.0);
    }
}
