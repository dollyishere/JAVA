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

//필요한 메서드 저장
public class UtilClass {

	// 생성자
	public UtilClass() {

	}
	
	// 줄 단위 데이터를 객체화 후 저장
	/** FileReader와 BufferedReader를 이용하여 txt 파일을 읽어들이는 메서드 **/
	public static void readInsertData() {
		// 1. 파일 경로 : uri 
		final String fname = "datas/cafe.txt";
		String line; // 한 줄을 저장
		
		DaoClass dao = new DaoClass();
		
		try {
			// FileInputStream => fname 필요, 글자 단위로 읽어냄
			FileInputStream fis = new FileInputStream(fname);
			
			// InputStreamReader => FileInputStream 객체 필요
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			
			// BufferedReader => InputStreamReader 객체 필요, readLine(); 메서드 이용 가능함
			BufferedReader br = new BufferedReader(isr);
			
			
			while((line = br.readLine()) != null) {
				String[] temp = line.split("\", ");
				// System.out.println(temp[1].substring(1).substring(0, 11));
				// 하나의 객체로 저장
				CafeMenu menu = new CafeMenu(temp[0].substring(1), temp[1].substring(1), temp[2].substring(1), temp[3].substring(1), Integer.parseInt(temp[4]));

				// 전체 데이터 저장소에 추가
				// 여기서 insert 실행
				dao.insert(menu);
			}
			
			// 최근에 사용한 거부터 먼저 close
			br.close();
			isr.close();
			fis.close();
		
			// db 데이터 저장
			dao.selectAll();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	} // readInsertData() END
	
	// html 태그 생성한 뒤 printClass로 보내주는 메서드
	public static void makeHTMLFile(LinkedList<String> onlyValues) {
		final String saveUri = "datas/cafe_list.html";
		
		String tags = makeHTMLTags(onlyValues, DataClass.orderList);
		
		PrintClass.createHTML(saveUri, tags);
	}

//	/** String을 이용하여 HTML 태그들을 생성하는 메서드 **/
	public static String makeHTMLTags(LinkedList<String> onlyValues, LinkedList<CafeMenu> orderList) {
		String tags = "<!doctype html>";
		tags = tags + "<html>";
		tags = tags + "<head>";
		tags = tags + "<meta charset=\"utf-\">";
		tags = tags + "<title>일일 판매 목록 및 일일 평균 판매액</title>";
		tags = tags + "</head>";
		tags = tags + "<body>";
		for (int i = 0; i < onlyValues.size(); i++) {
			tags = tags + "<h1>" + onlyValues.get(i) + "</h1>";
			for (int j = 0; j < orderList.size(); j ++) {
				// 해당 날짜일 때만 태그 추가
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
	
	// 판매 날짜에 따른 일일 평균 매출액 및 html 파일 생성
	public static void showDayData() {
		LinkedList<String> changedList = changeList("d", DataClass.orderList);
		LinkedList<String> onlyValues = outDoubleValue(changedList);
		
		PrintClass.printAvgDay(onlyValues, DataClass.orderList);
		makeHTMLFile(onlyValues);
		
	} // findMaxDate END
	
	// 최다 판매 상품
	public static String findMaxItem() {
		DaoClass dao = new DaoClass();
		String pro;
		LinkedList<String> changedList = changeList("i", DataClass.orderList);
		LinkedList<String> onlyValues = outDoubleValue(changedList);
		String v = findMaxValue(changedList, onlyValues);
		dao.findCaseSum("i", v);
		pro = v  + " ==> " + dao.findCaseSum("i", v) + "원";
		
		return pro;
	} // findMaxItem END
		
	// 최다 판매 시간대
	public static String findMaxTime() {
		DaoClass dao = new DaoClass();
		String time;
		LinkedList<String> changedList = changeList("t", DataClass.orderList);
		LinkedList<String> onlyValues = outDoubleValue(changedList);
		String v = findMaxValue(changedList, onlyValues);
		time = v  + "시 구간 ==> " + dao.findCaseSum("t", v) + "원";
		
		return time;
		
	} // findMaxTime END
	
	// 최다 판매 카테고리
	public static String findMaxCategory() {
		DaoClass dao = new DaoClass();
		String cat = "";
		LinkedList<String> changedList = changeList("c", DataClass.orderList);
		LinkedList<String> onlyValues = outDoubleValue(changedList);
		String v = findMaxValue(changedList, onlyValues);
		cat = v  + " ==> " + dao.findCaseSum("c", v) + "원";
		
		return cat;
	} // findMaxCategory END

	// 어떤 요소 가지고 있는지 리스트로 뽑기
	public static LinkedList<String> changeList(String scase, LinkedList<CafeMenu> orderList) {
		LinkedList<String> changedList = new LinkedList<String>();
		
		for (int i=0;i<orderList.size();i++) {
			// 케이스에 따라 분류해서 처리
			switch(scase) {
			// item 리스트 구할 시
				case "i":
					changedList.add(orderList.get(i).getItem());
					break;
			// 날짜 구할 시
				case "d":
					changedList.add(orderList.get(i).getOrderDate().substring(0, 11));
					break;
			// 시간대 리스트 구할 시
				case "t":
					changedList.add(orderList.get(i).getOrderDate().substring(11, 13));
					break;
			// 카테고리 리스트 구할 시
			default:
					changedList.add(orderList.get(i).getCategory());
					break;
			}
		}
		
		return changedList;
	}	// changeList() END
	
	// 중복 제거된 리스트 만들기
	public static LinkedList<String> outDoubleValue(LinkedList<String> changedList) {
		// 중복 제거된 리스트
		LinkedList<String> onlyValues = new LinkedList<String>();
		
		// 2. 날짜 추출
		for (int i=0;i<changedList.size();i++) {
			// 만약 아직 onlyValues에 안 담겨 있는 값이면, 담아주기
			if (!onlyValues.contains(changedList.get(i))) {
				onlyValues.add(changedList.get(i));
			}
		}
		return onlyValues;
	} // outDoubleName END
	
	// 리스트 대조해서 최대값 리턴
	public static String findMaxValue(LinkedList<String> changedList, LinkedList<String> onlyValues) {
		// 최대값
		int maxN = 0;
		// 상품명
		String maxI = "";
		
		// onlyValues 순회
		for (int i=0;i<onlyValues.size();i++) {
			// 현재 상품 수 담아줄 nowN 생성
			int nowN = 0;
			for (int j=0;j<changedList.size();j++) {
				if (changedList.get(j).equals(onlyValues.get(i))) {
					nowN ++;
				}
			}
			// 만약 현재 상품 전체 수가 최대 값보다 크다면, 대체
			if (nowN > maxN) {
				maxN = nowN;
				maxI = onlyValues.get(i);
			}
		}
		
		return maxI;
	} // findMaxValue END
	
	
}