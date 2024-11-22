public class RingBuffer {
	int size;
	int first;
	double[] queue;
	int capacity;
	int last;
	
	
	
	public RingBuffer(int capacity) {
		queue = new double[capacity];
		this.capacity = capacity;
		first = 0;
		size = 0;
		last = 1;
	}
	
	/*
	 * Returns the size of the queue
	 * <p>
	 * @return int, will return integer representation of the size of the queue
	 */
	public int size() {
		return size;
	}
	
	/*
	 * is empty will return true if the queue is empty
	 * <p>
	 * @return boolean, returns boolean true if it is empty, and false if it is not
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/*
	 * isFull will return true if the queue is full
	 * <p>
	 * @return boolean, returns boolean true if it is full, and false if it is not
	 */
	public boolean isFull() {
		return size==capacity;
	}
	
	/*
	 * enqueue will add the new element to the end of the queue, unless it is full.
	 * <p>
	 * @param newInt, this is the new integer that you want to be added to the end of the queue
	 */
	public void enqueue(double newDouble) {
		if (isFull()) throw new RuntimeException ("Woah there, hold your horses! The queue is full!");
		queue[(first + size)%capacity] = newDouble;
		size++;
		last++;
	}
	
	/*
	 * dequeue will take the int at the first slot, return it and move the front back one.
	 * <p>
	 * @return int, returns the int at the first position
	 */
	public double dequeue() {
		if(isEmpty()) throw new RuntimeException ("Florpaligopilis! the queue is empty!");
		size--;
		last--;
		if (first == capacity) first = 0;
		first++;
		return queue[first-1];
	}
	
	/*
	 * This will show the variable first in the queue
	 * @return int, the variable in the first slot of the queue
	 */
	public double peek() {
		if(isEmpty()) throw new RuntimeException ("Florpaligopilis! the queue is empty!");
		return queue[first%capacity];
	}
	

	public static void main(String[] args) {
		RingBuffer boof = new RingBuffer(5);
		System.out.println(boof.isEmpty());
		boof.enqueue(3);
		System.out.println(boof.dequeue());
//		System.out.println(boof.dequeue());
//		boof.dequeue();
		boof.enqueue(4);
//		boof.enqueue(5);
//		boof.enqueue(6);
//		boof.enqueue(7);
//		boof.enqueue(8);
		//boof.enqueue(9);
		System.out.println(boof.peek());
		
	}
}