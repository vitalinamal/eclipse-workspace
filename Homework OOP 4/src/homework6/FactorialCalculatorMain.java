package homework6;

public class FactorialCalculatorMain {
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
