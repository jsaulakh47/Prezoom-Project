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
import app.utility.PropertyName;

public class Sheet {
    private String status;
    private int currentStateIndex;
    private boolean selectedObject;

    private List<States> states;
    private PropertyChangeSupport observable;

    private static final double WIDTH = 1080.0;
    private static final double HEIGHT = 720.0;

    public Sheet() {
        this.status = "";
        this.selectedObject = false;
        this.states = new ArrayList<>();
        this.observable = new PropertyChangeSupport(this);

        addState();       
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        observable.addPropertyChangeListener(pcl);
    }
 
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        observable.removePropertyChangeListener(pcl);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCurrentStateIndex(int index) {
        this.currentStateIndex = index;
    }

    public void setHasSelectedObject(boolean selected) {
        this.selectedObject = selected;
    }

    public boolean hasSelectedObject() {
        return selectedObject;
    }

    public double getHeight() {
        return HEIGHT;
    }

    public double getWidth() {
        return WIDTH;
    }

    public String getStatus() {
        return status;
    }

    public int getSheetSize() {
        return states.size();
    }

    public States getCurrentState() {
        return states.get(currentStateIndex);
    }

    public int getCurrentStateId() {
        return  getCurrentState().getId();
    }

    public int getCurrentStateIndex() {
        return currentStateIndex;
    }

    public int getCurrentStateSize() {
        return states.get(currentStateIndex).getStateSize();
    }

    public List<States> getStates() {
        return states;
    }

    public void addState() {
        int size = getSheetSize(); 
        States state = new States();

        states.add(state);
        setCurrentStateIndex(getSheetSize() - 1);
        observable.firePropertyChange(PropertyName.STATES.getName(), size, getSheetSize());
    }

    public void replicateState(int index) throws InvalidObjectTypeException {
        int size = getSheetSize(); 
        States state = new States();
        for (Objects object : states.get(index).getObjects()) {
            state.addObject(object.getType(), object.getX(), object.getY());
            state.updateObject(object.getAttributes());
        }

        states.add(state);
        setCurrentStateIndex(getSheetSize() - 1);
        observable.firePropertyChange(PropertyName.STATES.getName(), size, getSheetSize());
    }

    public void removeState(int index) {
        int size = getSheetSize();
        states.remove(index);

        if (size == 1) {
            addState();
        } else {
            setCurrentStateIndex(index == 0 ? 0 : index - 1);
        }

        observable.firePropertyChange(PropertyName.STATES.getName(), size, getSheetSize());
    }

    public void addObject(String type, double xPosition, double yPosition) throws InvalidObjectTypeException {
        States state = getCurrentState();
        state.addObject(type, xPosition, yPosition);
    }

    public void updateObject(Map<String, String> attr) {
        States state = getCurrentState();
        state.updateObject(attr);
    }

    public Map<String, String> getObjectAttributes() {
        return states.get(currentStateIndex).getObjectAttributes();
    }

    public void selectObjectAt(double x, double y) {
        States state = getCurrentState();
        boolean selected = state.selectObject(x, y);

        setHasSelectedObject(selected);
        observable.firePropertyChange(PropertyName.ATTRIBUTES.getName(), null, selected);
    }

    public void draw(DrawingAdapterI drawingAdapter) {
        for (Objects object : states.get(currentStateIndex).getAllObjects()) {
            object.draw(drawingAdapter);
        }
	}
}