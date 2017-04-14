package Chapter12;

import java.io.File;
import java.util.Scanner;

public class Exercise12_30 {
	public static void main(String[] args){
		int[] n = new int[52];
		if(sort(n))
			display(n);
	}
	
	public static boolean sort(int[] n){
		System.out.print("Enter a filename:");
		Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		
		File file = new File(name);
		if(!file.exists()){
			System.out.println("File does not exists");
			return false;
		}
		else{
			Scanner input1 = new Scanner(name);
			while(input1.hasNext()){
				String s = input1.nextLine();
				for(int i = 0;i < s.length();i++){
					if(s.charAt(i) >= 65 && s.charAt(i) <= 90)
						n[s.charAt(i) - 65] = s.charAt(i);
					else if(s.charAt(i) >= 97 && s.charAt(i) <= 122)
						n[s.charAt(i) - 71] = s.charAt(i);
				}
			}
			return true;
		}
	}
	
	public static void display(int[] n){
		for(int i = 0;i < n.length;i++){
			if(i <= 25)
			System.out.println("Number of " + (char)(i + 65) + "'s: " + n[i]);
			else
			System.out.println("Number of " + (char)(i + 71) + "'s: " + n[i]);
		}
	}
}
