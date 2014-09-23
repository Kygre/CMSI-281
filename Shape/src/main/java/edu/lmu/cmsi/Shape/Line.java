package edu.lmu.cmsi.Shape;

/**
 * 
 * @author Kwadwo Yeboah Represent a Line segment If slope is vertical uses x =
 *         number If slope is horizontal uses y = number
 * 
 */
public class Line {

	private double slope, intercept;
	private TwoDPoint p1, p2;
	private boolean vertical, horizontal;

	public Line(TwoDPoint first, TwoDPoint second) {
		// TODO Auto-generated constructor stub

		if (first == null || second == null) {
			// System.err.println("One or either TwoDPoints is null");
			throw new IllegalArgumentException(
					"One or either TwoDPoints is null");
		} else if (first.equals(second)) {
			// System.err.println("Points are equal = line does not exist");
			throw new IllegalArgumentException(
					"Points are equal = line does not exist");
		} else {
			// create new line

			// undefined - vertical line
			if (first.getX() - second.getX() == 0) {
				// slope => x = number;
				slope = first.getX();

				if (first.getX() == 0) {
					intercept = 0;
				}
				// intercept left null

				vertical = true;
			}
			// horizontal line
			else if (first.getY() - second.getY() == 0) {

				// slope => y = number;
				slope = first.getY();
				intercept = first.getY();
				horizontal = true;
			}

			else {
				// create new line
				slope = (first.getY() - second.getY())
						/(first.getX() - second.getX());
				intercept = first.getY() - (slope * first.getX());
			}

			
			if(first.getY() < second.getY()){
				this.p1 = first;
				this.p2 = second;
			}
			else if(first.getY() > second.getY()){
				this.p1 = second;
				this.p2 = first;
			}
			else{ // same x coordinate
				
				if(first.getX() < second.getX()){
					this.p1 = first;
					this.p2 = second;
				}
				else{
					this.p1 = second;
					this.p2 = first;
				}
			}
			
			
		}

	}

	/**
	 * Determines if this line segment equals an @param o
	 * 
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Line) {
			Line l = (Line) o;

			if(this.p1.equals(l.p1) && this.p2.equals(l.p2)){
				return true;
			}
		}
		return false;

	}

	/**
	 * return true if this line segment intersects with @param l Checks using
	 * sweeping line algorithm
	 */

	public boolean intersects(Line l) {
		// p1 determined by low leftmmost point
		

		if (l != null) {

			// y = mx+b
			// covers all horizontal and vertical same line checks
			if (this.equals(l)) {
				return true;
			}
			else if(this.p1.equals(l.p1) || this.p1.equals(l.p2) || this.p2.equals(l.p1) || this.p2.equals(l.p2)){
				return true;
			}
			else if((this.horizontal && l.vertical)){
				if(this.getP1().getX() < l.getP1().getX() && this.getP2().getX() > l.getP2().getX()){
					if(l.getP1().getY() < this.getP1().getY() && l.getP2().getY() > this.getP2().getY()){
						return true;
					}
				}
			}
			else if((this.vertical && l.horizontal)){
				if(l.getP1().getX() < this.getP1().getX() && l.getP2().getX() > this.getP2().getX()){
					if(this.getP1().getY() < l.getP1().getY() && this.getP2().getY() > l.getP2().getY()){
						return true;
					}
				}
			}
			else {
				if(this.slope - l.slope != 0){
					double xsect = (l.intercept - this.intercept)/(this.slope - l.slope);
					boolean thislonger = false;
					if(this.length() > l.length()){
						thislonger = true;
					}
					
					if(thislonger){
						if(xsect > this.p1.getX() && xsect < this.p2.getX()){
							return true;
						}
					}
					else{
						if(xsect > l.p1.getX() && xsect < l.p2.getX()){
							return true;
						}
					}
					
					
				}
				else{
					// slopes are perpendicular	
					// y = mx+ b
					// y = -1/m * x + b
					
				}
			}
		}
		return false;
	}

	/**
	 * return a TwoDPoint representing the midpoint of this line
	 */
	public TwoDPoint midpoint() {

		return new TwoDPoint((p1.getX() + p2.getX() / 2),
				(p1.getY() + p2.getY() / 2));

	}

	// returns the length of this line
	public double length() {
		return p1.distanceTo(p2);
	}

	/**
	 * @return the slope
	 */
	public double getSlope() {

		return slope;
	}

	/**
	 * @return the intercept
	 */
	public double getIntercept() {
		return intercept;
	}

	/**
	 * @return the p1
	 */
	public TwoDPoint getP1() {
		return p1;
	}

	/**
	 * @return the p2
	 */
	public TwoDPoint getP2() {
		return p2;
	}

	/**
	 * @return the vertical
	 */
	public boolean isVertical() {
		return vertical;
	}

	// return stringy version of this line in slope intercept format
	@Override
	public String toString() {

		return "y = " + slope + "x + " + intercept;
	}

	/**
	 * @return the horizontal
	 */
	public boolean isHorizontal() {
		return horizontal;
	}

}
