package edu.edina.lib.motion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DualNum {
    private final double[] values;

    public DualNum(double... values) {
        this.values = values;
    }

    public double value() {
        return get(0);
    }

    public double get(int i) {
        return values[i];
    }

    public DualNum drop(int n) {
        return new DualNum(Arrays.copyOfRange(values, n, values.length));
    }
}
