
public class Wolf extends Sprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public Wolf(int x, int y, int scale) {
		super("wolf", x, y, scale, scale, direction, 3, 10);
	}
	
}
