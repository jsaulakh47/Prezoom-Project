package app.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.model.objects.Objects;

public class Sheet {
    private List<States> states;
    private Map<Integer, ArrayList<Objects>> objects;
    private static Sheet instance;

    private Sheet() {
        this.states = new ArrayList<States>();
        this.objects = new HashMap<Integer, ArrayList<Objects>>();
    }

    public static Sheet getInstance() {
        if (instance == null) {
            instance = new Sheet();
        }

        return instance;
    }

    public void addState() {
        States state = new States();

        states.add(state);
        objects.put(state.getId(), new ArrayList<Objects>());
    }

    public List<States> getStates() {
        return states;
    }

    public void addObject(int stateId, Objects object) {
        objects.get(stateId).add(object);
    }

    public void updateObject(int stateId, int objectId, Map<String, String> attr) {
        System.out.println(stateId);
        System.out.println(objects);
        System.out.println( objects.get(stateId));
        for (Objects object : objects.get(stateId)) {
            if (object.getId() == objectId) {
                for (Map.Entry<String, String> entry : attr.entrySet()) {
                    object.setAttribute(entry.getKey(), entry.getValue());
                }
            }
        }
    }
}
