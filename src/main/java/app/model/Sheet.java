package app.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.exceptions.InvalidObjectTypeException;
import app.interfaces.DrawingAdapterI;
import app.interfaces.ObjectFactoryI;
import app.interfaces.ObjectsI;
import app.model.objects.ObjectFactory;
import app.model.objects.ObjectType;
import app.model.objects.Objects;

public class Sheet {
    private int CurrentStateIndex;

    private List<States> states;
    private PropertyChangeSupport observable;
    private Map<Integer, ArrayList<Objects>> objects;

    private static final double WIDTH = 1080.0;
    private static final double HEIGHT = 720.0;

    public Sheet(PropertyChangeListener pcl) {
        this.objects = new HashMap<>();
        this.states = new ArrayList<>();
        this.observable = new PropertyChangeSupport(this);

        this.observable.addPropertyChangeListener(pcl);        
        States state = new States();
        states.add(state);

        setCurrentStateIndex(getSheetSize() - 1);
        objects.put(state.getId(), new ArrayList<>());
        observable.firePropertyChange("states", 0, 1);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        observable.addPropertyChangeListener(pcl);
    }
 
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        observable.removePropertyChangeListener(pcl);
    }

    public double getHeight() {
        return HEIGHT;
    }

    public double getWidth() {
        return WIDTH;
    }

    private int getSheetSize() {
        return this.states.size();
    }

    public void setCurrentStateIndex(int index) {
        this.CurrentStateIndex = index;
    }

    public States getCurrentState() {
        return states.get(getCurrentStateIndex());
    }


    public int getCurrentStateId() {
        return  getCurrentState().getId();
    }

    public int getCurrentStateIndex() {
        return this.CurrentStateIndex;
    }

    public int getCurrentStateObjectSize() {
        States state = states.get(getCurrentStateIndex());
        return objects.get(state.getId()).size();
    }

    public void addState() {
        int size = this.getSheetSize();
        observable.firePropertyChange("states", size, size + 1);
        
        States state = new States();

        states.add(state);
        objects.put(state.getId(), new ArrayList<>());
        this.setCurrentStateIndex(this.getSheetSize() - 1);
    }

    public void replicateState(int index) {
        int size = this.getSheetSize();
        observable.firePropertyChange("states", size, size + 1);
        
        States state = new States();

        states.add(state);
        objects.put(state.getId(), objects.get(getStates().get(index).getId()));
    }

    public void removeState(int index) {
        int size = this.getSheetSize();
        int newSize = size == 1 ? size : size - 1; 
        observable.firePropertyChange("states", size, newSize);
        
        States state = states.get(index);
        
        states.remove(index);
        objects.remove(state.getId());

        if (this.getSheetSize() == 0) {
            this.addState();
        }
    }

    public List<States> getStates() {
        return states;
    }

    public List<Objects> loadState(int stateId) {
        return objects.get(stateId);
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

        objects.get(getCurrentStateId()).add((Objects) object);
    }

    public void updateObject(int stateId, int objectId, Map<String, String> attr) {
        for (Objects object : objects.get(stateId)) {
            if (object.getId() == objectId) {
                for (Map.Entry<String, String> entry : attr.entrySet()) {
                    object.setAttribute(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public void draw(DrawingAdapterI drawingAdapter) {
        for (Objects object : objects.get(getCurrentStateId())) {
            object.draw(drawingAdapter);
        }
	}
}