package app.model.attributes;

public class Length extends Attributes {

    public static final String DEFAULT_DATA = "100";

    public Length(String data) {
        super(AttributeLabel.LENGTH.getLabel(), data);
        
    }
    
    public Length() {
        this(DEFAULT_DATA);
    }       
}