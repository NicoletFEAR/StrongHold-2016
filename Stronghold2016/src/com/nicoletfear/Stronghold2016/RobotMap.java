package com.nicoletfear.Stronghold2016;

import edu.wpi.first.wpilibj.DigitalInput;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//CANTalon ports
	// use instead of magic numbers
	//will be updated once we have a finished bot
	
	public static final int backLeftPort = 0;
	public static final int backRightPort = 7;
	public static final int frontLeftPort = 42;
	public static final int frontRightPort = 12;
	public static final int intakeMotorPort = 15;
	public static final int positionMotorPort = 1;
	public static final int limitSwitchTopPort = 8;
	public static final int limitSwitchBottomPort = 7;
	
	public static final double armSpeed = .2;
	public static final double intakeSpeed = -1;
	public static final double passSpeed = .5;
	public static final double shootSpeed = 1;

	

	
	//I think that our error may be in here


	
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
