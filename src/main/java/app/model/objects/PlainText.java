package app.model.objects;

import app.model.attributes.Text;
import app.interfaces.DrawingAdapterI;
import app.model.attributes.AttributeLabel;
import app.model.attributes.FillColor;
import app.model.attributes.FontSize;
import app.model.attributes.StrokeColor;
import app.model.attributes.StrokeWidth;
import java.util.Map;

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
    public boolean locatedAt(double x, double y) {
        // TODO Auto-generated method stub
        Map<String, String> attributes = this.getAttributes();        
        double xPos = Double.parseDouble(attributes.get(AttributeLabel.X_POSITION.getLabel()));
        double yPos = Double.parseDouble(attributes.get(AttributeLabel.Y_POSITION.getLabel()));
        double fontWidth = Double.parseDouble(attributes.get(AttributeLabel.WIDTH.getLabel()));
        //String textLabel = attributes.get(AttributeLabel.TEXT.getLabel());  
        
        return ( x >= xPos && y >= yPos && x >=(xPos + fontWidth) && y >=(xPos + fontWidth)) ? true : false;
        
    }

    @Override
    public void draw(DrawingAdapterI drawingAdapter) {
        // // TODO Auto-generated method stub
        Map<String, String> attributes = this.getAttributes();
        double x = Double.parseDouble(attributes.get(AttributeLabel.X_POSITION.getLabel()));
        double y = Double.parseDouble(attributes.get(AttributeLabel.Y_POSITION.getLabel()));

        double fontWidth = Double.parseDouble(attributes.get(AttributeLabel.WIDTH.getLabel()));
        

        String text = attributes.get(AttributeLabel.TEXT.getLabel());

        drawingAdapter.SetTextFont(attributes.get(AttributeLabel.FONT.getLabel()));
        //drawingAdapter.SetTextFont(attributes.get(AttributeLabel.FONT_SIZE.getLabel()));
        drawingAdapter.SetTextColor(attributes.get(AttributeLabel.FILL_COLOR.getLabel()));

        drawingAdapter.drawText(text, x, y, fontWidth);
        
        
               

    }
}

