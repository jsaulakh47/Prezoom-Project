package app.interfaces;

public interface ObjectFactoryI {
    ObjectsI makeCircle(String x, String y);

    ObjectsI makeLine(String x, String y);

    ObjectsI makeRectangle(String x, String y);

    ObjectsI makeText(String x, String y);

    ObjectsI makeTextArea(String x, String y);

    ObjectsI makeImage(String x, String y);
}