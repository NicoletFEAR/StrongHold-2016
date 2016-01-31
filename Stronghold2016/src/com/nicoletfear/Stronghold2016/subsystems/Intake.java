
package com.nicoletfear.Stronghold2016.subsystems;

import com.nicoletfear.Stronghold2016.Robot;
import com.nicoletfear.Stronghold2016.RobotMap;
import com.nicoletfear.Stronghold2016.commands.IntakeCommand;
import com.nicoletfear.Stronghold2016.commands.RunNormal;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	public Intake(){
	}
	CANTalon intakeMotor = new CANTalon(RobotMap.intakeMotorPort);

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new IntakeCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void intake(){
    	if(Robot.oi.getA() == true)
    	intakeMotor.set(1);
    	
    }
}

