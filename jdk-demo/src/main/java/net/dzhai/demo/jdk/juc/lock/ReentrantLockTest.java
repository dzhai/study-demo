package net.dzhai.demo.jdk.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class ReentrantLockTest {

	private static Lock fairLock = new ReentrantLock(true);

	private static Lock unfairLock = new ReentrantLock();

	@Test
	public void fair() {
		System.out.println("fair version");
		for (int i = 0; i < 5; i++) {
			Thread t = new Thread(new Job(fairLock));
			t.start();
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void unfair() {
		System.out.println("fair version");
		for (int i = 0; i < 5; i++) {
			Thread t = new Thread(new Job(unfairLock));
			t.start();
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

class Job implements Runnable {

	private Lock lock;

	public Job(Lock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			lock.lock();
			try {
				System.out.println("Lock by:"
						+ Thread.currentThread().getName());

			} finally {
				lock.unlock();
			}

		}

	}

}