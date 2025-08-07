package edu.edina.lib.actions;

import java.util.ArrayList;
import java.util.Arrays;

/* Action combinator that executes the action group initialActions in parallel. Each call to run on
 * this action calls run on every live child action in the order provided. Completed actions are
 * removed from the rotation and do not prevent the completion of other actions. This action
 * completes when all of initialActions have. */
public class ParallelAction implements Action {
    private final String name;
    private final ArrayList<Action> actions;

    public ParallelAction(String name, Action... initialActions) {
        this(name, new ArrayList<>(Arrays.asList(initialActions)));
    }

    public ParallelAction(String name, ArrayList<Action> initialActions) {
        this.name = name;
        actions = initialActions;
    }

    @Override
    public boolean run() {
        ArrayList<Action> doneList = new ArrayList<>();

        for (Action a : actions) {
            if (!a.run())
                doneList.add(a);
        }

        actions.removeAll(doneList);

        return !actions.isEmpty();
    }

    @Override
    public void writeTo(ActionLog actionLog) {
        actionLog.writeln("parallel %s", name);
        actionLog.indent();
        for (Action a : actions)
            a.writeTo(actionLog);
        actionLog.unindent();
    }
}
