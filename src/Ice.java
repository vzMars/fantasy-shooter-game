public class Ice extends Sprite {
	
	static String[] direction = { "up", "dn", "lt", "rt"};

	
	 int speed = 5;
	  int dir;

	   
	    public Ice(int x, int y, int scale, int dir) {
			super("ice", x, y, scale, scale, direction, 4, 10);
			
			this.dir = dir;
		}  
	       

	    public void update() {
	        switch (dir) {
	            case 0: this.moveUp(speed); break; // UP
	            case 1: this.moveDown(speed); break; // DOWN
	            case 2: this.moveLeft(speed);; break; // LEFT
	            case 3: this.moveRight(speed);; break; // RIGHT
	        }
	    }
	
}