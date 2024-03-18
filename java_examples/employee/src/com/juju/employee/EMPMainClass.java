package com.juju.employee;

public class EMPMainClass {

	public static void main(String[] args) {
		// EMPDataClass 생성
		EMPDataClass emp = new EMPDataClass();
		
		// 성이 "이"씨인 사람들 인원 수?
		/*
		 * 1. emp 객체가 필요
		 * 2. emp 객체가 가진 name 배열
		 * 3. name 배열의 데이터 중 "이"로 시작하는 데이터 찾기 
		 * 		String 객체의 메서드를 이용하여 검색
		 * 4. 인원수 담을 변수 => int startSum = 0;
		 * 5. for로 name 배열 순회 => for()
		 * 6. 만약 name 내에 "이"로 시작하는 객체가 있다면, 카운팅 => if()
		 *  */
		
		String startStr = "이";
		int count = 0;
		for (int k=0; k < emp.name.length; k++) {
			if(emp.name[k].startsWith(startStr)) {
				count ++;
			}
		}
		
		System.out.println("'" + startStr + "'" + "씨 성을 가진 인원 수: " + count);
		
		// 직업이 Java이고 근무지가 국내인 사원의 평균 급여 구하기
		/*
		 * 1. emp 객체의 job, code(둘 다 조건), pay(도출할 값 용도) 배열 => for()
		 * 2. job 배열에서 Java를 직업으로 가진 사원의 인덱스 찾기 ==> if()
		 * 3. code에 해당하는 인덱스를 대조해서 해당 사원이 국내("KR")에서 일하는지 검증 ==> &&, equals
		 * 4. 기왕이면 대조할 직업이랑 지역 변수화 ==> String countJob, String countCode
		 * 5. java 직업으로 가진 사원 수 카운팅 => int countJ = 0; ==> 값 초기화
		 * 6. java 직업으로 가진 사원의 급여 카운팅 => int payJ = 0; ==> 값 초기화
		 * 7. 평균 급여 구하기 ==> double payA; ==> 그냥 바로 값 배정해주거나 미리 해주거나~
		 * 8. 값 출력
		 * */
		
		int countJ = 0;
		int payJ = 0;
		double payA;
		
		String countJob = "java";
		String countCode = "JP";
		
		for (int n=0;n<emp.job.length;n++) {
			if (emp.job[n].equals(countJob) && emp.code[n].equals(countCode)) {
				countJ ++;
				payJ += emp.pay[n];
			}
		}
		
		payA = (float) payJ / countJ;
		
		System.out.println(countJob + " 직업이고 " + countCode + "에 근무하는 사원의 평균 급여: " + payA);
	}
	

	
}
