/**
 * 
 */
package edu.lmu.cmsi.Shape;


import java.util.ArrayList;
import java.util.List;


/**
 * @author Kwadwo Yeboah
 * Represents rectangle class. Uses TwoDPoints as corners
 *
 */
public class Rectangle {

	// reresent 4 TwoDPoint moving counter-clockwise from lower left corner
	private List<TwoDPoint> myl = new ArrayList<TwoDPoint>(4);
	private double width, height;
	
	public Rectangle(TwoDPoint lowleft, TwoDPoint lowright, TwoDPoint upright,
			TwoDPoint upleft) {
		// TODO Auto-generated constructor stub
		
		// check not null
		if(lowleft == null || lowright == null || upright == null || upleft == null ){
			throw new IllegalArgumentException("A TwoDPoint for this rectangle is null");
		}
		myl.add(lowleft);
		myl.add(lowright);
		myl.add(upright);
		myl.add(upleft);
		
		// check all points are unique
		List<TwoDPoint> t = new ArrayList<TwoDPoint>(myl);
		
		
		while(!t.isEmpty()){
			TwoDPoint compare = t.get(0);	

			for(int i = 1; i < t.size(); i++){
				if(t.get(i).equals(compare)){
					throw new IllegalArgumentException("TwoDPoints for rectangle are not unique");
				}
			}
			t.remove(0);
			
			
		}
		
		this.width = this.getMyl().get(2).getX() - this.getMyl().get(0).getX();
		this.height = this.getMyl().get(2).getY() - this.getMyl().get(0).getY();
		
		
	}




	public double getArea() {
	
		
		return (this.myl.get(1).getX()  - this.myl.get(0).getX())
				* (this.myl.get(2).getY()  - this.myl.get(0).getY());
	}

	
	public boolean contains(TwoDPoint twod) {
		
		if(twod.getX() < this.myl.get(0).getX() || twod.getX() > this.myl.get(1).getX()){
			return false;
		}
		if(twod.getY() < this.myl.get(0).getY() || twod.getY() > this.myl.get(2).getY()){
			return false;
		}
		return true;
	}

	


	
	public Rectangle getBoundingRectangle() {
		
		return this;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Rectangle){
			Rectangle rec = (Rectangle) obj;
			
			
			for(int i = 0; i < rec.myl.size(); i++){
				if(!(rec.myl.get(i).equals(this.myl.get(i)))){
					return false;
				}
			}
			
			return true;
		}
		return false;
	}


	public double getPerimeter() {
		
		double width = this.getMyl().get(2).getX() - this.getMyl().get(0).getX();
		double  height = this.getMyl().get(2).getY() - this.getMyl().get(0).getY();
		
		return 2 * (width + height);
	}
	/**
	 * @return the myl
	 */
	public List<TwoDPoint> getMyl() {
		return myl;
	}
	// translates by using the upper left corner of this rectangle
	public void Translate(TwoDPoint twod) {
		// TODO Auto-generated method stub
		if(twod == null){
			throw new IllegalArgumentException("Point given is null. No translation action");
		}
		
		List<TwoDPoint> translated = new ArrayList<TwoDPoint>();
		
		myl.get(0).setX(twod.getX());
		myl.get(0).setY(twod.getY());
		
		translated.add(myl.get(0));
		translated.add(new TwoDPoint(myl.get(0).getX() + width,myl.get(0).getY() ));
		translated.add(new TwoDPoint(myl.get(0).getX() + width,myl.get(0).getY() + height ));
		translated.add(new TwoDPoint(myl.get(0).getX() ,myl.get(0).getY() + height ));
		
		this.myl = translated;
		}

	@Override
	public String toString() {
		String s = "";
		int count = 0;
		for(TwoDPoint a : myl){
			s += count + " - " + a.toString() + "\n";
			count++;
		}
		return s;
	}




	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}




	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

}
