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
	//are final ports
	
	public static final int backLeftPort = 15;
	public static final int backRightPort = 12;
	public static final int frontLeftPort = 14;
	public static final int frontRightPort = 13;
	public static final int intakeMotorPort = 2;
	public static final int positionMotorPort = 3;
	public static final int limitSwitchTopPort = 8;
	public static final int limitSwitchBottomPort = 7;
	public static final int limitSwitchIntakePort = 6;
	
	//game mech constants
	//use instead of hard-coded values
	public static final double armSpeed = .5;
	public static final double intakeSpeed = -1;
	public static final double passSpeed = .75;
	public static final double shootSpeed = 1;
	public static final double raisePortcullisSpeed = 1;

	//autonomous constants
	//use instead of hard-coded numbers
	public static final double lowBarSpeed = 0.6;
	public static final double moatSpeed = 0.6;
	public static final double rampartsSpeed = 0.5;
	public static final double rockyTerrainSpeed = 0.6;
	public static final double rockWallSpeed = 0.6;
	public static final double portcullisSpeed = 0.6;
	public static final double autoSpeed = 0.5;
	
	public static final double autoTimer = 5;
	public static final double moatTimer = 4;
	public static final double rockWallTimer = 3;
	public static final double rockyTerrainTimer = 4;
	public static final double rampartsTimer = 3;
	public static final double lowBarTimer = 4;
	public static final double portcullisTimer = 3;
	public static final double armDownTimer = 3;
	public static final double armUpTimer = 3;
	
	public static final double scaling = .6;
	public static final double turningScaling = .45;
	public static final double autoScaling = 1.45;
	//Set to autoScaling 1.01 for Sir Lance A Bot
	public static final double deadZone = 0.05;
	
	public static final double defaultArmPosition = 0;
	
	//camara stuff
	public static final String cameraID = "cam0";
	public static final int compressionValue = 50;
	
	public static final double ArmF = 0.0;
	public static final double ArmP = 0.6;
	public static final double ArmI = 0.0004;
	public static final double ArmD = 0.0;
	
	public static final double intakeTarget = 2250;
	public static final double homeTarget = 50;
	public static final double topLimitSwitchSet = 0;
	public static final double portTarget = 2700;
	public static final double bottomLimitSwitchSet = 2770;
    /* For example to map the left and right motors, you could define the
     following variables to use with your drivetrain subsystem.
     If you are using multiple modules, make sure to define both the port
     number and the module. 
     
     */
}
