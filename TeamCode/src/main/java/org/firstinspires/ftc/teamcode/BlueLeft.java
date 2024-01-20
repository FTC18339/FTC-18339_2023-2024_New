package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class BlueLeft extends Autonomous001 {
    @Override
    public void childCommandInitialization() {
        commands = new Command[] {
                new Command("MOVE", 36 * mmPerInch, true, 0),
                new Command("ROTATE", -90, true, 0),
                new Command("MOVE", 42 * mmPerInch, true, 0)
        };
    }
}
