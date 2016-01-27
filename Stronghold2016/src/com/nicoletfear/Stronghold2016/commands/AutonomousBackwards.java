
package com.nicoletfear.Stronghold2016.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import com.nicoletfear.Stronghold2016.Robot;
import com.nicoletfear.Stronghold2016.subsystems.DriveTrain;

/**
 *
 */
public class AutonomousBackwards extends Command {

    public AutonomousBackwards() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        setTimeout(5);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//will have bot drive forwards for 5 seconds
    	//Timer timer = new Timer();
    	//timer.start();
    	//starts and initializes timer
    	Robot.driveTrain.drive(1 , 1);
    	//values inverted because it was driving backwards for some reason
    	//Timer.delay(5);
    	//Robot.driveTrain.brake();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.driveTrain.autoDrive(.25);
    	
    	//runs autodrive method at speed .25
    	//method in drivetrain subsystem
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
