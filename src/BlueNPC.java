
public class BlueNPC extends Sprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public BlueNPC(int x, int y, int scale) {
		super("blue", x, y, scale, scale, direction, 4, 10, 100);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}