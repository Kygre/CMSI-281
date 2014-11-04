package lmu.cmsi.Collections.Implements;

import java.util.Collections;
import java.util.Iterator;

import lmu.cmsi.Collections.Interface.Framework;

/**
 * 
 * @author Kwadwo Yeboah
 * Linked List allocation of a RecentCollection
 *
 * @param <E>
 */
public class RecentLinkedList<E> implements Framework<E>, Iterable<E> {


	public Node<E> head;
	public Node<E> current;

	public int index;
	public int max;

	public static void main(String[] args) {


		int max = 4;
		int offset = 2;

		RecentLinkedList<Integer> myl = new RecentLinkedList<Integer>(max);

		for(int i = 0 ; i < max + offset; i++){
			myl.add(i);
		}
		myl.printCollection();
System.out.println(myl.getOldestIndex());
		System.out.println(myl.getOldest());
	}



	// allow only up to max elements
	public RecentLinkedList(int max) {
		super();

		if(max > 0){

			this.index = 0;
			this.max = max;
			//init_NodeLinks(max);
		}
		else{
			throw new IllegalStateException(" Max size must be greater than zero ");
		}

		this.max = max;

	}



	// prints this collection
	public void printCollection(){
		if(head != null){
			String s = "< ";

			Node<E> temp = head;

			if(!head.hasNext()){
				s += head.getValue() + " :";
				System.out.println(s);
			}
			else{

				while(temp.hasNext()){

					if(temp.getValue() != null){
						s += temp.getValue() + " : ";
					}
					else{
						s += " NULL : ";
					}
					temp = temp.getNext();
				}

				System.out.println(s + temp.getValue() +" >");
			}

		}

	}

	@Override
	public Iterator<E> iterator() {


		if(this.getSize() > 0){


			return new RecentLinkedListIterator<E>(this);

		}
		else{
			return Collections.emptyIterator();
		}
	}

	@Override
	public E getOldest() {

		int size = this.getSize();

		if(size == 1){
			return head.getValue();
		}
		else if(size < max){
			return head.getValue();
		}
		else{

			Node<E> temphead = head;

			int newest = this.getNewestIndex();
			if(newest == max - 1){
				// do nothing
				// already at head
			}
			else{

				for(int i = 0 ; i <= newest && temphead.hasNext(); i++){


					temphead = temphead.getNext();
				}
			}

			return temphead.getValue();
		}


	}

	// helper method for iterator
	public int getOldestIndex(){
		int size = this.getSize();

		int count = 0;
		if(size == 1){
			return count;
		}
		else if(size < max){
			return count;
		}
		else{

			Node<E> temphead = head;

			int newest = this.getNewestIndex();

			if(newest == max - 1){
				// do nothing
				// already at head
				return count;
			}
			else{

				
				for(int i = 0 ; i <= newest && temphead.hasNext(); i++){


					++count;
				}
				return count;




			}
		}
	}
	@Override
	public E getNewest() {

		int size = this.getSize();

		if(size == 1){
			return head.getValue();
		}
		else{
			Node<E> temphead = this.head;
			int offset = 0;

			if(size < max){
				offset = index;
			}
			else{
				offset = index - 1;
			}
			for(int i = 0; i <= offset && temphead.hasNext(); i++){

				temphead = temphead.getNext();

			}


			return temphead.getValue();		
		}


	}




	// helper method for  setting iterator
	public int getNewestIndex(){
		int size = this.getSize();

		if(size == 1){
			return 0;
		}
		else{

			int offset = 0;

			if(size < max){
				offset = index + 1;
			}
			else{
				offset = index ;
			}

			return offset;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(E e) {


		if(e != null){



			Node<E> next = null;
			if((e instanceof Node<?>)){

				next = (Node<E>) e;

			}
			else{
				next = new Node<E>(e);
			}




			if(max == 1){
				this.head = next;
			}
			else if(head == null){
				this.head = next;

			}
			else{

				Node<E> temphead = this.head;
				int size = this.getSize();
				if(index < max - 1){

					if(size == max){
						Node<E> saveprevious = null;

						for(int i = 0; i <= index && temphead.hasNext(); i++){
							saveprevious = temphead;
							temphead = temphead.getNext();

						}

						next.setNext(temphead.getNext());
						saveprevious.setNext(next);
						index++;

					}
					else{

						for(int i = 0; i < max  && temphead.hasNext(); i++){
							index++;
							temphead = temphead.getNext();

						}


						temphead.setNext(next);


					}
				}
				else{
					next.setNext(this.head.getNext());
					this.head = next;
					this.index = 0;
				}


			}



		}
		else{
			throw new IllegalArgumentException("No null adding allowed");
		}

	}




	// prints from this node previous to end of nodeList
	public void printNodeList(Node<E> node){
		String s = "< ";
		Node<E> node1 = node;
		while(node1.hasNext()){

			s += node1.getValue() + ": ";
			node1 = node1.getNext();
		}

		s += " >";

		System.out.println(s);
	}
	@Override
	public int getSize() {
		int count = 0;

		Node<E> temp = head;

		if(temp == null){
			return 0;
		}


		while(temp.hasNext()){

			if(temp.getValue() != null){
				count++;
			}
			temp = temp.getNext();

		}

		return ++count;
	}

	@Override
	public void reset() {

		head = null;
		current = null;
		this.index = 0;

	}

}
