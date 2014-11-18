package edu.lmu.cmsi.GameEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;

import edu.lmu.cmsi.BetterGame.Drive;
import edu.lmu.cmsi.Sprite.Actor;
import edu.lmu.cmsi.Sprite.Rock;
import edu.lmu.cmsi.Sprite.Sprite;
import edu.lmu.cmsi.Sprite.Tree;
import edu.lmu.cmsi.Sprite.Wall;

/**
 * 
 * @author kygre
 *	Represents grid of sprites
 *	At this level all Sprites will be error checked 
 */
public class Grid {

	private int frame;
	private int size;
	private Wall[] edges;
	private Sprite[] sprites;


	public Grid(int size, Sprite[] sprites){
		if(size  < 1){
			throw new IllegalArgumentException("Grid size must be greater than 1");
		}
		this.frame = 0;
		this.size = size;

		this.initWalls();

		// if sprites is null throws IllegalArgumentException
		this.sprites = error_check(size, sprites);


	}

	private Sprite[] error_check(int size, Sprite[] sprites) {


		if(sprites != null){

			// check for nulls
			for(Sprite p : sprites){
				if(p == null){
					throw new NullPointerException("A sprite is null in sprites");
				}
			}

			// outside of grid
			for(Sprite p : sprites){
				if(p.getLoc().getX() < 0 || p.getLoc().getX() >= size
						|| p.getLoc().getY() < 0 || p.getLoc().getY() >= size){
					throw new IllegalArgumentException("< A Sprite is not inside your created " + size + " x " + size + " grid >");
				}

			}

			// check for same sprites at location 

			for(int i = 0; i < sprites.length; i++){

				for(int j = i + 1 ; j <= sprites.length -1; j++){
					if(sprites[i].getLoc().equals(sprites[j].getLoc())){
						throw new IllegalArgumentException("<Two or more sprites occupy same Location!\n" + sprites[i].toString() + " -- "  + sprites[j].toString() + " >"); 
					}
					// Debug mode allowed duplicates for simplicity
					else if(!Drive.debug) {
						if (sprites[i].getRender().equals(sprites[j].getRender())) {

							throw new IllegalStateException("<Two or more sprites have the same Render character >");
						}
					}

				}
			}
			// two or more sprites occupy same area
			return sprites;
		}
		else{
			throw new IllegalArgumentException("No Sprites have been added to Grid since array is null");
		}
	}



	public void update() {
		this.frame++;


		this.updateSprites();
		this.render();
		this.checkCollisions();

		printSprites();
	}

	// helper method to print Sprites
	private void printSprites() {
		System.out.println();
		// update Game Screen with information on Actors
		for(Sprite p : sprites){
			if(!(p instanceof Rock || p instanceof Tree)){
				Actor a = (Actor) p;

				System.out.println(a.getClass().getSimpleName() + " " + a.toString());
			}
		}

		System.out.println("=========================");
	}

	// Inside grid checks made in driver
	public void render() {
		// TODO Auto-generated method stub
		String[][] grid = new String[this.size][this.size];


		for(int i = 0 ; i < this.edges.length; i++){
			Wall w = this.edges[i];
			grid[w.getLoc().getY()][w.getLoc().getX()] = w.getRender();
		}

		if(sprites != null){
			for(Sprite p : sprites){

				grid[p.getLoc().getY()][p.getLoc().getX()] = p.getRender();


			}
		}


		System.out.println("=========================");
		System.out.println("Frame: " + this.frame);  

		for(int i = 0; i < grid.length; i++){

			for(int j = 0 ; j < grid[i].length; j++){
				String w = grid[i][j];

				if(w == null){
					w = ".";
				}

				System.out.print(w + " ");
			}
			System.out.println("");
		}



	}

	// update all sprites and calls them to act
	public void updateSprites() {
		// TODO Auto-generated method stub
		for(Sprite p : sprites){
			p.act();
		}

	}

	/**
	 * Checks all instances of Actors -> only those that can move.
	 */
	public void checkCollisions() {

		ArrayList<Actor> myl = getActors();

		while(myl.size() > 0){
			Actor a = myl.get(0);
			for(Wall w : edges){

				if(a.collidesWith(w)){

					a.CollideItWith(w);
				}
			}	

			for(Actor b : myl){
				if(!(a.equalsLoc(b))){
					if(a.collidesWith(b)){
						PrintCollisionSucesss(a, b);
						a.CollideItWith(b);
					}
				}
			}
			myl.remove(0);
		}

	}


	// returns Sprites as Actors
	private ArrayList<Actor> getActors() {
		// TODO Auto-generated method stub
		ArrayList<Actor> myl = new ArrayList<Actor>();

		for(Sprite p : sprites){
			if(p instanceof Actor){
				myl.add((Actor) p);
			}
		}
		return myl;
	}
	// helper method to print Collisions and increase cleanlieness
	private void PrintCollisionSucesss(Sprite collider, Sprite collidee){
		System.out.println("< " + collider.getClass().getSimpleName()+ " "+ collider.getRender() + " -- Hit -- " 
				+ collidee.getClass().getSimpleName() +" "
				+ collidee.getRender() +  " > ");
	}

	private void PrintCollisionFail(Sprite collider, Sprite collidee){
		System.out.println("< " + collider.getClass().getSimpleName() + " "+ collider.getRender() + " --  Missed -- " 
				+ collidee.getClass().getSimpleName() +" "
				+ collidee.getRender() +  " > ");
	}



	// generates Walls for grid
	private void initWalls() {
		// TODO Auto-generated method stub
		int wallCount = 0;
		this.edges = new Wall[this.size * 4 - 4];

		for (int x = 0; x < this.size; x++) {
			Wall x1 = new Wall(x, 0);
			edges[wallCount++] = x1;
			Wall x2 = new Wall(x, this.size - 1);
			edges[wallCount++] = x2;
		}

		for (int y = 1; y < size - 1; y++) {
			Wall y1 = new Wall(0, y);
			edges[wallCount++] = y1;
			Wall y2 = new Wall(this.size - 1, y);
			edges[wallCount++] = y2;
		}

	}
	/**
	 * 	* DISCLAIMER: This is only used for testing purposes in debug mode
	 * @param sprites the sprites to addSprites to the end of this sprite array.
	 * It should not be used for regular instantiation
	 */
	public void setSprites(Sprite[] soda) {

		if(Drive.debug){
			this.sprites = soda;
		}


	}




	public Sprite[] getSprites(){
		return this.sprites;
	}
	/**
	 * @return the edges
	 */
	public Wall[] getEdges() {
		return edges;
	}




}
