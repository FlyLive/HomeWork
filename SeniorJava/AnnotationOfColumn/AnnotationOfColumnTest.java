package AnnotationOfColumn;

import java.util.*;

import AnnotationOfLabel.Person;
import AnnotationOfLabel.PersonDisplay;
import AnnotationOfLabel.PersonInput;

public class AnnotationOfColumnTest {
	private static final List<Person> persons = new ArrayList<Person>();
	private static final PersonInputOfColumn personInputOfColumn = new PersonInputOfColumn();
	private static final PersonDisplayOfColumn personDisplayOfColumn = new PersonDisplayOfColumn();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("请根据提示输入(1~3)整数:");
			System.out.println("1、添加人员信息\n2、删除\n3、修改人员信息\n4、查询\n5、退出");
			try {
				int num = scanner.nextInt();
				switch (num) {
				case 1:
					add();
					break;
				case 2:
					delet();
					break;
				case 3:
					modify();
					break;
				case 4:
					check();
					break;
				case 5:
					System.exit(0);
					scanner.close();
					break;
				default:
					System.out.println("输入有误，请重试");
					break;
				}
			} catch (Exception e) {
				System.out.println("输入有误，已停止" + e);
				scanner.close();
				System.exit(0);
			}
		} while (true);
	}

	public static void add() {
		Person person = new Person();
		person = personInputOfColumn.process(person);
		persons.add(person);

		System.out.println("添加成功");
	}

	public static void delet() {
		if (!isEmpty()) {
			persons.remove(persons.size() - 1);
			System.out.println("删除成功");
		}
	}

	public static void modify() {
		if (!isEmpty()) {
			Scanner scanner = new Scanner(System.in);
			do {
				System.out.println("请输入要修改的人员的下标(1~" + persons.size() + "):");

				int index = 0;
				try {
					if (scanner.hasNext()) {
						index = scanner.nextInt();
						Person person = persons.get(index - 1);
						person = personInputOfColumn.process(person);
					}
					break;
				} catch (Exception e) {
					System.out.println("输入有误，请重试");
				}
			} while (true);
		}
	}

	public static void check() {
		if (!isEmpty()) {
			System.out.println("\n");
			for (Person person : persons) {
				personDisplayOfColumn.process(person);
				System.out.println("\n");
			}
			System.out.println("遍历完毕\n");
		}
	}

	public static Boolean isEmpty() {
		if (persons.size() == 0) {
			System.out.println("尚无录入人员信息,请添加");
			return true;
		}
		return false;
	}
}
