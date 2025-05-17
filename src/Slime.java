
public class Slime extends Sprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public Slime(int x, int y, int scale) {
		super("slime", x, y, scale, scale, direction, 3, 10, 100);
	}
	
	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
