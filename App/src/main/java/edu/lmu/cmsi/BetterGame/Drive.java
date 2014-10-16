package edu.lmu.cmsi.BetterGame;

import java.util.Scanner;

import edu.lmu.cmsi.GameEngine.Grid;
import edu.lmu.cmsi.Sprite.Actor;
import edu.lmu.cmsi.Sprite.BossK;
import edu.lmu.cmsi.Sprite.Rock;
import edu.lmu.cmsi.Sprite.SmallMonsterZ;
import edu.lmu.cmsi.Sprite.Sprite;
import edu.lmu.cmsi.Sprite.Tree;

/**
 * 
 * @author kygre Interprets command line input and manages game engine Debug
 *         boolean should translate to more verbose printing to console and
 *         permit more control over grid Debug status is set on for GridTesting
 */
public class Drive {

	private Grid grid;
	private Scanner keyboard = null;
	public static boolean debug = true;

	public static void main(String[] args) {

		
		int size = 10;

		// Input all actors  here
		Sprite[] myl = { new Actor(size - 6, size - 3, -1, -1, "p"),
				new Rock(5, 5), new Tree(7, 2),new Tree(2, 1),
				new SmallMonsterZ(2, size - 4, 0, 1),
				new BossK(size - 2, 6, 1, 0) };

		
		// init grid
		Drive dr = new Drive(size, myl);
		
	}

	public Drive(int size, Sprite[] spr) {

		System.out.println("Welcome to BetterGame");
		System.out.println("Commands are: [N]ext frame or [Q]uit");
		this.keyboard = new Scanner(System.in);

		Sprite[] myl = null;
		if (spr != null) {

			myl = spr;
		}

		this.grid = new Grid(size, myl);

			run();


	}

	public void run() {

		String input = this.getInput();

		while (!input.equals("q")) {
			if (input.equals("n")) {
				this.grid.update();
			}

			input = this.getInput();
		}

	}

	// helper method to autorun game
	private void autoRun() {

		while (true) {
			long millis = System.currentTimeMillis();
			// code to run

			this.grid.update();
			try {
				Thread.sleep(1000 - millis % 1000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}// While
	}

	/*
	 * Returns the lower case String of the keyboard input
	 */
	private String getInput() {
		return this.keyboard.next().toLowerCase();
	}

}
