public class Ice extends Spell {
	
	static String[] direction = { "up", "dn", "lt", "rt"};

	
	 public Ice(int x, int y, int scale, int dir) {
			super("ice",x,y,scale,dir);
			setSpeed(ICESPEED);
			setDamage(10);

		}  
	       

	    


	
}