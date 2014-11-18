package lmu.cmsi.Tests;

import lmu.cmsi.Recursion.Fibonnaci;

import org.junit.Assert;
import org.junit.Test;


public class FibonacciTest {


	@Test
	public void testFibZero() {
		Assert.assertEquals(0, Fibonnaci.FibTo(0), 0);
	}
	@Test
	public void testFibOne() {
		Assert.assertEquals(1, Fibonnaci.FibTo(1), 0);
	}
	@Test
	public void testFibTwo() {
		Assert.assertEquals(1, Fibonnaci.FibTo(2), 0);
	}
	@Test
	public void testFibTen() {
		Assert.assertEquals(55 , Fibonnaci.FibTo(10), 0);
	}
	
	

}
