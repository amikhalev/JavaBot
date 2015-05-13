package org.teamtators.tankdrive.commands;

import org.teamtators.tankdrive.R;
import org.teamtators.tankdrive.subsystems.DriveMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 * The command which should run in teleop to control the drive train from
 * operator input
 */
public class DriveTeleop extends Command {
	public DriveTeleop() {
		super("DriveTeleop");
	}

	protected void initialize() {
		R.drive.setDriveMode(DriveMode.PID);
	}
	
	protected void execute() {
		double left = R.oi.getDriveLeft();
		double right = R.oi.getDriveRight();
		
		left = exponent(deadzone(left, .05), 2.0);
		right = exponent(deadzone(right, .05), 2.0);
		
		R.drive.setSpeeds(left, right);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		R.drive.setSpeeds(0, 0);
	}

	protected void interrupted() {
		R.drive.setSpeeds(0, 0);
	}
	
	/**
	 * Applys a deadzone to a joystick value
	 * @param input The input joystick value
	 * @param deadzone The maximum magnitude for the joystick value before it is
	 * deadzoned
	 * @return The deadzoned value
	 */
	private double deadzone(double input, double deadzone) {
		if (Math.abs(input) <= deadzone) {
			return 0.0;
		}
		return input;
	}
	
	/**
	 * Applys an exponent to a joystick value, preserving sign
	 * @param input The input joystick value
	 * @param exponent The exponent to apply
	 * @return The value with exponent applied
	 */
	private double exponent(double input, double exponent) {
		if (input >= 0) {
			return Math.pow(Math.abs(input), exponent);
		} else {
			return -Math.pow(Math.abs(input), exponent);
		}
	}
}
