package Chapter22;

import java.util.*;

public class Exercise22_7 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> listValue = new ArrayList<Integer>();
		Set<Integer> listMax = new HashSet<Integer>();
		int num;
		System.out.println("请依次输入不定数目的数字(以0结尾)");
		do{
			num = input.nextInt();
			if(num == 0){
				break;
			}
			else{
				list.add(num);
			}
		}while(num == 0);
		for(int element:list){
			listValue.add(Collections.frequency(list, element));
		}
		int max=list.get(Collections.max(listValue));
		for(int row=0;row<listValue.size();row++){
			int element = listValue.get(row);
			if(element == max){
				listMax.add(list.get(row));
			} 
		}
		System.out.println("输入频率最高的数字是:" + listMax);
	}
}
