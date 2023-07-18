package homework6;

import java.util.concurrent.atomic.AtomicLong;

public class MultiThreadedSumCalculator {
	private static final int NUM_THREADS = 4;

	public static long calculateSum(int[] array) {
		int size = array.length;
		int chunkSize = (size + NUM_THREADS - 1) / NUM_THREADS; 

		SumThread[] threads = new SumThread[NUM_THREADS];

		for (int i = 0; i < NUM_THREADS; i++) {
			int start = i * chunkSize;
			int end = Math.min((i + 1) * chunkSize, size);
			threads[i] = new SumThread(array, start, end);
			threads[i].start();
		}

		for (SumThread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		long totalSum = 0;
		for (SumThread thread : threads) {
			totalSum += thread.getPartialSum();
		}

		return totalSum;
	}

	private static class SumThread extends Thread {
		private int[] array;
		private int start;
		private int end;
		private AtomicLong partialSum = new AtomicLong(0);

		public SumThread(int[] array, int start, int end) {
			this.array = array;
			this.start = start;
			this.end = end;
		}

		public void run() {
			for (int i = start; i < end; i++) {
				partialSum.addAndGet(array[i]);
			}
		}

		public long getPartialSum() {
			return partialSum.get();
		}
	}

	public static void main(String[] args) {
		int arraySize = 100000000; 

		int[] array = new int[arraySize];

		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
		var start = System.currentTimeMillis();
		System.out.println("Started with threads at " + start);
		long sum = calculateSum(array);
		var end = System.currentTimeMillis();
		System.out.println("Finished with threads at " + end);
		System.out.println(end - start);

		System.out.println("The sum of the elements in the array is: " + sum);

		long sum2 = 0;
		start = System.currentTimeMillis();
		System.out.println("Started without threads at " + System.currentTimeMillis());

		for (int i : array) {
			sum2 += i;
		}
		end = System.currentTimeMillis();
		System.out.println("Finished without threads at " + end);
		System.out.println(end - start);


		System.out.println("The sum of the elements in the array is: " + sum2);

	}
}
