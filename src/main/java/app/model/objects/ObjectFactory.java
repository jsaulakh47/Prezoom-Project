package app.model.objects;

import app.interfaces.ObjectFactoryI;
import app.interfaces.ObjectsI;
import app.model.objects.Circle;
import app.model.objects.Line;
import app.model.objects.Rectangle;
import app.model.objects.PlainText;
import app.model.objects.TextArea;
import app.model.objects.Image;


public class ObjectFactory implements ObjectFactoryI{
    public ObjectsI makeCircle(String x, String y) {
        Circle circle = new Circle(x , y);
        return circle;
    }

    public ObjectsI makeLine(String x, String y) {
        Line line = new Line(x , y);
        return line;
    }
    
    public ObjectsI makeRectangle(String x, String y) {
        Rectangle rectangle = new Rectangle(x , y);
        return rectangle;
    }
    
    public ObjectsI makeText(String x, String y) {
        PlainText text = new PlainText(x , y);
        return text;
    }
    
    public ObjectsI makeTextArea(String x, String y) {
        TextArea textArea = new TextArea(x , y);
         return textArea;
    }
    
    public ObjectsI makeImage(String x, String y) {
        Image image = new Image(x , y);
        return image;
    }

}