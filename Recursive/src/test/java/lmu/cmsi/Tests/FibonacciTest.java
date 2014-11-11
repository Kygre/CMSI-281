package lmu.cmsi.Tests;

import lmu.cmsi.Recursion.Fibonnaci;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {


	@Test
	public void testFibZero() {
		Assert.assertEquals(0, Fibonnaci.FibTo(1), 0);
	}
	@Test
	public void testFibTen() {
		Assert.assertEquals(34, Fibonnaci.FibTo(10), 0);
	}
	
	

}
