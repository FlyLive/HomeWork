package Chapter10;

import java.util.Scanner;

public class Exercise10_3 {
	public static void main(String[] args){
		MyInteger m = new MyInteger(6);
		System.out.println(m.getValue() + " is even is " + m.isEven(m)
			+ ",and is odd is " + m.isOdd(m) + ",and is prime is " +
			m.isPrime(m));
		
		int testNumber = 7;
		System.out.println(testNumber + " is even is " +
			m.isEven(testNumber) + ",and is odd is " +
			m.isOdd(testNumber) + ",and is prime is " +
			m.isPrime(testNumber));
		
		System.out.println(testNumber + " and " + m.getValue() + " is "
			+ " is equals is " + m.equals(testNumber) + "\n" +
			m.getValue() + " and " + m.getValue() + " is equals is " +
			m.equals(m));
		
		System.out.print("Enter an array with characters "
			+ "by five characters:");
		char[] c = createdArray();
		System.out.println("The number of this array is " +
			m.parseInt(c));
		
		System.out.print("Enter a string:");
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		System.out.println("The number of this string is " +
			Integer.parseInt(s));
	}
	
	public static char[] createdArray(){
		Scanner input = new Scanner(System.in);
		char[] c = new char[5];
		for(int i = 0;i < c.length;i++)
			c[i] = input.next().charAt(0);
		return c;
	}
}

class MyInteger{
	private int value;
	
	public MyInteger(int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	public boolean isEven(int value){
		return value % 2 == 0;
	}
	
	public boolean isOdd(int value){
		
		return value % 2 != 0;
	}
	
	public boolean isPrime(int value){
		int i;
		for(i = 2;i < value;i++)
			if(value % i == 0)
				break;
		return value == i;
	}
	
	public static boolean isEven(MyInteger m){
		return m.isEven(m.getValue());
	}
	
	public static boolean isOdd(MyInteger m){
		return m.isOdd(m.getValue());
	}
	
	public static boolean isPrime(MyInteger m){
		return m.isPrime(m.getValue());
	}
	
	public boolean equals(int n){
		return this.getValue() == n;
	}
	
	public boolean equals(MyInteger m){
		return this.getValue() == m.getValue();
	}
	
	public static int parseInt(char[] c){
		int n = 0;
		for(int i = 0;i < c.length;i++)
			n = ((c[i] - 48) + n * 10);
		return n;
	}
	
	public static int parseInt(String s){
		return Integer.parseInt(s);
	}
}