package edu.edina.lib.actions;

public class InstantAction implements Action {
    private final String name;
    private final InstantFunction function;

    public InstantAction(String name, InstantFunction function) {
        this.name = name;
        this.function = function;
    }

    @Override
    public boolean run() {
        function.run();
        return false;
    }

    @Override
    public void writeTo(ActionLog actionLog) {
        actionLog.writeln("call %s", name);
    }
}
