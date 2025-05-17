
public class OrcNPC extends Sprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public OrcNPC(int x, int y, int scale) {
		super("orc", x, y, scale, scale, direction, 5, 10, 100);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}