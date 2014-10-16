package edu.lmu.cmsi.Sprite;

public abstract class BigMonster extends Monster {

	public BigMonster(int x, int y, int dx, int dy, String id,
			double hitPercentage) {
		super(x, y, dx, dy, id, 0.50);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void CollideItWith(Sprite sprite){
		Actor sprite1 = (Actor) sprite;
		if(sprite1 instanceof Tree || sprite1 instanceof Rock || sprite1 instanceof Wall){
			this.deltaReverse();
		}
		else if(! (sprite1 instanceof Monster)){
			sprite1.Hit(Math.random() <= this.getHitPercentage());
		}
		
		

	}

}
