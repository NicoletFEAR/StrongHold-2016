
package com.nicoletfear.Stronghold2016.commands;

import com.nicoletfear.Stronghold2016.Robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *this command passes the ball
 */
public class MoveToHome extends Command {

    public MoveToHome() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double degrees = Robot.oi.pot.get();
    	while(degrees !=392.049){
    		if(degrees<392.049){
    			Robot.arm.armUp();
    		}
    		if(degrees>392.049){
    			Robot.arm.armDown();
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.oi.pot.get() < 392.049){
    		return false;
    	}else if(Robot.oi.pot.get() > 392.049){
    		return false;
    	}else{
    		return true;
    	}
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
