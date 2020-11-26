package app.model.attributes;

public class StrokeWidth extends Attributes {

    public static final String DEFAULT_DATA = "1";

    public StrokeWidth(String data) {
        super(AttributeLabel.STROKE_WIDTH.getLabel(), data);
    }

    public StrokeWidth() {
        this(DEFAULT_DATA);
    }
}
