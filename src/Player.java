
public class Player extends Sprite {
	
	static String[] direction = { 
			"up", "dn", "lt", "rt",
			"up_magic", "dn_magic", "lt_magic", "rt_magic",
			"up_sword", "dn_sword", "lt_sword", "rt_sword",
			"up_dead", "dn_dead", "lt_dead", "rt_dead"};
	
	public Player(int x, int y, int scale) {
		super("player", x, y, scale, scale, direction, 4, 10);
	}

}
