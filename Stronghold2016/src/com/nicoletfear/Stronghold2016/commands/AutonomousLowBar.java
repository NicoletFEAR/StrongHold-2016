package com.nicoletfear.Stronghold2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousLowBar extends CommandGroup {
	
    public  AutonomousLowBar() {
    	//addSequential(new AutoArmDown());
    	addSequential(new LowBar());
    	//addSequential(new AutoArmUp());
    	//runs forwards
    }
}
