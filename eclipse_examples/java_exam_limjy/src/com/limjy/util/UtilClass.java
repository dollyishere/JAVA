package com.limjy.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

import com.limjy.dao.DaoClass;
import com.limjy.db.DataClass;
import com.limjy.dto.CafeMenu;
import com.limjy.view.PrintClass;

//�ʿ��� �޼��� ����
public class UtilClass {

	// ������
	public UtilClass() {

	}
	
	// �� ���� �����͸� ��üȭ �� ����
	/** FileReader�� BufferedReader�� �̿��Ͽ� txt ������ �о���̴� �޼��� **/
	public static void readInsertData() {
		// 1. ���� ��� : uri 
		final String fname = "datas/cafe.txt";
		String line; // �� ���� ����
		
		DaoClass dao = new DaoClass();
		
		try {
			// FileInputStream => fname �ʿ�, ���� ������ �о
			FileInputStream fis = new FileInputStream(fname);
			
			// InputStreamReader => FileInputStream ��ü �ʿ�
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			
			// BufferedReader => InputStreamReader ��ü �ʿ�, readLine(); �޼��� �̿� ������
			BufferedReader br = new BufferedReader(isr);
			
			
			while((line = br.readLine()) != null) {
				String[] temp = line.split("\", ");
				// System.out.println(temp[1].substring(1).substring(0, 11));
				// �ϳ��� ��ü�� ����
				CafeMenu menu = new CafeMenu(temp[0].substring(1), temp[1].substring(1), temp[2].substring(1), temp[3].substring(1), Integer.parseInt(temp[4]));

				// ��ü ������ ����ҿ� �߰�
				// ���⼭ insert ����
				dao.insert(menu);
			}
			
			// �ֱٿ� ����� �ź��� ���� close
			br.close();
			isr.close();
			fis.close();
		
			// db ������ ����
			dao.selectAll();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	} // readInsertData() END
	
	// html �±� ������ �� printClass�� �����ִ� �޼���
	public static void makeHTMLFile(LinkedList<String> onlyValues) {
		final String saveUri = "datas/cafe_list.html";
		
		String tags = makeHTMLTags(onlyValues, DataClass.orderList);
		
		PrintClass.createHTML(saveUri, tags);
	}

//	/** String�� �̿��Ͽ� HTML �±׵��� �����ϴ� �޼��� **/
	public static String makeHTMLTags(LinkedList<String> onlyValues, LinkedList<CafeMenu> orderList) {
		String tags = "<!doctype html>";
		tags = tags + "<html>";
		tags = tags + "<head>";
		tags = tags + "<meta charset=\"utf-\">";
		tags = tags + "<title>���� �Ǹ� ��� �� ���� ��� �Ǹž�</title>";
		tags = tags + "</head>";
		tags = tags + "<body>";
		for (int i = 0; i < onlyValues.size(); i++) {
			tags = tags + "<h1>" + onlyValues.get(i) + "</h1>";
			for (int j = 0; j < orderList.size(); j ++) {
				// �ش� ��¥�� ���� �±� �߰�
				if (onlyValues.get(i).equals(orderList.get(j).getOrderDate().substring(0, 11))) {
					tags = tags + "<p> " 
							+ orderList.get(j).getOrderId() + " "
							+ orderList.get(j).getOrderDate() + " "
							+ orderList.get(j).getCategory() + " "
							+ orderList.get(j).getItem() + " "
							+ orderList.get(i).getPrice() + " "
							+ "</p>";
				}
			}
		}
		tags = tags + "</body>";
		tags = tags + "</html>";
		
		return tags;
	}
	
	// �Ǹ� ��¥�� ���� ���� ��� ����� �� html ���� ����
	public static void showDayData() {
		LinkedList<String> changedList = changeList("d", DataClass.orderList);
		LinkedList<String> onlyValues = outDoubleValue(changedList);
		
		PrintClass.printAvgDay(onlyValues, DataClass.orderList);
		makeHTMLFile(onlyValues);
		
	} // findMaxDate END
	
	// �ִ� �Ǹ� ��ǰ
	public static String findMaxItem() {
		DaoClass dao = new DaoClass();
		String pro;
		LinkedList<String> changedList = changeList("i", DataClass.orderList);
		LinkedList<String> onlyValues = outDoubleValue(changedList);
		String v = findMaxValue(changedList, onlyValues);
		dao.findCaseSum("i", v);
		pro = v  + " ==> " + dao.findCaseSum("i", v) + "��";
		
		return pro;
	} // findMaxItem END
		
	// �ִ� �Ǹ� �ð���
	public static String findMaxTime() {
		DaoClass dao = new DaoClass();
		String time;
		LinkedList<String> changedList = changeList("t", DataClass.orderList);
		LinkedList<String> onlyValues = outDoubleValue(changedList);
		String v = findMaxValue(changedList, onlyValues);
		time = v  + "�� ���� ==> " + dao.findCaseSum("t", v) + "��";
		
		return time;
		
	} // findMaxTime END
	
	// �ִ� �Ǹ� ī�װ�
	public static String findMaxCategory() {
		DaoClass dao = new DaoClass();
		String cat = "";
		LinkedList<String> changedList = changeList("c", DataClass.orderList);
		LinkedList<String> onlyValues = outDoubleValue(changedList);
		String v = findMaxValue(changedList, onlyValues);
		cat = v  + " ==> " + dao.findCaseSum("c", v) + "��";
		
		return cat;
	} // findMaxCategory END

	// � ��� ������ �ִ��� ����Ʈ�� �̱�
	public static LinkedList<String> changeList(String scase, LinkedList<CafeMenu> orderList) {
		LinkedList<String> changedList = new LinkedList<String>();
		
		for (int i=0;i<orderList.size();i++) {
			// ���̽��� ���� �з��ؼ� ó��
			switch(scase) {
			// item ����Ʈ ���� ��
				case "i":
					changedList.add(orderList.get(i).getItem());
					break;
			// ��¥ ���� ��
				case "d":
					changedList.add(orderList.get(i).getOrderDate().substring(0, 11));
					break;
			// �ð��� ����Ʈ ���� ��
				case "t":
					changedList.add(orderList.get(i).getOrderDate().substring(11, 13));
					break;
			// ī�װ� ����Ʈ ���� ��
			default:
					changedList.add(orderList.get(i).getCategory());
					break;
			}
		}
		
		return changedList;
	}	// changeList() END
	
	// �ߺ� ���ŵ� ����Ʈ �����
	public static LinkedList<String> outDoubleValue(LinkedList<String> changedList) {
		// �ߺ� ���ŵ� ����Ʈ
		LinkedList<String> onlyValues = new LinkedList<String>();
		
		// 2. ��¥ ����
		for (int i=0;i<changedList.size();i++) {
			// ���� ���� onlyValues�� �� ��� �ִ� ���̸�, ����ֱ�
			if (!onlyValues.contains(changedList.get(i))) {
				onlyValues.add(changedList.get(i));
			}
		}
		return onlyValues;
	} // outDoubleName END
	
	// ����Ʈ �����ؼ� �ִ밪 ����
	public static String findMaxValue(LinkedList<String> changedList, LinkedList<String> onlyValues) {
		// �ִ밪
		int maxN = 0;
		// ��ǰ��
		String maxI = "";
		
		// onlyValues ��ȸ
		for (int i=0;i<onlyValues.size();i++) {
			// ���� ��ǰ �� ����� nowN ����
			int nowN = 0;
			for (int j=0;j<changedList.size();j++) {
				if (changedList.get(j).equals(onlyValues.get(i))) {
					nowN ++;
				}
			}
			// ���� ���� ��ǰ ��ü ���� �ִ� ������ ũ�ٸ�, ��ü
			if (nowN > maxN) {
				maxN = nowN;
				maxI = onlyValues.get(i);
			}
		}
		
		return maxI;
	} // findMaxValue END
	
	
}