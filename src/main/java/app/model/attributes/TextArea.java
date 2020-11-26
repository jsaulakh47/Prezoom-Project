package app.model.attributes;

public class TextArea extends Attributes {

    public static final String DEFAULT_DATA = "Alfa";

    public TextArea(String data) {
        super("Text area", data);
    }

    public TextArea() {
        this(DEFAULT_DATA);
    }    
}
