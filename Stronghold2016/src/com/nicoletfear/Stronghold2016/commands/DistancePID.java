package com.nicoletfear.Stronghold2016.commands;

import com.nicoletfear.Stronghold2016.Robot;
import com.nicoletfear.Stronghold2016.RobotMap;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DistancePID extends Command {

	public double revs;
	
    public DistancePID(double feet) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	double circumference = 2 * Math.PI * RobotMap.WHEEL_RADIUS;
		revs = 12 * feet / circumference;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.frontLeft.changeControlMode(TalonControlMode.Position);
    	Robot.driveTrain.frontRight.changeControlMode(TalonControlMode.Position);
    	Robot.driveTrain.frontLeft.setEncPosition(0);
    	Robot.driveTrain.frontRight.setEncPosition(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!leftIsWithinError()){
    		Robot.driveTrain.frontLeft.set(revs);
    	}
    	if(!rightIsWithinError()){
    		Robot.driveTrain.frontRight.set(revs);
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
    	double closedLoopError = revs - Robot.driveTrain.frontLeft.get();
    	double error = 1 / RobotMap.ERROR_CONSTANT;
    	boolean temp = Math.abs(closedLoopError) < error;
    	return temp;
    }
    
    private boolean rightIsWithinError(){
    	double closedLoopError = revs - Robot.driveTrain.frontRight.get();
    	double error = 1 / RobotMap.ERROR_CONSTANT;
    	boolean temp = Math.abs(closedLoopError) < error;
    	return temp;
    }
}
