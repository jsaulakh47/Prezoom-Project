package app.api;

import java.util.List;

import app.model.Sheet;
import app.model.States;

public class Interaction {
    public static int addState()
    {
        return Sheet.getInstance().addState();
    }

    public static List<States> getStates() {
        return Sheet.getInstance().getStates();
    }

    // public static List<States> addObject(int stateId) {
    //     return Sheet.getInstance().adObject();
    // }
}
