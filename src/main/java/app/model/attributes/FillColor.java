package app.model.attributes;

public class FillColor extends Attributes {

    public FillColor(String data) {
        super("Fill color", data);
    }

    public FillColor() {
        this("#FF0000");
    }    
}
