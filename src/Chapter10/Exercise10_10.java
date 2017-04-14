package Chapter10;

public class Exercise10_10 {
	public static void main(String[] args){
		Queue q = new Queue();
		for(int i = 0;i < 8;i++)
			q.enqueue(i);
		while(!q.empty())
			System.out.print(q.dequeue() + " ");
	}
}

class Queue{
	private int[] element;
	private int size;
	public static final int DEFAULT = 8;
	
	public Queue(){
		this(DEFAULT);
	}
	
	public Queue(int number){
		element = new int[number];
	}
	public void enqueue(int v){
		element[size++] = v;
	}
	
	public int dequeue(){
		return element[element.length - size--];
	}
	
	public boolean empty(){
		return getSize() == 0;
	}
	
	public int getSize(){
		return size;
	}
}