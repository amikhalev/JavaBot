package org.teamtators.tankdrive.subsystems;

/**
 * The interface that commands can use to receive operator input
 */
public interface OperatorInterface {
	/**
	 * Gets the input value for the left side of the drive train.
	 * 
	 * @return The value, in range [-1, 1]
	 */
	public double getDriveLeft();

	/**
	 * Gets the input value for the right side of the drive train.
	 * 
	 * @return The value, in range [-1, 1]
	 */
	public double getDriveRight();
}