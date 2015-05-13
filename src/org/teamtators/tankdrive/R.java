package org.teamtators.tankdrive;

import org.teamtators.tankdrive.subsystems.Drive;
import org.teamtators.tankdrive.subsystems.OperatorInterface;
import org.teamtators.tankdrive.subsystems.impl.DriveImpl;
import org.teamtators.tankdrive.subsystems.impl.OperatorInterfaceImpl;

/**
 * The class which holds references to all robot components (ie. subsystems, etc.)
 */
public abstract class R {
	public static OperatorInterface oi = new OperatorInterfaceImpl();
	public static Drive drive = new DriveImpl();
}
