package app.model.attributes;

//import app.model.attributes.Attributes;

public class YPosition extends Attributes {

    private double Ypos;

    @Override
    public void setData(double data) {        
        this.Ypos = data;
    }

    @Override
    public double get() {        
        return Ypos;
    }
    
}
