package org.teamtators.tankdrive.subsystems;

/**
 * A mode that the drive can run in.
 */
public enum DriveMode {
	/**
	 * Running in direct drive mode, ie. raw powers, unscaled
	 */
	DIRECT,

	/**
	 * Running in PID rate controlled mode
	 */
	PID;
}
