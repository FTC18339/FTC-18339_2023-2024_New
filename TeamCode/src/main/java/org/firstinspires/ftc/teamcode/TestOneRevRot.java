package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class TestOneRevRot extends Autonomous001 {
    @Override
    public void childCommandInitialization() {
        commands = new Command[] {
                new Command("ONEREVROT", 90, true, 0)
        };
    }
}