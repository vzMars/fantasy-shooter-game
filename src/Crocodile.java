
public class Crocodile extends Sprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public Crocodile(int x, int y, int scale) {
		super("crocodile", x, y, scale, scale, direction, 3, 10, 100);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}