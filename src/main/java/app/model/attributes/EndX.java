package app.model.attributes;

public class EndX extends Attributes {

    public static final String DEFAULT_DATA = "100";

    public EndX(String data) {
        super("End X", data);

    }

    public EndX() {
        this(DEFAULT_DATA);
    }
}
