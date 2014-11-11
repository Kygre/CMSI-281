package lmu.cmsi.Stack;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 
 * @author Kwadwo Yeboah
 *
 */
public class Balance {

	
	// Uses stack to determine if parenthesis are balanced
	public static boolean isBalanced(String s){
		
		if(s.isEmpty()){
			return false;
		
		}
		
		
		Stack<String> stack = new Stack<String>();
		
		
		
		for(int i = 0; i < s.length(); i++){
			String now = s.substring(i, i+1);
			
			if(now.equals("(") || now.equals("[")){
				stack.push(s.substring(i, i+1));
				
			}
			else{
				try {
					stack.pop();
				} catch (EmptyStackException e) {
					// TODO Auto-generated catch block
					return false;
				}
			}
			
			
		}
		
		if(!stack.isEmpty()){

			return false;	
		}
		
		return true;
		
		
		
		
	}

}
