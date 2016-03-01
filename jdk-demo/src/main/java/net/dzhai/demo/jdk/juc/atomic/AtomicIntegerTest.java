package net.dzhai.demo.jdk.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;



public class AtomicIntegerTest {

	
	public static void main(String[] args) {
		
		AtomicInteger ai=new AtomicInteger();
		
		System.out.println(ai.addAndGet(1));//更新并返回
		
		System.out.println(ai.get());//get
		
		System.out.println(ai.compareAndSet(1, 2));//cas
		
		System.out.println(ai.getAndAdd(1));
		
		System.out.println(ai.get());
		
		System.out.println(ai.incrementAndGet());
		
		System.out.println(ai.decrementAndGet());
		
		System.out.println(ai.get());
		
		
	}}



