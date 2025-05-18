import java.util.ArrayList;

public class Cyclops extends EnemySprite {
	static String[] direction = { "up", "dn", "lt", "rt"};

	public Cyclops(int x, int y, int scale) {
		super("cyclops", x, y, scale, scale, direction, 3, 10, 100, 2);
		
		health  = 120; // Health of the enemy
		setDamageGiven(12); // the damage it gives to the player
		setForcePushback(20); // the push back value it gives to the player
	}
}
