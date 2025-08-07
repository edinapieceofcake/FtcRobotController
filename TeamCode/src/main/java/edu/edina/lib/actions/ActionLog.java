package edu.edina.lib.actions;

import com.qualcomm.robotcore.util.RobotLog;

public class ActionLog {
    private final StringBuilder str;
    private final String tag;
    private int indentLevel;

    public ActionLog(String tag) {
        this.tag = tag;
        str = new StringBuilder();
    }

    public void writeln(String s, Object... args) {
        if (str.length() > 0)
            str.append('\n');

        for (int i = 0; i < indentLevel; i++)
            str.append(' ');

        str.append(String.format(s, args));
    }

    public void indent() {
        indentLevel += 4;
    }

    public void unindent() {
        indentLevel -= 4;
    }

    public void writeToRobotLog() {
        RobotLog.ii(tag, str.toString());
    }
}
