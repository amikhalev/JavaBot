package org.teamtators.tankdrive.subsystems;

/**
 * The interface for the drive subsystem
 */
public interface Drive {
	/**
	 * Set the speeds of the wheels in RPS
	 * @param leftRPS The target RPS of the left wheel
	 * @param rightRPS The target RPS of the right wheel
	 */
	public void setSpeedsRPS(double leftRPS, double rightRPS);
	
	/**
	 * Set the powers of the wheels (in range [-1, 1])
	 * @param leftSpeed The power of the left wheel
	 * @param rightSpeed The power of the right wheel
	 */
	public void setSpeeds(double leftSpeed, double rightSpeed);
	
	/**
	 * Sets the drive mode
	 * @param driveMode The drive mode to use
	 */
	public void setDriveMode(DriveMode driveMode);
	
	/**
	 * Gets the current drive mode
	 * @return The current drive mode
	 */
	public DriveMode getDriveMode();
}
