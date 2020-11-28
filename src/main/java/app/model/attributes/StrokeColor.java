package app.model.attributes;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 *
 * Class : This class represents Stoke Color attribute.
 * The value of this attribute determines the object's stroke color.
 * If no data is provided constructor, then the default value will be #000000.
 */

public class StrokeColor extends Attributes {

    public static final String DEFAULT_DATA = "#000000";

    public StrokeColor(String data) {
        super(AttributeLabel.STROKE_COLOR.getLabel(), data);
    }

    public StrokeColor() {
        this(DEFAULT_DATA);
    }
}
