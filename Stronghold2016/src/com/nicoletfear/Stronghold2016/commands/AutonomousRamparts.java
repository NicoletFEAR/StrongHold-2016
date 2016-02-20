package com.nicoletfear.Stronghold2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousRamparts extends CommandGroup {
	
    public  AutonomousRamparts() {
    	addSequential(new Ramparts());
    	//runs forwards
    }
}
