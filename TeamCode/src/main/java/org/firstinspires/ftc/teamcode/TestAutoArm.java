package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class TestAutoArm extends Autonomous001 {
    @Override
    public void childCommandInitialization() {
        commands = new Command[] {
                new Command("CHOPSTICKS ARM", 10, false, 0)
        };
    }
}
