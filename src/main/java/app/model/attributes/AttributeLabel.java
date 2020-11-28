package app.model.attributes;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 *
 * Class : AttributeLabel Enum
 * This enum is used to store labels for all the attributes in the application.
 */
public enum AttributeLabel {
    END_X("End X"),
    FILL_COLOR("Fill color"),
    FONT("Font"),
    FONT_SIZE("FontSize"),
    HEIGHT("Height"),
    LENGTH("Length"),
    RADIUS("Radius"),
    SOURCE("Source"),
    STROKE_COLOR("Stroke color"),
    STROKE_WIDTH("Stroke width"),
    TEXT("Text"),
    TEXT_AREA("Text area"),
    WIDTH("Width"),
    X_POSITION("X position"),
    Y_POSITION("Y position"),
    END_Y("End Y");

    private String label;

    AttributeLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
