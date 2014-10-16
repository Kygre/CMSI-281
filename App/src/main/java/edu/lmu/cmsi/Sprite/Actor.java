package edu.lmu.cmsi.Sprite;

import edu.lmu.cmsi.Core.Displacement;
import edu.lmu.cmsi.Core.Location;

/**
 * 
 * @author kygre
 * Extends Sprite and adds functionality for hp 
 */
public class Actor extends Sprite  {

	private int hp;
	private Displacement delta;
	public Actor(int x, int y,int dx, int dy, String id) {
		super(x, y, id);
		
		if(dx > 1 || dx < -1 || dy > 1 || dy < -1){
			// only support one block movement
			throw new IllegalArgumentException("< Sprite has delta displacement greater than 1! >");
		}
		else{
			this.delta = new Displacement(dx, dy);
			
			this.hp = 0;
		}
		
	}

	// set new Location using Sprite location and delta movement
	public void act() {
		// TODO Auto-generated method stub
		Location loc = super.getLoc();
		loc.setX(loc.getX() + delta.getDx());
		loc.setY(loc.getY() + delta.getDy());
		
	}
	
	// collide this sprite against sprite p
	public void CollideItWith(Sprite sprite1){
		
	
		Actor sprite = (Actor) sprite1;
		if(sprite != null){
			
			if(sprite instanceof Tree || sprite instanceof Rock || sprite instanceof Wall){
				this.deltaReverse();
			}
			else{
				// is a monster - try cast to Monster
				try {
					this.hit((Monster) sprite);
				} catch (Exception e) {
					// Suppressed Exception until fixed
					
				//	e.printStackTrace();
				}
				
			}
		
		}
		else{
			throw new IllegalStateException("Actor collides with null < NOT ALLOWED > ");
		}
	}
	
	// Determines whether Actor player hits a monster
	private void hit(Monster sprite) {
		// TODO Auto-generated method stub
		if(sprite instanceof SmallMonsterX ||  sprite instanceof SmallMonsterZ){
			sprite.Hit(Math.random() <= 0.50);
		}
		else if(sprite instanceof BigMonsterA || sprite instanceof BigMonsterS){
			sprite.Hit(Math.random() <= 0.50);
		}
		else if(sprite instanceof BossK || sprite instanceof BossO){
			sprite.Hit(Math.random() <= 0.30);
		}
		else{
			throw new IllegalArgumentException("Sprite instance not found");
		}
	}

	// helper method to invert delta and increase cleanliness
	public void deltaReverse(){
		this.delta.invert();
	}
	
	// helper method to add one to hp
	
	public void Hit(){
		
		this.hp++;
	}
	

	/**
	 * @return this Actor's hp
	 */
	public int getHp() {
		return hp;
	}



	/**
	 * @return the delta
	 */
	public Displacement getDelta() {
		return delta;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + " hp = " + hp + ", delta = "  + delta;
	}

	public void Hit(boolean b) {
		// TODO Auto-generated method stub
		if(b){
			this.hp++;
		}
	}
	
	




}
