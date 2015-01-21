
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SimpleRobot;


public class RobotTemplate extends SimpleRobot{

    private Joystick leftJoystick = new Joystick(2);
    private Joystick rightJoystick = new Joystick(1);
    private EDC converDriveVal;
    private Forklift forklift;
    private AxisCamera cam;
    
    //Needs ports for compressor.
    private Compressor comp = new Compressor( , );
    
    //Robot picks up totes, drives forward in autonomous.
    public void autonomous(){
        
    }
    
    //Driver controls the robot in teleop.
    public void operatorControl(){
        while(isOperatorControl() && isEnabled()) {
            
        }
    }
    
  
    //Startup method. Turns compressor and camera on.
    public void init(){
        comp.start();
        
        // The string parameter for the AXIS cam should be its IP address
        cam = AxisCamera.getInstance("");
    }
    
}