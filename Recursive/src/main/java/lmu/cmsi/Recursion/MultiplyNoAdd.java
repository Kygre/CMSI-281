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
		
		if( b > a){
					
			int temp = a;
			a = b;
			b = temp;
		}
		
		int ans = MultAdd(Math.abs(a),Math.abs(b));
		
		if(a < 0 && b < 0){
			// do nothing
		}
		else if(a < 0 || b < 0){
			ans = ans * -1;
		}
		
		
		return ans;
		
	}

	private static int MultAdd(int a, int b) {
		
		if( b == 1){
			return a;
		}
		else{
			return a + MultAdd(a, b - 1);
		}
	}
	

}
