package app.model;

public class States {
    private int id;
    private static int count = 1;

    public States() {
        this.id = count++;
    }

    public int getId() {
        return id;
    }
};

    

