package app.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.model.objects.Objects;

public class Sheet {
    private List<States> states;
    private PropertyChangeSupport observable;
    private Map<Integer, ArrayList<Objects>> objects;

    public Sheet() {
        this.states = new ArrayList<States>();
        this.observable = new PropertyChangeSupport(this);
        this.objects = new HashMap<Integer, ArrayList<Objects>>();
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        observable.addPropertyChangeListener(pcl);
    }
 
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        observable.removePropertyChangeListener(pcl);
    }

    private int getSheetSize() {
        return this.states.size();
    }

    public void addState() {
        int size = this.getSheetSize();
        observable.firePropertyChange("states", size, size + 1);
        
        States state = new States();

        states.add(state);
        objects.put(state.getId(), new ArrayList<Objects>());
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

    public void addObject(int stateId, Objects object) {
        objects.get(stateId).add(object);
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
}
