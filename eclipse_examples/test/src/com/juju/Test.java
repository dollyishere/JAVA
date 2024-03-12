package com.juju;

public class Test {

	public static void main(String[] args) {
		int[] arr = new int[4];
		int arr2[] = new int[4];
		int num = 0;
		
		for (int i = 0;i<arr.length;i++) {
			num += 10;
			arr[i] = num;
		}
		
		System.out.println(arr.length);
		
		// 비교(if)
		// 비교 연산자: >, <, >=, <=, ==, !=
		// 비교 연산의 결과를 판단 -> 논리 연산자: &&, ||, !
		// 그리고, ~이고 -> &&(AND) => true && true ===> true
		// 또는 -> ||(OR), false || false ===> false
		// true <=> false -> !
//		if(비교값 비교연산자 비교값) { 
//				(비교 연산의 결과가 true일 경우 실행할 코드) 
//			} else {
//				(비교 연산의 결과가 false일 경우 실행 내용)
//			}
		if(10 < 20 && arr[0] > arr[1]) {
			System.out.println("참");
		} else {
			System.out.println("거짓");
		}
		
		
		/*
		 * 연령이 34세 이상이면 월 지원금 100만원...
		 * age 34 >= if print
		 * */
		int age = 40;
		if (age >= 34) {
			System.out.println("월 지원금 100만원");
		}
		
		/*
		 * 월 소득이 300만원 이하이고, 가구 인원이 2인 이상이면 세금 공제 
		 * # 이렇게 명사가 들어있는 경우에는 변수 처리를 해야 함~
		 * income 300 <= && household 2 >= print */
		int income = 280;
		int household = 3;

		if (income <= 300 && household >= 2) {
			System.out.println("세금공제");
		} else {
			System.out.println("세금추징");
		}
		
		// 누적변수: 반드시 초기값을 설정
		// for문은 반복되는 코드를 줄이기 위해서임
		int sum = 0;
		sum = sum + arr[0]; // 10
		sum = sum + arr[1]; // 30
		sum = sum + arr[2]; // 60
		sum = sum + arr[3]; // 100
		
		// sum 변수에 arr 배열의 모든 값을 누적
		for(int i=0; i < arr.length ; i++) {
			sum += arr[i];
		}
		
		for(int n:arr) {
			sum += n;
		}
		
		System.out.println(sum);
		
		// arr 배열의 값 중, 40인 index 번호 출력
		for(int i=0; i < arr.length; i++) {
			System.out.println(arr[i]);
			if (arr[i] == 40) {
				System.out.println("index:" + i);
			}
		}
		
		// String
		String str;
		String str2 = "강";
		str = "강아지";
	}
}
