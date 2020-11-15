package app.model.objects;

import app.interfaces.ObjectFactoryI;
import app.interfaces.ObjectsI;


public class ObjectFactory implements ObjectFactoryI{
    public ObjectsI makeCircle(String x, String y) {
        ObjectsI circle = new Circle(x , y);
        return circle;
    }

    public ObjectsI makeLine(String x, String y) {
        ObjectsI line = new Line(x , y);
        return line;
    }
    
    public ObjectsI makeRectangle(String x, String y) {
        ObjectsI rectangle = new Rectangle(x , y);
        return rectangle;
    }
    
    public ObjectsI makeText(String x, String y) {
        ObjectsI text = new PlainText(x , y);
        return text;
    }
    
    public ObjectsI makeTextArea(String x, String y) {
        ObjectsI textArea = new TextArea(x , y);
         return textArea;
    }
    
    public ObjectsI makeImage(String x, String y) {
        ObjectsI image = new Image(x , y);
        return image;
    }

}