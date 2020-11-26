package app.model.attributes;

public class Text extends Attributes {

    public static final String DEFAULT_DATA = "Alfa";

    public Text(String data) {
        super("Text", data);
    }

    public Text() {
        this(DEFAULT_DATA);
    }    
}
