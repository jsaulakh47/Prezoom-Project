package app.model.attributes;

import app.interfaces.AttributesI;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 *
 * Class : This class represent the parent Attribute class.
 * Any attribute present in the application has to extend this class.
 */

public class Attributes implements AttributesI {
    private String data;
    private String label;

    public Attributes(String label, String data) {
        this.label = label;
        this.data = data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public String getLabel() {
        return label;
    }
}


