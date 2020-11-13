package app.model;

import java.util.List;

import app.model.attributes.Attributes;

public class Camera {
    private List<Attributes> attributes;
    
    private static Camera instance;
    private Camera() {}
    
    public static Camera getInstance() {
        if(instance == null) {
            instance = new Camera();
        }
        return instance;
    }
    public void setAttributes(List<Attributes> attributes) {
        this.attributes = attributes;
    }

    public List<Attributes> getAttributes() {
        return attributes;
    }
}
