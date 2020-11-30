package gui.javafx;

import javafx.geometry.Point2D;

public class Transform {
	private double viewWidth;
	private double viewHeight;
	private double worldWidth;
	private double worldHeight;
	private Affine transformation;

	private double xScale;
	private double yScale;
	private double xOffset;
	private double yOffset;

    public static final double OFFSET = 4.0;
	
	public Transform(double viewWidth, double viewHeight, double worldWidth, double worldHeight) {
		this.viewWidth = viewWidth;
		this.viewHeight = viewHeight;
		this.worldWidth = worldWidth;
		this.worldHeight = worldHeight;

		double width = viewWidth / (worldWidth + OFFSET);
		double height = viewHeight / (worldHeight + OFFSET);

		this.xScale = Math.max(width, height);
		this.yScale = Math.min(width, height);

		this.xOffset = (viewWidth - (xScale * worldWidth)) / 2;
		this.yOffset = (viewHeight - (yScale * worldHeight)) / 2;
	}
	
	public Point2D worldToView(double i, double j) { 
		double x = i * xScale + xOffset;
		double y = j * yScale + yOffset;

		return new Point2D(x, y);
	}
	
	public Point2D viewToWorld(double i, double j) {
		double x = (i - xOffset) / xScale;
		double y = (j - yOffset) / yScale;
		
		return new Point2D(x, y);
	}

	public void setTransformation(Affine transform) {
		this.transformation = transform;
	}
	
}
