package edu.edina.lib.actions;

import java.util.ArrayList;
import java.util.Arrays;

/* Action combinator that executes the action group initialActions in series. Each action is run one
 * after the other. When an action completes, the next one is immediately run. This action completes
 * when the last action completes. */
public class SequentialAction implements Action {
    private final String name;
    private final ArrayList<Action> actions;

    public SequentialAction(String name, Action... initialActions) {
        this(name, new ArrayList<>(Arrays.asList(initialActions)));
    }

    public SequentialAction(String name, ArrayList<Action> initialActions) {
        this.name = name;
        actions = initialActions;
    }

    @Override
    public boolean run() {
        while (!actions.isEmpty()) {
            if (actions.get(0).run())
                return true;
            else
                actions.remove(0);
        }

        return false;
    }

    @Override
    public void writeTo(ActionLog actionLog) {
        actionLog.writeln("sequence %s", name);
        actionLog.indent();
        for (int i = 0; i < actions.size(); i++) {
            if (i == 1)
                actionLog.writeln("-----------------------");

            Action a = actions.get(i);
            a.writeTo(actionLog);
        }
        actionLog.unindent();
    }
}
