package com.revature.linkedlist.ds;

public abstract class LinkedList implements List {
	public Object currentNode;
	public Object headNode;
	
	public abstract Object nextNode();
	public abstract void add (Object obj, int index);
	
	@Override
	public void add (Object obj) {
		// TODO
	}
}
