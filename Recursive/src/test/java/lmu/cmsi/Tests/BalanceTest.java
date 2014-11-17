package lmu.cmsi.Tests;

import static org.junit.Assert.*;
import lmu.cmsi.Stack.Balance;

import org.junit.Assert;
import org.junit.Test;

public class BalanceTest {

	@Test
	public void testIsBalancedTrue() {
		Assert.assertTrue(Balance.isBalanced("(()[])"));
	}

	@Test
	public void testIsBalancedFalse() {
		Assert.assertFalse(Balance.isBalanced("[(])"));
	}

}
