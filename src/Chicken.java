
public class Chicken extends Sprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public Chicken(int x, int y, int scale) {
		super("chicken", x, y, scale, scale, direction, 3, 10, 100);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
