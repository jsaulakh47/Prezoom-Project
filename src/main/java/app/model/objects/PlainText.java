package app.model.objects;

import app.model.attributes.Text;
import app.model.attributes.FillColor;
import app.model.attributes.FontSize;
import app.model.attributes.StrokeColor;
import app.model.attributes.StrokeWidth;

public class PlainText extends Objects {

    public static final String DEFAULT_TEXT = "Alfa";
    public static final String DEFAULT_FONTSIZE = "10";

    public PlainText(String x, String y, String text, String fontsize) {
        super(x, y, ObjectType.PLAIN_TEXT.getType());
        addAttribute(new Text(text));
        addAttribute(new FontSize(fontsize));
        addAttribute(new StrokeWidth());
        addAttribute(new FillColor());
        addAttribute(new StrokeColor());
    }

    public PlainText(String x, String y) {
        this(x, y, DEFAULT_TEXT, DEFAULT_FONTSIZE);
    }

    @Override
    public void draw() {
        // TODO Auto-generated method stub

    }
}

