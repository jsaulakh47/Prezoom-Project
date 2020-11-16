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
    public static void addState() {
        Sheet.getInstance().addState();
    }

    public static List<States> getStates() {
        return Sheet.getInstance().getStates();
    }

    public static Objects createObject(String type, int stateId, String x, String y) {
        ObjectsI object;
        ObjectFactoryI factory = new ObjectFactory();

        if ("Circle".equals(type)) {
            object = factory.makeCircle(x, y);
        } else if ("Image".equals(type)) {
            object = factory.makeImage(x, y);
        } else if ("Line".equals(type)) {
            object = factory.makeLine(x, y);
        } else if ("Text".equals(type)) {
            object = factory.makeText(x, y);
        }  else if ("TextArea".equals(type)) {
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
