package app.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.exceptions.InvalidObjectTypeException;
import app.interfaces.ObjectFactoryI;
import app.interfaces.ObjectsI;
import app.model.objects.Camera;
import app.model.objects.ObjectFactory;
import app.model.objects.ObjectType;
import app.model.objects.Objects;
import app.utility.Trigger;

public class States {
    private int id;
    private static int count = 1;
    private List<Objects> objects;

    private int currentObjectIndex;

    private Trigger trigger;

    private String triggerValue;

    public States() {
        this.id = count++;
        this.objects = new ArrayList<>();

        objects.add(new Camera());
    }

    public int getId() {
        return id;
    }

    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
    }

    public void setCurrentObjectIndex(int index) {
        this.currentObjectIndex = index;
    }

    public Objects getCurrentObject() {
        return objects.get(currentObjectIndex);
    }

    public Trigger getTrigger() {
        return trigger;
    }

    public int getCurrentObjectId() {
        return getCurrentObject().getId();
    }

    public int getCurrentObjectIndex() {
        return currentObjectIndex;
    }

    public int getStateSize() {
        return objects.size();
    }

    public List<Objects> getObjects() {
        return objects.subList(1, objects.size());
    }

    public List<Objects> getAllObjects() {
        return objects;
    }

    public Map<String, String> getCameraAttributes() {
        return objects.get(0).getAttributes();
    }

    public void addObject(String type, double xPosition, double yPosition) throws InvalidObjectTypeException {
        ObjectsI object;
        ObjectFactoryI factory = new ObjectFactory();

        String x = String.valueOf(xPosition);
        String y = String.valueOf(yPosition);

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

        objects.add((Objects) object);
        setCurrentObjectIndex(objects.size() - 1);
    }

    public void updateObject(Map<String, String> attr) {
        Objects object = objects.get(currentObjectIndex);
        for (Map.Entry<String, String> entry : attr.entrySet()) {
            object.setAttribute(entry.getKey(), entry.getValue());
        }
    }

    public Map<String, String> getObjectAttributes() {
        return objects.get(currentObjectIndex).getAttributes();
    }

    public boolean selectObject(double x, double y) {
        int index = 1;
        boolean found = false;
        for (Objects object : getObjects()) {
            if (object.locatedAt(x, y)) {
                setCurrentObjectIndex(index);
                found = true;
                break;
            }

            index++;
        }

        return found;
    }
};

