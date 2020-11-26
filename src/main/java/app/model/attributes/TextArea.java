package app.model.attributes;

public class TextArea extends Attributes {

    public static final String DEFAULT_DATA = "Alfa";

    public TextArea(String data) {
        super(AttributeLabel.TEXT_AREA.getLabel(), data);
    }

    public TextArea() {
        this(DEFAULT_DATA);
    }    
}
