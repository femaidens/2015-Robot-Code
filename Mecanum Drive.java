/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot {
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    //ADD PORTS!!!
    private Joystick leftJoystick = new Joystick(x);
    private Joystick rightJoystick = new Joystick(y);
    private Talon frontLeft = new Talon(1);
    private Talon rearLeft = new Talon(2);
    private Talon frontRight = new Talon(3);
    private Talon rearRight = new Talon(4);
    private RobotDrive mecDrive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
    private Gyro gyroscope = new Gyro(1);
    
    //Pneumatics
    
    
            
    public void autonomous() {
        
    }
    
    public void operatorControl() {
        double xValue = 0.0;
        double yValue = 0.0;
        double rotation = 0.0;
        double gyroAngle = 0.0;
                
         while(isOperatorControl() && isEnabled()) {
             xValue = rightJoystick.getX();
             yValue = rightJoystick.getY();
             rotation = leftJoystick.getX();
             gyroAngle = gyroscope.getAngle();
            
             mecDrive.mecanumDrive_Cartesian(xValue, yValue, rotation, gyroAngle);
                     
         }
    }
    
    public void test() {
    
    }
}
