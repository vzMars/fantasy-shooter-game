
public class FireGhost extends Sprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public FireGhost(int x, int y, int scale) {
		super("fire_ghost", x, y, scale, scale, direction, 3, 10);
	}
	
}
