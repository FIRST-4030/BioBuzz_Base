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

public class PedroConstantsBioBuzzCompetitionBot implements PedroConstants {
    @Override
    public FollowerConstants getFollowerConstants() {
        return new FollowerConstants()
                .mass(5.604)  // Kg
                .forwardZeroPowerAcceleration(-46.147414758850900)
                .lateralZeroPowerAcceleration(-63.242491832933500)
                .translationalPIDFCoefficients(new PIDFCoefficients(0.08, 0, 0.00, 0.025))
                .headingPIDFCoefficients(new PIDFCoefficients(2.2,0,0,0.032))
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
                .xVelocity(54.433983349737500)
                .yVelocity(46.051271613814400);
    }

    @Override
    public PinpointConstants getLocalizerConstants() {
        return new PinpointConstants()
                .forwardPodY(-5.5)
                .strafePodX(5.0)
                .distanceUnit(DistanceUnit.INCH)
                .hardwareMapName("pinpoint")
                .encoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD)
                .forwardEncoderDirection(GoBildaPinpointDriver.EncoderDirection.REVERSED)
                .strafeEncoderDirection(GoBildaPinpointDriver.EncoderDirection.REVERSED);
    }
}
