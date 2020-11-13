package app.model.attributes;

public class FontAttributes extends Attributes {
    
    private double fontSize;

    @Override
    public void setData(double data) {        
       this.fontSize = data;
    }
    @Override
    public double get() {        
        return fontSize;
    }
}
