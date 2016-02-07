package com.nicoletfear.Stronghold2016;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import com.nicoletfear.Stronghold2016.commands.ArmDown;
import com.nicoletfear.Stronghold2016.commands.ArmUp;
import com.nicoletfear.Stronghold2016.commands.IntakeCommand;
import com.nicoletfear.Stronghold2016.commands.PassCommand;
import com.nicoletfear.Stronghold2016.commands.ShootCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Joystick left0;
    public Joystick right1;
    public static Joystick gameMech;
    public static Button aButton;
    public static Button bButton;
    public static Button yButton;
    public static Button rightBumper;
    public static Button leftBumper;
	public static DigitalInput limitSwitchTop;
	public static DigitalInput limitSwitchBottom;


    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    	gameMech = new Joystick(2);
    	aButton = new JoystickButton(gameMech , com.nicoletfear.Stronghold2016.xbox.Buttons.A);
    	bButton = new JoystickButton(gameMech , com.nicoletfear.Stronghold2016.xbox.Buttons.B);
    	yButton = new JoystickButton(gameMech , com.nicoletfear.Stronghold2016.xbox.Buttons.Y);
    	rightBumper = new JoystickButton(gameMech , com.nicoletfear.Stronghold2016.xbox.Buttons.RightBump);
    	leftBumper = new JoystickButton(gameMech , com.nicoletfear.Stronghold2016.xbox.Buttons.LeftBump);
    	
    	limitSwitchTop = new DigitalInput(RobotMap.limitSwitchTopPort);
		limitSwitchBottom = new DigitalInput(RobotMap.limitSwitchBottomPort);


    	aButton.whileHeld(new IntakeCommand());
    	bButton.whileHeld(new PassCommand());
    	yButton.whileHeld(new ShootCommand());
    	leftBumper.whileHeld(new ArmUp());
    	rightBumper.whileHeld(new ArmDown());
    	//runs commands when buttons pressed
    	
        right1 = new Joystick(1);
        
        left0 = new Joystick(0);
        
        
        //Button A = new JoystickButton(gameMech, 1);
        //1 is button A on xbox
        

	    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
	public static void init(){
		
	}
    public Joystick getLeft() {
        return left0;
    }

    public Joystick getRight() {
        return right1;
    }
    
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

