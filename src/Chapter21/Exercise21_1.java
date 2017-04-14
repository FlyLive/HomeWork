package Chapter21;

public class Exercise21_1 {
	private int[] list;
	private int size;
	public static final int DEFULAT_NUM = 10;

	public Exercise21_1() {
		list = new int[DEFULAT_NUM];
	}

	public void push(int num) {
		if (size >= list.length) {
			int[] copy = new int[size * 2];
			System.arraycopy(list, 0, copy, 0, list.length);
			list = copy;
		}
		list[size++] = num;
	}

	public int getSize() {
		return this.size;
	}

	public int peek() {
		return list[this.size--];
	}

	public int pop() {
		return list[--this.size];
	}

	public boolean isEmpty() {
		return size == 0;
	}
	//Exercise21_2
	public static <E extends Comparable<E>> int binarySearch(E[] list,E key){
		int min=0,max=list.length-1,mid;
		do{
			mid=(max-(max-min)/2);
			if(key.compareTo(list[mid])>0){
				min=mid;
			}
			else if(key.compareTo(list[mid])<0){
				max=mid;
			}
			else if(key.compareTo(list[mid])==0){
				break;
			}
		}while(min==max);
		return mid;
	}
	//Exercise21_3
	public static <E extends Comparable<E>> void selectionSort(E[] list){
		int minIndex;
		E temp;
		for(int i = 0;i < list.length;i++){
			minIndex=i;
			for(int j = i+1;j < list.length-1;j++){
				minIndex=list[minIndex].compareTo(list[j])>0?minIndex:j;
			}
			if(minIndex!=i){
				temp=list[i];
				list[i]=list[minIndex];
				list[minIndex]=temp;
			}
		}
	}
	//Exercise21_4
	public static <E extends Comparable<E>> void insertionSort(E[] list){
		for(int i=1;i<list.length;i++){
			for(int j=i;j>0;j--){
				if(list[j].compareTo(list[j-1])>0){
					E temp=list[j];
					list[j]=list[j-1];
					list[j-1]=temp;
				}
				else{
					break;
				}
			}
		}
	}
	
	//Exercise21_5
	public static <E extends Comparable<E>> E max(E[] list){
		E temp=list[0];
		for(int i=1;i<list.length;i++){
			if(list[i].compareTo(temp)>0)
				temp=list[i];
		}
		return temp;
	}
	
	//Exercise21_6
	public static <E extends Comparable<E>> E max(E[][] list){
		E temp=list[0][0];
		for(int i = 0;i < list.length;i++){
			for(int j=1;j<list[i].length;j++){
				if(list[i][j].compareTo(temp)>0)
					temp=list[i][j];
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		//Exercise21_1
		Exercise21_1 stack = new Exercise21_1();

		for (int i = 0; i < 19; i++)
			stack.push(i);
		while (!stack.isEmpty())
			System.out.print(stack.pop() + " ");
		System.out.println();
		//Exercise21_2
		//Exercise21_3
		//Exercise21_4
		//Exercise21_5
		//Exercise21_6
	}
}