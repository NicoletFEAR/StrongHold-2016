
package com.nicoletfear.Stronghold2016.subsystems;

import com.nicoletfear.Stronghold2016.OI;
import com.nicoletfear.Stronghold2016.Robot;
import com.nicoletfear.Stronghold2016.RobotMap;
import com.nicoletfear.Stronghold2016.commands.HoldArm;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
	
	//declare variables here
	double position;
	double target = 0;
	
	String switchHitLast;
	String bottomLimit = "bottom";
	String topLimit = "top";
	
	public CANTalon positionMotor;
	DigitalInput limitSwitchTop;
	DigitalInput limitSwitchBottom;
	
	public Arm(){
		//assign variables here
		positionMotor = new CANTalon(RobotMap.positionMotorPort);
		positionMotor.changeControlMode(CANTalon.TalonControlMode.Position);
		
		positionMotor.setEncPosition(0);
		
		positionMotor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		
		positionMotor.reverseSensor(false);
		
		positionMotor.setAllowableClosedLoopErr(0); // parameter needs to be determined
	        positionMotor.setProfile(0);
	        positionMotor.setF(RobotMap.ArmF);
	        positionMotor.setP(RobotMap.ArmP); // parameter needs to be determined
	        positionMotor.setI(RobotMap.ArmI); // parameter needs to be determined
	        positionMotor.setD(RobotMap.ArmD); // parameter needs to be determined
	        positionMotor.enable();
	        positionMotor.enableControl();
	    
	        position = positionMotor.getEncPosition();
		
		limitSwitchTop = OI.limitSwitchTop;
		limitSwitchBottom = OI.limitSwitchBottom;
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand(){
        // Set the default command for a subsystem here.
    	setDefaultCommand(new HoldArm());

    
    }
    public void armUp(){
    	
    		//position += 30;
    	position -= 10;
    		positionMotor.set(position);
    		
    		//if(upLimitSwitchPressed()){
    		//position = positionMotor.getEncPosition();
    		//}
    	
        
    }
    //moves arm up
    public void armDown(){
    	 
    	
    		//position -= 10;
    	position += 30;
    		positionMotor.set(position);
		
    	
    		// if(downLimitSwitchPressed()){
     		//position = positionMotor.getEncPosition();
    		//	}
    	 
        
    }
    
    public void autoArmDown(){
    	positionMotor.set(RobotMap.portTarget);
        //	}
        	// if(downLimitSwitchPressed()){
         		//position = positionMotor.getEncPosition();
         //	}
        }
    
    public void autoArmUp(){
    	positionMotor.set(RobotMap.homeTarget);
    }
    
    public void autoArmIntake(){
    	positionMotor.set(RobotMap.intakeTarget);
    }
    
    public void armSetIntake(double target){
    	//if(limitSwitchTop.get() != true && limitSwitchBottom.get()){
    	positionMotor.set(target);
    	//}
    }
    
    public void armSetHome(double target){
    	if(limitSwitchTop.get() != true && positionMotor.get() < RobotMap.homeTarget){
		positionMotor.set(target);
    	}
	}
    
    public void armSetPort(double target){
    	if(limitSwitchBottom.get() != true && positionMotor.get() > RobotMap.portTarget)
		positionMotor.set(target);
	
	}
    	
        //	}
        	// if(downLimitSwitchPressed()){
         		//position = positionMotor.getEncPosition();
         //	}
        
        
    
    //moves arm down
    
    public void armHold(){
        positionMotor.set(position);
    }
    //stops arm
    
    public void armDefaultPosition(){
        position = RobotMap.defaultArmPosition;
        positionMotor.set(position);
    }
    //stops arm
    
    public boolean upLimitSwitchPressed(){
    	if(OI.limitSwitchTop.get() && positionMotor.get() < 0){
    		return false;
    	}else{
    		positionMotor.setPosition(0);
    		return true;
    	}
    }
    //returns true when pressed
    
    public boolean downLimitSwitchPressed(){
    	if(OI.limitSwitchBottom.get()){
    		return false;
    	}else{
    		return true;
    	}
    }
    
    //returns true when pressed
    /*
    public void raisePortcullis(){
    	if(position < 0){
    		position += 40;
    	}
    	if(upLimitSwitchPressed()){
    		position = positionMotor.getEncPosition();
    	}
    	positionMotor.set(position);
    }
    */

}
