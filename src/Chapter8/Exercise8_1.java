package Chapter8;

import java.util.Scanner;

public class Exercise8_1 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Wnter a 3-by-4 matrex row by row:");
		double[][] m = new double[3][4];
		for(int i = 0;i < m.length;i++)
			for(int j = 0;j < m[i].length;j++)
				m[i][j] = input.nextDouble();
		for(int i = 0;i < 4;i++)
			System.out.println("Sum of elements at column " + i + " is "
				+ sumColumn(m,i));
	}
	
	public static double sumColumn(double[][] m,int columnIndex){
		double sum = 0;
		for(int i = 0;i < m.length;i++)
			sum += m[i][columnIndex];
		return sum;
	}
}
