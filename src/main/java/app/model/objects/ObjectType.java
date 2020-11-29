package app.model.objects;

public enum ObjectType {
    CIRCLE("Circle"),
    IMAGE("Image"),
    LINE("Line"),
    PLAIN_TEXT("Text"),
    RECTANGLE("Rectangle"),
    TEXT_AREA("TextArea"),
    CAMERA("Camera");

    private String type;

    ObjectType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
