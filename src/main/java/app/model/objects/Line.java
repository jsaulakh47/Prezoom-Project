package app.model.objects;


import app.model.attributes.EndX;
import app.model.attributes.EndY;
import app.model.attributes.StrokeColor;


public class Line extends Objects
{
	public Line(String start_x, String start_y, String end_x,String end_y) {

		super(start_x, start_y);
		addAttribute(new EndX(end_x));
		addAttribute(new EndY(end_y));
		addAttribute(new StrokeColor("#000000"));
	}

	public Line(String x, String y) {
		this(x, y, "100" , "100" );
	}

    @Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}

