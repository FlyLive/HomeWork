package Chapter5;

import java.util.Scanner;

public class Exercise5_17 {
	public static void main(String[] args){
		System.out.print("Enter the number of lines(1~15):");
		Scanner input = new Scanner(System.in);
		int i,j,r,num = input.nextInt();
		for(j = 0;j < num;j++){
			for(i = 0;i < 32 - (j * 2);i++)
				System.out.print(" ");
			for(r = 1 + j;r > 0;r--)
				System.out.print(r + " ");
			for(r = 2;r <= 1 + j;r++)
				System.out.print(r + " ");
			System.out.println();
		}
		method1();
		method2();
	}
	public static void method1(){
		System.out.print("Enter the number of lines(1~15)(methord1):");
		Scanner input = new Scanner(System.in);
		int i = 0,j = 0,r = 0,num = input.nextInt();
		do{
			i = 0;
			do{
				System.out.print(" ");
				i++;
			}while(i< 32 - (j * 2));
			r = 1 + j;
			do{
				System.out.print(r + " ");
				r--;
			}while(r > 0);
			r = 2;
			do{
				System.out.print(r + " ");
				r++;
			}while(r <= 1 + j);
			System.out.println();
			j++;
		}while(j< num);
		
	}
	public static void method2(){
		System.out.print("Enter the number of lines(1~15):(methord2)");
		Scanner input = new Scanner(System.in);
		int i = 0,j = 0,r = 0,num = input.nextInt();
		while(j < num){
			i = 0;
			while(i < 32 - (j * 2)){
				System.out.print(" ");
				i++;
			}
			r = 1 + j;
			while(r > 0){
				System.out.print(r + " ");
				r--;
			}
			r = 2;
			while(r <= 1 + j){
				System.out.print(r + " ");
				r++;
			}
			System.out.println();
			j++;
		}
	}
}