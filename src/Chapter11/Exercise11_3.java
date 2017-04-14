package Chapter11;

import java.util.Date;

public class Exercise11_3 {
	public static void main(String[] args){
		Acount a = new Acount(131,10000);
		Acount c = new Checking(158,20000);
		Acount s = new Saving(185,30000);
		
		System.out.println("Before DRAW");
		toString(a);
		toString(c);
		toString(s);
		
		System.out.println("\nAfter DRAW");
		a.withDraw(10001);
		toString(a);
		c.withDraw(25000);
		toString(c);
		s.withDraw(35000);
		toString(s);
	}
	
	public static void toString(Acount a){
		System.out.println(a.toString());
	}
}

class Checking extends Acount{
	private double checkingMoney = -5000;
	
	public Checking(){
	}
	
	public Checking(int id,double balance){
		super(id,balance);
	}

	public double getCheckingMoney() {
		return checkingMoney;
	}

	public void setCheckingMoney(double checkingMoney) {
		this.checkingMoney = checkingMoney;
	}
	
	@Override
	public void withDraw(double draw){
		if(backBalance() < draw){
			if((backBalance() - draw) <= this.checkingMoney)
				super.withDraw(backBalance() - checkingMoney);
		}
		
		else
			super.withDraw(draw);
	}

	@Override
	public String toString(){
		return "The id of " + backId() + " is a Checking acount," +
			"and the checkingmoney is " + getCheckingMoney() + " " +
			super.toString();
	}
}

class Saving extends Acount{
	public Saving(){
	}
	
	public Saving(int id,double balance){
		super(id,balance);
	}
	
	@Override
	public void withDraw(double draw){
		if(backBalance() > 0){
			if((backBalance() - draw) > 0)
				super.withDraw(draw);
			else{
				System.out.println("The rest balance of this id is not"
					+ " enough,so this choice will give you the rest" +
					" money you have.After that,this id will leave 0");
				super.withDraw(backBalance());
			}
		}
	}
	
	@Override
	public String toString(){
		return "The id of " + backId() + " is a Saving acount," +
			super.toString();
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
		annualInterestRate = 4.5;
	}

	public Acount(int newId,double newBalance){//�ض�id�����
		id = newId;
		balance = newBalance;
		annualInterestRate = 4.5;
	}
	
	public void changeId(int newId){			//����id
		id = newId;
	}
	
	public void changeRate(double newRate){	//��������
		annualInterestRate = newRate;
	}
	
	public int backId(){						//����id
		return id;
	}
	
	public double backBalance(){				//����balance
		return balance;
	}
	
	public double backAnnualInterestRate(){	//��������
		return annualInterestRate;
	}
	
	public Date backDate(){					//��������
		return dateCreated/*.toString()*/;
	}
	
	public void dateCreated(Date newDate){					//�޸�����
		dateCreated = newDate;
	}
	
	public double getMonthlyInterestRate(){	//����������
		return annualInterestRate / 12;
	}
	
	public double getMonthlyInterest(){		//��������Ϣ
		return balance * annualInterestRate / 12 / 100;
	}
	
	public void withDraw(double draw){			//ȡ��
		balance = balance - draw;
	}
	
	public void deposit(double incrase){		//���
		balance = balance + incrase;
	}
	
	public String toString(){
		return backId() + "'s balance is " + backBalance() + 
			" and the MonthlyInterest is " + getMonthlyInterest() +
			" and the created time is " + backDate();
	}
}