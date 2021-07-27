package ex3;

public class MyQueue {

	MyStack stack1;
	MyStack stack2;

	public MyQueue (int capacity)
	{
		this.stack1 = new MyStack(capacity);
		this.stack2 = new MyStack (capacity);

	}

	public boolean enqueue(int data) {
		return stack1.push(data);
	}

	public int dequeue()
	{
		if((stack1.pop() == Integer.MAX_VALUE) && (stack2.pop() == Integer.MAX_VALUE))
			return Integer.MAX_VALUE;
		if((stack2.pop() == Integer.MAX_VALUE))
			while(stack1.pop() != Integer.MAX_VALUE)
				stack2.push(stack1.pop());
		return stack2.pop();
	}


}
