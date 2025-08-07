package edu.edina.lib.motion;

import edu.edina.lib.math.Vector2d;

public class Pose2d {
    public final Vector2d position;
    public final double heading;

    public Pose2d(Vector2d position, double heading) {
        this.position = position;
        this.heading = heading;
    }
}
