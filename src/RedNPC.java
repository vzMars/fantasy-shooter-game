
public class RedNPC extends Sprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public RedNPC(int x, int y, int scale) {
		super("red", x, y, scale, scale, direction, 5, 10, 100);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}