package org.firstinspires.ftc.teamcode.Pedro;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;

public class PedroUtility {
    private final Follower follower;

    public PedroUtility(Follower follower) {
        this.follower = follower;
    }
    public PathChain makeCommonTwoPosePathChain(Pose pose1, Pose pose2) {
        return follower.pathBuilder()
                .addPath(new BezierLine(
                        pose1,
                        pose2
                ))
                .setLinearHeadingInterpolation(
                        pose1.getHeading(),
                        pose2.getHeading()
                )
                .build();
    }
}
