package ds.queue;

public class Queue {

	private int maxSize; // Initializes the set number of slots
	private long[] queArray; // slots to main the data
	private int front; // this will be the index position for the element in the front
	private int rear; // element to be in the index position of back of the line
	private int nItems; // counter to maintain the number of times in the queue
	
	public Queue(int size) {
		this.maxSize = size;
		this.queArray = new long[size];
		front = 0; // index position of the first slot of the array
		rear = -1; // there is no item in the array yet to be considered as the last item
		nItems = 0; // we don't have elements in the array yet
	}
	
	public void insert(long j) {
		rear++;
		queArray[rear] = j;
		nItems ++;
	}
	
	public long remove() {// remove item from the front of the queue
		long temp = queArray[front];
		front ++;
		if(front == maxSize) {
			front = 0; // we can set back front to the 0th index so that we can utilize the enire array
		}
		nItems --;
		return temp;
	}
	
	public long peekFront() {
		return queArray[front];
	}
	
	public boolean isEmpty() {
		return (nItems == 0);
	}
	
	public boolean isFull() {
		return (nItems == maxSize);
	}
	
	public void view() {
		System.out.print("[ ");
		for(int i = 0; i < queArray.length; i++) {
			System.out.print(queArray[i] + " ");
		}
		System.out.print(" ]");
	}
}
