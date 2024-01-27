package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class TestAutoRotate extends Autonomous001 {
    @Override
    public void childCommandInitialization() {
        commands = new Command[] {
                new Command("TEMPROTATE", 21.169 * mmPerInch, true, 0)
        };
    }
}
