package app.model.attributes;

import app.interfaces.AttributesI;

public class Attributes implements AttributesI {
    private double data;

    public void setData (double data){
        this.data = data;
    }
    @Override
    public double get() {        
        return data;
    }
      
    
}


