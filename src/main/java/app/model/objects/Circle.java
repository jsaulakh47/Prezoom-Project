package app.model.objects;


import app.model.attributes.Radius;
import app.model.attributes.FillColor;
import app.model.attributes.StrokeColor;

public class Circle extends Objects
{
	public Circle(String x, String y, String radius) {
		super(x, y, "Circle");
		addAttribute(new Radius(radius));
		addAttribute(new FillColor("#FF0000"));
		addAttribute(new StrokeColor("#000000"));
	}

	public Circle(String x, String y) {
		this(x, y, "50" );
	}

    @Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}

