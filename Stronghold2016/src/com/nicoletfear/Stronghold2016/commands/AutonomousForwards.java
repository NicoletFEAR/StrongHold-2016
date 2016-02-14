package com.nicoletfear.Stronghold2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousForwards extends CommandGroup {
	
    public  AutonomousForwards() {
    	addSequential(new Forwards());
    	//runs forwards
    }
}
