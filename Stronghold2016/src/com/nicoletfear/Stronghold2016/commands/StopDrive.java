
package com.nicoletfear.Stronghold2016.commands;

import com.nicoletfear.Stronghold2016.Robot;
import com.nicoletfear.Stronghold2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StopDrive extends Command {

    public StopDrive() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        //makes bot drive forwards for five seconds

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.brake();
    	//values inverted because it was driving backwards for some reason
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.brake();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
