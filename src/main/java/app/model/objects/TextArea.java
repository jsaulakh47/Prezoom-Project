package app.model.objects;

import app.model.attributes.Text;
import app.model.attributes.Width;
import app.model.attributes.Height;
import app.interfaces.DrawingAdapterI;
import app.model.attributes.FillColor;
import app.model.attributes.StrokeColor;
import app.model.attributes.StrokeWidth;

public class TextArea extends Objects {

    public static final String DEFAULT_TEXT = "Alfa";
    public static final String DEFAULT_WIDTH = "100";
    public static final String DEFAULT_HEIGHT = "100";

    public TextArea(String x, String y, String text, String width, String height) {
        super(x, y, ObjectType.TEXT_AREA.getType());
        addAttribute(new Text(text));
        addAttribute(new Width(width));
        addAttribute(new Height(height));
        addAttribute(new StrokeWidth());
        addAttribute(new FillColor());
        addAttribute(new StrokeColor());
    }

    public TextArea(String x, String y) {
        this(x, y, DEFAULT_TEXT, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    @Override
    public void draw(DrawingAdapterI drawingAdapter) {
        // TODO Auto-generated method stub
    }
}

