package com.nicoletfear.Stronghold2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousPortcullis extends CommandGroup {
	
    public  AutonomousPortcullis() {
    	addSequential(new AutoArmDown());
    	addSequential(new Portcullis());
    	addSequential(new AutoArmUp());
    	//runs forwards
    }
}
