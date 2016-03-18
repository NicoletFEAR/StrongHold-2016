
package com.nicoletfear.Stronghold2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import com.nicoletfear.Stronghold2016.OI;
import com.nicoletfear.Stronghold2016.Robot;
import com.nicoletfear.Stronghold2016.RobotMap;

/**
 *Command that raises arm. It stops when the user releases the
 *upper limit switch or releases the button
 */
public class ArmTargetPositionIntake extends Command {
	double position;
    public ArmTargetPositionIntake(double target) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.arm);
        position = target;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.arm.setFixedPosition(RobotMap.intakeTarget);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.arm.armHold();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
