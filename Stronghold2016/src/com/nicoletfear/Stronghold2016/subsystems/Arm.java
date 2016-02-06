
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
	public Arm(){
		
	}
	CANTalon positionMotor = new CANTalon(RobotMap.positionMotorPort);
	DigitalInput limitSwitchTop = Robot.oi.limitSwitchTop;
	DigitalInput limitSwitchBottom = Robot.oi.limitSwitchBottom;
	
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void armUp(){
    	positionMotor.set(.2);
    }
    public void armDown(){
    	positionMotor.set(-.2);
    }
    public void armStop(){
    	positionMotor.set(0);
    }
    public boolean upLimitSwitchPressed(){
    	if(OI.limitSwitchTop.get()){
    		return true;
    	}else{
    		return false;
    	}
    }
    public boolean downLimitSwitchPressed(){
    	if(OI.limitSwitchBottom.get()){
    		return true;
    	}else{
    		return false;
    	}
    }
}
