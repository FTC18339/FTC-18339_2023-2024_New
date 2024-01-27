package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

public class Main002 extends LinearOpMode {
    public Servo wrist;
    public Servo chopsticks;
    public Servo drone_launcher;
    public DcMotorEx left_front;
    public DcMotorEx right_front;
    public DcMotorEx left_back;
    public DcMotorEx right_back;
    public DcMotorEx linear_actuator;
    public DcMotorEx chopsticks_arm;

    public final float MAX_NUM_TICKS_MOVEMENT = 537.7f;
    public final float MOVEMENT_RPM = 25;

    // (NEED TO GET NUMBERS, THIS FROM 22-23) public final float MAX_NUM_TICKS_LINEAR_ACTUATOR = 384.5f;
    public final float LINEAR_ACTUATOR_RPM = 110;

    // (NEED TO GET NUMBERS)
    public final float MAX_NUM_TICKS_CHOPSTICKS_ARM = 1000;
    public final float MAX_NUM_TICKS_LINEAR_ACTUATOR = 1000;
    public final float CHOPSTICKS_ARM_RPM = 40;

    public Algorithms002 math;

    @Override
    public void runOpMode() { }

    public void initMaths() {
        math = new Algorithms002();
        math.Initialize();
    }

    public void initHardware() {
        wrist = hardwareMap.get(Servo.class, "wrist");
        chopsticks = hardwareMap.get(Servo.class, "chopsticks");

        left_front = hardwareMap.get(DcMotorEx.class, "left_front");
        right_front = hardwareMap.get(DcMotorEx.class, "right_front");
        left_back = hardwareMap.get(DcMotorEx.class, "left_back");
        right_back = hardwareMap.get(DcMotorEx.class, "right_back");

        right_back.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right_front.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        left_back.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        left_front.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        linear_actuator = hardwareMap.get(DcMotorEx.class, "linear_actuator");

        chopsticks_arm = hardwareMap.get(DcMotorEx.class, "chopsticks_arm");

        drone_launcher = hardwareMap.get(Servo.class, "drone_launcher");
    }

    public void initManualModes() {
        right_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right_front.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        left_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        left_front.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        linear_actuator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        chopsticks_arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void initAutonomousModesMovement() {
        resetMotorsAutonomousMovement();
        right_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right_front.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        left_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        left_front.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void initAutonomousArm() {
        resetMotorsAutonomousArm();
        chopsticks_arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void RunToPositionAutonomousMovement() {
        right_back.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_front.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left_back.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left_front.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void runToPositionAutonomousArm() {
        chopsticks_arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void StopMotors() {
        right_back.setVelocity(0);
        left_back.setVelocity(0);
        right_front.setVelocity(0);
        left_front.setVelocity(0);

        linear_actuator.setVelocity(0);

        chopsticks_arm.setVelocity(0);
    }

    public void resetMotorsAutonomousMovement() {
        right_back.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_front.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        left_back.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        left_front.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void resetMotorsAutonomousArm() {
        chopsticks_arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public boolean noNullHardware() {
        return (left_back != null && left_front != null && right_back != null && right_front != null && linear_actuator != null && chopsticks_arm != null);
    }
}
