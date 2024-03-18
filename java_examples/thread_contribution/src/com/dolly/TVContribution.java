package com.dolly;

public class TVContribution {
	static Account acc = new Account();
	
	public static void main(String[] args) {
		Customer c1 = new Customer(acc, "02-720-2220");
		Customer c2 = new Customer(acc, "02-720-2221");
		Customer c3 = new Customer(acc, "02-720-2222");
		
		c1.start();
		c2.start();
		c3.start();
		
		try {
			c1.join();
			c2.join();
			c3.join();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("รั ธ๐ฑÝพื : " + acc.getTotal());
	}

}
