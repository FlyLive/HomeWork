package AnnotationOfAll;import java.util.*;public class Test {	private static final Class<?> clazz = new Person().getClass();	public static void main(String[] args) {		ObjectEdit objEdit = new ObjectEdit();		Scanner input = new Scanner(System.in);		int choice = 0;		while (true) {			System.out.println("请输入命令:\n1、显示所有该对象的信息\n2、新增\n3、删除\n4、修改\n5、查找\n6、退出");			choice = input.nextInt();			switch (choice) {				case 1:					objEdit.showAll(clazz);					break;				case 2:					objEdit.create(clazz);					break;				case 3:					objEdit.delete(clazz);					break;				case 4:					objEdit.update(clazz);					break;				case 5:					objEdit.select(clazz);					break;				case 6:					input.close();					System.exit(0);					break;				default:					System.out.println("输入有误，请重试");					break;			}		}	}}