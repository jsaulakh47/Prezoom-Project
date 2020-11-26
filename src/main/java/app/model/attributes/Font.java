package app.model.attributes;

public class Font extends Attributes {

    public static final String DEFAULT_DATA = "";

    public Font(String data) {
        super("Font", data);
        
    }

    public Font() {
        this(DEFAULT_DATA);
    }
}
