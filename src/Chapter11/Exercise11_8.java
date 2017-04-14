package Chapter11;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Exercise11_8 {
	public static void main(String[] args){	
		NewAcount a = new NewAcount("George",1122,1000);
		a.setRate(1.5);
		disPlayNewAcount(a);
	}
	
	public static void checkBalance(NewAcount client){
		System.out.println("The balance is " + client.getBalance());
	}
	
	public static void withDraw(NewAcount client){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an amount to withdraw:");
		double money = input.nextDouble();
		client.withDraw(money);
	}
	
	public static void deposit(NewAcount client){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an amount to deposit:");
		double money = input.nextDouble();
		client.deposit(money);
	}
	
	public static void transaction(NewAcount client){
		System.out.println("The transaction is:");
		for(int i = 0;i < client.getTransaction().size();i++)
			System.out.println(client.getTransaction().get(i).
				getDescription());
	}
	
	public static void disPlayNewAcount(NewAcount client){		//进入ATM
		Scanner input = new Scanner(System.in);
		int choice;
		do{
			menu();
			choice =input.nextInt();
			switch(choice){
			case 1:checkBalance(client);break;
			case 2:withDraw(client);break;
			case 3:deposit(client);break;
			case 4:transaction(client);break;
			case 5:break;
			default:System.out.print("Enter the correct number(1~5):");
				break;
			}
		}while(choice != 5);
	}

	public static void menu(){						//主菜单
		System.out.println("\nMain menu");
		System.out.println("1:check balance");
		System.out.println("2:withdraw");
		System.out.println("3:deposit");
		System.out.println("4:transaction");
		System.out.println("5:exit");
		System.out.print("Enter a choice:");
	}
}

class NewAcount extends Acount2{
	private String name;
	private ArrayList<Transaction> transaction = new ArrayList<>();
	
	public NewAcount(){
	}
	
	public NewAcount(String name,int id,double amount){
		super(id,amount);
		this.name = name;
	}
	
	public ArrayList<Transaction> getTransaction(){
		return transaction;
	}
	
	@Override
	public void withDraw(double amount){
		if(amount <= super.getBalance()){
			System.out.println("Your balance before is " +
				super.getBalance());
			super.withDraw(amount);
			System.out.println("Your balance after is " +
					super.getBalance());
			
			transaction.add(
					new Transaction('W',amount,super.getBalance(),
					"Name:" + this.name +",ID:" + super.getId() +
					super.getAnnualInterestRate() + ",W " + amount +
					" at date " + new Date() + " and the balance"
					+ " is leave" + super.getBalance()));
		}
		else{
			System.out.println("\nYour balance is not enough,"
				+ "and you just can withdraw " + super.getBalance()
				+ " and your balance leave 0\n");
			
			transaction.add(
					new Transaction('W',amount,super.getBalance(),
					"Name:" + this.name +",ID:" + super.getId() +
					super.getAnnualInterestRate() + ",W " +
					super.getBalance() + " at date " + new Date()
					+ " and the balance" + " is 0"));
			
			super.withDraw(super.getBalance());
		}			
	}
	
	@Override
	public void deposit(double amount){
		
		System.out.println("Your balance before is " +
				super.getBalance());
		super.deposit(amount);
		System.out.println("Your balance after is " +
				super.getBalance());
		
		transaction.add(
				new Transaction('D',amount,super.getBalance(),
				"Name:" + this.name +",ID:" + super.getId() +
				super.getAnnualInterestRate() + ",D " + amount +
				" at date " + new Date() + " and the balance"
				+ " is " +super.getBalance()));
	}
}

class Transaction{
	private Date date = new Date();
	private char type;
	private double amount;
	private double balance;
	private String description;
	
	public Transaction(){
	}
	
	public Transaction(char type,double amount,
			double banlance,String description){
		setType(type);
		setDescription(description);
		setAmount(amount);
		setBalance(balance);
	}
	
	public Date getDate() {
		return date;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

class Acount2{
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated = new Date();
	
	public Acount2(){					//初始化账户
	}

	public Acount2(int newId,double newBalance){//特定id及余额
		id = newId;
		balance = newBalance;
	}
	
	public void setId(int newId){			//更改id
		id = newId;
	}
	
	public void setRate(double newRate){	//更改利率
		annualInterestRate = newRate;
	}
	
	public int getId(){						//返回id
		return id;
	}
	
	public double getBalance(){				//返回balance
		return balance;
	}
	
	public double getAnnualInterestRate(){	//返回利率
		return annualInterestRate;
	}
	
	public Date getDate(){					//返回日期
		return dateCreated/*.toString()*/;
	}
	
	public void dateCreated(Date newDate){					//修改日期
		dateCreated = newDate;
	}
	
	public double getMonthlyInterestRate(){	//返回月利率
		return annualInterestRate / 12;
	}
	
	public double getMonthlyInterest(){		//返回月利息
		return balance * annualInterestRate / 12 / 100;
	}
	
	public void withDraw(double draw){			//取款
		balance = balance - draw;
	}
	
	public void deposit(double incrase){		//存款
		balance = balance + incrase;
	}
}