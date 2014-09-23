package edu.lmu.cmsi.Shape;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.lmu.cmsi.Shape.Rectangle;
import edu.lmu.cmsi.Shape.TwoDPoint;

public class RectangleTest {

	private Rectangle unitRectangle;
	private Rectangle bigRectangle;
	
	TwoDPoint twodz ,twody ,twodx, twodxy ,	cent, bigcent, centright;
	
	@Before
	public void initSquares(){
		
		twodz = new TwoDPoint(0, 0);
		 twody = new TwoDPoint(0, 1);
		twodx = new TwoDPoint(1, 0);
		twodxy = new TwoDPoint(1, 1);
		cent = new TwoDPoint(2, 2);
		bigcent = new TwoDPoint(0, 2);
		centright = new TwoDPoint(2,0);
		
		unitRectangle = new Rectangle(twodz, twodx, twodxy, twody);
		bigRectangle = new Rectangle(twodz, centright, cent, bigcent);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testRectangleConstructorBadTwoDPoint(){
		thrown.expect(IllegalArgumentException.class);
		TwoDPoint badpoint = new TwoDPoint(-1,0);
	}
	
	@Test
	public void testRectangleConstructorNull(){
		thrown.expect(IllegalArgumentException.class);
		Rectangle rec = new Rectangle(null, twodx, twodxy, twody);
	}
	
	@Test
	public void testRectangleConstructorSamePoints(){
		thrown.expect(IllegalArgumentException.class);
		Rectangle rec = new Rectangle(null, twodx, twodx, twody);
	}
	
	
	@Test
	public void testRectangleArea(){
		double width = unitRectangle.getMyl().get(2).getX() - unitRectangle.getMyl().get(0).getX();
		double  height = unitRectangle.getMyl().get(2).getY() - unitRectangle.getMyl().get(0).getY();
		BigDecimal recarea = new BigDecimal(height * width);
		
		Assert.assertEquals("Rectangle Area equal", recarea.doubleValue(), unitRectangle.getArea(),0.0000001000);
		
		
	}
	@Test
	public void testRectangleContains(){
		TwoDPoint in = new TwoDPoint(0.5,0.5);
		TwoDPoint out = new TwoDPoint(2.5,2.5);
		TwoDPoint wayout = new TwoDPoint(5.5,5.5);
		
		Assert.assertTrue(unitRectangle.contains(in));
		Assert.assertFalse(unitRectangle.contains(out));
		Assert.assertFalse(unitRectangle.contains(wayout));
	}
	@Test
	public void testRectangleEquals(){
		
		Assert.assertTrue("UnitRec to itself", unitRectangle.equals(unitRectangle));
		Assert.assertTrue("BigRec to itself", bigRectangle.equals(bigRectangle));
		
		Rectangle tempRectangle = new Rectangle(twodz, twodx, twodxy, twody);
		
		Assert.assertFalse("UnitRec to BigRec",unitRectangle.equals(bigRectangle));
		Assert.assertTrue("UnitRec to new itself",unitRectangle.equals(tempRectangle) );
		
	}
	@Test
	public void testRectanglePerimeter(){
		double width = unitRectangle.getWidth();
		double  height = unitRectangle.getHeight();
		
		Assert.assertEquals("Unit Permiter", (2 * (width + height)), unitRectangle.getPerimeter(), 0.0000100);
		
	}
	
	@Test
	public void testTranslate() {
		unitRectangle.Translate(cent);
		Assert.assertTrue(unitRectangle.getMyl().get(0).equals(cent));
	}
	
	
}
