package edu.edina.lib.actions;

public class RunUntilAction implements Action {
    private final String name;
    private final Condition doneCondition;
    private final Action action;

    public RunUntilAction(String name, Condition doneCondition, Action action) {
        this.name = name;
        this.doneCondition = doneCondition;
        this.action = action;
    }

    @Override
    public boolean run() {
        if (doneCondition.run())
            return false;

        return action.run();
    }

    @Override
    public void writeTo(ActionLog actionLog) {
        actionLog.writeln("until %s", name);
        actionLog.indent();
        action.writeTo(actionLog);
        actionLog.unindent();
    }
}
