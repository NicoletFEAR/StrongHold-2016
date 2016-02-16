package com.nicoletfear.Stronghold2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousPIDForwards extends CommandGroup {
	
    public  AutonomousPIDForwards() {
    	//goes forwards for 10 feet
    	addSequential(new DistancePID(10));
    }
}
