package AnnotationOfLabel;

import java.util.Scanner;

public class AnnotationOfLabelTest {
	private static final PersonDisplay personDisplay = new PersonDisplay();
	private static final PersonInput personInput = new PersonInput();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Person person = null;
		
		do{
			System.out.println("请根据提示输入(1~3)整数:");
			System.out.println("1、输入人员信息。\n2、查询\n3、退出");
			try {
				int num = scanner.nextInt();
				switch (num) {
				case 1:
					person = personInput.process(new Person());
					break;
				case 2:
					personDisplay.process(person);
					break;
				case 3:
					scanner.close();
					System.exit(0);
					break;
				default:
					System.out.println("输入有误，请重试");
					break;
				}
			} catch (Exception e) {
				System.out.println("输入有误，已停止");
				scanner.close();
				System.exit(0);
			}
		}while(true);
	}
}
