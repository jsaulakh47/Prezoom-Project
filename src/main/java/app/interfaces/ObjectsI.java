package app.interfaces;

import java.util.Map;

public interface ObjectsI {
    Map<String, String> getAttributes();

    void setAttribute(String key, String value);

    boolean locatedAt(double x, double y);

    void draw(DrawingAdapterI drawingAdapter);
}