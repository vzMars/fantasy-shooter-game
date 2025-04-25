
public class Cyclops extends Sprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public Cyclops(int x, int y, int scale) {
		super("cyclops", x, y, scale, scale, direction, 3, 10);
	}
	
}
