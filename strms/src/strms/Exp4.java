//STACK


package strms;


class StackArray{
	private int maxSize;
	private int[] arr;
	private int top;
	
	public StackArray(int size) {
		this.maxSize = size;
		this.arr = new int[maxSize];
		this.top = -1;
	}
	
	public boolean isFull() {
		return (top == maxSize-1);
	}
	
	public boolean isEmpty() {
		return (top ==-1);
	}
	
	public void push(int value) {
		if(isFull()) {
			System.out.println("Stack Overflow");
		}
		arr[++top] =value;
		
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack Underflow");
			return -1;
		}
		top--;	
		return arr[top];
	}
	public int peep() {
		if(isEmpty()) {
			System.out.println("Stack Underflow");
			return -1;
		}
		return arr[top];
	}
}


public class Exp4 {

	public static void main(String[] args) {

		StackArray obj = new StackArray(5);
		obj.push(4);
		obj.push(6);
		obj.push(8);
		obj.push(18);
		obj.push(45);
		obj.push(48);
		
		System.out.println(obj.peep());
		
		
	}

}
