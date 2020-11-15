package app.api;

import java.util.List;
import java.util.Map;

import app.interfaces.ObjectFactoryI;
import app.interfaces.ObjectsI;
import app.model.Sheet;
import app.model.States;
import app.model.objects.ObjectFactory;

public class Interaction {
    public static int addState() {
        return Sheet.getInstance().addState();
    }

    public static List<States> getStates() {
        return Sheet.getInstance().getStates();
    }

    public static Map<String, String> createObject(String type, String x, String y) {
        
        ObjectFactoryI factory = new ObjectFactory();
        ObjectsI object;
        if ("Circle".equals(type)) {
            object = factory.makeCircle(x, y);
            return object.getAttributes();
        } else if ("Image".equals(type)) {
            object = factory.makeCircle(x, y);
            return object.getAttributes();
        } else if ("Line".equals(type)) {
            object = factory.makeLine(x, y);
            return object.getAttributes();
        } else if ("Text".equals(type)) {
            object = factory.makeText(x, y);
            return object.getAttributes();
        }  else if ("TextArea".equals(type)) {

        } else {
            object = factory.makeRectangle(x, y);
            return object.getAttributes();
        }
        
        return null;
    }
}
