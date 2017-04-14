import java.util.Scanner;


public class WaterCharge {
    private int tons;
    private boolean isBusiness;

    public WaterCharge(boolean isBusiness, int tons) {
        this.isBusiness = isBusiness;
        this.tons = tons;
    }

    public boolean isBusiness() {
        return isBusiness;
    }

    public double WaterFee() {
        double fee = 0;
        if (!isBusiness) {
            if (tons <= 10) {
                fee = tons * 2.5;
            } else {
                fee = 10 * 2.5 + (tons - 10) * 3.0;
            }
        } else {
            if (tons <= 20) {
                fee = tons * 3.9;
            } else {
                fee = 20 * 2.5 + (tons - 10) * 4.8;
            }
        }
        return fee;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please Enter a number of Domestic Water's ton:");
        int domesticTons = input.nextInt();
        WaterCharge domestic = new WaterCharge(false, domesticTons);

        System.out.println("Please Enter a number of Commercail water's ton:");
        int commercailTons = input.nextInt();
        WaterCharge commercail = new WaterCharge(true, commercailTons);

        printMoney(domestic);
        printMoney(commercail);
    }

    public static void printMoney(WaterCharge wc) {
        if (wc.isBusiness()) {
            System.out.println("The Fee of this Commercail Water is "
                    + wc.WaterFee());
        } else {
            System.out.println("The Fee of this Domestic Water is "
                    + wc.WaterFee());
        }
    }
}
