package app.model.attributes;

public class EndY extends Attributes {

    public static final String DEFAULT_DATA = "100";

    public EndY(String data) {
        super(AttributeLabel.END_Y.getLabel(), data);
    }
    
    public EndY() {
        this(DEFAULT_DATA);
    }    
}
