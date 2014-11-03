package lmu.cmsi.Collections.Implements;

import java.util.Iterator;

/**
 * 
 * @author Kwadwo Yeboah
 * Represents the iterator for RecentArray
 * iterates from oldest to newest
 *
 * @param <E>
 */
public class RecentArrayIterator<E> implements Iterator<E> {

	private E[] bin;
	private int index;


	// size must be greater than zero
	public RecentArrayIterator(E[] bin, int oldestindex,
			int newestindex) {

		if(oldestindex > newestindex){
			bin = doSomethingSpecial(bin, oldestindex, newestindex);
		}

		
		this.index = 0;
		this.bin = bin;
		
		
		

	}

	// oldest > newest
	@SuppressWarnings("unchecked")
	private E[] doSomethingSpecial(E[] bin2, int oldestindex, int newestindex) {
		E[] newbin = ((E[]) new Object[bin2.length]);

		int count = 0;
		for(int i = oldestindex; i < bin2.length; i++){
			newbin[count] = bin2[i];
			count++;
		}

		for(int i = 0 ; i <= newestindex; i++){
			newbin[count] = bin2[i];
			count++;
		}

		return newbin;




	}
	
	// prints this iterator from index 0
	public void printIteration(){
		
		for(E e : this.bin){
			if(e != null){
				
				System.out.print(e.toString() + " :");
			}
			else{
				System.out.print( "NULL :");
			}
		}
		
		System.out.println();
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub

		return this.index < this.bin.length;
	}

	@Override
	public E next() {
		// TODO Auto-generated method stub
		if(this.hasNext()){
			E next = this.bin[index];
			index++;
			
			return next;
		}
		else{
			throw new IndexOutOfBoundsException("There is no next");
		}
	}

}
