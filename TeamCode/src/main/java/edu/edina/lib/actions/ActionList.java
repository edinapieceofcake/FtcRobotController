package edu.edina.lib.actions;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.List;

public class ActionList {
    private List<Action> runningActions;

    public ActionList() {
        runningActions = new ArrayList<>();
    }

    public void clear() {
        runningActions.clear();
    }

    public void add(Action a) {
        runningActions.add(a);
    }

    public void remove(Action a) {
        runningActions.remove(a);
    }

    public void run() {
        List<Action> runList = runningActions;
        runningActions = new ArrayList<>();

        for (Action action : runList) {
            if (action.run()) {
                runningActions.add(action);
            }
        }
    }

    @SuppressLint("DefaultLocale")
    public void writeToRobotLog() {
        ActionLog log = new ActionLog("ActionList");
        for (int i = 0; i < runningActions.size(); i++) {
            Action a = runningActions.get(i);
            a.writeTo(log);
        }

        log.writeToRobotLog();
    }
}
