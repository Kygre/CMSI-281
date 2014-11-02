package lmu.cmsi.Collections.Tests;

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
	public void FewerNgetOld() {
		int target = max -2;
		
		initTo(target);
		
		
		
	}

	@Test
	public void MoreNGetOld() {

	}

	@Test
	public void fewerNGetNew() {

	}

	public void MoreNGetNew() {

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

		
		
		
		for(Integer i : myl){

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
		

		int count = 0;
		
		
		
		Integer[] myints = new Integer[max];
		for(int i = 0; i < max -1;i++){
			myints[i] = max + i;
			
		}
		
		myints[max - 1] = max - 1;
		
		
		for(Integer g : myl){
			Assert.assertEquals(myints[count], g,0);
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
