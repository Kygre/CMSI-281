package lmu.cmsi.Collections.Tests;

import static org.junit.Assert.fail;

import java.util.Iterator;

import lmu.cmsi.Collections.Implements.RecentArray;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RecentArrayTester {

	
	
	private int max = 4;
	private RecentArray<Integer> myl;
	
	
	@Rule
    public ExpectedException thrown= ExpectedException.none();

	
	@Before
	public void init_Collection(){
		myl = new RecentArray<Integer>(max);
	}
	
	
	// helper method to initalize myl to offset
	public void initTo(int offset){
		
		for(int i = 0; i < offset; i++){
				myl.add(i);
		}
	}
	
	@Test
	public void testRecentArrayNoZero() {
		thrown.expect(IllegalStateException.class);
		myl = new RecentArray<Integer>(0);
	}


	@Test
	public void testNoNullAdd() {
		thrown.expect(IllegalArgumentException.class);
		myl.add(null);
	}

	@Test
	public void testFewerNGetSize() {
		int target = 3 % max;
		
	
		initTo(target);	
		Assert.assertEquals(target, myl.getSize(),0);
	}

	@Test
	public void testMoreNGetSize() {
		int target = 13 % max;
		
	
		initTo(target);	
		Assert.assertEquals(target, myl.getSize(),0);
	}
	
	@Test
	public void testRecentArray() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAdd() {
		fail("Not yet implemented"); // TODO
	}


	@Test
	public void testIteratorLessN() {
		int target = max - 1;
		initTo(target);
		
		Iterator<Integer> iter = myl.iterator();
		
		int count = 0;
		while(iter.hasNext()){
			
			Assert.assertEquals(count, iter.next(), 0);
			
			count++;
		}
	}

	
	@Test
	public void testReset() {
		int target = max - 1;
		initTo(target);
		
		myl.reset();
		
		Assert.assertEquals(0, myl.getSize(),0);
	}
	

	

}
