package app.interfaces;

/**
 * adapter interface for drawing objects on presentation mode
 */

public interface DrawingAdapterI {
    void SetStrokeColor(String color);

    void SetFillColor(String color);

    void SetTextColor(String color);

    void SetTextFont(String font);

    void SetLineWidth(double color);

    // void getTransform ();
    // void transform ();
    // void resetDrawingParameters();

    void drawRectangle(double x, double y, double width, double height);

    void drawCircle(double x, double y, double radius);

    void drawLine(double start_x, double start_y, double end_x, double end_y);

    void drawText(double x, double y, double text);

    void drawTextArea();

    // void drawImage();
}