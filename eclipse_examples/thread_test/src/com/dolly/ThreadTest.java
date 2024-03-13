package com.dolly;

public class ThreadTest {
	
	// 주(메인) 스레드: 이 스레드가 종료되면 보조 스레드들은 자동 종료!
	public static void main(String[] args) {
		SleepThread sleep = new SleepThread();
		sleep.start();
		
		System.out.println("main start");
		
		// 디지털 시계도 만들 수 있음~! (1초마다 깨어나게 할 수 있으니까)
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("main end");
		
		
//		MyThread m1 = new MyThread();
//		m1.start();
//		MyThread m2 = new MyThread();
//		m2.start();
//		MyThread m3 = new MyThread();
//		m3.start();
//		
//		System.out.println("main() 종료");
		// 실행하면 main() 종료가 먼저 찍히고, 스레드들이 실행된 것을 알 수 있음
		// 따라서 별개로(병렬적으로) 실행된다는 사실을 알 수 있음
		// 각 스레드가 독립적으로 실행됨
		
//		FakeThread m1 = new FakeThread();
//		m1.start();
//		FakeThread m2 = new FakeThread();
//		m2.start();
//		FakeThread m3 = new FakeThread();
//		m3.start();
//		
//		System.out.println("main() 종료");
//		// 이때는 스레드 클래스를 상속 받은 게 아니기에, main() 종료가 위 코드가 모두 실행된 다음에야 실행됨
//		// 즉, 스레드는 독립적인 작업이라고 할 수 있음
		
//		// 현재 스레드 이름을 가져옴
//		System.out.println(Thread.currentThread().getName());
//		
//		// runnable 객체 이용해 스레드 객체 따로 생성하는 방법
//		// => RunnableClass 객체 자체를 조작하거나 이후 필요할 때 사용
//		RunnableClass r1 = new RunnableClass();
//		Thread t1 = new Thread(r1);
//		System.out.println(t1.getName());
//
//		// join(): 해당 스레드가 일을 마치고 난 후, 다음 코드를 진행
//		// 			프로세스가 일을 진행하는 것을 강제로 막는 것이기에, 예외 처리가 필요 (try, catch)
//		//			start()보다 선행함 (보통 이게 맞긴 한데, 자바 버전에 따라 start()가 먼저 와야 할 수도 있음)
//		// 이하 코드는, main이 먼저 실행되고, t1, t2가 순차적으로 실행되는 것을 확인할 수 있음
//		try {
//			t1.join();
//		} catch (InterruptedException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		t1.start();
//		
//		
//		// 익명 개체를 생성해 스레드로 변환
//		// => 스레드를 다시 구동시키는 게 아니라, 슬립 메서드라던지 스레드가 가진 메서드를 가지고 추가 작업할 경우
//		Thread t2 = new Thread(new RunnableClass());
//		t2.setName("bbbbbbbbbbbb");
//		System.out.println(t2.getName());
//		t2.start();
//		try {
//			t2.join();
//		} catch (InterruptedException e) {
//			System.out.println(e.getMessage());
//		}
//		
////		t2.start();
//		// 노빠꾸 실행
//		// => 아무 생각 없이 구동만 시키면 ok인 경우
//		new Thread(new RunnableClass()).start();
//		
//		// 보조 스레드가 일을 다 마칠 때까지 대기 시키는 방법도 있음
//		
//		System.out.println("main() 종료");
	}

}
