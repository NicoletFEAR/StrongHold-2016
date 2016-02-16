package com.nicoletfear.Stronghold2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousPIDForwards extends CommandGroup {
	
    public  AutonomousPIDForwards() {
    	addSequential(new DistancePID(10));
    	//runs forwards
    }
}
