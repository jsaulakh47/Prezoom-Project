package app.model.attributes;

//import app.model.attributes.Attributes;;

public class Radius extends Attributes {

    private double radius; 

    @Override
    public void setData(double data) {        
        this.radius = data;
    }

    @Override
    public double get() {        
        return radius;
    }
    
}
