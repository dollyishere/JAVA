package com.juju.employee;

public class EMPDataClass { // 클래스 선언부
	// 데이터 베이스 직접 연결하기 전까지는 얘가 데이터베이스 역할을 맡게 됨
	int[] age = new int[31];
	String[] name = new String[31];
	String[] phone = new String[31];
	String[] gender = new String[31];
	String[] job = new String[31];
	int[] pay = new int[31];
	String[] code = new String[31];

	public EMPDataClass() { // 생성자
		age[0]=44; name[0]="오성훈"; phone[0]="010-7730-4737"; gender[0]="M"; job[0]="java"; pay[0]=200; code[0]="US";
		age[1]=34; name[1]="정동욱"; phone[1]="010-9679-5257"; gender[1]="M"; job[1]="java";  pay[1]=200; code[1]="FR";
		age[2]=28; name[2]="안정환"; phone[2]="010-9962-4536"; gender[2]="M"; job[2]="mobile"; pay[2]=250; code[2]="JP";
		age[3]=26; name[3]="한성탁"; phone[3]="010-4617-0975"; gender[3]="M"; job[3]="it";  pay[3]=300; code[3]="US";
		age[4]=29; name[4]="황태욱"; phone[4]="011-895-7892"; gender[4]="M"; job[4]="mobile";  pay[4]=300; code[4]="CN";
		age[5]=28; name[5]="임원석"; phone[5]="010-6201-6976"; gender[5]="M"; job[5]="java";  pay[5]=200; code[5]="DE";
		age[6]=27; name[6]="이상덕"; phone[6]="010-9492-6059"; gender[6]="M"; job[6]="game";  pay[6]=350; code[6]="KR";
		age[7]=29; name[7]="윤지홍"; phone[7]="010-4245-0105"; gender[7]="M"; job[7]="java";  pay[7]=200; code[7]="JP";
		age[8]=29; name[8]="정석원"; phone[8]="010-6243-4849"; gender[8]="M"; job[8]="mobile";  pay[8]=400; code[8]="DE";
		age[9]=32; name[9]="이경오"; phone[9]="010-4517-1609"; gender[9]="M"; job[9]="it";  pay[9]=440; code[9]="KR";
		age[10]=23; name[10]="오은지"; phone[10]="010-3470-5204"; gender[10]="F";  job[10]="java"; pay[10]=340; code[10]="FR";
		age[11]=30; name[11]="안은경"; phone[11]="010-4311-2563"; gender[11]="F"; job[11]="mobile";  pay[11]=250; code[11]="JP";
		age[12]=30; name[12]="이상배"; phone[12]="010-5131-9058"; gender[12]="M"; job[12]="it";  pay[12]=220; code[12]="KR";
		age[13]=28; name[13]="조영동"; phone[13]="010-6515-4454"; gender[13]="M"; job[13]="mobile";  pay[13]=270; code[13]="FR";
		age[14]=31; name[14]="김윤기"; phone[14]="010-8565-1746"; gender[14]="M"; job[14]="java";  pay[14]=330; code[14]="CN";
		age[15]=26; name[15]="장한샘"; phone[15]="010-4875-0827"; gender[15]="M"; job[15]="game";  pay[15]=430; code[15]="US";
		age[16]=33; name[16]="김지훈"; phone[16]="010-2034-3054"; gender[16]="M"; job[16]="java";  pay[16]=220; code[16]="US";
		age[17]=30; name[17]="김철호"; phone[17]="010-9180-4710"; gender[17]="M"; job[17]="it";  pay[17]=510; code[17]="CN";
		age[18]=28; name[18]="이승철"; phone[18]="011-473-8512"; gender[18]="M"; job[18]="mobile";  pay[18]=640; code[18]="JP";
		age[19]=27; name[19]="윤수연"; phone[19]="010-3062-2557"; gender[19]="F"; job[19]="game";  pay[19]=320; code[19]="KR";
		age[20]=33; name[20]="박유선"; phone[20]="010-3037-1174"; gender[20]="F"; job[20]="java";  pay[20]=280; code[20]="DE";
		age[21]=31; name[21]="이혁성"; phone[21]="010-8743-0995"; gender[21]="M"; job[21]="it";  pay[21]=290; code[21]="US";
		age[22]=32; name[22]="문경곤"; phone[22]="010-5634-5664"; gender[22]="M"; job[22]="mobile";  pay[22]=310; code[22]="US";
		age[23]=35; name[23]="김병률"; phone[23]="010-4220-5355"; gender[23]="M"; job[23]="it";  pay[23]=410; code[23]="KR";
		age[24]=35; name[24]="김태환"; phone[24]="010-2211-3901"; gender[24]="M"; job[24]="java";  pay[24]=500; code[24]="FR";
		age[25]=25; name[25]="곽진영"; phone[25]="010-9190-2303"; gender[25]="F"; job[25]="game";  pay[25]=370; code[25]="KR";
		age[26]=33; name[26]="조영석"; phone[26]="010-5277-4620"; gender[26]="M"; job[26]="java";  pay[26]=290; code[26]="JP";
		age[27]=34; name[27]="조요환"; phone[27]="010-3013-1022"; gender[27]="M"; job[27]="it";  pay[27]=405; code[27]="CN";
		age[28]=28; name[28]="김동현"; phone[28]="010-9977-9804"; gender[28]="M"; job[28]="mobile";  pay[28]=440; code[28]="DE";
		age[29]=28; name[29]="정대현"; phone[29]="010-4564-7145"; gender[29]="M"; job[29]="it";  pay[29]=530; code[29]="KR";
		age[30]=27; name[30]="박지혜"; phone[30]="010-8562-0537"; gender[30]="F"; job[30]="game";  pay[30]=460; code[30]="JP";
		
		// System.out.println("EMPDataClass의 생성자 호출됨!!!");
	} // EMPDataClass() END
	
	public void test(int n) {
		System.out.println("test() 메서드 호출됨!! " + n);
	} // test() END
	
} // EMPDataClass END
