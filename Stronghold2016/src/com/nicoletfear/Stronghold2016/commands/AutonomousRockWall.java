package com.nicoletfear.Stronghold2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousRockWall extends CommandGroup {
	
    public  AutonomousRockWall() {
    	addSequential(new RockWall());
    	//runs forwards
    }
}
