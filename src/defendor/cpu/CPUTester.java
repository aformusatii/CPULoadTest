package defendor.cpu;

import java.math.BigInteger;

public class CPUTester {

	private static final Long TEST_CICLES = 499999999L;
	private static final int TEST_THREADS = 3;
	
	public static void main(String[] args) {
		for (int i = 0; i < TEST_THREADS; i++) {
			CPUWorker cpuWorker = new CPUWorker();
			cpuWorker.start();
		}
	}
	
	public static class CPUWorker extends Thread {
		
		public void run() {
			BigInteger factValue = BigInteger.ONE;
			
			long start = System.currentTimeMillis();
			
			for (Long l = 0L; l < TEST_CICLES; l++) {
				factValue = factValue.multiply(BigInteger.valueOf(l));
			}
			
			long end = System.currentTimeMillis();
			
			System.out.println(String.format("[%s] -  %s", Thread.currentThread().getName(), (end - start)));
		}
		
	}

}
