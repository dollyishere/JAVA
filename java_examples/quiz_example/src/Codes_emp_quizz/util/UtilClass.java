package com.freeflux.util;

import java.util.ArrayList;
import java.util.Scanner;

import com.freeflux.db.MySQLconnector;
import com.freeflux.dto.Employee;
import com.freeflux.view.PrintResult;

public class UtilClass {

	public UtilClass() {
	}

	public static void ee() {
		MySQLconnector mysql = new MySQLconnector();
		mysql.connectMySQL();
		
		Scanner scan = new Scanner(System.in);
		boolean status = true;
		ArrayList<Employee> empList = null;

		// *
		while (status) {

			int no = scan.nextInt();
			switch (no) {
			case 1:
				System.out.println();
				System.out.println("전체사원조회");
				empList = mysql.selectAll();
				PrintResult.printSelectAll(empList);

				PrintResult.printJobSelect();
				break;
			case 2:
				System.out.println();
				System.out.println("사원추가");
				mysql.insert();
				empList = mysql.selectAll();
				PrintResult.printSelectAll(empList);

				PrintResult.printJobSelect();
				break;
			case 3:
				System.out.println();
				System.out.println("전사원 급여10%올림");
				empList = UtilClass.payRaise(empList, 10);
				empList = mysql.update(empList);
				PrintResult.printSelectAll(empList);

				PrintResult.printJobSelect();
				break;
			case 4:
				System.out.println();
				System.out.println("과장 직책 사원 삭제");
				mysql.delete();
				empList = mysql.selectAll();
				PrintResult.printSelectAll(empList);
				
				PrintResult.printJobSelect();
				break;
			case 5:
				status = false;
				break;
			}
		}
		scan.close();
		System.out.println("작업이 종료 되었습니다..");
	}
	
	public static ArrayList<Employee> payRaise(ArrayList<Employee> empList, float n) {
		float raise = n /100;
		System.out.println(raise);
		
		for(Employee employee : empList) {
			float raise1 = employee.getSale() * raise;
			float raise2 = employee.getSale() + raise1;
			employee.setSale((int)raise2);
		}
		return empList;
	}
}
