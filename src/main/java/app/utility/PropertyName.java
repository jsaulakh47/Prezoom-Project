package app.utility;

public enum PropertyName {
    STATES("states"),
    OBJECTS("objects"),
    OBJECTID("object_id"),
    ATTRIBUTES("attributes");

    private String name;

    PropertyName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}