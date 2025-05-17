
public class Cyclops extends EnemySprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public Cyclops(int x, int y, int scale) {
		super("cyclops", x, y, scale, scale, direction, 3, 10);
		
		health  = 80;
	}

	@Override
	public void takeDamage(int amt) {
		 health -= amt;
	       
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	 
	
	
}
