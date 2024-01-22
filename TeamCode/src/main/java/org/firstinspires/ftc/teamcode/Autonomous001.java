package org.firstinspires.ftc.teamcode;

public abstract class Autonomous001 extends Main002 {

    public Command[] commands;
    boolean runningAuto = false;
    int commandsIndex = 0;

    public float mmPerInch = Algorithms002.mmPerInch;

    // find distances in inches and notate them in variables here
    // (multiply by mmPerInch and set equal to a variable for distance)

    @Override
    public void runOpMode() {
        initMaths();
        initHardware();
        initManualModes();

        initAutonomousModes();

        childCommandInitialization();

        waitForStart();

        if(opModeIsActive()) {
            while(opModeIsActive()) {
                if(!runningAuto) {
                    runningAuto = true;
                    if(commandsIndex < commands.length) {
                        RunAutoCommand(commands[commandsIndex]);
                    } else
                        break;

                    StopMotors();
                }
                idle();
            }
        }
    }

    // Experimentally tested value - GoBilda

    /* Not too sure on the accuracy of my method:
    I set the bot straight, measured the angle (using the compass app on a phone) as 265 degrees
    West. Then, I ran OneRevRot (as seen in TestAutoRotate), and measured the degree after OneRevRot ran,
    and got 300 degrees (not sure of direction). Does this mean the rotationAngleOfOneRevolution in ANGLES
    is 35 degrees? As method of measurement is unsure, I do not know this. Unsure of how 55.1 degrees
    was originally gathered. Rotation section is convoluted and unsure. Also need to re-understand how math
    behind manual protocol works. Unfortunately, the compass app is inaccurate as I tested it on another
    phone, and it varied relatively greatly (more than 5 degrees). */
    double rotationAngleOfOneRevolution = Math.toRadians(55.1);
    public void RunAutoCommand(Command command) {
        String name = command.name;
        double data = command.data;
        long time = System.currentTimeMillis() + (long) (command.time * 1000);

        float ticksForMotors = MAX_NUM_TICKS_MOVEMENT;
        double revs = data / Algorithms002.wheelCircumferenceMm;

        if (command.positional) {
            switch (name) {
                case "ROTATE":
                    // Find the revolution the wheels must take for a certain angle, use the desired
                    // angle and divide by the rotation that one wheel revolution provides.
                    revs = Math.toRadians(data) / rotationAngleOfOneRevolution;
                    break;
                case "ONEREVROT":
                    revs = 1;
                    break;
                // starts at -14 ticks (CHECK REGULARLY)
                case "CHOPSTICKS ARM":
                    setChopsticksArmTicks((int) data);
                    break;
                case "WRIST":
                    break;
                case "CHOPSTICKS":
                    break;
            }
        }

        int ticks = (int) (revs * ticksForMotors);

        if (name == "MOVE") {
            setMovingTicks(ticks);
        } else if (name == "ROTATE") {
            setRotateTicks(ticks);
        } else if (name == "ONEREVROT") {
            SetTicksAndMotorsForMovement(ticks, true);
        } else if (name == "CHOPSTICKS ARM") {
            setChopsticksArmTicks(ticks);
        } else if (name == "WRIST") {
            setWrist();
        } else if (name == "CHOPSTICKS") {
            setChopsticks();
        }

        initAutonomousModes();
        commandsIndex++;
        runningAuto = false;
    }

    void SetTicksAndMotorsForMovement(int ticks, boolean rot) {
        int rotMultiplier = 1;
        if (rot) {
            rotMultiplier = -1;
        }

        left_back.setTargetPosition(rotMultiplier * ticks * -1);
        left_front.setTargetPosition(ticks * -1);
        right_back.setTargetPosition(rotMultiplier * ticks);
        right_front.setTargetPosition(ticks);

        RunToPositionAutonomousMovement();

        double ticksSpeed = MAX_NUM_TICKS_MOVEMENT * 0.05 * MOVEMENT_RPM;

        left_back.setVelocity(rotMultiplier * ticksSpeed);
        left_front.setVelocity(ticksSpeed);
        right_back.setVelocity(ticksSpeed);
        right_front.setVelocity(rotMultiplier * ticksSpeed);

        while(left_back.isBusy() && opModeIsActive()) {

        }
    }

    void setMovingTicks(int ticks) {
        left_back.setTargetPosition(ticks * -1);
        left_front.setTargetPosition(ticks * -1);
        right_back.setTargetPosition(ticks);
        right_front.setTargetPosition(ticks);

        RunToPositionAutonomousMovement();

        left_back.setVelocity(MAX_NUM_TICKS_MOVEMENT * 0.05 * MOVEMENT_RPM);
        left_front.setVelocity(MAX_NUM_TICKS_MOVEMENT * 0.05 * MOVEMENT_RPM);
        right_back.setVelocity(MAX_NUM_TICKS_MOVEMENT * 0.05 * MOVEMENT_RPM);
        right_front.setVelocity(MAX_NUM_TICKS_MOVEMENT * 0.05 * MOVEMENT_RPM);

        while (left_back.isBusy() && opModeIsActive()) {

        }
    }

    void setRotateTicks(int ticks) {

    }

    void setChopsticksArmTicks(int ticks) {

    }

    void setWrist() {

    }

    void setChopsticks() {

    }

    public void childCommandInitialization() {};
}