package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class TestAutoMove extends Autonomous001 {
    @Override
    public void childCommandInitialization() {
        commands = new Command[] {
                new Command("TEMPROTATE", 22 * mmPerInch, false, 0),
                new Command("TEMPROTATE", -22 * mmPerInch, false, 0)
        };
    }
}
