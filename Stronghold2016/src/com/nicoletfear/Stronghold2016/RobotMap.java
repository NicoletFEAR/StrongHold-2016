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
	public static final int limitSwitchBottomPort = 117;
	
	public static DigitalInput limitSwitchTop;
	public static DigitalInput limitSwitchBottom;
	
	public static void init(){
		limitSwitchTop = new DigitalInput(limitSwitchTopPort);
		limitSwitchBottom = new DigitalInput(limitSwitchBottomPort);
	}

	
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
