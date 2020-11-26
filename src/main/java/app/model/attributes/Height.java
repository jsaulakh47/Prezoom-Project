package app.model.attributes;

public class Height extends Attributes {

    public static final String DEFAULT_DATA = "100";

    public Height(String data) {
        super(AttributeLabel.HEIGHT.getLabel(), data);
        
    }

    public Height() {
        this(DEFAULT_DATA);
    }
}
