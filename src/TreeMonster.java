
public class TreeMonster extends Sprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public TreeMonster(int x, int y, int scale) {
		super("tree_monster", x, y, scale, scale, direction, 3, 10);
	}
	
}
