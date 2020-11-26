package app.interfaces;

import java.util.Map;

public interface ObjectsI {
    Map<String, String> getAttributes();

    void setAttribute(String key, String value);

    void draw(DrawingAdapterI drawingAdapter);
}