package com.dolly;

public class RunnableClass implements Runnable {

	public RunnableClass() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		int i=0;
		while(i<100) {
			System.out.println(i);
			i++;
		}
	}

}
