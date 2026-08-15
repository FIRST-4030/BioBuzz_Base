package org.firstinspires.ftc.teamcode.Pedro;

import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.pedropathing.ftc.localization.constants.PinpointConstants;
import com.pedropathing.paths.PathConstraints;

public interface PedroConstants {
    FollowerConstants getFollowerConstants();
    PathConstraints getPathConstraints();
    MecanumConstants getDriveConstraints();
    PinpointConstants getLocalizerConstants();
}
