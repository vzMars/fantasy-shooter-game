
public class Demon extends EnemySprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public Demon(int x, int y, int scale) {
		super("demon", x, y, scale, scale, direction, 3, 10, 100);
		setDamageGiven(30);
		setForcePushback(40);
	}

	

	@Override
	public void setDamageGiven(int amt) {
		
		this.damageGive = amt;
		
	}

	@Override
	public void setForcePushback(int amt) {
		this.forcePushBack = amt;
	}
	
}
