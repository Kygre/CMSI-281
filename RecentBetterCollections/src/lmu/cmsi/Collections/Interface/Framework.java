package lmu.cmsi.Collections.Interface;

public interface Framework<E> {
	
	
	public E getOldest();
	
	public E getNewest();
	
	public void add(E e);
	
	public int getSize();
	
	public void reset(); 
}
