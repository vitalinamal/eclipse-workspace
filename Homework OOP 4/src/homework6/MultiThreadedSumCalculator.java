package homework6;

import java.util.concurrent.atomic.AtomicLong;

public class MultiThreadedSumCalculator implements Runnable {
	private int[] array;
	private int startIndex;
	private int endIndex;
	private AtomicLong partialSum;

	public MultiThreadedSumCalculator() {
	}

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

	public long calculateSumWithThreads(int[] array, int numThreads) throws InterruptedException {
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

}
