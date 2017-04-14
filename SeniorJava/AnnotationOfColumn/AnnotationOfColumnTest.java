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
			System.out.println("�������ʾ����(1~3)����:");
			System.out.println("1�������Ա��Ϣ\n2��ɾ��\n3���޸���Ա��Ϣ\n4����ѯ\n5���˳�");
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
					System.out.println("��������������");
					break;
				}
			} catch (Exception e) {
				System.out.println("����������ֹͣ" + e);
				scanner.close();
				System.exit(0);
			}
		} while (true);
	}

	public static void add() {
		Person person = new Person();
		person = personInputOfColumn.process(person);
		persons.add(person);

		System.out.println("��ӳɹ�");
	}

	public static void delet() {
		if (!isEmpty()) {
			persons.remove(persons.size() - 1);
			System.out.println("ɾ���ɹ�");
		}
	}

	public static void modify() {
		if (!isEmpty()) {
			Scanner scanner = new Scanner(System.in);
			do {
				System.out.println("������Ҫ�޸ĵ���Ա���±�(1~" + persons.size() + "):");

				int index = 0;
				try {
					if (scanner.hasNext()) {
						index = scanner.nextInt();
						Person person = persons.get(index - 1);
						person = personInputOfColumn.process(person);
					}
					break;
				} catch (Exception e) {
					System.out.println("��������������");
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
			System.out.println("�������\n");
		}
	}

	public static Boolean isEmpty() {
		if (persons.size() == 0) {
			System.out.println("����¼����Ա��Ϣ,�����");
			return true;
		}
		return false;
	}
}
