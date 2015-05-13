package org.teamtators.tankdrive;


import org.teamtators.tankdrive.commands.DriveTeleop;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * The main robot class.
 */
public class Robot extends IterativeRobot {
	private Scheduler scheduler = Scheduler.getInstance();
	
	public Robot() {
		super();
	}

	public void robotInit() {
	}

	public void disabledInit() {
	}

	public void autonomousInit() {
	}

	public void teleopInit() {
		new DriveTeleop().start();
	}

	public void testInit() {
	}

	public void disabledPeriodic() {
	}

	public void autonomousPeriodic() {
	}

	public void teleopPeriodic() {
		scheduler.run();
	}

	public void testPeriodic() {
	}
	
}
