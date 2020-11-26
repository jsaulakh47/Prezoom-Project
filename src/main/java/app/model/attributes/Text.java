package app.model.attributes;

public class Text extends Attributes {

    public static final String DEFAULT_DATA = "Alfa";

    public Text(String data) {
        super(AttributeLabel.TEXT.getLabel(), data);
    }

    public Text() {
        this(DEFAULT_DATA);
    }    
}
