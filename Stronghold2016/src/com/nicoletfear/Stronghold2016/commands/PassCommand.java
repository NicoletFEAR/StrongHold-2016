
package com.nicoletfear.Stronghold2016.commands;

import edu.wpi.first.wpilibj.command.Command;

import com.nicoletfear.Stronghold2016.Robot;
import com.nicoletfear.Stronghold2016.xbox.Buttons;

/**
 *this command passes the ball
 */
public class PassCommand extends Command {

    public PassCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.intake.pass();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	//when A is pressed, starts passing
    	//when A is released, stops intake from spinning
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.stopIntake();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
