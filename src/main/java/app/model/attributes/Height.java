package app.model.attributes;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 *
 * Class : This class represents Height attribute.
 * The value of this attribute determines the object's Height.
 * If no data is provided constructor, then the default value will be 100.
 */

public class Height extends Attributes {

    public static final String DEFAULT_DATA = "100";

    public Height(String data) {
        super(AttributeLabel.HEIGHT.getLabel(), data);
        
    }

    public Height() {
        this(DEFAULT_DATA);
    }
}
