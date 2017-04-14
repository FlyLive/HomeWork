package Chapter25;

import java.util.*;

public class Exercise25_4 {
	public static void main(String[] args){
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 2;;i++){
			for(int j = 1;j < i;j++){
				if( j != 1 && i % j == 0)
					break;
				else if(j == i - 1){
					stack.push(i);
				}
			}
			if(stack.size() == 50)
				break;
		}
			System.out.println(stack.size());
		for(int i = stack.size();i > 0;i--)
			System.out.print(stack.pop() + " ");
	}
}
