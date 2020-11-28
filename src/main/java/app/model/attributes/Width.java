package app.model.attributes;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 *
 * Class : This class represents Width attribute.
 * The value of this attribute determines the object's width.
 * If no data is provided constructor, then the default value will be 100.
 */

public class Width extends Attributes {

    public static final String DEFAULT_DATA = "100";

    public Width(String data) {
        super(AttributeLabel.WIDTH.getLabel(), data);
    }

    public Width() {
        this(DEFAULT_DATA);
    }
}
