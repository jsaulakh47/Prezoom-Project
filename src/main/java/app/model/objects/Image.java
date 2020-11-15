package app.model.objects;

import app.model.attributes.TextArea;
import app.model.attributes.Width;
import app.model.attributes.Height;
import app.model.attributes.FillColor;
import app.model.attributes.StrokeColor;

public class TextArea extends Objects
{
	public TextArea(String x, String y, String text, String width , String height) {

		super(x, y);
		addAttribute(new TextArea(text));
		addAttribute(new Width(width));	
		addAttribute(new Height(height));	
		addAttribute(new FillColor("#FF0000"));
		addAttribute(new StrokeColor("#000000"));
	}

    @Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}

