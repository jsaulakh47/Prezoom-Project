package app.model.attributes;

//import app.model.attributes.Attributes;

public class ColorAttributes extends Attributes {

    private double color;
    
    @Override
    public void setData(double data) {                
        this.color = data;
    }

    @Override
    public double get() {        
        return color;
    }
    
}
