package app.model;

import java.util.Map;

import app.interfaces.ObjectsI;

public abstract class  Objects implements ObjectsI {

    private static int id = 0;

    public Objects() {
        id++;
    }

    public int getId() {
        return id;
    }

}