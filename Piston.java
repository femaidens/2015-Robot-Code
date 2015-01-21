/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
/**
 *
 * @author student
 */
public class Piston{
    
    private DoubleSolenoid piston;
    /*pistons are generally booleans. they have two values: on and off. there is no in between.
    pistons are controlled by solenoids, which control the air flow into the pistons. 
    when air is moved through the back of the piston, the air pushes the piston out, making it extend.
    in order to retract the piston, air is moved through the front of the piston. 
    the difference in air pressure is what causes the piston to extend and retract*/
    
    public piston (1, 2){
        //creation of piston in ports 1 and 2
        piston= new DoubleSolenoid (1, 2);
       
    }
    
    public void extend(){
        //method used to extend the pistons
        piston.set(DoubleSolenoid.Value.kForward);
       
    }
   /* public void off(){
        //method used stop piston movement through movement of air
        piston.set(DoubleSolenoid.Value.kOff);
        
    }
    */
    public void retract(){
        //method used to retract the pistons
        piston.set(DoubleSolenoid.Value.kReverse);
       
    }  
}