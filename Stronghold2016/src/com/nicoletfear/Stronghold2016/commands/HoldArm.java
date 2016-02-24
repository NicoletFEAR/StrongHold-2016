
package com.nicoletfear.Stronghold2016.commands;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;

import com.nicoletfear.Stronghold2016.OI;
import com.nicoletfear.Stronghold2016.Robot;

/**
 *Command that lowers arm. It stops when the user releases the
 *lower limit switch or releases the button
 */
public class HoldArm extends Command {
	
	private double heldPosition;
	
    public HoldArm() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.arm.positionMotor.changeControlMode(TalonControlMode.Position);
    	//Robot.arm.positionMotor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
    	heldPosition = Robot.arm.positionMotor.getEncPosition();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.arm.positionMotor.set(heldPosition);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return OI.leftBumper.get() || OI.rightBumper.get();
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.arm.positionMotor.changeControlMode(TalonControlMode.Speed);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
