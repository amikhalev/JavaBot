package org.teamtators.tankdrive.subsystems.impl;

import org.teamtators.tankdrive.subsystems.OperatorInterface;

import edu.wpi.first.wpilibj.DriverStation;

/**
 * The default implementation for the operator interface.
 */
public class OperatorInterfaceImpl implements OperatorInterface {
	private final DriverStation driverStation = DriverStation.getInstance();
	private final int leftStick = 0;
	private final int leftAxis = 1;
	private final int rightStick = 0;
	private final int rightAxis = 3;
	
	public OperatorInterfaceImpl() {
	}
	
	@Override
	public double getDriveLeft() {
		return driverStation.getStickAxis(leftStick, leftAxis);
	}
	
	@Override
	public double getDriveRight() {
		return driverStation.getStickAxis(rightStick, rightAxis);
	}
}
