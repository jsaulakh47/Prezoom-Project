package app.model.objects;


import app.model.attributes.Text;
import app.model.attributes.Font;


public class PlainText extends Objects
{
	public PlainText(String x, String y, String text, String font) {
				
        super(x, y);
		addAttribute(new Text(text));
		addAttribute(new Font(font));
		
	}

    @Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}

