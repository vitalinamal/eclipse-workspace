package homework6;

import java.math.BigInteger;

public class Factorial implements Runnable {

	private int number;

	public Factorial(int number) {
		super();
		this.number = number;
	}

	public BigInteger factorialCalculate(int n) {
		BigInteger fact = BigInteger.ONE;
		for (int i = 1; i <= n; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		return fact;
	}

	@Override
	public void run() {
		Thread thr = Thread.currentThread();
		for (int i = 1; i <= number; i++) {
			BigInteger fact = factorialCalculate(i);

			System.out.println(thr.getName() + " -> " + i + " != " + fact);
		}
	}
}
