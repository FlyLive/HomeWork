package Chapter6;

import java.util.Scanner;

public class Exercise6_3 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer:");;
		int n = input.nextInt();
		System.out.print("The number of " + n + " is Palindome is "
			+ isPalindrome(n));
		if(isPalindrome(n))
			System.out.println(" and the Palindromenumber is "
				+ reverse(n));
	}
	public static int reverse(int n){
		int i = 0,pnum = 0,temp = n;
		while(temp != 0){
			i++;
			pnum = pnum * 10 + temp % 10;
			temp /= 10;
		}
		if(pnum == n)
			return pnum;
		else
			return -1;
	}
	public static boolean isPalindrome(int n){
		if(reverse(n) == n)
			return true;
		else
			return false;
	}
}
