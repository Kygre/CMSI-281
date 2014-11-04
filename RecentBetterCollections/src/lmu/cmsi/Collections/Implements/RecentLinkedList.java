package lmu.cmsi.Collections.Implements;

import java.util.Collections;
import java.util.Iterator;

import lmu.cmsi.Collections.Interface.Framework;

public class RecentLinkedList<E> implements Framework<E>, Iterable<E> {


	public Node<E> head;
	public Node<E> current;

	public int index;
	public int max;

	public static void main(String[] args) {
		int max = 4;
		int offset = 4;
		RecentLinkedList<Integer> myl = new RecentLinkedList<>(max);

		for(int i = 0; i <= max + offset; i++){
			myl.add(i);

		}

		myl.printCollection();
		System.out.println(myl.getSize());
	}



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

			return new RecentLinkedListIterator<E>(this.head, this.current);

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
		else{

			Node<E> temphead = head;
			Node<E> newest =  (Node<E>) new Node<E>( this.getNewest());
			Node<E> prevtemp = null;


			while(!temphead.equals(newest)){


				if(temphead.hasNext()){
					prevtemp = temphead;	
					temphead = temphead.getNext();
				}
				else{
					break;
				}
			}

			return prevtemp.getValue();
		}


	}

	@Override
	public E getNewest() {

		int size = this.getSize();

		if(size == 1){
			return head.getValue();
		}
		else{
			return current.getValue();		
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
				head = next;
			}
			else if(head == null){
				head = next;
				current = head;
				index++;


			}
			else{



				System.out.println("index - "+index);
				if(index >= max ){

					System.out.println(index + " >= " + max);
					
					if(current.hasNext()){
						
						System.out.println("CURRENT " + current.getValue());
						System.out.println("CURRENT NEXT " + current.getNext().getValue());
						current.setNext(next);
						current = next;

						System.out.println(current.toString());
					}
					else{
						
						index = 0;
						
						this.printCollection();
						
						current = next;
						current.setNext(head.getNext());
						head = current;
						
						//current = head.getNext();
						this.printCollection();
					}

				}
				else{

					this.printCollection();



					
					try {
						System.out.println(current.getNext().getValue());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}

					if(!current.hasNext()){

						current.setNext(next);
						current = next;
					}
					else{

						Node<E> nextNext = null;


						if(current.getNext().hasNext()){
							nextNext = current.getNext().getNext();	
						}
						




						if(nextNext != null){

							current.setNext(next);
							next.setNext(nextNext);
							current = next;
						}

					}

					System.out.println("CURRENT " + current.getValue());

				}


				index++;


			}


		}
		else{
			throw new IllegalArgumentException("No null adding allowed");
		}

	}


	private void printNode(Node<E> current2) {

		System.out.print(current2.getValue());
		if(current2.hasNext()){

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
