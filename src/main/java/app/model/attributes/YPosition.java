package app.model.attributes;

public class YPosition extends Attributes {

    public static final String DEFAULT_DATA = "50";

    public YPosition(String data) {
        super(AttributeLabel.Y_POSITION.getLabel(), data);
    }

    public YPosition() {
        this(DEFAULT_DATA);
    }
}
