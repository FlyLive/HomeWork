package Chapter9;

public class Exercise9_2 {
	public static void main(String[] args){
		Stock Stock = new Stock();
		Stock.symbol = "ORCL";
		Stock.name = "Oracle Corporation";
		Stock.previousClosingPrice = 34.5;
		Stock.currentPrice = 34.35;
		System.out.println("After one day,the previous of " +
			Stock.previousClosingPrice + " and current " +
			Stock.currentPrice + "'s change is " +
			Stock.getChangePercent());
	}
}
class Stock{
	String symbol;
	String name;
	double previousClosingPrice;
	double currentPrice;
	
	Stock(){
		symbol = "symbol";
		name = "name";
	}
	
	double getChangePercent(){
		return (previousClosingPrice - currentPrice) / previousClosingPrice;
	}
}
