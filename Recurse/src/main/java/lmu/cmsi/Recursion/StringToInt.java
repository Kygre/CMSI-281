package lmu.cmsi.Recursion;

/**
 * 
 * @author Kwadwo Yeboah
 * 
 * Converts a String to an integer using base 10 multiplication
 *
 */
public class StringToInt {



	public static int StringConvert(String s){
		return Convert(s.toCharArray(), 0);
	}
	private static int Convert(char[] charArray, int i) {
		if(i == charArray.length ){
			return 0;
		}
		else{

			int a = Character.getNumericValue(charArray[i]) * (int) Math.pow(10, Math.abs(charArray.length - 1 - i));

			return a + Convert(charArray, i + 1);
		}

	}


}
