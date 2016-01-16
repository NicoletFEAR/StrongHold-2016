// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package com.nicoletfear.Stronghold2016.subsystems;

import com.nicoletfear.Stronghold2016.RobotMap;
import com.nicoletfear.Stronghold2016.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveTrain extends Subsystem {
	
	public DriveTrain(){
		//follower code
		backLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		backRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		backLeft.set(RobotMap.frontLeftPort);
		backRight.set(RobotMap.frontRightPort);
		frontLeft.setInverted(true);
		//this inverts the cantalons on the left side
	}
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	//CANTalon objects
	CANTalon backLeft = new CANTalon(RobotMap.backLeftPort);
	CANTalon backRight = new CANTalon(RobotMap.backRightPort);
	CANTalon frontLeft = new CANTalon(RobotMap.frontLeftPort);
	CANTalon frontRight = new CANTalon(RobotMap.frontRightPort);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new Drive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }


	public void drive(double leftInput, double rightInput) {
		final double scaling = .5;
		//scales between .5 and -.5
		//did this because we don't know what the maximum speed of the motors is
		double leftOutput = leftInput * scaling;
		double rightOutput = rightInput * scaling;
		frontLeft.set(leftOutput);
		frontRight.set(rightOutput);
	}
	
	private void ensurePositionMode(){
		frontLeft.changeControlMode(CANTalon.TalonControlMode.Position);
		frontRight.changeControlMode(CANTalon.TalonControlMode.Position);
		frontLeft.setProfile(RobotMap.positionProfile);
		frontRight.setProfile(RobotMap.positionProfile);
	}
	
	private void ensureVelocityMode(){
		frontLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
		frontRight.changeControlMode(CANTalon.TalonControlMode.Speed);
		frontLeft.setProfile(RobotMap.velocityProfile);
		frontRight.setProfile(RobotMap.velocityProfile);
	}
}

