package app.model.attributes;

//import app.model.attributes.Attributes;


public class Length extends Attributes {
    
    private double length;

    @Override
    public void setData(double data) {        
        this.length = data;
    }

	@Override
	public double get() {		
		return length ;
	}
    
}