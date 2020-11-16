package app.model.objects;


import app.model.attributes.EndX;
import app.model.attributes.EndY;
import app.model.attributes.FillColor;
import app.model.attributes.StrokeColor;


public class Line extends Objects
{
	public Line(String x, String y, String end_x,String end_y) {
		super(x, y, "Line");
		addAttribute(new EndX(end_x));
		addAttribute(new EndY(end_y));
		addAttribute(new FillColor("#FF0000"));
		addAttribute(new StrokeColor("#000000"));
	}

	public Line(String x, String y) {
		this(x, y, String.valueOf(Double.parseDouble(x) + 100), String.valueOf(Double.parseDouble(y) + 100));
	}

    @Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}

