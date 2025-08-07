package edu.edina.lib.motion;

import edu.edina.lib.math.Vector2d;

public class Vector2dDual {
    public final DualNum x, y;

    public Vector2dDual(DualNum x, DualNum y) {
        this.x = x;
        this.y = y;
    }

    public Vector2d value() {
        return new Vector2d(x.value(), y.value());
    }

    public Vector2dDual drop(int n) {
        return new Vector2dDual(x.drop(n), y.drop(n));
    }
}

