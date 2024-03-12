package split_test;

public class MemberClass {
	String name;       	// 이름
	String joinDate;   	// 가입일
	String lastVisitDate;  // 최종방문일
	int numVisit;	// 방문횟수
	String gender;         // 성별
	int age;         	// 연령대
	
	public MemberClass() {
		// TODO Auto-generated constructor stub
	}
	
	// 매개변수
	public void inputRecord(String rawData) {
		// String.split("구분자) ==> String[]로 반환
		String[] split = rawData.split(",");
		
		name = split[0];
		joinDate = split[1];
		lastVisitDate = split[2];
		numVisit = Integer.parseInt(split[3]);
		gender = split[4];
		
		// String.substring(시작 인덱스, 끝 인덱스)
		String temp = split[5].substring(0, 2);
		
		// "비공개" 데이터 처리
		if (temp.equals("비공")) {
			temp = "0";
		}
		
		age = Integer.parseInt(temp);
	}
}
