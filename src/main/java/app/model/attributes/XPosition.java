package app.model.attributes;

public class XPosition extends Attributes {

    public static final String DEFAULT_DATA = "50";

    public XPosition(String data) {
        super(AttributeLabel.X_POSITION.getLabel(), data);
    }

    public XPosition() {
        this(DEFAULT_DATA);
    }
}
