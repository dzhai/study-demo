package net.dzhai.demo.jdk.juc.atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class AtomicReferenceFieldUpdaterTest {

	public static AtomicReferenceFieldUpdater<User, String> updater = AtomicReferenceFieldUpdater
			.newUpdater(User.class, String.class, "name");

	public static void main(String[] args) {
		User user = new User("zhangsan", 12);
		updater.compareAndSet(user, user.getName(), "lisi");

		System.out.println(user.getName());
	}

}

class User {
	public volatile String name;
	
	public int old;

	public User() {

	}

	public User(String name, int old) {
		this.name = name;
		this.old = old;
	}

	public String getName() {
		return name;
	}

	public int getOld() {
		return old;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOld(int old) {
		this.old = old;
	}

}