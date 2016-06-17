package net.dzhai.demo.jdk.link;

import java.util.LinkedList;

public class Test {

	public static void main(String[] args) {

		Node node=new Node(0);;
		
		for(int i=1;i<10;i++){
			Node next=new Node(i);
			next.next=node.next;
			node.next=next;
		}
	}

	public static void reverse(Node phead, int from, int to) {
		
		Node pcur=phead.next;
		for(int i=0;i<from-1;i++){
			phead=pcur;
			pcur=pcur.next;
		}
		
	
		Node next=null;
		for(int i=0;i<to-from;i++){
			next=pcur;
			next.next=phead.next;
			phead.next=next;
			
			
		}
	}

}

class Node {

	int v;
	Node next;

	public Node(int v) {
		this.v = v;
		this.next = null;

	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
