package com.nicoletfear.Stronghold2016.commands;

import com.nicoletfear.Stronghold2016.Robot;
import com.nicoletfear.Stronghold2016.RobotMap;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousDistancePID extends Command {

	public double revs;
	
    public AutonomousDistancePID(double feet) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	double circumference = 2 * Math.PI * RobotMap.WHEEL_RADIUS;
		revs = 12 * feet / circumference;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.backLeft.changeControlMode(TalonControlMode.Position);
    	Robot.driveTrain.backRight.changeControlMode(TalonControlMode.Position);
    	Robot.driveTrain.backLeft.setEncPosition(0);
    	Robot.driveTrain.backRight.setEncPosition(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!leftIsWithinError()){
    		Robot.driveTrain.backLeft.set(revs);
    	}
    	if(!rightIsWithinError()){
    		Robot.driveTrain.backRight.set(revs);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(leftIsWithinError() && rightIsWithinError()){
    		return true;
    	}
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    private boolean leftIsWithinError(){
    	return Math.abs(revs - Robot.driveTrain.backLeft.get()) < Robot.driveTrain.error;
    }
    
    private boolean rightIsWithinError(){
    	return Math.abs(revs - Robot.driveTrain.backRight.get()) < Robot.driveTrain.error;
    }
}
