public class GuitarString {
	int ticCount;
	int capacity;
	RingBuffer array;
	
	
	/*
	 * 
	 */
	public GuitarString (double frequency) {
		ticCount = 0;
		double brug = (44100 / frequency);
		int n = (int) Math.round(brug);
		capacity = n;
		RingBuffer boof = new RingBuffer(n);
		
		for (int i = 0; i < n; i++) {
			boof.enqueue(0);
		}
		array = boof;
	}
	
	/*
	 * Consturctor GuitarString will make a new instance of string it will initialize size and ticCount to 0, make a RingBuffer 
	 * the length of the inputted array, and will fill the new array with the values in the imputted array.
	 * <p>
	 * @param double[] init, this is the array you want to be put made into a RingBuffer 
	 */
	public GuitarString (double[] init) {
		int length = init.length;
		ticCount = 0;
		capacity = length+1;
		RingBuffer boof = new RingBuffer(length);
		for (int i = 0; i <= length; i++) {
			boof.enqueue(init[i]);
		}
		array = boof;
	}
	
	/*
	 * pluck will fill the array with random numbers between -.5 and .5, and take out all the 0 that are in theory in the queue
	 */
	public void pluck() {
		for (int i = 0; i <= capacity; i++) {
			double random1 = Math.random() - .5;
			array.dequeue();
			array.enqueue(random1);
			
		}
	}
	
	/*
	 * tic will peek the first number in the queue, delete it, peek the second number. average them and then multiply it by 
	 * the decay factor which is .994 to make it so the string wont sound forever
	 */
	public void tic() {
		double firstVar = array.peek();
		array.dequeue();
		double secondVar = array.peek();
		double average = ((firstVar + secondVar)*.5)*.994;
		array.enqueue(average);
		ticCount++;
	}
	
	/*
	 * returns the first variable in the queue. this will use the peek function from ringbuffer.java
	 * <p>
	 * @return double, this will return a double (between -.5 and .5) representing the front of the ring buffer
	 */
	public double sample() {
		return array.peek();
	}
	
	
	/*
	 * time will return how many times tic was called 
	 * <p>
	 * @return int, this will be the integer count of times tic was called
	 */
	public int time() {
		return ticCount;
	}
	
	
	/*
	 * 
	 */
	public String toString() {
		String StringRep = "[";
		for (int i = 0; i < capacity; i++) {
			//Temp = array.peek();
			double Temp1 = array.queue[i];
			StringRep = StringRep + Temp1;
			//array.dequeue();
			//array.enqueue(Temp);
			
		}
		StringRep += "]";
		return StringRep;
	}
	
	
	public static void main(String[] args) {
		GuitarString gti = new GuitarString(50);
		gti.pluck();
		System.out.println(gti);
		gti.tic();
		gti.tic();
		System.out.println(gti);
		System.out.println(gti.time());
		System.out.println(gti.sample());
		
		
	}
}