
public class Golem extends Sprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public Golem(int x, int y, int scale) {
		super("golem", x, y, scale, scale, direction, 3, 10, 100);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
