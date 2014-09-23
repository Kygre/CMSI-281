package edu.lmu.cmsi.Shape;

import org.junit.Assert;
import org.junit.Test;

import edu.lmu.cmsi.Shape.TwoDPoint;

public class TwoDPointTest {

	@Test
	public void TwoDPointXPositive(){
		TwoDPoint twod = new TwoDPoint(1.0,2.0);
		
		org.junit.Assert.assertEquals("Equal", 1.0, twod.getX(), 0);
	}
	@Test
	public void TwoDPointYPositive(){
		TwoDPoint twod = new TwoDPoint(1.0,2.0);
		
		org.junit.Assert.assertEquals("Equal", 2.0, twod.getY(), 0);
	}
	
	//check exception is thrown for negative value in x or y
	
	@Test(expected=IllegalArgumentException.class)
	public void ThrowNegativeException(){
		
			TwoDPoint twod = new TwoDPoint(-1.0,2.0);
			
	}
	
	@Test
	public void PointIsNull(){
		TwoDPoint twod = null;
		Assert.assertTrue(twod == null);
	}
	
	@Test
	public void PointEqual() {
		TwoDPoint twod = new TwoDPoint(1.0,2.0);
		TwoDPoint tdani = new TwoDPoint(1.0,2.0);
		
		Assert.assertTrue(twod.equals(tdani));
	}
	
	@Test
	public void PointIsNullEqual() {
		TwoDPoint twod = new TwoDPoint(1.0,2.0);
		TwoDPoint tdani = null;
		
		Assert.assertTrue(!twod.equals(tdani));
	}
	
	@Test
	public void DistanceToXCorrect(){
		
		TwoDPoint twod = new TwoDPoint(1.0,0.0);
		TwoDPoint zero = new TwoDPoint(0.0,0.0);
		
		
		Assert.assertEquals(zero.distanceTo(twod),1 , 0.0);
	}
	
	@Test
	public void DistanceToYCorrect(){
		
		TwoDPoint twod = new TwoDPoint(0.0,1.0);
		TwoDPoint zero = new TwoDPoint(0.0,0.0);
		
		
		Assert.assertEquals(zero.distanceTo(twod),1 , 0.0);
	}
	
	@Test
	public void DistanceFailCorrect(){
		
		TwoDPoint twod = null;
		TwoDPoint zero = new TwoDPoint(0.0,0.0);
		
		
		Assert.assertEquals(zero.distanceTo(twod),-1.0 , 0.0);
	}
	
	@Test
	public void ToStringCorrect() {
		
		TwoDPoint zero = new TwoDPoint(0.0,0.0);
		
		Assert.assertTrue(zero.toString().equals("(0.0,0.0)"));
	}
}
