package edu.lmu.cmsi.Shape;

/**
 * 
 * @author Kwadwo Yeboah Represent 2D point immutable class of only positive
 *         doubles Methods including: Distance and eqaulity
 * 
 */
public class TwoDPoint {

	private double x, y;

	public TwoDPoint(double x, double y) {
		super();

		boolean threxception = false;

		if (x < 0.0) {

			threxception = true;
		} else {
			this.x = x;
		}

		if (y < 0.0) {

			threxception = true;
		} else {
			this.y = y;
		}

		if (threxception) {
			//System.err.print("<Point x & y must be postive>");
			throw new IllegalArgumentException();
		}

	}

	// compares equality of this point and point twod
	public boolean equals(TwoDPoint twod) {

		if (twod != null) {
			if (this.x == twod.getX() && this.y == twod.getY()) {
				return true;
			}
		}

		return false;
	}

	// return the distance to another TwoDPoint
	// returns -1.0 if twod is null
	public double distanceTo(TwoDPoint twod) {
		if (twod != null) {
			return Math.abs(Math.pow(this.x - twod.getX(), 2)
					+ Math.pow(this.y - twod.getY(), 2));
		}

		return -1.0;

	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}

}
