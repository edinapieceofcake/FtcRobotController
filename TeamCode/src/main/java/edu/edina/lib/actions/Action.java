package edu.edina.lib.actions;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.ArrayList;
import java.util.List;

public interface Action {
    boolean run();

    void writeTo(ActionLog actionLog);
}
