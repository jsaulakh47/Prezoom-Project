package app.model.attributes;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 *
 * Class : This class represents Font attribute.
 * The value of this attribute determines the font family of the text.
 * If no data is provided constructor, then the default value will be <TBD>.
 */

public class Font extends Attributes {

    public static final String DEFAULT_DATA = "";

    public Font(String data) {
        super(AttributeLabel.FONT.getLabel(), data);
        
    }

    public Font() {
        this(DEFAULT_DATA);
    }
}
