package Chapter23;

import java.util.*;

public class Exercise23_1 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("������һ���ַ���");
		String str = input.nextLine();
		Map<Integer,String> strs = new TreeMap<Integer,String>();
		String temp = "";
		for(int i = 0;i < str.length() - 1;i++){
				temp += str.charAt(i);
			if(str.charAt(i) < str.charAt(i + 1)){
				if((i + 1)==str.length() - 1){
					temp += str.charAt(i+1);
					strs.put(temp.length(), temp);
				}
				continue;
			}
			else{
				if(temp != ""){
					strs.put(temp.length(), temp);
				}
				temp = "";
			}
		}
		Set<Integer> entrySet = strs.keySet();
		int key = Collections.max(entrySet);
		System.out.print("���ַ�����������������������Ӵ���:");
		System.out.println(strs.get(key));
	}
}
