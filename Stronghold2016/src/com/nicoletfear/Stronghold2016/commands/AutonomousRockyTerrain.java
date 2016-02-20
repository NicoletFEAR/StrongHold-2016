package com.nicoletfear.Stronghold2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousRockyTerrain extends CommandGroup {
	
    public  AutonomousRockyTerrain() {
    	addSequential(new RockyTerrain());
    	//runs forwards
    }
}
