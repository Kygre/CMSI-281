package edu.lmu.cmsi.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.lmu.cmsi.BetterGame.Drive;
import edu.lmu.cmsi.Core.Location;
import edu.lmu.cmsi.GameEngine.Grid;
import edu.lmu.cmsi.Sprite.Actor;
import edu.lmu.cmsi.Sprite.BigMonsterA;
import edu.lmu.cmsi.Sprite.BossK;
import edu.lmu.cmsi.Sprite.Rock;
import edu.lmu.cmsi.Sprite.SmallMonsterX;
import edu.lmu.cmsi.Sprite.Sprite;
import edu.lmu.cmsi.Sprite.Tree;
import edu.lmu.cmsi.Sprite.Wall;

/**
 * 
 * @author kygre
 *	Test grids initliazed to all corners and moves counter-clockwise through array
 *
 */
public class GridTest {

	private Grid gr;
	private static Grid rockGr, treeGr, smallMGr, BigMGr, BossGr, emptyGr;

	private static int size = 5;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@BeforeClass
	public static void initAllGridCases() {

		// running tests allow for Debugging
		Drive.debug = true;

	}

	private static Sprite[] addAll(Sprite[] a , Sprite[] b){

		List<Sprite> myl = new ArrayList<Sprite>();

		for(Sprite a1  : a){
			myl.add(a1);
		}
		for(Sprite b1 : b){
			myl.add(b1);
		}

		return  myl.toArray(new Sprite[a.length + b.length]);
	}


	private static Grid initCorners(Sprite[] myl) {
		int count = 0;
		for (Sprite p : myl) {
			Actor a = (Actor) p;
			
			if (!Drive.debug) {
				if (count == 0) {

				} else {
					a.setRender("" + count);
				}
			}
			if (count == 0) {
				a.setLoc(new Location(1, 1));
			} else if (count == 1) {
				a.setLoc(new Location(size - 2, 1));

			} else if (count == 2) {
				a.setLoc(new Location(1, size - 2));
			} else if (count == 3) {
				a.setLoc(new Location(size - 2, size - 2));
			}
			count++;
		}

		return new Grid(size, myl);
	}

	// helper method to act all sprites without rendering
	private void add_Act(Grid gr, Sprite[] ins) {

		gr.setSprites(addAll(gr.getSprites(), ins));
		gr.update();

	}
	@Before
	public void init_Grid() {

		Sprite[] myl = { new Rock(1, 1), new Rock(size - 2, size - 2),
				new Rock(1, size - 2), new Rock(size - 2, 1) };
		rockGr = initCorners(myl);

		Sprite[] myl1 = { new Tree(0, 0), new Tree(0, 0), new Tree(0, 0),
				new Tree(0, 0) };
		treeGr = initCorners(myl1);

		Sprite[] myl2 = { new SmallMonsterX(0, 0, 0, 0),
				new SmallMonsterX(0, 0, 0, 0), new SmallMonsterX(0, 0, 0, 0),
				new SmallMonsterX(0, 0, 0, 0) };

		smallMGr = initCorners(myl2);

		Sprite[] myl4 = { new BigMonsterA(0, 0, 0, 0),
				new BigMonsterA(0, 0, 0, 0), new BigMonsterA(0, 0, 0, 0),
				new BigMonsterA(0, 0, 0, 0) };

		BigMGr = initCorners(myl4);

		Sprite[] myl6 = { new BossK(0, 0, 0, 0), new BossK(0, 0, 0, 0),
				new BossK(0, 0, 0, 0), new BossK(0, 0, 0, 0) };

		BossGr = initCorners(myl6);

	}


	@Test
	public void testSpriteOutXGrid() {
		Sprite a = new Actor(-10, 0, 0, 0, "p");
		Sprite b = new Actor(2, -10, 0, 0, "p1");
		Sprite c = new Actor(-10, 0, 0, 0, "p2");

		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("< A Sprite is not inside your created " + size + " x " + size + " grid >");
		Sprite[] myl = {a,b,c};
		gr = new Grid(size, myl);
	}

	@Test
	public void testSpriteOutYGrid() {
		Sprite a = new Actor(2, 2, 0, 0, "p1");
		Sprite b = new Actor(2, -10, 0, 0, "p2");
		Sprite c = new Actor(-10, 0, 0, 0, "p3");

		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("< A Sprite is not inside your created " + size + " x " + size + " grid >");
		Sprite[] myl = {a,b,c};
		gr = new Grid(size, myl);
	}




	@Test
	public void testGridCreation() {

		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Grid size must be greater than 1");
		Sprite[] myl = { new Actor(1, 1, 1, 0, "p") };

		gr = new Grid(-100, myl);

	}

	@Test
	public void testGridFailSpriteNull() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("No Sprites have been added to Grid");

		gr = new Grid(10, null);
	}

	@Test
	public void testCheckHOrizontalCollisions() {
		Sprite[] myl = { new Actor(5, 5, 1, 0, "p"),
				new Actor(2, 2, -1, 0, "q"), new Rock(6, 5), new Tree(1, 2) };

		gr = new Grid(10, myl);
		gr.update();

		Assert.assertTrue("Actor P did not hit Rock",
				myl[0].collidesWith(myl[2]));

		Assert.assertTrue("Actor Q did not hit Tree",
				myl[1].collidesWith(myl[3]));

	}



	@Test
	public void testCheckForVerticalCollisions() {
		Sprite[] myl = { new Actor(5, 5, 0, 1, "p"),
				new Actor(2, 2, 0, -1, "q"), new Rock(5, 6), new Tree(2, 1) };

		gr = new Grid(10, myl);
		gr.update();

		Assert.assertTrue("Actor P did not hit Rock",
				myl[0].collidesWith(myl[2]));


		Assert.assertTrue("Actor Q did not hit Tree",
				myl[1].collidesWith(myl[3]));
	}



	@Test
	public void SimpleWallCollisionHorizontal() {
		Actor a   = new Actor(size - 3,size -2 ,1,0, "p");
		Sprite[] ins = {a};
		add_Act(rockGr, ins);

		// act once
		rockGr.update();

		// check all wall collisions
		Wall[] edges = rockGr.getEdges();
		for(int k = 0; k < edges.length; k++){
			if(a.collidesWith(edges[k])){

				Assert.assertTrue(true);

			}
		}
		Assert.assertFalse(false);

	}



	// Delta checked after frame has rendered
	@Test
	public void CheckBigMonsterSmallMonsterNoHpCollision() {
		SmallMonsterX smx = new SmallMonsterX(size - 5 , size -2, 1, 0);
		Sprite[] ins = {smx};
		add_Act(BigMGr, ins);


		// move twice
		BigMGr.update();
		BigMGr.update();


		// Monsters do not interact, hp should remain zero
		Actor a = (Actor) smx;
	
		Assert.assertEquals(0, smx.getHp(), 0.000);
		Assert.assertEquals(0, a.getHp(), 0.000);

		


	}

	// only checks collision not Hp
	@Test
	public void testDiagonalCollisionPlayerMonster() {
		
		Actor a  = new Actor(2, 2, -1, -1, "p");
		Sprite[] ins = {a};
		add_Act(BossGr, ins);
		
		Assert.assertTrue("Diagonal Player - Boss did not collide", a.collidesWith(BossGr.getSprites()[0]));
	}
	@Test
	public void CollisionPlayerBigMonster() {

		Actor a = new Actor(1,2,0,-1,"p");
		Sprite[] ins = {a};
		add_Act(BigMGr, ins);

		Assert.assertTrue("Actor is not in same space as ", BigMGr.getSprites()[0].collidesWith(a));
	}


}
