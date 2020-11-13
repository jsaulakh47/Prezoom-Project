package app.model.attributes;

//import app.model.attributes.Attributes;;

public class XPosition extends Attributes {

    private double Xpos; 

    @Override
    public void setData(double data) {        
        this.Xpos = data;
    }

    @Override
    public double get() {        
        return Xpos;
    }
    
}
