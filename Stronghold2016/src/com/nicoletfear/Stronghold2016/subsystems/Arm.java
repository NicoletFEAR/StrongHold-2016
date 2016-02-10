
package com.nicoletfear.Stronghold2016.subsystems;

import com.nicoletfear.Stronghold2016.OI;
import com.nicoletfear.Stronghold2016.Robot;
import com.nicoletfear.Stronghold2016.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
	
	//declare variables here
	CANTalon positionMotor;
	DigitalInput limitSwitchTop;
	DigitalInput limitSwitchBottom;
	
	public Arm(){
		//assign variables here
		positionMotor = new CANTalon(RobotMap.positionMotorPort);
		limitSwitchTop = OI.limitSwitchTop;
		limitSwitchBottom = OI.limitSwitchBottom;
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void armUp(){
    	positionMotor.set(-RobotMap.armSpeed);
    }
    //moves arm up
    public void armDown(){
    	positionMotor.set(RobotMap.armSpeed);
    }
    //moves arm down
    public void armStop(){
    	positionMotor.set(0);
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
}
