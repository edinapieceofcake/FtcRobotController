package edu.edina.lib.actions;

import androidx.annotation.NonNull;

public class WaitUntil implements Action {
    private final Condition condition;
    private final String name;

    public WaitUntil(String name, Condition condition) {
        this.condition = condition;
        this.name = name;
    }

    @Override
    public boolean run() {
        return !condition.run();
    }

    @Override
    public void writeTo(ActionLog actionLog) {
        actionLog.writeln("wait until %s", name);
    }
}
