package app.model.objects;


import app.model.attributes.Text;
import app.model.attributes.Width;
import app.model.attributes.Height;
import app.model.attributes.FillColor;
import app.model.attributes.StrokeColor;

public class TextArea extends Objects
{
	public TextArea(String x, String y, String text, String width , String height) {

		super(x, y);
		addAttribute(new Text(text));
		addAttribute(new Width(width));	
		addAttribute(new Height(height));	
		addAttribute(new FillColor("#FF0000"));
		addAttribute(new StrokeColor("#000000"));
	}

	public TextArea(String x, String y) {
		this(x, y, "Alfa" , "100" , "100" );
	}

    @Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}

