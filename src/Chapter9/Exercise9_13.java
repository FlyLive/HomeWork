package Chapter9;

import java.util.Scanner;

public class Exercise9_13 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int row,column;
		Location l = new Location();
		
		System.out.print("Enter numbwe of rows "
			+ "and columns in the array:");
		
		row = input.nextInt();
		column = input.nextInt();
		
		double array[][] = new double[row][column];
		
		System.out.println("Enter the array:");
		for(int i = 0;i < array.length;i++)
			for(int j = 0;j < array[i].length;j++)
				array[i][j] = input.nextDouble();
		
		l = locataLargest(array);
		
		System.out.println("The location of the largest element is "
			+ l.maxValue + " at (" + l.row + "," + l.column + ")");
	}
	
	public static Location locataLargest(double[][] a){
		Location l = new Location();
		double max = a[0][0];
		int row = 0,column = 0;
		for(int i = 0;i < a.length;i++){
			for(int j = 0;j < a[i].length;j++){
				if(max < a[i][j]){
					row = i;
					column = j;
					max = a[i][j];
				}
			}
		}
		
		l.row = row;
		l.column = column;
		l.maxValue = max;
		
		return l;
	}
}

class Location{
	int row;
	int column;
	double maxValue;
	
	Location(){
	}
}
