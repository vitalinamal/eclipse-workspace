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

    private BigInteger calculateFactorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
