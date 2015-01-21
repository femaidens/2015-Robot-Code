/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.      
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import  edu.wpi.first.wpilibj.Compressor;

public class RobotTemplate extends SimpleRobot {
    
    private Joystick leftJoystick = new Joystick(x);
    private Joystick rightJoystick = new Joystick(y);
    private Talon frontLeft = new Talon(1);
    private Talon rearLeft = new Talon(2);
    private Talon frontRight = new Talon(3);
    private Talon rearRight = new Talon(4);
    private RobotDrive omniDrive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
    
    public void autonomous() {
        
    }
    
    public void operatorControl() {
        double xValue = 0.0;
        double yValue = 0.0;
                
         while(isOperatorControl() && isEnabled()) {
             xValue = rightJoystick.getX(); //joystick configuration same as mecanum drive
             yValue = rightJoystick.getY();
            
             omniDrive.tankDrive(xValue, yValue); //tankDrive for now, test and make changes later
            
         }
    }
    
    public void test() {
    
    }
}
