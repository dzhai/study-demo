package net.dzhai.demo.jdk.juc.atomic;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class AtomicMarkableReferenceTest {


	public static void main(String[] args) {
		AtomicMarkableReference<String> amr= new AtomicMarkableReference<String>("zhangsan", true);
		amr.compareAndSet("zhangsan", "lisi", true, false);	
		System.out.println(amr.getReference());
	}

}
