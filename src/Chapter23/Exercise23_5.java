package Chapter23;

import java.util.*;

public class Exercise23_5 {
	public static void main(String[] args){
		List<Integer> list = new ArrayList<Integer>();
		Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
		int num,frequence = 0,maxIndex = 0;
		Scanner input = new Scanner(System.in);
		do{
			num = input.nextInt();
			if(num == 0){
				break;
			}
			else{
				list.add(num);
			}
		}while(num != 0);
		for(int i = 0;i < list.size();i++){
			if(i < list.size() - 1 && list.get(i) == list.get(i + 1)){
				frequence ++;
				continue;
			}
			else{
				frequence ++;
				if(i != 0 && map.size() != 0){
					Collection<Integer> entrySet = map.values();
					int key = Collections.max(entrySet);
					if (frequence > key) {
						maxIndex = i - frequence + 1;
					}
				}
				map.put(i - frequence + 1, frequence);
				frequence = 0;
			}
		}
		System.out.println(maxIndex + " with " + map.get(maxIndex) + " values of " + list.get(maxIndex));
	}
}
