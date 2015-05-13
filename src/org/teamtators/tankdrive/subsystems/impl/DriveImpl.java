package org.teamtators.tankdrive.subsystems.impl;

import org.teamtators.tankdrive.subsystems.Drive;
import org.teamtators.tankdrive.subsystems.DriveMode;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

/**
 * The default implementation for the drive subsystem
 */
public class DriveImpl implements Drive {
	private final SpeedController leftMotor;
	private final SpeedController rightMotor;
	private final Encoder leftEncoder;
	private final Encoder rightEncoder;
	private final PIDController leftController;
	private final PIDController rightController;
	private final double maxRPS;

	private DriveMode driveMode;

	public DriveImpl() {
		leftMotor = new Talon(0);
		rightMotor = new Talon(1);

		leftEncoder = new Encoder(0, 1);
		rightEncoder = new Encoder(2, 3);
		leftEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
		rightEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
		leftEncoder.setDistancePerPulse(1.0 / 360.0);
		rightEncoder.setDistancePerPulse(1.0 / 360.0);

		leftController = new PIDController(.02, 0.0, 0.0, leftEncoder,
				leftMotor);
		rightController = new PIDController(.02, 0.0, 0.0, rightEncoder,
				rightMotor);

		maxRPS = 20.0;

		driveMode = DriveMode.PID;
	}

	@Override
	public void setSpeedsRPS(double leftRPS, double rightRPS) {
		leftController.setSetpoint(leftRPS);
		rightController.setSetpoint(rightRPS);
	}

	@Override
	public void setSpeeds(double leftPower, double rightPower) {
		switch (driveMode) {
		case DIRECT:
			leftMotor.set(leftPower);
			rightMotor.set(rightPower);
			break;
		case PID:
			setSpeedsRPS(leftPower * maxRPS, rightPower * maxRPS);
			break;
		}
	}

	@Override
	public void setDriveMode(DriveMode driveMode) {
		this.driveMode = driveMode;
		switch (driveMode) {
		case DIRECT:
			leftController.disable();
			rightController.disable();
			break;
		case PID:
			leftController.enable();
			rightController.enable();
			break;
		}
	}

	@Override
	public DriveMode getDriveMode() {
		return driveMode;
	}

}
