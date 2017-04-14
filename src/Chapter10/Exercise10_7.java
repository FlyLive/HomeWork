package Chapter10;

import java.util.Date;
import java.util.Scanner;

public class Exercise10_7 {
	public static void main(String[] args){			//主函数	
		Scanner input = new Scanner(System.in);
		Acount[] a = createdClient();
		EnterATM(a);
	}
	
	public static Acount[] createdClient(){			//创建账号
		Acount[] a = new Acount[10];
		for(int i = 0;i < 10;i++){
			a[i] = new Acount(i,100);
		}
		return a;
	}
	
	public static void EnterATM(Acount[] a){		//输入账号
		Scanner input = new Scanner(System.in);
			System.out.print("Enter an Id:");
		do{
			int i,id = input.nextInt();
			for(i = 0;i < 10;i++){
				if(a[i].getId() == id){
					disPlay(a[i]);
					break;
				}
			}
			if(i == 10)
				System.out.print("Enter the correct Idnumber:");
			else
				System.out.print("Enter an Id:");
		}while(true);
	}
	
	public static void checkBalance(Acount client){
		System.out.println("The balance is " + client.getBalance());
	}
	
	public static void withDraw(Acount client){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an amount to withdraw:");
		double money = input.nextDouble();
		if(money > client.getBalance())
			System.out.println("Your balance is empty,and withdraw " +
				client.getBalance());
		client.withDraw(money);
	}
	
	public static void deposit(Acount client){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an amount to deposit:");
		double money = input.nextDouble();
		client.deposit(money);
	}
	
	public static void disPlay(Acount client){		//进入ATM
		Scanner input = new Scanner(System.in);
		int choice;
		do{
			menu();
			choice =input.nextInt();
			switch(choice){
			case 1:checkBalance(client);break;
			case 2:withDraw(client);break;
			case 3:deposit(client);break;
			case 4:break;
			default:System.out.print("Enter the correct number(1~4):");
				break;
			}
		}while(choice != 4);
	}

	public static void menu(){						//主菜单
		System.out.println("\nMain menu");
		System.out.println("1:check balance");
		System.out.println("2:withdraw");
		System.out.println("3:deposit");
		System.out.println("4:exit");
		System.out.print("Enter a choice:");
	}
}

class Acount{
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated = new Date();
	
	public Acount(){					//初始化账户
		id = 0;
		balance = 0;
		annualInterestRate = 0;
	}

	public Acount(int newId,double newBalance){//特定id及余额
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
	
	public void setDate(Date newDate){					//修改日期
		dateCreated = newDate;
	}
	
	public double getMonthlyInterestRate(){	//返回月利率
		return annualInterestRate / 12;
	}
	
	public double getMonthlyInterest(){		//返回月利息
		return balance * annualInterestRate / 12 / 100;
	}
	
	public void withDraw(double draw){			//取款
		if(balance > draw)
			balance = balance - draw;
		else
			balance = 0;
	}
	
	public void deposit(double incrase){		//存款
		balance = balance + incrase;
	}
}