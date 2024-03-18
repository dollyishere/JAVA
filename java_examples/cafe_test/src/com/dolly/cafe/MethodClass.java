package com.dolly.cafe;

import java.util.ArrayList;
import java.util.Comparator;

public class MethodClass {
	// CafeClass ��ü���� item�� �����Ͽ� ������ ArrayList
	private ArrayList<String> items = new ArrayList<String>();
	
	// ���� items���� �ߺ� ���ŵ� item�鸸 ������ ArrayList
	private ArrayList<String> no = new ArrayList<String>();
	
	// ���� �ߺ� ���ŵ� item�� count�� �� �ֵ��� ������ ��üȭ�Ͽ� ������ ArrayList
	private ArrayList<ItemCountClass> item_count_list = new ArrayList<ItemCountClass>();
	
	// �ڵ� ���� �߿��� 
	
	// �ٸ� ������ �� �ǵ帮�� ����
	public MethodClass() { // �⺻ ������
		// TODO Auto-generated constructor stub
	}
	
	// CafeClass ��ü���� item�� �����Ͽ� ���� �޼���
	public void item() {
		for (int n=0; n<DataClass.cafe.size();n++) {
			items.add(DataClass.cafe.get(n).getItem());
		} 
		
		// �Ǵ�
//		for (CafeClass cafe : DataClass.cafe) {
//			items.add(cafe.getItem());
//		}
	}
	
	// items ���� ������ �ߺ� ���� �޼���
	// 	static ArrayList<String> no = new ArrayList<String>();
	public void duplicate() {
		String tempString = ""; // �ߺ� ���Ÿ� ���� �ӽ� ����
		
		// �ߺ� ���� �� ������ ���� : ArrayList.sort()
		items.sort(Comparator.naturalOrder());
		
		for(int n=0; n<items.size(); n++) {
			if (!tempString.equals(items.get(n))) {
				tempString = items.get(n);
				no.add(tempString);
			}
		}
		System.out.println(no);
	} // duplicate() END
	
	// no ���� item ���� count ������ �ϳ��� ��ü�� �߰� �޼���
	// static ArrayList<ItemCountClass> item_count_list = new ArrayList<ItemCountClass>();
	public void item_count_list() {
		for (String item: no) {
			item_count_list.add(new ItemCountClass(item));
		}
	} // item_count_list() END
	
	// ItemCountClass ��ü���� ������ ArrayList�� ��ü �����͸� ���Ͽ� counting�ϴ� �޼���
	// 2�� for��
	public void counting() {
		for(ItemCountClass itemObj: item_count_list) {
			for(int idx=0; idx<DataClass.cafe.size(); idx++) {
				if (itemObj.item.equals(DataClass.cafe.get(idx).getItem())) {
					itemObj.count++;
				}
			} // ��ü ������ ��ȸ
		} // �ߺ� ������ ��ȸ
	} // item_count_list() END

	
	// count ���� ���� ū ��ü�� ã�Ƽ� ��ȯ
	public ItemCountClass maxItem() {
		// 1. �ʱ� ������ �ε�
		DataClass.initData();
		
		// 2. CafeClass ��ü���� item�� �����Ͽ� ����
		item();
		
		// 3. items ���� ������ �ߺ� ���� �޼��� ȣ��
		duplicate();
		
		// 4. no ���� item ���� count ������ �ϳ��� ��ü�� �߰� �޼��� ȣ��
		// => item�� count�� �� ������ �ٷ�� ����...
		item_count_list();

		// 5. counting �ϴ� �޼��� ȣ��
		counting();
		
		ItemCountClass tempObj= new ItemCountClass(); // �ӽ� ����
		
		for(ItemCountClass item: item_count_list) {
			if(tempObj.count < item.count) {
				tempObj.count = item.count;
				tempObj.item = item.item;
			}
		}
		
		return tempObj;
	} // maxItem() END
	
} // MethodClass End
