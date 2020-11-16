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

    public static Objects createObject(String type, String x, String y) {
        ObjectsI object;
        ObjectFactoryI factory = new ObjectFactory();

        if ("Circle".equals(type)) {
            object = factory.makeCircle(x, y);
            return (Objects) object;
        } else if ("Image".equals(type)) {
            object = factory.makeImage(x, y);
            return (Objects) object;
        } else if ("Line".equals(type)) {
            object = factory.makeLine(x, y);
            return (Objects) object;
        } else if ("Text".equals(type)) {
            object = factory.makeText(x, y);
            return (Objects) object;
        }  else if ("TextArea".equals(type)) {
            object = factory.makeTextArea(x, y);
            return (Objects) object;
        } else {
            object = factory.makeRectangle(x, y);
            return (Objects) object;
        }
    }

    public static void saveObject(int stateId, int objectId, Map<String, String> attr) {
        Sheet.getInstance().updateObject(stateId, objectId, attr);
    }
}
