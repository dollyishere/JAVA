package com.dolly;

public class ThreadTest {
	
	// ��(����) ������: �� �����尡 ����Ǹ� ���� ��������� �ڵ� ����!
	public static void main(String[] args) {
		SleepThread sleep = new SleepThread();
		sleep.start();
		
		System.out.println("main start");
		
		// ������ �ð赵 ���� �� ����~! (1�ʸ��� ����� �� �� �����ϱ�)
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
//		System.out.println("main() ����");
		// �����ϸ� main() ���ᰡ ���� ������, ��������� ����� ���� �� �� ����
		// ���� ������(����������) ����ȴٴ� ����� �� �� ����
		// �� �����尡 ���������� �����
		
//		FakeThread m1 = new FakeThread();
//		m1.start();
//		FakeThread m2 = new FakeThread();
//		m2.start();
//		FakeThread m3 = new FakeThread();
//		m3.start();
//		
//		System.out.println("main() ����");
//		// �̶��� ������ Ŭ������ ��� ���� �� �ƴϱ⿡, main() ���ᰡ �� �ڵ尡 ��� ����� �������� �����
//		// ��, ������� �������� �۾��̶�� �� �� ����
		
//		// ���� ������ �̸��� ������
//		System.out.println(Thread.currentThread().getName());
//		
//		// runnable ��ü �̿��� ������ ��ü ���� �����ϴ� ���
//		// => RunnableClass ��ü ��ü�� �����ϰų� ���� �ʿ��� �� ���
//		RunnableClass r1 = new RunnableClass();
//		Thread t1 = new Thread(r1);
//		System.out.println(t1.getName());
//
//		// join(): �ش� �����尡 ���� ��ġ�� �� ��, ���� �ڵ带 ����
//		// 			���μ����� ���� �����ϴ� ���� ������ ���� ���̱⿡, ���� ó���� �ʿ� (try, catch)
//		//			start()���� ������ (���� �̰� �±� �ѵ�, �ڹ� ������ ���� start()�� ���� �;� �� ���� ����)
//		// ���� �ڵ��, main�� ���� ����ǰ�, t1, t2�� ���������� ����Ǵ� ���� Ȯ���� �� ����
//		try {
//			t1.join();
//		} catch (InterruptedException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		t1.start();
//		
//		
//		// �͸� ��ü�� ������ ������� ��ȯ
//		// => �����带 �ٽ� ������Ű�� �� �ƴ϶�, ���� �޼������� �����尡 ���� �޼��带 ������ �߰� �۾��� ���
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
//		// ����� ����
//		// => �ƹ� ���� ���� ������ ��Ű�� ok�� ���
//		new Thread(new RunnableClass()).start();
//		
//		// ���� �����尡 ���� �� ��ĥ ������ ��� ��Ű�� ����� ����
//		
//		System.out.println("main() ����");
	}

}
