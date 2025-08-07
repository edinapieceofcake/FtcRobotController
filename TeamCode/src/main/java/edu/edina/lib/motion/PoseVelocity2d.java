package edu.edina.lib.motion;

import edu.edina.lib.math.Vector2d;

public class PoseVelocity2d {
    public final Vector2d linearVel;
    public final double angVel;

    public PoseVelocity2d(Vector2d linearVel, double angVel) {
        this.linearVel = linearVel;
        this.angVel = angVel;
    }
}
