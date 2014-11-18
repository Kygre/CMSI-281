package lmu.cmsi.Recursion;

/**
 * 
 * @author Kwadwo Yeboah
 * 
 * Recursive algorithm to produce nth Fibonacci number
 *
 */
public class Fibonnaci {


	public static int FibTo(int i) {
		// F = F(n - 1) + F(n - 2) 
		
		return FibIt(i);
	}
	
	private static int FibIt(int i) {
		
		if(i == 0){
			return 0;
		}
		else if(i == 1){
			return 1;
		}
		else{
			return FibIt(i - 1) + FibIt(i - 2 );
		}
	}


}
