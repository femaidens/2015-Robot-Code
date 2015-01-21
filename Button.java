/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;

public class Button {
    private Joystick leftJoystick;
    private Joystick rightJoystick;
    private Joystick attackController;
    private Forklift forklift;
    
public Button(Joystick left, Joystick right,Joystick atk, Forklift lift){
    leftJoystick = left;
    rightJoystick = right;
    attackController = atk;
    forklift = lift;
    }
public void configureButtons() {
    //if button 6 on the attack controller is pressed, the forklift moves up
   if (attackController.getRawButton(6)) {
        forklift.up();
   }
    //if button 7 on the attack controller is pressed, the forklift moves down
   if (attackController.getRawButton(7)) {
        forklift.down();
   }
   //if neither button 6 nor 7 on the attack controller is pressed, the forklift stops
   else if(!attackController.getRawButton(6) && !attackController.getRawButton(7)){
        forklift.stop();
   }
   //if button 4 on the attack controller is pressed, the robot goes into bin mode to prepare for carrying recycling bin
   if (attackController.getRawButton(4)) {
        forklift.binMode();
   }
   //if button 5 on the attack controller is pressed, the robot goes into tote mode to prepare for carrying totes
   if (attackController.getRawButton(5)) {
        forklift.toteMode();
    }
}
