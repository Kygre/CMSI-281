package lmu.cmsi.Tests;

import lmu.cmsi.Recursion.StringToInt;

import org.junit.Assert;
import org.junit.Test;

public class StringToIntTest {

	@Test
	public void ConvertToTest() {
		String s = "123";
		Assert.assertEquals(Integer.parseInt(s), StringToInt.StringConvert(s),0);
	}
	
	@Test
	public void ConvertToTestAgain() {
		String s = "23498";
		Assert.assertEquals(Integer.parseInt(s), StringToInt.StringConvert(s),0);
	}

}
