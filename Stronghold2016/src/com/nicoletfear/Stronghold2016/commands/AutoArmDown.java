
package com.nicoletfear.Stronghold2016.commands;

import com.nicoletfear.Stronghold2016.Robot;
import com.nicoletfear.Stronghold2016.RobotMap;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;

/**
 *Command that lowers arm. It stops when the user releases the
 *lower limit switch or releases the button
 */
public class AutoArmDown extends Command {
	
    public AutoArmDown() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.arm);
        setTimeout(RobotMap.armDownTimer);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.arm.autoArmDown();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.arm.armHold();
    	//new HoldArm().start();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
