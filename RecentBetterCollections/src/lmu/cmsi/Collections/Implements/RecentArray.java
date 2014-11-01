package lmu.cmsi.Collections.Implements;

import java.util.Iterator;

import lmu.cmsi.Collections.Interface.Framework;

public class RecentArray<E> implements Iterable<E>, Framework<E> {


	private E bin[];
	private int index;


	public static void main(String[] args){

	}

	@SuppressWarnings("unchecked")
	public RecentArray(int max) {
		super();

		this.index = 0;

		if(max > 0){

			try {
				this.bin = ((E[]) new Object[max]);
			} catch (Exception e) {
				// Catch array initialize exceptions
				e.printStackTrace();
			}
		}
		else{
			throw new IllegalStateException(" Max size must be greater than zero ");
		}

	}

	@Override
	public E getOldest() {
		// TODO Auto-generated method stub
		return this.bin[this.getOldestIndex()];
	}

	// helper method to getOldestIndex
	private int getOldestIndex() {

		int size = this.getSize();

		int newest = this.getNewestIndex();

		if(size == 1){
			return 0;
		}
		else if(newest < this.bin.length){
			if(newest + 1 >= this.bin.length){
				return 0;
			}
			else{
				return newest + 1;
			}
		}
		else{
			throw new IllegalStateException("Newest is greater than bin length");
		}


	}

	@Override
	public E getNewest() {
		// TODO Auto-generated method stub


		return this.bin[this.getNewestIndex()];
	}

	private int getNewestIndex() {
		// TODO Auto-generated method stub

		int size = this.getSize();

		if(size > 0){
			if(size == 1 ){
				return 0;
			}
			else if( size >= this.bin.length){

				// has overlapped
				if(index > this.bin.length){
					return 0;
				}
				else{
					return index;
				}
			}
			else{

				return index;
			}
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


				if(index >= this.bin.length){
					this.index = 0;


				}

				this.bin[index] = e;
				index++;			


			}
			else{
				throw new IllegalArgumentException(" No null adding allowed! ");
			}
		}
		else{
			throw new IllegalStateException("Bin not initalized");
		}
	}


	// returns how many elemnts are in array
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		int count  = 0;

		for(E e : this.bin){
			if(e != null){
				count++;
			}
		}

		return count;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < this.bin.length; i++){
			this.bin[i] = null;
		}

		this.index = 0;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new RecentArrayIterator<E>(this.bin, this.index, this.getOldestIndex(), this.getNewestIndex());
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
