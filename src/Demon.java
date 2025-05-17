
public class Demon extends Sprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public Demon(int x, int y, int scale) {
		super("demon", x, y, scale, scale, direction, 3, 10);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
