package edu.lmu.cmsi.Shape;



import java.math.BigDecimal;
import java.math.MathContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.lmu.cmsi.Shape.Circle;
import edu.lmu.cmsi.Shape.Rectangle;
import edu.lmu.cmsi.Shape.TwoDPoint;

/**
 * 
 * @author Kwadwo Yeboah
 * Finish getArea Tests
 *
 */
public class CircleTest {

	private Circle unitcircle;
	private Circle bigcirlce;
	
	@Before
	public void initCircles(){
		unitcircle = new Circle(new TwoDPoint(2,2), 1);
		
		bigcirlce = new Circle(new TwoDPoint(34, 35), 16);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	@Test
	public void ConstructorTestRadius() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Circle must have radius > 0.0");
		Circle bad = new Circle(new TwoDPoint(0,0),-1);
		
	}
	
	@Test
	public void ConstructorTestTwoDPoint() {
		// thrown by TwoDPoint Constructor
		thrown.expect(IllegalArgumentException.class);
		
		Circle bad = new Circle(new TwoDPoint(-10,10),1);
		
	}
	
	@Test
	public void TestGetArea() {
		// test cirlce 
		
		BigDecimal bg = new BigDecimal(Math.PI * Math.pow(unitcircle.getRadius(), 2));
		Assert.assertEquals("Area equal", bg.round(new MathContext(16)).doubleValue(), unitcircle.getArea(), 0);
		
		bg = new BigDecimal(Math.PI * Math.pow(bigcirlce.getRadius(), 2));
		Assert.assertEquals("Area equal", bg.round(new MathContext(16)).doubleValue(), bigcirlce.getArea(), 0);
	}
	
	@Test
	public void TestCircumference() {
		// added bigger delta to account for BigInteger precision
		BigDecimal bg = new BigDecimal(Math.PI * (unitcircle.getRadius() * 2));
		
		Assert.assertEquals("Circumference equal", bg.round(new MathContext(16)).doubleValue(), unitcircle.getCircumference(), 0.00000100);
		
		bg = new BigDecimal(Math.PI * (bigcirlce.getRadius() * 2));
		Assert.assertEquals("Circumference equal", bg.round(new MathContext(16)).doubleValue(), bigcirlce.getCircumference(), 0.00000100);
		
	}
	
	@Test
	public void TestContains() {
		// test circumference
		
		TwoDPoint twodz = new TwoDPoint(0, 0);
		TwoDPoint twody = new TwoDPoint(0, 1);
		TwoDPoint twodx = new TwoDPoint(1, 0);
		TwoDPoint twodxy = new TwoDPoint(1, 1);
		TwoDPoint cent = new TwoDPoint(2, 2);
		TwoDPoint bigcent = new TwoDPoint(32, 35);
		
		
		Assert.assertFalse(unitcircle.contains(twodx));
		Assert.assertFalse(unitcircle.contains(twody));
		Assert.assertFalse(unitcircle.contains(twodz));
		Assert.assertFalse(unitcircle.contains(twodxy));
		Assert.assertTrue(unitcircle.contains(cent));
		Assert.assertFalse(unitcircle.contains(bigcent));
		Assert.assertTrue(bigcirlce.contains(bigcent));
		
		
	}
	
	@Test
	public void TestTranslate() {
		
		thrown.expect(IllegalArgumentException.class);
		
		unitcircle.Translate(new TwoDPoint(-10, -10));
	
		
	}
	

	@Test
	public void TestTranslateX() {
		
		thrown.expect(IllegalArgumentException.class);
		
		unitcircle.Translate(new TwoDPoint(-10, 2));
	
		
	}

	@Test
	public void TestTranslateY() {
		
		thrown.expect(IllegalArgumentException.class);
		
		unitcircle.Translate(new TwoDPoint(2, -10));
	
		
	}
	
	
	
	@Test
	public void TestgetBoundingRectangle() {

			// unit is 2,2
		TwoDPoint lowleft, lowright, upright, upleft;
		lowleft = new TwoDPoint(1.0,1.0);
		lowright = new TwoDPoint(3.0,1.0);
		upright = new TwoDPoint(3.0,3.0);
		upleft = new TwoDPoint(1.0,3.0);
		Rectangle rec = new Rectangle(lowleft, lowright, upright, upleft);
		
		
		Assert.assertTrue("Rectangle bounds not equal", unitcircle.getBoundingRectangle().equals(rec));
		
		Assert.assertFalse("Rectangle should not be equal", bigcirlce.getBoundingRectangle().equals(rec));
		
	}	
	
}
