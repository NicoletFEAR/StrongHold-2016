
package com.nicoletfear.Stronghold2016.subsystems;

import com.nicoletfear.Stronghold2016.Robot;
import com.nicoletfear.Stronghold2016.RobotMap;
import com.nicoletfear.Stronghold2016.commands.IntakeSpin;

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
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void intake(){
    	intakeMotor.set(-1);
    }
    public void stopIntake(){
    	intakeMotor.set(0);
    }
    public void pass(){
    	intakeMotor.set(.5);
    }
    public void shoot(){
    	intakeMotor.set(1);
    }
}

