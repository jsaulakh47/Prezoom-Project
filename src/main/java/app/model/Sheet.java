package app.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.model.objects.Objects;

public class Sheet {
    private List<States> states;
    private static Sheet instance;
    private Map<Integer, ArrayList<Objects>> objects;

    private Sheet() {
        this.states = new ArrayList<>();
        this.objects = new HashMap<>();
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
        objects.put(state.getId(), new ArrayList<>());
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
