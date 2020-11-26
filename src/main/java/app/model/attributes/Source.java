package app.model.attributes;

public class Source extends Attributes {

    public static final String DEFAULT_DATA = "src/main/resources/alfa.png";

    public Source(String data) {
        super(AttributeLabel.SOURCE.getLabel(), data);
        
    }

    public Source() {
        this(DEFAULT_DATA);
    }
}
