package lmu.cmsi.Collections.Implements;

import java.util.Arrays;
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
	public RecentArrayIterator(E[] bin, int index, int oldestindex,
			int newestindex) {

		if(oldestindex > newestindex){
			bin = doSomethingSpecial(this.bin, index, oldestindex, newestindex);
		}


		this.index = 0;
		this.bin = bin;

	}

	// oldest > newest
	@SuppressWarnings("unchecked")
	private E[] doSomethingSpecial(E[] bin2, int index2, int oldestindex,
			int newestindex) {
		E[] newbin = ((E[]) new Object[bin2.length]);

		for(int i = oldestindex; i < bin2.length; i++){
			newbin[i] = bin2[i];
		}

		for(int i = 0 ; i <= newestindex; i++){
			newbin[i] = bin2[i];
		}

		return newbin;




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
