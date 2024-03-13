package com.dolly;

// 모금함 역할
public class Account {
	
	private int total = 0; // 전체 모금액 저장
	// total 변수는 다 다르지만, 각 스레드의 결과에 따라 값이 달라질 수 있음
	// 스레드 a, b, c가 있을 때, 셋 모두 동시 호출된다고 가정했을 때 계산이 꼬이게 됨
	// 예를 들어 은행 계좌에 만원이 들어있을 때, 3000원 입금과 5000원 출금이 동시에 이루어진다면, 입금한 잔고는 13000원, 출금한 잔고는 5000원이 되어버림
	// 이를 해결하기 위해 0.00000001초라도 먼저 들어온 아이부터 해결한 뒤, 다음에 들어온 아이를 해결함
	// 이를 바로 동기화 작업이라고 함

	public Account() {
		
	}

	public int getTotal() { // 모금액은 확인만 가능
		return total;
	}
	
	// 전화 올 때마다 모금액이 1000원씩 쌓이게 됨
	public void deposit() {
		this.total += 1000;
	}
	
}
