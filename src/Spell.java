
public abstract class Spell extends Sprite{

	static String[] direction = { "up", "dn", "lt", "rt"};

	
	//Default values
	int FIRESPEED = 10;
	int ICESPEED  = 5;
	int LIGHTINGSPEED = 15;
 	
	int speed;
	int dir;
	
	int damage;
	
	public Spell( String name,int x, int y, int scale, int dir) {
		super(name, x, y, scale, scale, direction, 4, 10);
		
		this.dir = dir;
	}  
	
	
	
	

	public int getDamage() {
		return damage;
	}





	@Override
	public void update() {
        switch (dir) {
            case 0: this.moveUp(speed); break; // UP
            case 1: this.moveDown(speed); break; // DOWN
            case 2: this.moveLeft(speed);; break; // LEFT
            case 3: this.moveRight(speed);; break; // RIGHT
        }
    }

	public void setSpeed(int newSpeed) {
		speed = newSpeed;	
	}
	
	public void setDamage(int newDamage) {
		
		this.damage = newDamage;
	}
}
