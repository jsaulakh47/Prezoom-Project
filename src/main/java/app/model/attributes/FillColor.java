package app.model.attributes;

public class FillColor extends Attributes {

    public static final String DEFAULT_DATA = "#FF0000";

    public FillColor(String data) {
        super("Fill color", data);
    }

    public FillColor() {
        this(DEFAULT_DATA);
    }    
}
