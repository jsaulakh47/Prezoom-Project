package app.model.objects;


import app.model.attributes.Text;
import app.model.attributes.FontSize;


public class PlainText extends Objects
{
	public PlainText(String x, String y, String text, String fontsize) {

        super(x, y);
		addAttribute(new Text(text));
		addAttribute(new FontSize(fontsize));
		
	}

	public PlainText(String x, String y) {
		this(x, y, "Alfa" , "10");
	}

    @Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}

