
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
	        positionMotor.setF(0.0);
	        positionMotor.setP(0.8); // parameter needs to be determined
	        positionMotor.setI(0.0004); // parameter needs to be determined
	        positionMotor.setD(0.0); // parameter needs to be determined
	        positionMotor.enable();
	        positionMotor.enableControl();
	    
	        position = positionMotor.getEncPosition();
		
		limitSwitchTop = OI.limitSwitchTop;
		limitSwitchBottom = OI.limitSwitchBottom;
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.

    
    }
    public void armUp(){
    	
    	if(position < 0){
    		position += 10;
    	}
    	if(upLimitSwitchPressed()){
    		position = positionMotor.getEncPosition();
    	}
    	positionMotor.set(position);
        
    }
    //moves arm up
    public void armDown(){
    	 
    	if(position > -1200){
    		position -= 10;
    	}
    	 if(downLimitSwitchPressed()){
     		position = positionMotor.getEncPosition();
     	}
    	 positionMotor.set(position);
        
    }
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
    	if(OI.limitSwitchTop.get()){
    		return false;
    	}else{
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
