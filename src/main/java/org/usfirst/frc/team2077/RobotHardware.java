package org.usfirst.frc.team2077;

import org.usfirst.frc.team2077.common.HardwareRequirements;
import org.usfirst.frc.team2077.common.WheelPosition;
import org.usfirst.frc.team2077.common.drivetrain.DriveModuleIF;
import org.usfirst.frc.team2077.drivetrain.SwerveChassis;
import org.usfirst.frc.team2077.subsystem.Claw;
import org.usfirst.frc.team2077.subsystem.ScissorArm;
import org.usfirst.frc.team2077.subsystem.SwerveModule;

public class RobotHardware extends HardwareRequirements<SwerveModule, SwerveChassis> {
    private static RobotHardware instance;

    public static RobotHardware getInstance() {
        if(instance == null) instance = new RobotHardware();
        return instance;
    }

    private final SwerveChassis chassis;

    public RobotHardware() {
        instance = this;

        chassis = new SwerveChassis();
    }

    @Override public SwerveChassis getChassis() {
        return chassis;
    }

    @Override public SwerveModule getWheel(WheelPosition position) {
        return chassis.getWheel(position);
    }
}
