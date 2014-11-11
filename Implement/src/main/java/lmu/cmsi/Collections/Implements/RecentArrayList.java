package lmu.cmsi.Collections.Implements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import lmu.cmsi.Collections.Interface.Framework;

/**
 * 
 * @author Kwadwo Yeboah
 * Represent arraylist version of RecentArray with n sized list
 *
 * @param <E>
 */
public class RecentArrayList<E> implements Iterable<E>, Framework<E> {


	private ArrayList<E> bin;
	private int index;
	private int max;


	
	public RecentArrayList(int n) {
		super();

		if(n > 0){
			this.bin = new ArrayList<E>(n);

			for(int i = 0; i < n; i++){
				this.bin.add(null);
			}
		}
		else{
			throw new IllegalStateException(" Max size must be greater than zero ");	
		}

		
		this.max = n;
		this.index = max;
	}

	@Override
	public E getOldest() {
		// TODO Auto-generated method stub


		return this.bin.get(this.getOldestIndex());
	}

	@Override
	public E getNewest() {
		// TODO Auto-generated method stub
		return this.bin.get(this.getNewestIndex());
	}

	private int getOldestIndex() {

		int size = this.getSize();

		int newest = this.getNewestIndex();


		if(size == 1 ||  this.bin.get(max -1) == null || newest + 1 >= max){

			return 0;

		}
		else if(newest + 1 < max){
			return newest + 1;
		}
		else{
			throw new IllegalStateException("Newest is greater than bin length");
		}


	}

	private int getNewestIndex() {
		// TODO Auto-generated method stub

		int size = this.getSize();

		if(size > 0){	

			return index;

		}
		else{
			throw new IllegalStateException("Nothing has been added yet!");
		}

	}


	@Override
	public void add(E e) {
		// TODO Auto-generated method stub
		if(this.bin != null){
			if(e != null){


				index++;		

				if(index >= max){
					this.index = 0;
				}

			
				this.bin.set(index, e);


			}
			else{
				throw new IllegalArgumentException(" No null adding allowed! ");
			}
		}
		else{
			throw new IllegalStateException("Bin not initalized");
		}
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		int count = 0;
		for(E i : this.bin){

			if(i != null){
				count++;
			}
		}
		return count;

	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

		this.bin.clear();
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		if(this.getSize() > 0){
			return new RecentArrayListIterator<E>(this.bin, this.getNewestIndex(), this.getOldestIndex());
		}
		else{
			return Collections.emptyIterator();
		}
	}

	public String printCollection() {
		// TODO Auto-generated method stub
		String s = "< ";
		for(E e : this.bin){
			if(e == null){
				s += " NULL :";
			}
			else{
				s += " " + e.toString() + " :";
			}
		}

		s += " >";
		return s;
	}

}
