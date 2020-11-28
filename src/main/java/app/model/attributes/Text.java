package app.model.attributes;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 *
 * Class : This class represents Text attribute.
 * The value of this attribute determines the text written on the sheet.
 * If no data is provided constructor, then the default value will be "Alfa".
 */

public class Text extends Attributes {

    public static final String DEFAULT_DATA = "Alfa";

    public Text(String data) {
        super(AttributeLabel.TEXT.getLabel(), data);
    }

    public Text() {
        this(DEFAULT_DATA);
    }    
}
