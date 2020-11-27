package gui.javafx;

import javafx.geometry.Point2D;

public class Transform {
	private double scale;
	private double viewWidth;
	private double viewHeight;
	private double worldWidth;
	private double worldHeight;

	private double xOffset;
	private double yOffset;

    public static final double OFFSET = 4.0;
	
	public Transform(double viewWidth, double viewHeight, double worldWidth, double worldHeight) {
		this.viewWidth = viewWidth;
		this.viewHeight = viewHeight;
		this.worldWidth = worldWidth;
		this.worldHeight = worldHeight;

		this.scale = Math.min((viewWidth / (worldWidth + OFFSET)), (viewHeight / (worldHeight + OFFSET)));

		this.xOffset = (viewWidth - (scale * worldWidth)) / 2;
		this.yOffset = (viewHeight - (scale * worldHeight)) / 2;
	}
	
	public Point2D worldToView(double i, double j) { 
		double x = i * scale + xOffset;
		double y = j * scale + yOffset;

		return new Point2D(x, y);
	}
	
	public Point2D viewToWorld(double i, double j) {
		double x = (i - xOffset) / scale;
		double y = (j - yOffset) / scale;
		
		return new Point2D(x, y);
	}
}
