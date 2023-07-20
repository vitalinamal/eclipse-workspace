package homework6;

import java.math.BigInteger;


public class FactorialCalculator implements Runnable {
    private final int number;

    public FactorialCalculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        BigInteger factorial = calculateFactorial(number);
        System.out.println("Factorial of Thread " + number + ": " + factorial);
    }

    private static BigInteger calculateFactorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        int numThreads = 100;

        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            int threadNumber = i + 1;
            threads[i] = new Thread(new FactorialCalculator(threadNumber));
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
