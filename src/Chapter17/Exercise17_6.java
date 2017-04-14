package Chapter17;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Exercise17_6 {
	public static void main(String[] args)
			throws ClassNotFoundException,IOException{
		Loan[] l1 = new Loan[5];
		for(int i = 0;i < 5;i++)
			l1[i] = new Loan();
		
		try(
			ObjectOutputStream output = new ObjectOutputStream
				(new FileOutputStream("Exercise17_6.dat",true));
		){
			for(int i = 0;i < l1.length;i++)
				output.writeObject(l1[i]);
		}
		testInput();
	}
	
	public static void testInput() throws ClassNotFoundException,IOException{
		double sum = 0;
		Loan[] l = new Loan[5];
		try(
			ObjectInputStream input = new ObjectInputStream
				(new FileInputStream("Exercise17_6.dat"));
		){
			while(true){
				int i = 0;
					l[i] = (Loan)input.readObject();
					sum += l[i].getLoanAmount();
					i++;
			}
		}
		catch(EOFException ex){
			System.out.println("All object were read");
		}
		catch(IOException ex){
			System.out.println("The file does not exist");
		}
		
		System.out.println(sum + " ");
	}
}

class Loan implements Serializable{
	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private java.util.Date loanDate;
	
	public Loan(){
		this(2.5,1,1000);
	}
	
	public Loan(double annualInterestRate,int numberOfYears,
			double loanAmount){
		this.annualInterestRate = annualInterestRate;
		this.numberOfYears = numberOfYears;
		this.loanAmount = loanAmount;
		loanDate = new java.util.Date();
	}
	
	public double getAnnualInterestRate(){
		return annualInterestRate;
	}
	
	public void setAnnualInteretRate(double annualInterestRate){
		this.annualInterestRate = annualInterestRate;
	}
	
	public int getNumberOfYears(){
		return numberOfYears;
	}
	
	public void setNumberOfYears(int numberOfYears){
		this.numberOfYears = numberOfYears;
	}
	
	public double getLoanAmount(){
		return loanAmount;
	}
	
	public void setLoanAmount(double loanAmount){
		this.loanAmount = loanAmount;
	}
	
	public double getMonthlyPayment(){
		double monthlyInterestRate = annualInterestRate / 1200;
		double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
			(1 / Math.pow(1 + monthlyInterestRate,numberOfYears * 12)));
		return monthlyPayment;
	}
	
	public double getTotalPayment(){
		double totalPayment = getMonthlyPayment() * numberOfYears * 12;
		return totalPayment;
	}
	
	public java.util.Date getLoanDate(){
		return loanDate;
	}
}