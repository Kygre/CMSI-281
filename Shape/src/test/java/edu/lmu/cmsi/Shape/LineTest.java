package edu.lmu.cmsi.Shape;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.lmu.cmsi.Shape.Line;
import edu.lmu.cmsi.Shape.TwoDPoint;

public class LineTest {

	private Line horizontal;
	private Line vertical;
	private Line unitline;
	private Line nullLine;
	private TwoDPoint zero,xone,yone, xoneyone;
	@Before
    public void initializeLines() {
		
		zero = new TwoDPoint(0,0);
		xone = new TwoDPoint(1, 0);
		yone = new TwoDPoint(0,1);
		xoneyone = new TwoDPoint(1, 1);
        horizontal = new Line(zero, xone);
        vertical = new Line(zero, yone);
        unitline  = new Line(zero, xoneyone);
        nullLine = null;
    }
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	@Test
	public void ConstructionNull() {
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("One or either TwoDPoints is null");
			Line bad = new Line(zero, null);
		
	}
	
	
	@Test
	public void ConstructionSlopeZero() {
			
			Line bad = new Line(zero, xone);
			Assert.assertEquals(0, bad.getIntercept(), 0);
		
	}
	
	@Test
	public void ConstructionCorrectLine() {
			
			Line bad = new Line(zero, yone);
			
			
			Assert.assertEquals("Horizontal Line - Slope is Zero", 0, horizontal.getSlope(), 0);
			Assert.assertEquals("Intercept is Zero",0, horizontal.getIntercept(), 0);
			Assert.assertEquals("Unit Line - Intercept Zero", 0, unitline.getIntercept(),0);
		
	}
	
	
	@Test
	public void ConstructionFailSamePoint() {
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("Points are equal = line does not exist");
			Line bad = new Line(zero, zero);
		
	}
	
	
	
	@Test
	public void LineEqualsCorrect(){
		
		Line l = new Line(zero, xone);
		Line v = new Line(zero, yone);
		Line u = new Line(zero, xoneyone);
		Assert.assertTrue(horizontal.equals(l));
		Assert.assertTrue(vertical.equals(v));
		Assert.assertTrue(unitline.equals(u));
		
		
	}
	
	@Test
	public void Intersect(){
		
		Line l = new Line(yone, xoneyone);
		TwoDPoint left, right, up, down;
		left = new TwoDPoint(0,3);
		right = new TwoDPoint(7,10);
		up = new TwoDPoint(0,5);
		down = new TwoDPoint(20,3);
		
		Line las = new Line(left, right);
		Line noches = new Line(zero, down);
		
		
		Assert.assertFalse("Las does not touch noches", las.intersects(noches));
	
		Assert.assertTrue(!unitline.intersects(nullLine));
		Assert.assertTrue(horizontal.intersects(vertical));
		Assert.assertTrue(vertical.intersects(unitline));
		Assert.assertTrue(!l.intersects(horizontal));
		
		
		
	}
	
	@Test
	public void MidPointTest(){
		TwoDPoint halfx = new TwoDPoint(xone.getX()/2, 0);
		TwoDPoint halfy = new TwoDPoint(0,yone.getY()/2);
		TwoDPoint halfxy = new TwoDPoint(xone.getX()/2,yone.getY()/2);
		Assert.assertTrue("half of horizontal", horizontal.midpoint().equals(halfx));
		
		Assert.assertTrue("half of vertical", vertical.midpoint().equals(halfy));
		Assert.assertTrue("half of unitline", unitline.midpoint().equals(halfxy));
	}
	
	@Test
	public void LengthTest(){
		Assert.assertEquals("Length of Vert", 1.0, vertical.length(), 0);
		Assert.assertEquals("Length of Horizontal",1.0 , horizontal.length(), 0);
		
	}
	
}
