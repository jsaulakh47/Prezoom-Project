package app.interfaces;

/**
 * adapter interface for drawing objects on presentation mode
 */

public interface DrawingAdapterI {
    void SetStrokeColor(String color);

    void SetFillColor(String color);

    void SetTextColor(String color);

    void SetTextFont(String font);

    void SetLineWidth(double width);

    void getTransform();

    void transform();

    void drawRectangle(double x, double y, double width, double height);

    void drawCircle(double x, double y, double radius);

    void drawLine(double start_x, double start_y, double end_x, double end_y);

    void drawText(String text, double x, double y, double width);

    void drawTextArea(double x, double y, String text, double width, double height);

    // void drawImage();
}