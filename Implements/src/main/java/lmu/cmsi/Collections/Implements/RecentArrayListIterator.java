package lmu.cmsi.Collections.Implements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RecentArrayListIterator<E> implements Iterator<E> {

	
	
	private Iterator<E> iter;
	private int count;
	public RecentArrayListIterator(ArrayList<E> bin, int newestindex,
			int oldestindex) {
		
		this.count = 0;
		ArrayList<E> newbin = new ArrayList<E>(bin.size());
		if(oldestindex > newestindex){
			Iterator<E> iternew = bin.listIterator(newestindex + 1);
			while(iternew.hasNext()){
				newbin.add(iternew.next());
			}
			
			for(int i = 0; i <= newestindex; i++){
				newbin.add(bin.get(i));
			}
			iter = newbin.listIterator();
		}
		else{
			iter = bin.listIterator();
		}
		
		
		
	}

	

	@Override
	public boolean hasNext() {
		return iter.hasNext();
	}

	@Override
	public E next() {
		if(iter.hasNext()){
			return iter.next();
		}
		else{
			throw new NoSuchElementException("No element after");
		}
		
	}

}
