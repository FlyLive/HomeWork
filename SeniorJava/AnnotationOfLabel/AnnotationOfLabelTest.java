package AnnotationOfLabel;

import java.util.Scanner;

public class AnnotationOfLabelTest {
	private static final PersonDisplay personDisplay = new PersonDisplay();
	private static final PersonInput personInput = new PersonInput();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Person person = null;
		
		do{
			System.out.println("�������ʾ����(1~3)����:");
			System.out.println("1��������Ա��Ϣ��\n2����ѯ\n3���˳�");
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
					System.out.println("��������������");
					break;
				}
			} catch (Exception e) {
				System.out.println("����������ֹͣ");
				scanner.close();
				System.exit(0);
			}
		}while(true);
	}
}
