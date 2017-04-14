package Chapter1;

public class Exercise1_4 {
	public static void main(String[] srgs){
		System.out.println("a    a^2    a^3");
		System.out.println(1 + "    " + 1 * 1 + "    " + 1 * 1 * 1);
		System.out.println(2 + "    " + 2 * 2 + "    " + 2 * 2 * 2);
		System.out.println(3 + "    " + 3 * 3 + "    " + 3 * 3 * 3);
		System.out.println(4 + "    " + 4 * 4 + "    " + 4 * 4 * 4);
		System.out.println("\n\n");
		Repeat();
	}
	public static void Repeat(){
		int a;
		System.out.println("a    a^2    a^3");
		for(a = 1;a <= 4;a ++)
		{
			System.out.println(a + "    " + a * a + "    " + Math.pow(a, 3));
		}
	}
}
