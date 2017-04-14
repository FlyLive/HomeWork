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
		System.out.println("ȡ��2500,the balance is " + cjy.backBalance());
		cjy.deposit(3000);
		System.out.println("���3000,the balance is " + cjy.backBalance());
		
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
	
	public Acount(){					//��ʼ���˻�
		id = 0;
		balance = 0;
		annualInterestRate = 0;
	}

	public Acount(int newId,double newBalance){//�ض�id�����
		id = newId;
		balance = newBalance;
	}
	
	void changeId(int newId){			//����id
		id = newId;
	}
	
	void changeRate(double newRate){	//��������
		annualInterestRate = newRate;
	}
	
	int backId(){						//����id
		return id;
	}
	
	double backBalance(){				//����balance
		return balance;
	}
	
	double backAnnualInterestRate(){	//��������
		return annualInterestRate;
	}
	
	Date backDate(){					//��������
		return dateCreated/*.toString()*/;
	}
	
	void dateCreated(Date newDate){					//�޸�����
		dateCreated = newDate;
	}
	
	double getMonthlyInterestRate(){	//����������
		return annualInterestRate / 12;
	}
	
	double getMonthlyInterest(){		//��������Ϣ
		return balance * annualInterestRate / 12 / 100;
	}
	
	void withDraw(double draw){			//ȡ��
		balance = balance - draw;
	}
	
	void deposit(double incrase){		//���
		balance = balance + incrase;
	}
}