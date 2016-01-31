
package com.nicoletfear.Stronghold2016.subsystems;

import com.nicoletfear.Stronghold2016.RobotMap;
import com.nicoletfear.Stronghold2016.commands.RunNormal;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TestBench extends Subsystem {
	public TestBench(){
	}
	CANTalon intakeMotor = new CANTalon(RobotMap.intakeMotorPort);
	CANTalon positionMotor = new CANTalon(RobotMap.positionMotorPort);
	CANTalon other = new CANTalon(1);

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new RunNormal());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void run(double input){
    	//final double scaling = 1;
    	double output = input;
    	intakeMotor.set(input);
    	positionMotor.set(input);
    	other.set(input);
    	
    }
}

