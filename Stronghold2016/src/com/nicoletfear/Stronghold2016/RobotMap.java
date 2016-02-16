package com.nicoletfear.Stronghold2016;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//CANTalon ports
	// use instead of magic numbers
	//are final ports
	
	public static final int backLeftPort = 15;
	public static final int backRightPort = 12;
	public static final int frontLeftPort = 14;
	public static final int frontRightPort = 13;
	public static final int intakeMotorPort = 3;
	public static final int positionMotorPort = 2;
	public static final int limitSwitchTopPort = 8;
	public static final int limitSwitchBottomPort = 7;
	public static final int limitSwitchIntakePort = 6;
	
	//game mech constants
	//use instead of hard-coded values
	public static final double armSpeed = .2;
	public static final double intakeSpeed = -1;
	public static final double passSpeed = .5;
	public static final double shootSpeed = 1;

	//autonomous constants
	//use instead of hard-coded numbers
	public static final double autoSpeed = 1;
	public static final double autoTimer = 5;
	
	
	public static final double scaling = 1;
	
	//this is PID stuff
	public static final double WHEEL_RADIUS = 3;
	public static final int TESTBENCH_CODES_PER_REV = 7;
	public static final int TESTBENCH_GEARBOX_RATIO = 71;
	public static final int OPTION8_CODES_PER_REV = 7;
	public static final double OPTION8_GEARBOX_RATIO = 8.45;
	public static final double ERROR_CONSTANT = 5;  //Allowable error, 360 / this = error in degrees
	//public static final double P = 0.005;
	public static final double P = 0.005;
	//public static final double I = 0.001;
	public static final double I = 0.0;
	//public static final double D = 0.0001;
	public static final double D = 0.0;
	public static final double F = 0.0;


	
	
    /* For example to map the left and right motors, you could define the
     following variables to use with your drivetrain subsystem.
     If you are using multiple modules, make sure to define both the port
     number and the module. 
     
     */
}
