# Assignment 5

## Fibonacci
The fibonnaci sequence runs using recursion and returns the nth element. It is written similiar to the mathematical             definition  and has a private helper method to help it start.

## Multiply Without Adding
The multiply without adding recursion just uses basic addition to add two numbers, without getting too fancy like the Russian Peasant's Algorithm. It checks for the largest and continues to this number including until the smaller number hits one, which is the base case.

## String to Integer
String to Integer converts the String to a char array and passes it through recursion. I chose this method over using String's method of substring for a performance reason. Each newly passed substring to the recursive call creates a new immutable String, I believe it easier just use a charr array and keep track of the index.
The recursive essentially grabs each char in the array and converts it to Base 10 using the index it is currently at. ( Assuming no leading zero magic)

## Stack Parenthesis Checker
The stack parenthesis checker uses the Java stack to check for a balanced parenthesis. If the brace is open then it is pushed, if it closed then the stack is popped and checked with the current parenthesis if it is a matching brace, if this fails then it is not a balanced parenthesis.
As in the simplified example below checking open parenthesis against a closed bracket and etc;
assuming pop is the popped string off of the stack

```java
	switch(pop){
		
		case "(":
		
		if(now.equals("]")){
			return false;
			}
			else{
				continue;
			}
		}

```
