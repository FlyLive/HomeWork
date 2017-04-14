package Chapter25;

public class Exercise25_3 {
	public class Node<E>{
		E element;
		Node<E> next;
		Node<E> previous;
		public Node(E element){
			this.element = element;
		}
	}
	
//	public void add(int index,E e){
//		if(index==0)
//			addFirst(e);
//		else if(index >= size)
//			addLast(e);
//		else if(index <= size / 2){
//			Node<E> current = head;
//			for(int i =1;i < index;i++)
//				current = current.next;
//			Node<E> temp = current.next;
//			current.next = new Node<E>(e);
//			(current.next).next = temp;
//		}
//		else{
//			Node<E> current = tail;
//			for(int i =1;i < index;i++)
//				current = current.previous;
//			Node<E> temp = current.previous;
//			current.previous = new Node<E>(e);
//			(current.previous).previous = temp;
//		}
//		size ++;
//	}
//	
//	public E remove(int index){
//		if(index < 0 || index >= size)
//			return null;
//		else if(index == 0)
//			return removeFisrt();
//		else if(index == size - 1)
//			return removeLast();
//
//		else if(index <= size / 2){
//			Node<E> previous = head;
//			for(int i =1;i < index;i++)
//				previous = previous.next;
//			Node<E> current = previous.next;
//			previous.next = current.next;
//		}
//		else{
//			Node<E> current = tail;
//			for(int i =1;i < index;i++)
//				current = current.previous;
//			Node<E> temp = current.previous;
//			current.previous = temp;
//		}
//		size --;
//	}
}
