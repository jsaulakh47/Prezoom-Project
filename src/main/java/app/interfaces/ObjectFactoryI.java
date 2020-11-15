package app.interfaces;

public interface ObjectFactoryI {

    public ObjectsI makeCircle (String x, String y);
    public ObjectsI makeLine (String x, String y);
    public ObjectsI makeRectangle (String x, String y);
    public ObjectsI makeText (String x, String y);
    public ObjectsI makeTextArea (String x, String y);
    public ObjectsI makeImage(String x, String y);
}