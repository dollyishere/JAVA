package com.dolly;

import java.util.Scanner;

import com.dolly.db.DataBaseClass;

/*
 * Controller
 * Dispacher class
 * */
public class MainClass {

	public static void main(String[] args) {
		DataBaseClass dbc = new DataBaseClass();
		dbc.connMySQL(); // ����̹� �ε� �� ����
		/* �����ͺ��̽� C(create) R(read) U(update) D(delete ����) */
//		dbc.selectAll(); // ��ü ���ڵ� ��ȸ
//		dbc.selectOne(); // �ϳ��� ���ڵ� ��ȸ
//		dbc.selectLimit(300); // ��ü ���ڵ� �� �Ϻ� ���ڵ�鸸 ��ȸ
//		dbc.insert(); // ���ڵ� �߰�
//		dbc.update(); // ���ڵ� ����
//		dbc.delete(); // ���ڵ� ����
		
		Scanner sc = new Scanner(System.in);
		
		/* switch ~ case */
		// switch�� �� case�� ���� ���� �� Ʋ���� ��
		// case�� �� break�� �ɷ��� ��
		int key = 1;
		boolean status = true;
		
		
		while(status) {
			System.out.println("�Ʒ� �޴����� �۾��� ��ȣ�� �Է��� �ּ���...");
			System.out.println("1. ��ü��ȸ / 2. ���ڵ� ���� / 3. ���ڵ� ���� / 4. ���ڵ� ���� / 5. �۾� ����");
			System.out.println("------------------------------------------------------------------------------");
			
			key = sc.nextInt();
			
			switch(key) {
			case 1:
				System.out.println("��ü��ȸ ȭ��.");
				dbc.selectAll();
				break;
			case 2:
				System.out.println("���ڵ� ����.");
				dbc.insert();
				break;
			case 3:
				System.out.println("���ڵ� ����.");
				dbc.update();
				break;
			case 4:
				System.out.println("���ڵ� ����.");
				dbc.delete();
				break;
			default:
				status = false;
				break;
			} // switch (key) END
		} // while(status) END
		
		sc.close();
		System.out.println("����Ǿ����ϴ�.");
		
//		// 1. ����̹� �ε�
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("����̹� �ε� ����");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
//	
//	
//		// 2. Connection ��ü ��ȯ �ޱ� => java.sql.Connection
//		Connection conn = null;
//		
//		try {
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
//			// Access denied for user 'root'@'localhost' (using password: YES)
//			System.out.println("DB ���� ����");
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		
//		// 3. SQL ���� ��ü
//		Statement stmt = null; // java.sql.Statement
//		try {
//			stmt = conn.createStatement(); // Statement ��ü�� ���� ��, �������� ������� �ʴ´�
//			System.out.println("Statement ��ü ���� �Ϸ�");
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		// 4. ������ Statement ��ü�� ���� ����
//		String query = "select * from tbl";
//		ResultSet rs = null;
//		try {
//			rs = stmt.executeQuery(query); // select ~ from ~ ����
//			System.out.println("��ȸ ����");
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		// 5. ��ȸ�� ���(ResultSet ��ü)�� ���ڵ尪 Ȯ��
//		try {
//			while(rs.next()) {
//				System.out.println(rs.getString("id") + " : " + rs.getString("name"));
//				System.out.println(rs.getString(1) + " : " + rs.getString(2));
//			}
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		// 6. ����� �Ϸ�� DB �ڿ� ����
//		try {
//			rs.close();
//			stmt.close();
//			conn.close();
//			System.out.println("�ڿ����� ����");
//		} catch(SQLException e) {
//			System.out.println(e.getMessage());
//		}
		
	}
} // main() END
