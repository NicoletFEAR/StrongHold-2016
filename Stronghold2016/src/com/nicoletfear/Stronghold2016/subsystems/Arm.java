
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
	boolean lastUpSwitchState;
    boolean lastDownSwitchState;
	
	public CANTalon positionMotor;
	DigitalInput limitSwitchTop;
	DigitalInput limitSwitchBottom;
	
	public Arm(){
		//assign variables here
		lastUpSwitchState = false;
		lastDownSwitchState = false;
		
		positionMotor = new CANTalon(RobotMap.positionMotorPort);
		positionMotor.changeControlMode(CANTalon.TalonControlMode.Position);
		
		positionMotor.setPosition(0);
		
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
    
        position = positionMotor.getPosition();
		
		limitSwitchTop = OI.limitSwitchTop;
		limitSwitchBottom = OI.limitSwitchBottom;
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand(){
        // Set the default command for a subsystem here.
    	setDefaultCommand(new HoldArm());
    }

    public double getPosition(){
    	return position;
    }
    public void armUp(){
    	
    	if(upLimitSwitchPressed() == false){
            position -= 10; // TODO is this sign correct?
            if (position < RobotMap.topLimitSwitchSet)
            {
            	position = RobotMap.topLimitSwitchSet;
            }
        }
    	positionMotor.set(position);
    }

    //moves arm up
    public void armDown(){
    	     	
    	if(downLimitSwitchPressed() == false){
            position += 10; // TODO is this sign correct?
            if (position > RobotMap.bottomLimitSwitchSet)
            {
            	position = RobotMap.bottomLimitSwitchSet;
            }
        }
    	positionMotor.set(position);
    }
    
    public void autoArmDown(){
    	positionMotor.set(RobotMap.portTarget);
    }
    
    public void autoArmUp(){
    	positionMotor.set(RobotMap.homeTarget);
    }
    
    public void autoArmIntake(){
    	positionMotor.set(RobotMap.intakeTarget);
    }
    
    public void armHold(){
    	
    	boolean currentUpSwitchState = upLimitSwitchPressed();
        boolean currentDownSwitchState = downLimitSwitchPressed();

        if(lastUpSwitchState == false && currentUpSwitchState == true)
        {
            positionMotor.setPosition(RobotMap.topLimitSwitchSet);
            position = RobotMap.topLimitSwitchSet;
        }        

        if(lastDownSwitchState == false && currentDownSwitchState == true)
        {
            positionMotor.setPosition(RobotMap.bottomLimitSwitchSet);
            position = RobotMap.bottomLimitSwitchSet;
        }

        lastUpSwitchState = currentUpSwitchState;
        lastDownSwitchState = currentDownSwitchState;

        positionMotor.set(position);
    }
    //stops arm
    
    public void setFixedPosition(double targetPosition){
        position = targetPosition;
        positionMotor.set(position);
    }

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
    
    public void updateFromNetworkTables() {
    	positionMotor.updateTable();
    }
}
