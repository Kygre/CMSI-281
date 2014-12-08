package lmu.cmsi.Stack;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 
 * @author Kwadwo Yeboah
 *	Checks if string is balanced using stack
 */
public class Balance {

	
	// Uses stack to determine if parenthesis are balanced
	public static boolean isBalanced(String s){
		
		if(s.isEmpty()){
			throw new IllegalArgumentException("Cannot check empty string");
		
		}
		
		
		Stack<String> stack = new Stack<String>();
		
		
		
		for(int i = 0; i < s.length(); i++){
			String now = s.substring(i, i+1);
			
			if(now.equals("(") || now.equals("[")){
				stack.push(s.substring(i, i+1));
				
			}
			else{

				try {
					
					String pop = stack.pop();
					switch(pop){
					
					case "(":
						
						if(now.equals("]")){
							return false;
						}
						else{
							continue;
						}
						
						
					case "[":
						if(now.equals(")")){
							return false;
						}
						else{
							continue;
						}
						
					}
				} catch (EmptyStackException e) {
					
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
