package app.model.attributes;

public class StrokeColor extends Attributes {

    public static final String DEFAULT_DATA = "#000000";

    public StrokeColor(String data) {
        super(AttributeLabel.STROKE_COLOR.getLabel(), data);
    }

    public StrokeColor() {
        this(DEFAULT_DATA);
    }
}
