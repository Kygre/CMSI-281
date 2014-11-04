package lmu.cmsi.Collections.Implements;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * 
 * @author Kwadwo Yeboah
 * Iterator for linkedlist that starts from oldest to newest
 *
 * @param <E>
 */
public class RecentLinkedListIterator<E> implements Iterator<E> {


	private Node<E> head, staticHead;
	private int oldest, newest;
	private Node<E> current;


	
	public RecentLinkedListIterator(RecentLinkedList<E> myl) {
		// TODO Auto-generated constructor stub
		this.head = myl.head;
		this.oldest = myl.getOldestIndex();
		this.newest = myl.getNewestIndex();

		this.staticHead = myl.head;
		// move to oldest


		Node<E> temphead = this.head;
		for(int i = 0; i < this.oldest && temphead.hasNext(); i++){

			temphead = 	temphead.getNext();
		}

		this.head = temphead;
	}


	@Override
	public boolean hasNext() {
		// set back to head - special case of oldest index at end
		if(current == null && oldest != newest){
			return staticHead.hasNext();
		}
		if(oldest != newest && current.hasNext()){
			return current.hasNext();
		}
		else if(oldest != newest && !(current.hasNext())){
			return true;
		}
		else if(oldest == newest){
			return false;
		}
		else{
			return false;
		}
		
	}

	@Override
	public E next() {
		if(current == null){
			current = head;
			return (E) current.getValue();
		}
		else{

			if(oldest != newest && current.hasNext()){

				E e = (E) current.getNext().getValue();

				this.current = current.getNext();

				oldest++;
				return e;
			}
			else if(oldest != newest && !(current.hasNext())){
				
				this.current = this.staticHead;
				oldest = 0;
				return current.getValue();
			}
			else if(oldest == newest){
				return null;
			}
			else{
				throw new NoSuchElementException("No more elements exist");

			}
		}

	}

}
