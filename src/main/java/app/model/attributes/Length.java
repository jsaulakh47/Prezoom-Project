package app.model.attributes;

public class Length extends Attributes {

    public static final String DEFAULT_DATA = "100";

    public Length(String data) {
        super("Length", data);
        
    }
    
    public Length() {
        this(DEFAULT_DATA);
    }       
}