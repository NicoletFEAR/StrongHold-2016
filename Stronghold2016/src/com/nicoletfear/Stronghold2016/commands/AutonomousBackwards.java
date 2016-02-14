package com.nicoletfear.Stronghold2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousBackwards extends CommandGroup {
	
    public  AutonomousBackwards() {
    	addSequential(new Backwards());
       //runs backwards command
    }
}
