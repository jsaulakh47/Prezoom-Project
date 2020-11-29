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

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 * Class : This class represents sheet.
 * this sheet class handles the states and it is also observable class that notify the editcontroller;
 */

public class Sheet {

    
    private int currentStateIndex;
    private boolean selectedObject;

    private List<States> states;
    private PropertyChangeSupport observable;

    private static final double WIDTH = 1080.0;
    private static final double HEIGHT = 720.0;

    /**
     * default constructor which setup the list for storing the states;
     * also add one default state on the sheet;
     */

    public Sheet() {
        this.status = "";
        this.selectedObject = false;
        this.states = new ArrayList<>();
        this.observable = new PropertyChangeSupport(this);

        addState();       
    }

    /**
     * this sub-routine allows to add the observers to sheet class; 
     * @param pcl;
     */

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        observable.addPropertyChangeListener(pcl);
    }

    /**
     * this sub-routine allows to removes the observers to sheet class
     * @param pcl;
     */
 
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        observable.removePropertyChangeListener(pcl);
    }

    

    /**
     * this sub-routine sets the index of the current state;
     * @param index;
     */

    public void setCurrentStateIndex(int index) {
        this.currentStateIndex = index;
    }

    /**
     * this sub-routine sets the selected object;
     * @param selected;
     */

    public void setHasSelectedObject(boolean selected) {
        this.selectedObject = selected;
    }

    /**
     * this sub-routine returns the TRUE when object is selected;
     * @return selectedObject;
     */

    public boolean hasSelectedObject() {
        return selectedObject;
    }

    /**
     * this sub-routine returns the height of the sheet;
     * @return height;
     */

    public double getHeight() {
        return HEIGHT;
    }

    /**
     *  this sub-routine returns the width of the sheet;
     * @return width;
     */

    public double getWidth() {
        return WIDTH;
    }

   
    /**
     * this sub-routine returns the size of the list that stores the states; 
     * @return size;
     */

    public int getSheetSize() {
        return states.size();
    }

    /**
     * this sub-routine return the current state by using current state index;
     * @return currentState;
     */

    public States getCurrentState() {
        return states.get(currentStateIndex);
    }

    /**
     * this sub-routine return the  id of current state;
     * @return Id;
     */

    public int getCurrentStateId() {
        return  getCurrentState().getId();
    }

    /**
     * this sub-routine return the  index of current state;
     * @return currentStateIndex;
     */

    public int getCurrentStateIndex() {
        return currentStateIndex;
    }

    /**
     * this sub-routine return the size of current state;
     * @return size of currentState;
     */

    public int getCurrentStateSize() {
        return getCurrentState().getStateSize();
    }

    /**
     * this sub-routine return the camera attributes;
     * @return cameraAttribures;
     */

    public Map<String, String> getCurrentCameraAttributes() {
        return getCurrentState().getCameraAttributes();
    }

    /**
     * this sub-routines returns the list of states;
     * @return states;
     */

    public List<States> getStates() {
        return states;
    }

    /**
     * this sub-routine adding the states and stores into the list
     * it also notify the others observers;
     */

    public void addState() {
        int size = getSheetSize(); 
        States state = new States();

        states.add(state);
        setCurrentStateIndex(getSheetSize() - 1);
        observable.firePropertyChange(PropertyName.STATES.getName(), size, getSheetSize());
    }

    /**
     * this sub-routine replicate the states and again store into the list;
     * it also notify the others observers; 
     * throws exception when there is invalid object enter;
     * @param index
     * @throws InvalidObjectTypeException
     */

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

    /**
     * this sub-routine remove the states from the sheet;
     * @param index
     */

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

    /**
     * this sub-routine adds objects to the states;
     * also throws the exception when invalid object is added;
     * @param type
     * @param xPosition
     * @param yPosition
     * @throws InvalidObjectTypeException
     */

    public void addObject(String type, double xPosition, double yPosition) throws InvalidObjectTypeException {
        States state = getCurrentState();
        state.addObject(type, xPosition, yPosition);
    }

    /**
     * this sub-routine updates the attributrs of the objects;
     * @param attr
     */

    public void updateObject(Map<String, String> attr) {
        getCurrentState().updateObject(attr);
        setHasSelectedObject(true);
    }

    /**
     * this sub-routine returns the objects attributes;
     * @return
     */

    public Map<String, String> getObjectAttributes() {
        return states.get(currentStateIndex).getObjectAttributes();
    }

    /**
     * this sub-routine helps the select the object;
     * @param x
     * @param y
     */

    public void selectObjectAt(double x, double y) {
        States state = getCurrentState();
        boolean selected = state.selectObject(x, y);
        observable.firePropertyChange(PropertyName.ATTRIBUTES.getName(), null, selected);
    }

    /**
     * this sub-routines draw all objects expect the camera object;
     * @param drawingAdapter
     */

    public void draw(DrawingAdapterI drawingAdapter) {
        for (Objects object : getCurrentState().getObjects()) {
            object.draw(drawingAdapter);
        }
    }
    
    /**
     * this sub-routines draw one objects at a time;
     * @param drawingAdapter
     * @param index
     */

    public void drawObject(DrawingAdapterI drawingAdapter, int index) {
        getCurrentState().getAllObjects().get(index).draw(drawingAdapter);
	}
}