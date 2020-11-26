package gui.javafx;

import javafx.geometry.Point2D;

public class Transform {
	private double viewWidth ;
	private double viewHeight ;
	private double worldWidth ;
	private double worldHeight ;
	
	public Transform(double viewWidth, double viewHeight, double worldWidth, double worldHeight ) {
		this.viewWidth = viewWidth ;
		this.viewHeight = viewHeight ;
		this.worldWidth = worldWidth ;
		this.worldHeight = worldHeight ;
	}
	
	Point2D worldToView(double i, double j) { 
		double myWidth = viewWidth ;
		double myHeight = viewHeight ;
		double scale = Math.min( myWidth/(worldWidth+4), myHeight/(worldHeight+4) ) ;
		
		double x_offset = (myWidth-scale*worldWidth)/2 ;
		double y_offset = (myHeight-scale*worldHeight)/2 ;
		double x = j * scale + x_offset;
		double y = i * scale + y_offset;

		return new Point2D(x,y) ;
	}
	
	Point2D viewToWorld(double x, double y) {
		double myWidth = viewWidth ;
		double myHeight = viewHeight ;
		double scale = Math.min( myWidth/(worldWidth+4), myHeight/(worldHeight+4) ) ;

		double x_offset = (myWidth-scale*worldWidth)/2 ;
		double y_offset = (myHeight-scale*worldHeight)/2 ;
		double j = (x-x_offset) / scale;
		double i = (y-y_offset) / scale ;
		
		return new Point2D(i,j) ;
	}
}
