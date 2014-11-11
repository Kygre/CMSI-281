package lmu.cmsi.Tests;

import lmu.cmsi.Recursion.MultiplyNoAdd;

import org.junit.Assert;
import org.junit.Test;

public class MultiplyTest {

	@Test
	public void testMultiplyZero() {
		Assert.assertEquals(0, MultiplyNoAdd.Multiply(0, 10));
	}
	@Test
	public void testMultiplyPos() {
		Assert.assertEquals(12, MultiplyNoAdd.Multiply(3, 4));
	}
	@Test
	public void testMultiplyNeg() {
		Assert.assertEquals(-12, MultiplyNoAdd.Multiply(3, -4));
	}

}
