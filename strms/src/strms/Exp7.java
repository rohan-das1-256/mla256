package strms;

class ArrayQueue{
	int[] arr;
	private int front, size, capacity;
	int rear;
	public ArrayQueue(int capacity) {
		this.capacity = capacity;
		this.arr = new int[capacity];
		this.front = 0;
		this.rear = -1;
		this.size = 0;
	}
	

	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == capacity;
	}
	
	public int size() {
		return size;
	}
	
	public void enqueue(int value) {
		if(isFull()) {
			System.out.println("Queue is full");
			return;
		}
		rear = (rear+1)%capacity;
		arr[rear] = value;
		size++;
		System.out.println("Enqueued one element: "+value);
		
	}
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		int value = arr[front];
		front = (front+1)%capacity;
		size--;
		System.out.println("Dequed one item: " + value);
		return value;
		
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("Queue is Empty");
		}
		
		return arr[front];
	}
	
}

public class Exp7 {

	public static void main(String[] args) {
		
		ArrayQueue data = new ArrayQueue(5);
		
		data.enqueue(50);
		data.enqueue(60);
		data.enqueue(70);
		data.enqueue(80);
		data.enqueue(90);
		data.enqueue(1000);
		
		System.out.println("Top element is: " + data.peek());
		data.dequeue();
		data.dequeue();
		System.out.println("Top element is: " + data.peek());
		data.enqueue(9809);
		data.enqueue(8568);
		System.out.println(data.size());
		System.out.println("Top element is: " + data.peek());
		System.out.println("Rear elem: "+ data.arr[data.rear]);
	}

}
