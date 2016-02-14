
package com.nicoletfear.Stronghold2016.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import com.nicoletfear.Stronghold2016.Robot;
import com.nicoletfear.Stronghold2016.RobotMap;
import com.nicoletfear.Stronghold2016.subsystems.DriveTrain;

/**
 *
 */
public class Backwards extends Command {

    public Backwards() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        setTimeout(RobotMap.autoTimer);
        //will have bot drive forwards for 5 seconds
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	Robot.driveTrain.drive(RobotMap.autoSpeed , RobotMap.autoSpeed);
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
