package app.model.objects;

import app.model.attributes.Width;
import app.model.attributes.Height;
import app.model.attributes.Source;

public class Image extends Objects
{
	public Image(String x, String y, String source, String width, String height) {
		super(x, y, "Image");
		addAttribute(new Source(source));
		addAttribute(new Width(width));	
		addAttribute(new Height(height));	
		
	}

	public Image(String x, String y) {
		this(x, y, "src/main/resources/alfa.png" ,"100" ,"100" );
	}

    @Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}

