package edu.edina.lib.motion;

public class Pose2dDual {
    public final Vector2dDual position;
    public final DualNum heading;

    public Pose2dDual(Vector2dDual position, DualNum heading) {
        this.position = position;
        this.heading = heading;
    }

    public Pose2dDual(DualNum positionX, DualNum positionY, DualNum heading) {
        this(new Vector2dDual(positionX, positionY), heading);
    }

    public Pose2d value() {
        return new Pose2d(position.value(), heading.value());
    }

    public Pose2dDual velocity() {
        return new Pose2dDual(position.drop(1), heading.drop(1));
    }
}
