package org.teamtators.tankdrive;


import org.teamtators.tankdrive.commands.DriveTeleop;
import org.teamtators.tankdrive.subsystems.Drive;
import org.teamtators.tankdrive.subsystems.OperatorInterface;
import org.teamtators.tankdrive.subsystems.impl.DriveImpl;
import org.teamtators.tankdrive.subsystems.impl.OperatorInterfaceImpl;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * The main robot class.
 */
public class Robot extends IterativeRobot {
	public static OperatorInterface oi;
	public static Drive drive;

	private Scheduler scheduler = Scheduler.getInstance();
	
	public Robot() {
		super();
	}

	public void robotInit() {
		defaultInit();

	}

	private void defaultInit() {
		oi = new OperatorInterfaceImpl();
		drive = new DriveImpl();
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
