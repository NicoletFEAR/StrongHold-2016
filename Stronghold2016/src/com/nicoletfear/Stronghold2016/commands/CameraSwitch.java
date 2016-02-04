package com.nicoletfear.Stronghold2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

public class CameraSwitch extends Command {

    public CameraSwitch() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }
    

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	int currSession;
    	int sessionfront;
    	int sessionback;
    	Image frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
        sessionfront = NIVision.IMAQdxOpenCamera("cam1", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        sessionback = NIVision.IMAQdxOpenCamera("cam2", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        currSession = sessionfront;
            if(currSession == sessionfront){
         		  NIVision.IMAQdxStopAcquisition(currSession);
    		  currSession = sessionback;
    	          NIVision.IMAQdxConfigureGrab(currSession);
    	} else if(currSession == sessionback){
        		  NIVision.IMAQdxStopAcquisition(currSession);
         		  currSession = sessionfront;
         		  NIVision.IMAQdxConfigureGrab(currSession);
          }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
