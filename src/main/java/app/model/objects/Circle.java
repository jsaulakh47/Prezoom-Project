package app.model.objects;

import app.model.attributes.Radius;
import app.model.attributes.FillColor;
import app.model.attributes.StrokeColor;
import app.model.attributes.StrokeWidth;

public class Circle extends Objects
{
	public Circle(String x, String y, String radius) {
		super(x, y, "Circle");
		addAttribute(new Radius(radius));
		addAttribute(new StrokeWidth());
		addAttribute(new FillColor());
		addAttribute(new StrokeColor());
	}

	public Circle(String x, String y) {
		this(x, y, "50" );
	}

    @Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}

