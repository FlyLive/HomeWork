package Chapter10;

import java.util.Date;
import java.util.Scanner;

public class Exercise10_7 {
	public static void main(String[] args){			//������	
		Scanner input = new Scanner(System.in);
		Acount[] a = createdClient();
		EnterATM(a);
	}
	
	public static Acount[] createdClient(){			//�����˺�
		Acount[] a = new Acount[10];
		for(int i = 0;i < 10;i++){
			a[i] = new Acount(i,100);
		}
		return a;
	}
	
	public static void EnterATM(Acount[] a){		//�����˺�
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
	
	public static void disPlay(Acount client){		//����ATM
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

	public static void menu(){						//���˵�
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
	
	public Acount(){					//��ʼ���˻�
		id = 0;
		balance = 0;
		annualInterestRate = 0;
	}

	public Acount(int newId,double newBalance){//�ض�id�����
		id = newId;
		balance = newBalance;
	}
	
	public void setId(int newId){			//����id
		id = newId;
	}
	
	public void setRate(double newRate){	//��������
		annualInterestRate = newRate;
	}
	
	public int getId(){						//����id
		return id;
	}
	
	public double getBalance(){				//����balance
		return balance;
	}
	
	public double getAnnualInterestRate(){	//��������
		return annualInterestRate;
	}
	
	public Date getDate(){					//��������
		return dateCreated/*.toString()*/;
	}
	
	public void setDate(Date newDate){					//�޸�����
		dateCreated = newDate;
	}
	
	public double getMonthlyInterestRate(){	//����������
		return annualInterestRate / 12;
	}
	
	public double getMonthlyInterest(){		//��������Ϣ
		return balance * annualInterestRate / 12 / 100;
	}
	
	public void withDraw(double draw){			//ȡ��
		if(balance > draw)
			balance = balance - draw;
		else
			balance = 0;
	}
	
	public void deposit(double incrase){		//���
		balance = balance + incrase;
	}
}