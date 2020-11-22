package app.model.objects;

import app.model.attributes.Width;
import app.model.attributes.Height;
import app.model.attributes.FillColor;
import app.model.attributes.StrokeColor;
import app.model.attributes.StrokeWidth;

public class Rectangle extends Objects
{
	public Rectangle(String x, String y, String width, String height) {
		super(x, y, "Rectangle");
		addAttribute(new Width(width));
		addAttribute(new Height(height));
		addAttribute(new StrokeWidth());
		addAttribute(new FillColor());
		addAttribute(new StrokeColor());
	}

	public Rectangle(String x, String y) {
		this(x, y,  "100" , "80");
	}

    @Override
	public void draw() {
		// TODO Auto-generated method stub;
	}
}

