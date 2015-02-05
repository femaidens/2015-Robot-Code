/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author student
 */
public class Autonomous {
    
    RobotDrive mecDrive;
    private Timer clock = new Timer();
    private Talon frontLeft = new Talon(1);
    private Talon rearLeft = new Talon(2);
    private Talon frontRight = new Talon(3);
    private Talon rearRight = new Talon(4);
    private RobotDrive mecDrive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
    
    public void moveForward() {
        clock.start();
        while (clock.get() < 15) {
            mecDrive.mecanumDrive_Cartesian(0, 1, 0, 0);
        }
    }
 
    public void tote() {
        forklift.up();
        moveForward(); 
        forklift.down();
    }
    
}
