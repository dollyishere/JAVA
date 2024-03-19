package com.limjy.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import com.limjy.dao.DaoClass;
import com.limjy.dto.CafeOrder;
import com.limjy.view.PrintClass;

// 필요한 메서드들 보관 및 사용 용이하도록 하는 클래스
public class UtilClass {

	public UtilClass() {
			
	}
	
	// database에 값 저장
	public static void readInsertData() {
		// 소스 파일 경로 설정
		final String fname = "datas/cafe.txt";
		String line; // 매 라인 저장
		
		DaoClass dao = new DaoClass();
		
		try {
			FileInputStream fis = new FileInputStream(fname);
			
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			
			BufferedReader br = new BufferedReader(isr);
			
			while((line = br.readLine()) != null) {
				String[] temp = line.split("\", ");
				CafeOrder menu = new CafeOrder(temp[0].substring(1), temp[1].substring(1), temp[2].substring(1), temp[3].substring(1), Integer.parseInt(temp[4]));

				// 데이터 db에 넣기
				dao.insert(menu);
			}
			
			// 최근에 사용한 순서대로 close
			br.close();
			isr.close();
			fis.close();
		
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	} // readInsertData() END
	
	// 데이터 업데이트
	public static void updateData() {
		DaoClass dao = new DaoClass();
		dao.updateItemData("비엔나커피", "시그니처 커피");
	} // updateData() END
	
	// 데이터 삭제
	public static void deleteData() {
		DaoClass dao = new DaoClass();
		PrintClass.printEnd(dao.countData());
		dao.deleteAll();
	}
}
