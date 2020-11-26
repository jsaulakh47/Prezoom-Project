package app.model.attributes;

public class FontSize extends Attributes {

    public static final String DEFAULT_DATA = "12";

    public FontSize(String data) {
        super("FontSize", data);
        
    }

    public FontSize() {
        this(DEFAULT_DATA);
    }
}
