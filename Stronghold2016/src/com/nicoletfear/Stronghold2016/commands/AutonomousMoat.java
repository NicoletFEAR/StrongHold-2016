package com.nicoletfear.Stronghold2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousMoat extends CommandGroup {
	
    public  AutonomousMoat() {
    	addSequential(new Moat());
    	//runs forwards
    }
}
