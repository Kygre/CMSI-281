package edu.lmu.cmsi.Shape;

import java.util.ArrayList;
import java.util.List;

public class Square  {

	private List<TwoDPoint> myl;
	private double width;
	public Square() {
		// TODO Auto-generated constructor stub
	}

	public Square(TwoDPoint lowleft, double width) {
		// TODO Auto-generated constructor stub

		if(width <= 0){
			throw new IllegalArgumentException("width must be greater than zero");
		}
		else if(lowleft == null){
			throw new IllegalArgumentException("TwoDPoint is null");
		}
		else{
			myl = new ArrayList<TwoDPoint>();
			
			myl.add(lowleft);

			myl.add(new TwoDPoint(lowleft.getX() + width, lowleft.getY()));

			myl.add(new TwoDPoint(lowleft.getX() + width, lowleft.getY() + width));

			myl.add(new TwoDPoint(lowleft.getX(), lowleft.getY() + width));

			this.width = width;
		}
	}

	public double getArea() {
		// TODO Auto-generated method stub

		return Math.pow(myl.get(1).getX() -  myl.get(0).getX(), 2);
	}

	public boolean contains(TwoDPoint twod) {
		// TODO Auto-generated method stub
		if(myl.get(0).getX() > twod.getX() && myl.get(1).getX() < twod.getX()){
			if(twod.getY() > myl.get(0).getY() &&  twod.getY() > myl.get(2).getY()){
				return true;
			}
		}
		return false;
	}



	public Rectangle getBoundingRectangle() {
		// TODO Auto-generated method stub
		return new Rectangle(this.myl.get(0),this.myl.get(1),this.myl.get(2),this.myl.get(3));
	}

	// moves square to new lowleft corner of twod
	public void Translate(TwoDPoint twod) {
		// TODO Auto-generated method stub
		
		if (!twod.equals(myl.get(0))) {
			myl.set(0, twod);
			myl.set(1, new TwoDPoint(twod.getX() + width, twod.getY()));
			myl.set(2, new TwoDPoint(twod.getX() + width, twod.getY() + width));
			myl.set(3, new TwoDPoint(twod.getX(), twod.getY() + width));
		}

	}

	/**
	 * @return the myl
	 */
	public List<TwoDPoint> getSquare() {
		return myl;
	}

	
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}



}
