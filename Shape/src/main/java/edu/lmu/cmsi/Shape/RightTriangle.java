package edu.lmu.cmsi.Shape;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author Kwadwo Yeboah
 * Represents a triangle 
 *
 */
public class RightTriangle  {

	
	private TwoDPoint p1,p2,p3;
	
	public RightTriangle(TwoDPoint p1, TwoDPoint p2, TwoDPoint p3) {
			
		// check if any angle made are 90 degrees
		
		List<TwoDPoint> myl = new ArrayList<TwoDPoint>();
		try {
			myl.add(p1);
			myl.add(p2);
			myl.add(p3);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			throw new IllegalArgumentException("Point(s) is null in Triangle Construction");
		}
		
		

		List<TwoDPoint> compare = myl;
		
		// check for duplicate points
		int count = 0;
		while(count < compare.size() - 1){
			
			if(compare.get(count).equals(compare.get(count + 1))){
				throw new IllegalArgumentException( " Two Points are the same ");
			}
			count++;
		}
		
		
		// assigns points using lowleft rule similiar to Line
		int lowindex = 0;

		for(int i = 1; i < compare.size(); i++){
			if(compare.get(lowindex).getY() == compare.get(i).getY()){
				if(compare.get(lowindex).getX() > compare.get(i).getX()){
					lowindex = i;
				}
			}
			else if(compare.get(lowindex).getY() > compare.get(i).getY()){
				lowindex = i;
			}
		}
		
		this.p1 = compare.get(lowindex);
		compare.remove(lowindex);
		
		
		
		if(compare.get(0).getY() < compare.get(1).getY()){
			this.p1 = compare.get(0);
			this.p2 = compare.get(1);
		}
		else if(compare.get(0).getY() > compare.get(1).getY()){
			this.p1 = compare.get(1);
			this.p2 = compare.get(0);
		}
		else{ // same x coordinate
			
			if(compare.get(0).getX() < compare.get(1).getX()){
				this.p1 = compare.get(0);
				this.p2 = compare.get(1);
			}
			else{
				this.p1 = compare.get(1);
				this.p2 = compare.get(0);
			}
		}
		
		// check if it is 90 degree triangle
		// is 90 if slopes are perpendicular
		Line aline = new Line(p1,p2);
		Line bline = new Line(p2,p3);
		Line cline = new Line(p3,p1);
		
		List<Line> mylines = new ArrayList<Line>();
		int bigindex = 0;
		for(int i = 1; i < mylines.size(); i++){
			if(mylines.get(bigindex).length() < mylines.get(i).length()){
				bigindex = i;
				
			}
		}
		// hypotenuse is longest part of triangle and opposite the 90 degree angle
		double leftsum = Math.pow(mylines.get(bigindex).length(), 2);
		mylines.remove(bigindex);
		
		Double rightsum = 0.0;
		for(Line l : mylines){
			rightsum += Math.pow(l.length(), 2);
		}
		
		if(leftsum != rightsum){
			throw new IllegalArgumentException("Is not right triangle");
		}
		
		
		
	}

	// returns the area of this triangle
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.abs((p1.getX()*(p2.getY() - p3.getY()) + p2.getX()*(p3.getY() - p1.getY()) + p3.getX() * (p1.getY() - p2.getY())/2));
		
	}

	
	// unsupported operation
	public boolean contains(TwoDPoint twod) {
		// TODO Auto-generated method stub
		
		throw new UnsupportedOperationException();
		
	}


	// return the bounding rectangle of this right triangle
	public Rectangle getBoundingRectangle() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	// translate this triangle to new points of parameters
	public void Translate(TwoDPoint twod, TwoDPoint nextwod, TwoDPoint lastwoD) {
		// TODO Auto-generated method stub
		RightTriangle tri = new RightTriangle(twod, nextwod, lastwoD);
		
		this.p1 = tri.p1;
		this.p2 = tri.p2;
		this.p3 = tri.p3;
	}

}

