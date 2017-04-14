package Chapter7;

import java.util.Scanner;

public class Exercise7_3 {
	public static void main(String[] args){
		System.out.print("Entre the integers between 1 and 100:");
		int[] n = getArray(),count = countNumber(n);
		printcount(count);
	}
	
	public static int[] countNumber(int[]n){
		int[] count = new int[100];
		for(int i = 0;i < n.length;i++){
			if(n[i] == 0)
				break;
			else
				count[n[i]]++;
		}
		return count;
	}
	public static int[] getArray(){
		int[] n = new int[100];
		Scanner input = new Scanner(System.in);
		for(int i = 0;i < n.length;i++){
			n[i] = input.nextInt();
			if(n[i] == 0)
				break;
		}
		return n;
	}
	
	public static void printcount(int[] count){
		for(int i = 1;i < count.length;i++){
			if(count[i] != 0 && count[i] > 1)
				System.out.println(i + " occurs " + count[i] + "times");
			else if(count[i] != 0 && count[i] == 1)
				System.out.println(i + " occurs " + count[i] + "time");
			
		}
	}
}
