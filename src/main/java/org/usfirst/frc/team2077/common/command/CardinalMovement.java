/*----------------------------------------------------------------------------*/
/* Copyright (c) 2020 FRC Team 2077. All Rights Reserved.                     */
/* Open Source Software - may be modified and shared by FRC teams.            */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2077.common.command;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.*;
import org.usfirst.frc.team2077.RobotHardware;
import org.usfirst.frc.team2077.common.*;
import org.usfirst.frc.team2077.common.control.DriveXboxController;
import org.usfirst.frc.team2077.common.drivetrain.*;
import org.usfirst.frc.team2077.util.SmartDashNumber;

public class CardinalMovement extends CommandBase {
    protected DriveXboxController stick;
    protected DriveChassisIF chassis;

    public CardinalMovement(DriveXboxController stick) {
        addRequirements(RobotHardware.getInstance().getPosition());

        this.stick = stick;
        this.chassis = RobotHardware.getInstance().getChassis();
    }

    @Override public void execute() {
        double north = -stick.getNorth();
        double east = stick.getEast();

        if(DriverStation.isTeleop()) chassis.setVelocityPercent(north, east);
    }

    @Override public void end(boolean interrupted) {
    }

    @Override public boolean isFinished() {
        return false;
    }
}
