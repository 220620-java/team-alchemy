package com.revature.arraylistapp.ds;

public interface List {
	public void add(Object obj);
	public Object get (int index);
	public Object remove (int index);
	public int indexOf (Object obj);
	
	public static void list() {
		System.out.println("Hello from list interface");
	}
}
