package app.model.attributes;

import app.interfaces.AttributesI;

public class Attributes implements AttributesI {
    private String data;
    private String label;

    public Attributes(String label, String data) {
        this.label = label;
        this.data = data;
    }

    public void setData (String data){
        this.data = data;
    }

    @Override
    public String get() {        
        return data;
    }

    @Override
    public String getLabel() {
        return label;
    }   
}


