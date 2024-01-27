package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class RedLeft extends Autonomous001 {
    @Override
    public void childCommandInitialization() {
        commands = new Command[] {
                new Command("MOVE", 54 * mmPerInch, true, 0),
                new Command("TEMPROTATE", 22 * mmPerInch, true, 0),
                new Command("MOVE", -36 * mmPerInch, true, 0),
                new Command("TEMPROTATE", 22 * mmPerInch, true, 0),
                new Command("MOVE", 54 * mmPerInch, true, 0),
                new Command("TEMPROTATE", 22 * mmPerInch, true, 0),
                new Command("MOVE", 36 * mmPerInch, true, 0)
        };
    }
}
