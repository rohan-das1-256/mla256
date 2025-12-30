//linkedlist

package strms;

import java.util.EmptyStackException;

class Node<T>{
	T data;
	Node<T> next;
	
	Node(T data){
		this.data = data;
		this.next = null;
	}
	
}

class LinkedListStack<T>{
	private Node<T> top;
	private int size;
	
	public LinkedListStack() {
		this.top = null;
		this.size=0;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int size() {
		return size;
	}
	
	public void push(T element) {
		Node<T> newNode = new Node<>(element);
		newNode.next = top;
		top = newNode;
		size++;
	}
	
	public T pop() {
		if(isEmpty()) {
			System.out.println("Stack underflow");
			throw(new EmptyStackException());
		}
		
		T poppedElem = top.data;
		top = top.next;
		size--;
		return poppedElem;
	}
	public T peek() {
		if(isEmpty()) {
			System.out.println("Stack underflow");
			throw(new EmptyStackException());
		}
		
		return top.data;
	}
}


public class Exp5 {
	public static void main(String[] args) {
	
		LinkedListStack<Integer> data = new LinkedListStack<>();
		data.push(100);
		data.push(200);
		data.push(300);
		data.push(400);
		data.push(500);
		
		System.out.println("Top element: " + data.peek());
		System.out.println("size of data: " + data.size());
		System.out.println("popped elem: " + data.pop());
		System.out.println("is stack empty: " + data.isEmpty());
		System.out.println("size of data: " + data.size());
		System.out.println("Top element: " + data.peek());
		
	}
}
