package app.model.objects;

import app.model.attributes.FillColor;
import app.model.attributes.Radius;
import app.model.attributes.StrokeColor;
import app.model.attributes.XPosition;
import app.model.attributes.YPosition;

public class Circle extends Objects
{
	public Circle(String x, String y, String radius) {
		super(x, y);
		addAttribute(new Radius(radius));

		addAttribute(new FillColor("#FF0000"));
		addAttribute(new StrokeColor("#000000"));
	}

    @Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}

