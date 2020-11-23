package app.api;

import java.util.List;
import java.util.Map;

import app.interfaces.ObjectFactoryI;
import app.interfaces.ObjectsI;
import app.model.Sheet;
import app.model.States;
import app.model.objects.ObjectFactory;
import app.model.objects.Objects;

public class Interaction {

    public static final String CIRCLE = "Circle";
    public static final String IMAGE = "Image";
    public static final String LINE = "Line";
    public static final String TEXT = "Text";
    public static final String TEXT_AREA = "TextArea";

    public static void addState() {
        Sheet.getInstance().addState();
    }

    public static List<States> getStates() {
        return Sheet.getInstance().getStates();
    }

    public static Objects createObject(String type, int stateId, String x, String y) {
        ObjectsI object;
        ObjectFactoryI factory = new ObjectFactory();

        if (CIRCLE.equals(type)) {
            object = factory.makeCircle(x, y);
        } else if (IMAGE.equals(type)) {
            object = factory.makeImage(x, y);
        } else if (LINE.equals(type)) {
            object = factory.makeLine(x, y);
        } else if (TEXT.equals(type)) {
            object = factory.makeText(x, y);
        }  else if (TEXT_AREA.equals(type)) {
            object = factory.makeTextArea(x, y);
        } else {
            object = factory.makeRectangle(x, y);
        }

        Sheet.getInstance().addObject(stateId, (Objects) object);
        return (Objects) object;
    }

    public static void saveObject(int stateId, int objectId, Map<String, String> attr) {
        Sheet.getInstance().updateObject(stateId, objectId, attr);
    }

    public static List<Objects> loadState(int stateId) {
        return Sheet.getInstance().loadState(stateId);
    }
}
