package app.model.objects;


import app.model.attributes.Width;
import app.model.attributes.Height;
import app.model.attributes.Source;


public class Image extends Objects
{
	public Image(String x, String y, String source, String width, String height) {

		super(x, y);
		addAttribute(new Source(source));
		addAttribute(new Width(width));	
		addAttribute(new Height(height));	
		
	}

    @Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}

