package app.model.objects;

import app.interfaces.ObjectFactoryI;
import app.interfaces.ObjectsI;


public class ObjectFactory implements ObjectFactoryI {
    public ObjectsI makeCircle(String x, String y) {
        return new Circle(x, y);
    }

    public ObjectsI makeLine(String x, String y) {
        return new Line(x, y);
    }

    public ObjectsI makeRectangle(String x, String y) {
        return new Rectangle(x, y);
    }

    public ObjectsI makeText(String x, String y) {
        return new PlainText(x, y);
    }

    public ObjectsI makeTextArea(String x, String y) {
        return new TextArea(x, y);
    }

    public ObjectsI makeImage(String x, String y) {
        return new Image(x, y);
    }
}