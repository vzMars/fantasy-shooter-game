
public class PurpleNPC extends Sprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public PurpleNPC(int x, int y, int scale) {
		super("purple", x, y, scale, scale, direction, 4, 10);
	}
	
}
