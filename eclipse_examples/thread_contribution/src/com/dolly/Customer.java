package com.dolly;

// ARS 회선 역할(Thread)
public class Customer extends Thread {
	
	// 모금함은 여러 개 있어서는 안됨
	// 따라서 main에서 Customer 객체를 생성할 때, Account 객체를 보내줘야 함
	private Account same;
	
	public Customer() {

	}
	
	public Customer(Account a, String s) {
		this.same = a;
		this.setName(s);	// 스레드 클래스로부터 상속받은 메서드
	}
	
	public void run() {
		for (int i= 1; i<200;i++) {
			System.out.println(this.getName() + ":" + i + "번째 성금자");
			this.same.deposit();
			if(same.getTotal() >= 200000) {
				break;
			}
		}
	}
	
}
