
public class Lighting extends Sprite {
	
	static String[] direction = { "up", "dn", "lt", "rt"};

	public Lighting(int x, int y, int scale) {
		super("lighting", x, y, scale, scale, direction, 4, 10);
	}
	
}
