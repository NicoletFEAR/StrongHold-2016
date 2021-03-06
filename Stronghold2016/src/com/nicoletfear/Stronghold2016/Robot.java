
package com.nicoletfear.Stronghold2016;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import com.nicoletfear.Stronghold2016.subsystems.Arm;
import com.nicoletfear.Stronghold2016.commands.AutonomousLowBar;
import com.nicoletfear.Stronghold2016.commands.AutonomousMoat;
import com.nicoletfear.Stronghold2016.commands.AutonomousRamparts;
import com.nicoletfear.Stronghold2016.commands.AutonomousRockWall;
import com.nicoletfear.Stronghold2016.commands.AutonomousRockyTerrain;
import com.nicoletfear.Stronghold2016.commands.AutonomousStop;
import com.nicoletfear.Stronghold2016.subsystems.DriveTrain;
import com.nicoletfear.Stronghold2016.subsystems.Intake;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Intake intake = new Intake();
	public static final Arm arm = new Arm();
	public static OI oi;
	
	//always do this
	//dont ask why
	public String Skynet = "Sentient";
	public Boolean SkynetEnabled = true;

	Command autonomousCommand;
	SendableChooser chooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
    
	public void robotInit() {
		oi = new OI();
		chooser = new SendableChooser();
		chooser.addDefault("StandStill", new AutonomousStop());
		chooser.addObject("Rock Wall", new AutonomousRockWall());
		chooser.addObject("Moat", new AutonomousMoat());
		chooser.addObject("Ramparts", new AutonomousRamparts());
		chooser.addObject("Rocky Terrain", new AutonomousRockyTerrain());
		chooser.addObject("Low Bar", new AutonomousLowBar());
		// makes objects to be seen in SmartDashboard
		SmartDashboard.putData("Auto Selector", chooser);
		CameraServer camera = CameraServer.getInstance();
		camera.setQuality(50);
		camera.startAutomaticCapture("cam0");
		camera.startAutomaticCapture();
		//autonomousCommand = new Forwards(); TO DO
		// sets command to autonomous forwards
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	public void autonomousInit() {
		autonomousCommand = (Command) chooser.getSelected();
		/*
		 * sets command equal to autonomous forwards schedule the autonomous
		 * command (example)
		 */
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		/*
		 * This makes sure that the autonomous stops running when teleop starts
		 * running. If you want the autonomous to continue until interrupted by
		 * another command, remove this line or comment it out.
		 */
		if (autonomousCommand != null)
			autonomousCommand.cancel();

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Arm Position", arm.positionMotor.getEncPosition());
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
