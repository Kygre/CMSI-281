package edu.lmu.cmsi.Core;

public class Displacement {
 
	private int dx ,dy; 
		
	public Displacement(int dx, int dy) {
		super();
		this.dx = dx;
		this.dy = dy;
	}




	public void invert(){
	    this.dx = this.dx * -1;
	    this.dy = this.dy * -1;
	}




	/**
	 * @return the dx
	 */
	public int getDx() {
		return dx;
	}




	/**
	 * @param dx the dx to set
	 */
	public void setDx(int dx) {
		this.dx = dx;
	}




	/**
	 * @return the dy
	 */
	public int getDy() {
		return dy;
	}




	/**
	 * @param dy the dy to set
	 */
	public void setDy(int dy) {
		this.dy = dy;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + dx + ", " + dy + ")";
	}

	
}
