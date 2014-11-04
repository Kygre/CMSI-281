package lmu.cmsi.Collections.Implements;

public class Node<E> {

	private E e;
	
	private Node<E> next;
	
	

	// only value -- no next
	public Node(E value){
		this.e = value;
		
	}
	public Node(E value, Node<E> next) {
		super();
		this.e = value;
		this.next = next;
	}
	
	
	
	// return true if hasNext node
	public boolean hasNext(){
		return next != null;
	}
	/**
	 * @return the e
	 */
	public E getValue() {
		return e;
	}
	/**
	 * @param e the e to set
	 */
	public void setE(E e) {
		this.e = e;
	}
	/**
	 * @return the next node
	 */
	public Node<E> getNext() {
		return next;
	}
	/**
	 * @param Set the next node of this node
	 */
	public void setNext(Node<E> next) {
		this.next = next;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String value, nextNode;
		if(e != null){
			value = e.toString();
		}
		else{
			value = "NULL";
		}
		
		
		if(next != null){
			nextNode = "NODE";
			
		}
		else{
			nextNode = "NULL";
		}
		
		return value + " : " + nextNode;

	}

	
	
	
	
}
