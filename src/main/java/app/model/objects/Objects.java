package app.model.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import app.interfaces.ObjectsI;
import app.model.attributes.XPosition;
import app.model.attributes.YPosition;
import app.model.attributes.Attributes;

public abstract class Objects implements ObjectsI {
    private List<Attributes> attributes;
    private static int count = 1;
    private String type;
    private int id;

    public Objects(String x, String y, String type) {
        attributes = new ArrayList<>();
        addAttribute(new XPosition(x));
        addAttribute(new YPosition(y));
        this.id = count++;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    protected void addAttribute(Attributes attribute) {
        this.attributes.add(attribute);
    }

    public void setAttribute(String key, String value) {
        for (Attributes attribute : attributes) {
            if (key.equals(attribute.getLabel())) {
                attribute.setData(value);
            }
        }
    }

    public Map<String, String> getAttributes() {
        Map<String, String> map = new HashMap<>();

        for (Attributes attribute : attributes) {
            map.put(attribute.getLabel(), attribute.getData());
        }

        return map;
    }
}