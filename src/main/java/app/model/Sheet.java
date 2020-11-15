package app.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import app.model.objects.Objects;

public class Sheet {
    PropertyChangeSupport changes = new  PropertyChangeSupport(this);

    private List<States> states;
    private Map<Integer, List<Objects>> objects;
    private static Sheet instance;

    private Sheet() {
        this.states =  new ArrayList<States>();
    }

    public static Sheet getInstance() 
    { 
        if (instance == null) {
            instance = new Sheet(); 
        }

        return instance; 
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        changes.addPropertyChangeListener(l);
    }
	
    public void removePropertyChangeListener(PropertyChangeListener l) {
        changes.removePropertyChangeListener(l);
    }
    
    public int addState() {
        List<States> old = states;
        States state = new States();

        states.add(state);
        changes.firePropertyChange("value", old, states);
        
        return state.getId();
    }

    public List<States> getStates() {
        return states;
    } 

    public void addObject(int stateId , Object object)
    {
        // objects.put(stateId, object);
    }
}
