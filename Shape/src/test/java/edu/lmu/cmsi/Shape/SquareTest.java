package edu.lmu.cmsi.Shape;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.lmu.cmsi.Shape.Square;
import edu.lmu.cmsi.Shape.TwoDPoint;

public class SquareTest {

	private static TwoDPoint zero,xoneyone, two;
	private Square unit, big;
	@BeforeClass
    public static void initializePoints() {
		
		zero = new TwoDPoint(0,0);
		
		xoneyone = new TwoDPoint(10, 10);
		two = new TwoDPoint(2,2);
		
    }
	
	@Before
	public void initalizeSqaures(){
		unit = new Square(zero, 1);
		big = new Square(two, 2);
        
	}
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testConstructor() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("width must be greater than zero");
		Square s  = new Square(zero, -1);
	}
	
	@Test
	public void testConstructorNull() {
		// exception handled by TwoDPoint
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("TwoDPoint is null");
		Square s  = new Square(null, 1);
	}
	
	
	
	@Test
	public void testGetArea() {
	Assert.assertEquals("Unit Area", 1 , unit.getArea(), 0);
	Assert.assertEquals("Big Area", 4 , big.getArea(), 0);
	}

	@Test
	public void testContains() {
		Assert.assertFalse("Point is not inside big", big.contains(new TwoDPoint(1,1)));
		Assert.assertFalse("Next point is inside big", big.contains(new TwoDPoint(3,3)));
	}

	@Test
	public void testTranslate() {
		unit.Translate(two);
		Assert.assertTrue("Unit Square not translated", unit.getSquare().get(0).equals(two));
		
		big.Translate(two);
		Assert.assertTrue("Big Square not translated", big.getSquare().get(0).equals(two));
	}

	@Ignore
	public void testGetBoundingRectangle() {
		// by definition a square is a rectangle
	}

	

}
