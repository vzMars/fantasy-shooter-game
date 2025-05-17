
public class Boar extends Sprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public Boar(int x, int y, int scale) {
		super("boar", x, y, scale, scale, direction, 3, 10);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}