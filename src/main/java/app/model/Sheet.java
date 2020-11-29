package app.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.KeyStore.Entry.Attribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.exceptions.InvalidObjectTypeException;
import app.interfaces.DrawingAdapterI;
import app.interfaces.ObjectFactoryI;
import app.model.attributes.Attributes;
import app.model.objects.ObjectFactory;
import app.model.objects.ObjectType;
import app.model.objects.Objects;
import app.utility.PropertyName;
import app.utility.Trigger;

public class Sheet {
    private int currentStateIndex;
    private boolean selectedObject;

    private boolean notify;
    private List<States> states;
    private PropertyChangeSupport observable;

    private static final double WIDTH = 1080.0;
    private static final double HEIGHT = 720.0;

    public Sheet() {
        this.notify = true;
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

    public void setNotify(boolean notify) {
        this.notify = notify;
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

    public boolean getNotify() {
        return notify;
    }

    public int getSheetSize() {
        return states.size();
    }

    public States getCurrentState() {
        return states.get(currentStateIndex);
    }

    public int getCurrentStateId() {
        return getCurrentState().getId();
    }

    public int getCurrentStateIndex() {
        return currentStateIndex;
    }

    public int getCurrentStateSize() {
        return getCurrentState().getStateSize();
    }

    public Map<String, String> getCurrentCameraAttributes() {
        return getCurrentState().getCameraAttributes();
    }

    public List<States> getStates() {
        return states;
    }

    public void addState() {
        int size = getSheetSize();
        States state = new States();

        states.add(state);
        setCurrentStateIndex(getSheetSize() - 1);
        if (getNotify()) {
            observable.firePropertyChange(PropertyName.STATES.getName(), size, getSheetSize());
        }
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
        if (getNotify()) {
            observable.firePropertyChange(PropertyName.STATES.getName(), size, getSheetSize());
        }
    }

    public void removeState(int index) {
        int size = getSheetSize();
        states.remove(index);

        if (size == 1) {
            addState();
        } else {
            setCurrentStateIndex(index == 0 ? 0 : index - 1);
        } if (getNotify()) {
            observable.firePropertyChange(PropertyName.STATES.getName(), size, getSheetSize());
        }
    }

    public void addObject(String type, double xPosition, double yPosition) throws InvalidObjectTypeException {
        States state = getCurrentState();
        state.addObject(type, xPosition, yPosition);
    }

    public void updateObject(Map<String, String> attr) {
        getCurrentState().updateObject(attr);
        setHasSelectedObject(true);
    }

    public Map<String, String> getObjectAttributes() {
        return states.get(currentStateIndex).getObjectAttributes();
    }

    public void selectObjectAt(double x, double y) {
        States state = getCurrentState();
        boolean selected = state.selectObject(x, y);
        if (getNotify()) {
            observable.firePropertyChange(PropertyName.ATTRIBUTES.getName(), null, selected);
        }
    }

    public void draw(DrawingAdapterI drawingAdapter) {
        for (Objects object : getCurrentState().getObjects()) {
            object.draw(drawingAdapter);
        }
    }

    public void drawObject(DrawingAdapterI drawingAdapter, int index) {
        getCurrentState().getAllObjects().get(index).draw(drawingAdapter);
    }

    public void saveTo(PrintWriter p) {
        p.println("current_state:" + getCurrentStateIndex());

        for (States state : states) {
            p.println("state:" + state.getId());
            p.println("trigger:" + state.getTrigger());
            p.println("background:" + state.getBackgroundColor());

            for (Objects object : state.getAllObjects()) {
                p.println("object:" + object.getType() + "|" + object.getX() + "|" + object.getY());
                p.println("link_id:" + object.getLinkId());
                for (Map.Entry<String, String> attribute : object.getAttributes().entrySet()) {
                    p.println(attribute.getKey() + ":" + attribute.getValue());
                }
            }
        }
    }

    public void loadFrom(BufferedReader file) {
        states.clear();
        setNotify(false);
        boolean camera = false;

        int current = 0;
        States state = null;
        Objects object = null;
        Map<String, String> attributes = new HashMap<>();

        try {
            for (String line = file.readLine(); line != null; line = file.readLine()) {
                String[] element = line.split(":");
                if (element[0].trim().equals("current_state")) {
                    current = Integer.parseInt(element[1]);
                } else  if (element[0].trim().equals("state")) {
                    addState();
                    attributes.clear();
                    state = getCurrentState();
                } else if (element[0].trim().equals("trigger")) {
                    state.setTrigger(Trigger.valueOf(element[1]));
                } else if (element[0].trim().equals("background")) {
                    state.setBackgroundColor(element[1]);
                } else if (element[0].trim().equals("object")) {
                    if (attributes.size() > 0) {
                        if (camera == true) {
                            state.setCurrentObjectIndex(0);
                            updateObject(attributes);
                            camera = false;
                        } else {
                            updateObject(attributes);
                        }
                        attributes.clear();
                    }

                    String[] obj = element[1].split("\\|"); 
                    if (obj[0].trim().equals("Camera")) {
                        camera = true;
                    } else {
                        state.addObject(obj[0], Double.parseDouble(obj[1]), Double.parseDouble(obj[1]));
                        object = getCurrentState().getCurrentObject();
                    }
                } else if (element[0].trim().equals("link_id") && Integer.parseInt(element[1]) > 0) {
                    object.setLinkId(Integer.parseInt(element[1]));
                } else {
                    attributes.put(element[0], element[1]);
                }
            }
        } catch (NumberFormatException | IOException | InvalidObjectTypeException e) {
            e.printStackTrace();
        }

        setCurrentStateIndex(current);
    }
}