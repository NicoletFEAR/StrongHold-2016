package com.nicoletfear.Stronghold2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousStop extends CommandGroup {
	
    public  AutonomousStop() {
    	addSequential(new StopDrive());
    	//runs forwards
    }
}
