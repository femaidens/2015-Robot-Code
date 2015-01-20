/* MUST CREATE ARM CLASS FROM MOTOR AND PULLEY
 * CREATE UP AND DOWN METHODS IN MOTORS OR PULLEY
 * MOTORS FORWARD OR BACKWARD. POSITIVE OR NEGATIVE
 */
 
package edu.wpi.first.wpilibj.templates;

public class Forklift{
    //the forklift that will carry the totes and recycling bin
    
    //create forklift object that will carry game pieces
    private Piston piston = new Piston(1,2);
    private Talon topMotor = new Talon(1);
    private Talon bottomMotor = new Talon(2);
    
    //method used to make the forklift go up
    public void up(){
      topMotor.set(0.75);
      bottomMotor.set(0.75);
    }
    
    //method used to make the forklift go down
    public void down(){
      topMotor.set(-0.75);
      bottomMotor.set(-0.75);
    }
    
    //method to stop the forklift
    public void stop(){
      topMotor.set(0.0);
      bottomMotor.set(0.0);
    }
    
    //method used to retract piston to push one arm in to fit around the tote
    public void toteMode(){
      piston.retract();
    }
    
    //method used to extend piston to move arm out to fit around the bin
    public void binMode(){
       piston.extend();
    }

}
