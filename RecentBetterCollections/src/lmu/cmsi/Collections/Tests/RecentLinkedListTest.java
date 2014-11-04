package lmu.cmsi.Collections.Tests;

import java.util.Iterator;

import lmu.cmsi.Collections.Implements.Node;
import lmu.cmsi.Collections.Implements.RecentLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RecentLinkedListTest {



	private int max = 4;
	private RecentLinkedList< Integer> myl;


	@Rule
	public ExpectedException thrown= ExpectedException.none();


	@Before
	public void init_Collection(){
		myl = new RecentLinkedList<Integer>(max);
	}


	// helper method to initalize myl to offset
	public void initTo(int offset){

		for(int i = 0; i < offset; i++){
			myl.add(i);
		}
	}


	@Test
	public void FewerNgetOld() {
		int offset = 2;
		int target = max - offset;

		initTo(target);

		Assert.assertEquals(0, myl.getOldest(), 0);
	}

	@Test
	public void MoreNGetOld() {
		int offset = 3;
		int target = max + offset;

		initTo(target);
		myl.printCollection();
		Assert.assertEquals(3, myl.getOldest(), 0);
	}

	@Test
	public void fewerNGetNew() {
		int offset = 2;
		int target = max - offset;

		initTo(target);


		Assert.assertEquals(1, myl.getNewest(), 0);
	}

	@Test
	public void MoreNGetNew() {
		int offset = 14;
		int target = max + offset;

		initTo(target);

		Assert.assertEquals(max + offset - 1, myl.getNewest(), 0.0);

	}

	@Test
	public void testRecentArrayNoZero() {
		thrown.expect(IllegalStateException.class);
		myl = new RecentLinkedList<Integer>(0);
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

		// target == 1
		initTo(target);	

		Assert.assertEquals(target, myl.getSize(),0);
	}


	@Test
	public void testAdd() {
		int target = 1;
		initTo(target);

		Assert.assertEquals(target - 1, myl.getNewest(), 0.0);
	}


	@Test
	public void testIteratorLessN() {
		int target = max - 1;
		initTo(target);


		int count = 0;




		Iterator<Integer> iter = myl.iterator();

		while(iter.hasNext()){
			Integer i = iter.next();
			if(count == target){

				Assert.assertTrue(i == null);
			}
			else{
				Assert.assertEquals(count, i, 0);

			}
			count++;
		}
	}

	@Test
	public void testIteratorMoreN() {

		int target = max + 3;
		initTo(target);

		Integer[] myints = new Integer[max];
		int count = 3;
		for(int i = 0; i < max;i++){
			myints[i] = count;
			count++;

		}

		count = 0;
		
		Iterator<Integer> iter = myl.iterator();
		
		
		while(iter.hasNext()){
		
			Integer i = iter.next();
			Assert.assertEquals(myints[count], i, 0.0);
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
