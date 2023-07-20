package homework6;

import java.util.concurrent.atomic.AtomicLong;

public class MultiThreadedSumCalculator implements Runnable {
	private final int[] array;
	private final int startIndex;
	private final int endIndex;
	private final AtomicLong partialSum;

	public MultiThreadedSumCalculator(int[] array, int startIndex, int endIndex, AtomicLong partialSum) {
		this.array = array;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.partialSum = partialSum;
	}

	@Override
	public void run() {
		long sum = 0;
		for (int i = startIndex; i <= endIndex; i++) {
			sum += array[i];
		}
		partialSum.addAndGet(sum);
	}

	public static long calculateSumWithThreads(int[] array, int numThreads) throws InterruptedException {
		int arrayLength = array.length;
		AtomicLong result = new AtomicLong(0);
		Thread[] threads = new Thread[numThreads];

		int blockSize = arrayLength / numThreads;
		int extraElements = arrayLength % numThreads;
		int currentIndex = 0;

		for (int i = 0; i < numThreads; i++) {
			int blockSizeWithExtra = blockSize + (i < extraElements ? 1 : 0);
			int endIndex = currentIndex + blockSizeWithExtra - 1;
			threads[i] = new Thread(new MultiThreadedSumCalculator(array, currentIndex, endIndex, result));
			threads[i].start();
			currentIndex = endIndex + 1;
		}

		for (int i = 0; i < numThreads; i++) {
			threads[i].join();
		}

		return result.get();
	}

	public static void main(String[] args) {
		int[] array = new int[100000000];
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}

		int numThreads = 4;
		var start = System.currentTimeMillis();
		System.out.println("Started with threads at " + start);
		long sum = 0;
		try {
			sum = calculateSumWithThreads(array, numThreads);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
