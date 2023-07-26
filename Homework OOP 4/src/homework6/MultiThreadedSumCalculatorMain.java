package homework6;

public class MultiThreadedSumCalculatorMain {

    public static void main(String[] args) {
        int[] array = new int[100000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        var multiCalculator = new MultiThreadedSumCalculator();

        int numThreads = 4;
        var start = System.currentTimeMillis();
        System.out.println("Started with threads at " + start);
        long sum = 0;
        try {
            sum = multiCalculator.calculateSumWithThreads(array, numThreads);
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
