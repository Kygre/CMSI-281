package edu.lmu.cmsi.Shape;


/**
 * 
 * @author Kwadwo Yeboah
 * Represents circle with TwoDPoint representing center
 *
 */
public class Circle  {

	private TwoDPoint center;
	private double radius;
	public Circle() {
		// TODO Auto-generated constructor stub

	}

	public Circle(TwoDPoint twod, double radius){

		// will throw exception if x,y negative in TwoDPoint constructor
		

		if(radius <= 0.0){
			throw new IllegalArgumentException("Circle must have radius > 0.0");
		}
		else{
			this.radius = radius;
		}
		
		this.center = twod;
		
		// if not positive corner will throw exception in TwoDPoint
		TwoDPoint ins = this.getBoundingRectangle().getMyl().get(0);

	}

	// return the area of a circle
	public double getArea() {
		// a = pi * r^2

		return Math.PI * Math.pow(this.radius, 2);
	}

	// returns circumference of this circle
	public double getCircumference(){
		// c = pi * d

		return Math.PI * (2 * radius);
	}




	public boolean contains(TwoDPoint twod) {
		// TODO Auto-generated method stub
		if(twod.equals(this.center)){
			return true;
		}
		Line length = new Line(twod, this.center);
		if(length.length() <= radius){
			return true;
		}
		return false;
	}

	// no negative TwoDPoints allowed
	// edge of circle must be positive


	public Rectangle getBoundingRectangle() {
		// TODO Auto-generated method stub
		// 
		TwoDPoint lowleft, lowright, upleft, upright;
		lowleft = new TwoDPoint(center.getX() - radius, center.getY() - radius);
		upleft = new TwoDPoint(center.getX() - radius, center.getY() + radius);
		lowright = new TwoDPoint(center.getX() + radius, center.getY() - radius);
		upright = new TwoDPoint(center.getX() + radius, center.getY() + radius);

		return new Rectangle(lowleft, lowright, upright, upleft);
	}

	/**
	 * @return the center
	 */
	public TwoDPoint getCenter() {
		return center;
	}

	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return center + ", r=" + radius ;
	}

	// translates to TwoDPoint
	public void Translate(TwoDPoint twod) {
		// TODO Auto-generated method stub
		
		 
		Rectangle rec = this.getBoundingRectangle();
		if(rec.contains(twod)){
			throw new IllegalArgumentException("All TwoDPoints in circle must remain positive");	
		}
		else{
			this.center = twod;
		}
		
		
		
		
	}

}
