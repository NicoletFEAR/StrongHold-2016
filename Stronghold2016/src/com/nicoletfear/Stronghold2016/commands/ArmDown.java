
package com.nicoletfear.Stronghold2016.commands;

import edu.wpi.first.wpilibj.command.Command;

import com.nicoletfear.Stronghold2016.Robot;

/**
 *
 */
public class ArmDown extends Command {
	
	private boolean finished;

    public ArmDown() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.arm);
        finished = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.arm.armDown();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Robot.arm.downLimitSwitchPressed()){
    		finished = true;
    	}
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.arm.armStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
