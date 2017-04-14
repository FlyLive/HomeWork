package Chapter12;

public class Exercise12_4 {

	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private java.util.Date loanDate;
	
	public Exercise12_4(){
		this(2.5,1,1000);
	}
	
	public Exercise12_4(double annualInterestRate,int numberOfYears,
			double loanAmount) throws IllegalArgumentException{
		if(annualInterestRate > 0)
			this.annualInterestRate = annualInterestRate;
		else
			throw new IllegalArgumentException("annualInterestRate can"
				+ " not be negative");
		if(numberOfYears > 0)
			this.numberOfYears = numberOfYears;
		else
			throw new IllegalArgumentException("numberOfYears  can"
				+ " not be negative");
		if(loanAmount > 0)
			this.loanAmount = loanAmount;
		else
			throw new IllegalArgumentException("loanAmount can not"
				+ " be negative");
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

