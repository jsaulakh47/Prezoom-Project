package app.model;

import java.util.List;


public class Sheet {
    private List<States> states;

    private static Sheet instance;

    private Sheet() {}

    public static Sheet getInstance() 
    { 
        if (instance == null) {
            instance = new Sheet(); 
        }

        return instance; 
    }

    public void addState() {
        new States();
    }
}
