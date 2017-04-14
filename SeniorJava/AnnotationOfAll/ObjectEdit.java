package AnnotationOfAll;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.Scanner;

public class ObjectEdit {
	private static final DatabaseDAO db = new DatabaseDAO();
	private static final ObjectInput objectInput = new ObjectInput();
	private static final ObjectDisplay objectDisplay = new ObjectDisplay();

	// ��ʾ��������Ϣ
	public void showAll(Class<?> clazz) {
		String className = clazz.getSimpleName();
		String sql = "select * from " + className;
		ResultSet rs = null;
		rs = db.executeSelectSQL(sql);
		if (rs != null) {
			objectDisplay.displayInfo(rs, clazz);
		} else {
			System.out.println("������Ϣ�������!");
		}
	}

	// ����
	public void create(Class<?> clazz) {
		// �����ʼ��
		Object obj = objectInput.createObject(clazz);

		Object[] fieldValues = objectDisplay.getFields(obj, clazz);

		// ƴ��ΪSQL����
		String sql = CreateObjectSQLString(clazz, fieldValues);

		// д�����ݿ�
		int count = db.executeUpdateSQL(sql, fieldValues);
		if (count > 0) {
			System.out.println("��ӳɹ���");
		} else {
			System.out.println("���ʧ�ܣ�");
		}
	}

	// ƴ����Ӷ���SQL���
	public String CreateObjectSQLString(Class<?> clazz, Object[] fieldValues) {
		String className = clazz.getSimpleName();
		String sql = "insert into " + className + " values(";

		for (int i = 0; i < clazz.getDeclaredFields().length; i++) {
			sql += "?,";
		}

		sql = sql.substring(0, sql.length() - 1);
		sql = sql + ");";

		return sql;
	}

	// ɾ��
	public void delete(Class<?> clazz) {
		String className = clazz.getSimpleName();
		Scanner input = new Scanner(System.in);

		System.out.println("��������Ҷ���ĺ��룺");
		int no = (int) objectInput.getCheckedInput("Integer");

		String sql = "delete from " + className + " where idNo=?";
		int count = db.executeUpdateSQL(sql, no);

		if (count > 0) {
			System.out.println("�ɹ�ɾ������Ϊ " + no + " �Ķ���");
		} else {
			System.out.println("δ�ҵ�IdΪ: " + no + " �Ķ���");
		}
	}

	// �޸�
	public void update(Class<?> clazz) {
		String className = clazz.getSimpleName();
		// �޸�ֵ�б�

		System.out.println("�������޸Ķ����ID:");
		int idNo = (int) objectInput.getCheckedInput("Integer");

		Object obj = objectInput.modifyObject(clazz);

		String sqlCenter = "";
		Object[] fields = objectDisplay.getFields(obj, clazz);

		// ƴ�Ӹ��²���SQL���
		int index = 0;
		for (Field field : clazz.getDeclaredFields()) {
			sqlCenter += field.getName() + "=?,";
			if (field.getName().equals("idNo")) {
				fields[index] = idNo;
			}
			index++;
		}

		sqlCenter = sqlCenter.substring(0, sqlCenter.length() - 1);

		String sql = "update " + className + " set " + sqlCenter
				+ " where idNo=" + idNo;

		// �����ݿ���в���
		int count = db.executeUpdateSQL(sql, fields);
		if (count > 0) {
			System.out.println("�ɹ��޸�IDΪ: " + idNo + " �Ķ���");
		} else {
			System.out.println("�޸�ʧ��!");
		}
	}

	// ����
	public void select(Class<?> clazz) {
		String className = clazz.getSimpleName();
		Scanner input = new Scanner(System.in);
		ResultSet rs = null;
		String sql = "select * from " + className + " where idNo=?";

		System.out.println("��������Ҷ���ĺ��룺");
		int idNo = (int) objectInput.getCheckedInput("Integer");

		rs = db.executeSelectSQL(sql, idNo);

		if (rs != null) {
			objectDisplay.displayInfo(rs, clazz);
		}
	}

}
