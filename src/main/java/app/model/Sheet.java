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
    private int CurrentState;
    private List<States> states;
    private PropertyChangeSupport observable;
    private Map<Integer, ArrayList<Objects>> objects;

    private static final double WIDTH = 1080.0;
    private static final double HEIGHT = 720.0;

    public Sheet() {
        this.CurrentState = 0;
        this.objects = new HashMap<>();
        this.states = new ArrayList<>();
        this.observable = new PropertyChangeSupport(this);
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

    public void setCurrentState(int index) {
        this.CurrentState = index;
    }

    public int getCurrentState() {
        return this.CurrentState;
    }

    public void addState() {
        int size = this.getSheetSize();
        observable.firePropertyChange("states", size, size + 1);
        
        States state = new States();

        states.add(state);
        objects.put(state.getId(), new ArrayList<>());
    }

    public void replicateState(int index) {
        int size = this.getSheetSize();
        observable.firePropertyChange("states", size, size + 1);
        
        States state = new States();

        states.add(state);
        objects.put(state.getId(), objects.get(states.get(index).getId()));
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
        States state = states.get(this.getCurrentState());

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

        objects.get(state.getId()).add((Objects) object);
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

    public void draw(DrawingAdapterI drawingAdapter ) {
        States state = states.get(this.getCurrentState());
        for (Objects object : objects.get(state.getId())) {
            object.draw(drawingAdapter);
        }
	}
}
