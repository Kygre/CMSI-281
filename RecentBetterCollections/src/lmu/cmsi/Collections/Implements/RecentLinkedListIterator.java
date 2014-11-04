package lmu.cmsi.Collections.Implements;

import java.util.Iterator;

public class RecentLinkedListIterator<E> implements Iterator<E> {

	
	private Node<E> head;
	private Node<E> current;
	
	
	public RecentLinkedListIterator(Node<E> head, Node<E> current) {
		super();
		
		
		
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public E next() {
		return null;
	}

}
