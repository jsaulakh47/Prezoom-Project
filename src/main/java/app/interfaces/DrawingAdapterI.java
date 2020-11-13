package app.interfaces;

/**
 * adapter interface for drawing objects on presentation mode
 */

public interface DrawingAdapterI {
   

    public void SetStrokeColor (String color);
    public void SetFillColor (String color);
    public void SetTextColor (String color);
    public void SetTextFont (String font);
    public void SetLineWidth (double color);
   // public void getTransform ();
   // public void transform ();
  //  public void resetDrawingParameters();
    public void drawRectangle(double x,double y, double width,double height);
    public void drawCircle(double x, double y, double radius);
    public void drawLine(double start_x,double start_y, double end_x,double end_y);
    public void drawText(double x,double y, double text);
    public void drawTextArea();
  //  public void drawImage();
    
}