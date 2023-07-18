package homework6;


public class Main {

	public static void main(String[] args) {
		Thread[] threads = new Thread[100];

		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Factorial(i + 1));
			threads[i].start();
		}

	}

}
