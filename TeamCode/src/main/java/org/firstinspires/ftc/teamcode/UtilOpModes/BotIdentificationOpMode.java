package org.firstinspires.ftc.teamcode.UtilOpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.BuildConfig;
import org.firstinspires.ftc.teamcode.ControlHub;

import java.io.IOException;

// DO NOT disable this opmode
@TeleOp(name="Bot Identification Manager", group = "Util")
public class BotIdentificationOpMode extends OpMode {

    ControlHub controlHub;
    String operation= "";

    public void init() {
        controlHub = new ControlHub();
        telemetry.addData("Compiled on:", BuildConfig.COMPILATION_DATE);
        telemetry.update();
    }

    public void loop() {
        boolean completed;
        telemetry.addLine("Initialize ControlHub:");
        telemetry.addLine("   A   - Create ControlHub file");
        telemetry.addLine("   B   - Delete ControlHub file");
        telemetry.addLine("   X   - Get ControlHub file name");
        telemetry.addLine("   Y   - Get Current ControlHub");
        telemetry.addLine("   LB - Define ControlHub as BIOBUZZ_DEMO");
        telemetry.addLine("   RB - Define ControlHub as BIOBUZZ_COMPETITION");
        telemetry.addLine("DPAD-DOWN - Define ControlHub as DECODE (probably don't use)");

        if (gamepad1.aWasReleased()) {
            try {
                completed = controlHub.createControlHubFile();
                if (completed) {
                    operation = "File Created";
                } else {
                    operation = "File NOT Created";
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else if (gamepad1.bWasReleased()) {
            completed = controlHub.deleteControlHubFile();
            if (completed) {
                operation = "File Deleted";
            } else {
                operation = "File NOT Deleted";
            }

        } else if (gamepad1.xWasReleased()) {
            operation = "File=";
            operation = operation + controlHub.getControlHubFileName();

        } else if (gamepad1.yWasReleased()) {
            operation = "ControlHub=" + controlHub.getBotIdentification();

        } else if (gamepad1.leftBumperWasReleased()) {
            try {
                controlHub.initializeControlHub(ControlHub.BotIdentification.BIOBUZZ_DEMO);
                operation = "ControlHub=" + controlHub.getBotIdentification();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else if (gamepad1.rightBumperWasReleased()) {
            try {
                controlHub.initializeControlHub(ControlHub.BotIdentification.BIOBUZZ_COMPETITION);
                operation = "ControlHub=" + controlHub.getBotIdentification();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (gamepad1.dpadDownWasPressed()) {
            try {
                controlHub.initializeControlHub(ControlHub.BotIdentification.DECODE);
                operation = "ControlHub=" + controlHub.getBotIdentification();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        telemetry.addData("Operation:",operation);
        telemetry.update();
    }
}
