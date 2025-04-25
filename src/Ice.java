public class Ice extends Sprite {
	
	static String[] direction = { "up", "dn", "lt", "rt"};

	public Ice(int x, int y, int scale) {
		super("ice", x, y, scale, scale, direction, 4, 10);
	}
	
}