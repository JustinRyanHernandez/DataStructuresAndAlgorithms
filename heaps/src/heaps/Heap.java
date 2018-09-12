package heaps;

public class Heap {

	private Node[] heapArray;
	private int maxSize; // size of the array
	private int currentSize; // number of nodes in the array
	
	public Heap(int size) {
		this.maxSize = size;
		currentSize = 0;
		heapArray = new Node[size]; // creates array
	}
	
	public int getSize() {
		return currentSize;
	}
	
	public boolean isEmpty() {
		return (currentSize == 0);
	}
	
	public boolean insert(int key) {
		if(currentSize == maxSize) {
			return false;
		}
		
		Node newNode = new Node(key);
		heapArray[currentSize] = newNode;
		
		trickleUp(currentSize);
		currentSize++;
		
		return true;
		
	}
	
	public void trickleUp(int idx) {
		int parentIndx = (idx-1)/2;
		Node nodeToInsert = heapArray[idx];
		
		//loop as long as we haven't reached the root and key of node to insert parent is less than new node
		while(idx > 0 && heapArray[parentIndx].getKey() < nodeToInsert.getKey()) {
			heapArray[idx] = heapArray[parentIndx]; // move the parent down
			idx = parentIndx;
			parentIndx = (parentIndx - 1) /2; //move up
		}
		
		heapArray[idx] = nodeToInsert;
	}
	
	public Node remove() {
		Node root = heapArray[0];
		currentSize--;
		heapArray[0] = heapArray[currentSize];
		
		trickleDown(0);
		
		return root;
	}
	
	private void trickleDown(int idx) {
		
		int largerChildIdx;
		Node top = heapArray[idx]; //save last into top variable
		
		//will run as long as indx is not on the bottom row (at least one child)
		while(idx < currentSize/2) {
			int leftChildIdx = 2*idx + 1;//left child idx position
			int rightChildIdx = 2*idx + 2;//left child idx position
			
			//find out which child is larger
			if(rightChildIdx < currentSize && 
					heapArray[leftChildIdx].getKey() < heapArray[rightChildIdx].getKey()) {
				largerChildIdx = rightChildIdx;
			} else {
				largerChildIdx = leftChildIdx;
			}
			if(top.getKey() >= heapArray[largerChildIdx].getKey()) {
				break;
			}
			
			heapArray[idx] = heapArray[largerChildIdx];
			idx = largerChildIdx; //go down
		}
		
		heapArray[idx] = top;
	}
	
}
