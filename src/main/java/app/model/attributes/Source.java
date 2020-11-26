package app.model.attributes;

public class Source extends Attributes {

    public static final String DEFAULT_DATA = "src/main/resources/alfa.png";

    public Source(String data) {
        super("Source", data);
        
    }

    public Source() {
        this(DEFAULT_DATA);
    }
}
