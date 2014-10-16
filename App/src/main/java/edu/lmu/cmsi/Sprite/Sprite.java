package edu.lmu.cmsi.Sprite;

import edu.lmu.cmsi.BetterGame.Drive;
import edu.lmu.cmsi.Core.Location;

/**
 * 
 * @author kygre
 *	Represents the base class all objects that interact with the game engines
 *	Sprite cannot move using act, only be displayed on screen
 *
 * 	 Any sprite can be created so as long as it passes constructor
 * 	Error checking on all sprites occurs in Grid
 */
public abstract class Sprite {
	
	private Location loc;
	private String id;
	
	public Sprite(int x , int y, String id) {
		// TODO Auto-generated constructor stub
		super();
		
		this.loc = new Location(x,y);
		this.id = id;
		
	}
	
	
	
	public abstract void act();
	
	/**
	 * @return true if this Sprite collides with @param p
	 */
	public boolean collidesWith(Sprite p) {
		// TODO Auto-generated method stub
		if(this.getLoc().equals(p.getLoc())){
			return true;
		}
		return false;
	}
	
	public String getRender(){
		return this.id;
	}
	
	public Location getLoc(){
		return this.loc;
	}
	
	
	
	// return stringy version of this sprite
	@Override
	public String toString() {
		
		return this.id + " - " + this.loc.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((loc == null) ? 0 : loc.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	public boolean equalsLoc(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Sprite))
			return false;
		Sprite other = (Sprite) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (loc == null) {
			if (other.loc != null)
				return false;
		} else if (!loc.equals(other.loc))
			return false;
		return true;
	}

	/**
	 * @param loc the loc to set
	 */
	public void setLoc(Location loc) {
		this.loc = loc;
	}

	/**
	 * @param setRender character only allowed in Debug mode
	 */
	public void setRender(String id) {
		if(Drive.debug){
			this.id = id;
		}
		
	}

	
	
	
	
}
