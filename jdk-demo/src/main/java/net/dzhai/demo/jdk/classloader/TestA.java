package net.dzhai.demo.jdk.classloader;

public class TestA {

	public static void main(String[] args) throws Exception {
		
		TestA a=new TestA();
		a.doSomething("A");
		
		//通过类加载创建对象实例
		TestA b =(TestA) Class.forName("net.dzhai.demo.jdk.classloader.TestA", false, TestA.class.getClassLoader()).newInstance();	
		b.doSomething("B");
	
	}
	
	
	
	public void doSomething(String name){
		
		System.out.println("do something "+name);
	}
	
}
