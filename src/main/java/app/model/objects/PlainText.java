package app.model.objects;

import app.model.attributes.Text;
import app.model.attributes.FillColor;
import app.model.attributes.FontSize;
import app.model.attributes.StrokeColor;


public class PlainText extends Objects
{
	public PlainText(String x, String y, String text, String fontsize) {
        super(x, y, "Text");
		addAttribute(new Text(text));
		addAttribute(new FontSize(fontsize));
		addAttribute(new FillColor("#FF0000"));
		addAttribute(new StrokeColor("#000000"));
	}

	public PlainText(String x, String y) {
		this(x, y, "Alfa" , "10");
	}

    @Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}

