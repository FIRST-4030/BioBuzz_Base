package org.firstinspires.ftc.teamcode.Pedro;

import com.pedropathing.control.FilteredPIDFCoefficients;
import com.pedropathing.control.PIDFCoefficients;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.pedropathing.ftc.localization.constants.PinpointConstants;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class PedroConstantsDecodeBot implements PedroConstants {
    @Override
    public FollowerConstants getFollowerConstants() {
        return new FollowerConstants()
                .mass(9.624)  // Kg
                .forwardZeroPowerAcceleration(-33.283483666739514)
                .lateralZeroPowerAcceleration(-60.30465072724906)
                .translationalPIDFCoefficients(new PIDFCoefficients(0.18, 0, 0.01, 0.025))
                .headingPIDFCoefficients(new PIDFCoefficients(2,0,0,0.035))
                .drivePIDFCoefficients(new FilteredPIDFCoefficients(0.02, 0, 0.00001, 0.6, 0.01)); //p = 0.01
    }

    @Override
    public PathConstraints getPathConstraints() {
        return new PathConstraints(0.99, 100, 1, 1);
    }

    @Override
    public MecanumConstants getDriveConstraints() {
        return new MecanumConstants()
                .maxPower(1)
                .rightFrontMotorName("rightFront")
                .rightRearMotorName("rightBack")
                .leftRearMotorName("leftBack")
                .leftFrontMotorName("leftFront")
                .leftFrontMotorDirection(DcMotorSimple.Direction.REVERSE)
                .rightFrontMotorDirection(DcMotorSimple.Direction.FORWARD)
                .leftRearMotorDirection(DcMotorSimple.Direction.REVERSE)
                .rightRearMotorDirection(DcMotorSimple.Direction.FORWARD)
                .xVelocity(57.44290521576647)
                .yVelocity(45.753937969057574);
    }

    @Override
    public PinpointConstants getLocalizerConstants() {
        return new PinpointConstants()
                .forwardPodY(0.125)
                .strafePodX(2.875)
                .distanceUnit(DistanceUnit.INCH)
                .hardwareMapName("pinpoint")
                .encoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD)
                .forwardEncoderDirection(GoBildaPinpointDriver.EncoderDirection.FORWARD)
                .strafeEncoderDirection(GoBildaPinpointDriver.EncoderDirection.FORWARD);
    }
}
