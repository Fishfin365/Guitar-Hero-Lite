public class GuitarHero {
	
	/*
	 * Creates an interactive guitar out of the user's keyboard using 37 keys
	 */
	public static void main(String[] args) {
		int notes = 37;
		String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
		
		// initialize the GuitarString[] with the strings of frequencies corresponding 
		// to their spot in the keyboard array
		GuitarString[] keyStrings = new GuitarString[notes];
		for (int i = 0; i < notes; i++) {
			keyStrings[i] = new GuitarString(440 * (Math.pow(1.05956, i - 24)));
		}
		
		while(true) {
			// check if the user has typed a key; if so, pluck the according string
			if (StdDraw.hasNextKeyTyped()) {
				
				char key = StdDraw.nextKeyTyped();
				int keyIndex = keyboard.indexOf(key);
				// indexOf() will return -1 if the key is not in the keyboard
				// if the key typed is valid, pluck
				if (keyIndex != -1) 
					keyStrings[keyIndex].pluck();
			}
			
			// compute the superposition of samples
            double sample = 0;
            for (int i = 0; i < notes; i++) {
            	sample += keyStrings[i].sample();
            }
            
            // play the sample on standard audio
            StdAudio.play(sample);
            
            // advance the simulation of each guitar string by one step
            for (int i = 0; i < notes; i++) {
            	keyStrings[i].tic();
            }
		}
	}
	
}