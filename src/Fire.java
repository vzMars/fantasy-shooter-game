public class Fire extends Sprite {
	
	static String[] direction = { "up", "dn", "lt", "rt"};

	public Fire(int x, int y, int scale) {
		super("fire", x, y, scale, scale, direction, 4, 10);
	}
	
}
