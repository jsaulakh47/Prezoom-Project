package app.model.attributes;

public class Radius extends Attributes {

    public static final String DEFAULT_DATA = "50";

    public Radius(String data) {
        super("Radius", data);
    }  
    
    public Radius() {
        this(DEFAULT_DATA);
    }
}
