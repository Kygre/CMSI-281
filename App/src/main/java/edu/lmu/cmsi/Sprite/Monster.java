package edu.lmu.cmsi.Sprite;

public abstract class Monster extends Actor {

	private double hitPercentage;
	public Monster(int x, int y, int dx, int dy, String id, double hitPercentage) {
		super(x, y, dx, dy, id);

		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the hitPercentage
	 */
	public double getHitPercentage() {
		return hitPercentage;
	}

	// all monsters only collide with actors and not other monsters




}
