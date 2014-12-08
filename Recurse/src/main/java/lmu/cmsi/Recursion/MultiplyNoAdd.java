package lmu.cmsi.Recursion;

/**
 * 
 * @author Kwadwo Yeboah
 * A program to multiply two integers using recursion without explicit multiplication
 *
 */
public class MultiplyNoAdd {


	public static int Multiply(int a, int b){
		
		if(a == 0 || b == 0){
			return 0;
		}
		
		if( b > a ){
					
			int temp = a;
			a = b;
			b = temp;
		}
		
		return MultAdd(a,b);
		
		
		
	}

	private static int MultAdd(int a, int b) {
		
		if( b == 1 ){
			return a;
		}
		else{
			return a + MultAdd(a, b - 1);
		}
	}
	

}
