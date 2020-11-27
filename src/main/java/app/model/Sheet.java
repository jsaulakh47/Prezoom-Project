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
    private int currentObjectId;
    private int currentStateIndex;

    private List<States> states;
    private PropertyChangeSupport observable;
    private Map<Integer, ArrayList<Objects>> objects;

    private static final double WIDTH = 1080.0;
    private static final double HEIGHT = 720.0;

    public Sheet() {
        this.status = "";
        this.objects = new HashMap<>();
        this.states = new ArrayList<>();
        this.observable = new PropertyChangeSupport(this);

        addState(null);       
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

    public int getSheetSize() {
        return states.size();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCurrentStateIndex(int index) {
        currentStateIndex = index;
    }

    public void setCurrentObjectId(int id) {
        observable.firePropertyChange(PropertyName.OBJECTID.getName(), currentObjectId, id);
        currentObjectId = id;
    }

    public States getCurrentState() {
        return states.get(getCurrentStateIndex());
    }


    public int getCurrentStateId() {
        return  getCurrentState().getId();
    }

    public int getCurrentStateIndex() {
        return currentStateIndex;
    }

    public int getCurrentStateObjectSize() {
        States state = states.get(getCurrentStateIndex());
        return objects.get(state.getId()).size();
    }

    public int getCurrentObjectId() {
        return currentObjectId;
    }

    public void addState(ArrayList<Objects> data) {
        int size = getSheetSize(); 
        States state = new States();

        states.add(state);
        setCurrentStateIndex(getSheetSize() - 1);
        objects.put(state.getId(), new ArrayList<>());
        
        if (data != null) {
            for (int i = 0; i < data.size(); i ++) {
                Objects object = data.get(i);
                try {
                    addObject(object.getType(), 0, 0);
                } catch (InvalidObjectTypeException ex) {
                    System.out.println(ex);
                }
    
                updateObject(getCurrentObjectId(), object.getAttributes());
            }
        }

        observable.firePropertyChange(PropertyName.STATES.getName(), size, getSheetSize());
    }

    public void replicateState(int index) {
        addState(objects.get(getStates().get(index).getId()));
    }

    public void removeState(int index) {
        int size = getSheetSize();
        States state = states.get(index);
        
        states.remove(index);
        objects.remove(state.getId());

        if (size == 1) {
            addState(null);
        } else {
            setCurrentStateIndex(index == 0 ? 0 : index - 1);
        }

        observable.firePropertyChange(PropertyName.STATES.getName(), size, getSheetSize());
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

        setCurrentObjectId(((Objects) object).getId());
        objects.get(getCurrentStateId()).add((Objects) object);
    }

    public void updateObject(int id, Map<String, String> attr) {
        for (Objects object : objects.get(getCurrentStateId())) {
            if (object.getId() == id) {
                for (Map.Entry<String, String> entry : attr.entrySet()) {
                    object.setAttribute(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public void selectObjectAt(double x, double y) {
        int id = 0;
        setCurrentObjectId(0);
        boolean found = false;
        for (Objects object : objects.get(getCurrentStateId())) {
            if (object.locatedAt(x, y)) {
                id = object.getId();
                found = true;
                break;
            }
        } if (found) {
            setCurrentObjectId(id);
        } 

        observable.firePropertyChange(PropertyName.ATTRIBUTES.getName(), 0, id);
    }

    public Map<String, String> getObjectAttributes(int id) {
        for (Objects object : objects.get(getCurrentStateId())) {
            if (object.getId() == id) {
                setCurrentObjectId(id);
                return object.getAttributes();
            }
        }
        
        setCurrentObjectId(0);
        return null;
    }

    public void draw(DrawingAdapterI drawingAdapter) {
        for (Objects object : objects.get(getCurrentStateId())) {
            object.draw(drawingAdapter);
        }
	}
}