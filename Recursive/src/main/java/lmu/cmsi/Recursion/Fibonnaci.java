package lmu.cmsi.Recursion;

public class Fibonnaci {


	public static int FibTo(int i) {
		// F = F(n - 1) + F(n - 2) 
		i--;
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

	public static void printFib(int n){
		 for(int i = 0; i <= n; i++){
			 System.out.print(FibTo(i) + " - ");
		 }
	}

}
