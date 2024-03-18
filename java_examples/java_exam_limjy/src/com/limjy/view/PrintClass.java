package com.limjy.view;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import com.limjy.dao.DaoClass;
import com.limjy.dto.CafeMenu;
import com.limjy.util.UtilClass;

public class PrintClass {

	public PrintClass() {
	
	}
	
	public static void startMenu() {
		Scanner sc = new Scanner(System.in);
		
		/* switch ~ case */
		// switch�� �� case�� ���� ���� �� Ʋ���� ��
		// case�� �� break�� �ɷ��� ��
		int key = 1;
		boolean status = true;
		DaoClass dao = new DaoClass();
		
		while(status) {
			System.out.println("============================================");
			System.out.println("�Ʒ� �޴��� ��ȣ�� �Է� ��, Enter�� ��������.");
			System.out.println("���� �Ǹ� ��� �� ���� ��� �Ǹž�(1)");
			System.out.println("�ִ� �Ǹ� ��ǰ�� �ش� ��ǰ�� �� �Ǹž�(2)");
			System.out.println("�ִ� �Ǹ� �ð��� �� �� �Ǹž�(3)");
			System.out.println("�ִ� �Ǹ� ī�װ� �� �� �Ǹž�(4)");
			System.out.println("����(5)");
			System.out.println("--------------------------------------");
			System.out.println("��ȣ �Է�>> ");
			key = Integer.parseInt(sc.next());
			
			switch(key) {
			case 1:
				UtilClass.showDayData();
				System.out.println("* info: ��¥ �� ī�� ����� �����Ǿ����ϴ�.");
				System.out.println();
				break;
			case 2:
				System.out.println("�ִ� �Ǹ� ��ǰ �� �Ǹž�: " + UtilClass.findMaxItem());
				System.out.println();
				break;
			case 3:
				System.out.println("�ִ� �Ǹ� �ð���: " + UtilClass.findMaxTime());
				System.out.println();
				break;
			case 4:
				System.out.println("�ִ� �Ǹ� ī�װ� �� �Ǹž�: " + UtilClass.findMaxCategory());
				System.out.println();
				break;
			default:
				status = false;
				System.out.println("�� " + dao.countData() + "�� ���ڵ尡 �����Ǿ����ϴ�.");
				dao.deleteAll();
				break;
			} // switch (key) END
		} // while(status) END
		
		sc.close();
		System.out.println("���α׷��� ����Ǿ����ϴ�.");
	} // startMenu() END
	
	// ���� ��� �Ǹž� ��� �޼���
	public static void printAvgDay(LinkedList<String> onlyValues, LinkedList<CafeMenu> orderList) {
		DaoClass dao = new DaoClass();
		
		for (int i = 0; i < onlyValues.size(); i++) {
			System.out.println("* * *");
			System.out.println("#" + onlyValues.get(i) + "�� ����");
			for (int j = 0; j < orderList.size(); j ++) {
				// �ش� ��¥�� ���� �±� �߰�
				if (onlyValues.get(i).equals(orderList.get(j).getOrderDate().substring(0, 11))) {
					System.out.println("-" 
							+ orderList.get(j).getOrderId() + " "
							+ orderList.get(j).getOrderDate() + " "
							+ orderList.get(j).getCategory() + " "
							+ orderList.get(j).getItem() + " "
							+ orderList.get(i).getPrice() + "��");
				}
			}
			System.out.println("============================================");
			System.out.println("$ " + onlyValues.get(i)  + "���� ��� �Ǹž� ==> " + dao.findCaseAvg(onlyValues.get(i)) + "��");
			System.out.println("");
		}
		
		
	}
	
	/** �ܺηκ��� ���޵� ���ڿ��� �̿��Ͽ� html ������ �����ϴ� �޼��� **/
	public static void createHTML(String  uri, String tags) {
		FileWriter fw=null;	// ����.html ���ο� HTML �±׸� ���� ���� ��ü ����  
		try {
			fw = new FileWriter(uri); 	// ���� ���� ��ü ����
			fw.write(tags); 				// tag �� ���Ͽ� ����
			fw.close();	// �������� ��, close()
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	} // makeHTML() END
	

}
