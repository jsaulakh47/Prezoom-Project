package app.api;

import java.util.List;
import java.util.Map;

import app.interfaces.ObjectFactoryI;
import app.interfaces.ObjectsI;
import app.model.Sheet;
import app.model.States;
import app.model.objects.ObjectFactory;
import app.model.objects.ObjectType;
import app.model.objects.Objects;

public class Interaction {

    public static void addState() {
    }

    public static List<States> getStates() {
        return null;
    }

    public static Objects createObject(String type, int stateId, String x, String y) throws InvalidObjectTypeException {
        ObjectsI object;
        ObjectFactoryI factory = new ObjectFactory();

        if (ObjectType.CIRCLE.getType().equals(type)) {
            object = factory.makeCircle(x, y);
        } else if (ObjectType.IMAGE.getType().equals(type)) {
            object = factory.makeImage(x, y);
        } else if (ObjectType.LINE.getType().equals(type)) {
            object = factory.makeLine(x, y);
        } else if (ObjectType.PLAIN_TEXT.getType().equals(type)) {
            object = factory.makePlainText(x, y);
        } else if (ObjectType.TEXT_AREA.getType().equals(type)) {
            object = factory.makeTextArea(x, y);
        } else if (ObjectType.RECTANGLE.getType().equals(type)) {
            object = factory.makeRectangle(x, y);
        } else {
            throw new InvalidObjectTypeException(type);
        }
        
        return null;
    }

    public static void saveObject(int stateId, int objectId, Map<String, String> attr) {
        
    }

    public static List<Objects> loadState(int stateId) {
        return null;
    }
}
