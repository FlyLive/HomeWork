package Chapter23;

import java.util.*;

public class Exercise23_4 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入第一个字符串");
		String str1 = input.nextLine();
		System.out.println("请输入第二个字符串");
		String str2 = input.nextLine();
		int str2Index = 0;
		int index = 0;
		for(int i = 0;i < str1.length();i++){
			if(str1.charAt(i) == str2.charAt(str2Index) && str2Index == (str2.length() - 1)){
				index = i - str2Index;
				break;
			}
			else if(str1.charAt(i) == str2.charAt(str2Index) && str2Index != (str2.length() - 1)){
				str2Index++;
				continue;
			}
			else if(str1.charAt(i) == str2.charAt(0)){
				str2Index = 1;
				continue;
			}
			else{
				str2Index=0;
			}
		}
		System.out.print("mached at index:");
		System.out.println(index);
	}
}
