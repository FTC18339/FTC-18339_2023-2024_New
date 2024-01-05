package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class Main001 extends LinearOpMode {
    public DcMotorEx left_front;
    public DcMotorEx right_front;
    public DcMotorEx left_back;
    public DcMotorEx right_back;
    public DcMotorEx linear_actuator;

    public final float MAX_NUM_TICKS_MOVEMENT = 537.7f;
    public final float MOVEMENT_RPM = 25;
    // the actuator numbers are assumptions based on last year, change if necessary
    public final float MAX_NUM_TICKS_ACTUATOR = 384.5f;
    public final float ACTUATOR_RPM = 180;

    public Algorithms001 math;

    @Override
    public void runOpMode() { }

    public void initMaths() {
        math = new Algorithms001();
        math.Initialize();
    }

    public void initHardware() {
        left_front = hardwareMap.get(DcMotorEx.class, "left_front");
        right_front = hardwareMap.get(DcMotorEx.class, "right_front");
        left_back = hardwareMap.get(DcMotorEx.class, "left_back");
        right_back = hardwareMap.get(DcMotorEx.class, "right_back");

        right_back.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right_front.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        left_back.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        left_front.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        linear_actuator = hardwareMap.get(DcMotorEx.class, "linear_actuator");
    }

    public void initManualModes() {
        right_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right_front.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        left_back.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        left_front.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        linear_actuator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public boolean noNullHardware() {
        return (left_back != null && left_front != null && right_back != null && right_front != null && linear_actuator != null);
    }
}
