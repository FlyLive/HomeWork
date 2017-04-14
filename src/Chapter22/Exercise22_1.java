package Chapter22;

import java.util.HashSet;
import java.util.Set;

public class Exercise22_1 {
	public static void main(String[] args){
		Set<String> set1 = new HashSet<String>();
		set1.add("George");
		set1.add("Jim");
		set1.add("John");
		set1.add("Blake");
		set1.add("Kevin");
		set1.add("Mechael");
		Set<String> set2 = new HashSet<String>();
		set2.add("George");
		set2.add("Katie");
		set2.add("Kevin");
		set2.add("Michelle");
		set2.add("Ryan");
		
		//set1与set2的并集
		Set<String> set1AndSet2 = new HashSet<String>();
		set1AndSet2.addAll(set1);
		set1AndSet2.addAll(set2);
		for(String item : set1AndSet2){
			System.out.println(item);
		}
		System.out.println();
		
		//set1与set2的交集
		Set<String> set1RetainSet2 = new HashSet<String>();
		set1RetainSet2.addAll(set1);
		set1RetainSet2.retainAll(set2);
		for(String item : set1RetainSet2){
			System.out.println(item);
		}
		System.out.println();
		
		//set1与set2的差集
		Set<String> set1DelSet2 = new HashSet<String>();
		set1DelSet2.addAll(set1);
		set1DelSet2.removeAll(set2);
		for(String item : set1DelSet2){
			System.out.println(item);
		}
		System.out.println();
		
		//set2与set1的差集
		Set<String> set2DelSet1 = new HashSet<String>();
		set2DelSet1.addAll(set2);
		set1DelSet2.removeAll(set1);
		for(String item : set2DelSet1){
			System.out.println(item);
		}
	}
}
