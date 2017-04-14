package Chapter9;

import java.util.Date;

public class Exercise9_7 {
	public static void main(String[] args){
		Acount cjy = new Acount(1122,20000);
		cjy.changeRate(4.5);
		System.out.println(cjy.backId() + "'s balance is " +
			cjy.backBalance() + " and monthlyInterestRate is " +
			cjy.getMonthlyInterestRate() + "");
		
		cjy.withDraw(2500);
		System.out.println("取款2500,the balance is " + cjy.backBalance());
		cjy.deposit(3000);
		System.out.println("存款3000,the balance is " + cjy.backBalance());
		
		System.out.println(cjy.backId() + "'s balance is " +
			cjy.backBalance() +
			" and monthlyInterest is " + cjy.getMonthlyInterest()
			+ " and the date is " + cjy.backDate());
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
	
	void changeId(int newId){			//更改id
		id = newId;
	}
	
	void changeRate(double newRate){	//更改利率
		annualInterestRate = newRate;
	}
	
	int backId(){						//返回id
		return id;
	}
	
	double backBalance(){				//返回balance
		return balance;
	}
	
	double backAnnualInterestRate(){	//返回利率
		return annualInterestRate;
	}
	
	Date backDate(){					//返回日期
		return dateCreated/*.toString()*/;
	}
	
	void dateCreated(Date newDate){					//修改日期
		dateCreated = newDate;
	}
	
	double getMonthlyInterestRate(){	//返回月利率
		return annualInterestRate / 12;
	}
	
	double getMonthlyInterest(){		//返回月利息
		return balance * annualInterestRate / 12 / 100;
	}
	
	void withDraw(double draw){			//取款
		balance = balance - draw;
	}
	
	void deposit(double incrase){		//存款
		balance = balance + incrase;
	}
}