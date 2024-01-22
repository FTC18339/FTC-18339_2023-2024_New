package org.firstinspires.ftc.teamcode;

public class Command {
    public String name;
    public double data;
    public boolean positional;
    public float time;

    //Initializer
    public Command(String initName, double initData, boolean initPositional, float initTime) {
        name = initName;
        data = initData;
        positional = initPositional;
        time = initTime;
    }
}