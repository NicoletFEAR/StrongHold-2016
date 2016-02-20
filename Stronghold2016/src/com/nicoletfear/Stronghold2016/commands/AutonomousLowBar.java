package com.nicoletfear.Stronghold2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousLowBar extends CommandGroup {
	
    public  AutonomousLowBar() {
    	addSequential(new LowBar());
    	//runs forwards
    }
}
