package app.model.attributes;

public class Width extends Attributes {

    public static final String DEFAULT_DATA = "100";

    public Width(String data) {
        super(AttributeLabel.WIDTH.getLabel(), data);
    }

    public Width() {
        this(DEFAULT_DATA);
    }
}
