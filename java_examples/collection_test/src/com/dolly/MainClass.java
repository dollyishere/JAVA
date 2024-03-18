package com.dolly;

import com.dolly.list.LinkedListTestClass;
import com.dolly.map.HashmapTestClass;
import com.dolly.map.Student;
import com.dolly.set.HashLotto;
import com.dolly.set.HashSetTestClass;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListTestClass.linkedListTest();
		HashSetTestClass.hashSetTest();
		HashLotto.lotto();
		HashmapTestClass.hashMapTest();
		
		Student s = new Student(10, "test");
		System.out.println(s);
		HashmapTestClass.hashMapStudent();
	}

}
