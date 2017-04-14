package Chapter22;

import java.util.*;

public class Exercise22_4 {
	public static void main(String[] args){
		List<String> list1 = new ArrayList<String>();
		list1.add("George");
		list1.add("Jim");
		list1.add("John");
		list1.add("Blake");
		list1.add("Kevin");
		list1.add("Mechael");
		List<String> list2 = new ArrayList<String>();
		list2.add("George");
		list2.add("Katie");
		list2.add("Kevin");
		list2.add("Michelle");
		list2.add("Ryan");
		
		//list1��list2�Ĳ���
		List<String> list1AndList2 = new ArrayList<String>();
		list1AndList2.addAll(list1);
		list1AndList2.addAll(list2);
		for(String item : list1AndList2){
			System.out.println(item);
		}
		System.out.println();
		
		//set1��set2�Ľ���
		List<String> list1RetainList2 = new ArrayList<String>();
		list1AndList2.addAll(list1);
		list1RetainList2.retainAll(list2);
		for(String item : list1RetainList2){
			System.out.println(item);
		}
		System.out.println();
		
		//set1��set2�Ĳ
		List<String> list1DelList2 = new ArrayList<String>();
		list1DelList2.addAll(list1);
		list1DelList2.removeAll(list2);
		for(String item : list1DelList2){
			System.out.println(item);
		}
		System.out.println();
		
		//set2��set1�Ĳ
		List<String> list2DelList1 = new ArrayList<String>();
		list2DelList1.addAll(list2);
		list2DelList1.removeAll(list1);
		for(String item : list2DelList1){
			System.out.println(item);
		}
		System.out.println();
	}
}
