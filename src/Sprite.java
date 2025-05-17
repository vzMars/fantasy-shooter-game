import java.awt.Graphics;

public abstract class Sprite extends Rect {
	Animation[] animation;

	boolean moving = false;
	
	final int UP = 0;
	final int DN = 1;
	final int LT = 2;
	final int RT = 3;
	
	int health;

	int pose = DN;
	
	Rect hitBox; // To to inflect damage
	Rect hurtBox; // Used to know if to take damage
	Rect radius;  // Used for Npc to detact and move closer
	Rect attackBox;  // Used for NPC if with in, attack
	
	int vx;
	int vy;
	
	int startingX;
	int startingY;

	public Sprite(String name, int x, int y, int w, int h, String[] pose, int count, int duration, int health) {
		super(x, y, w, h);
		this.health = health;
		
		startingX = x;
		startingY = y;
		
		animation = new Animation[pose.length];
		
		for (int i = 0; i < pose.length; i++) {
			animation[i] = new Animation(name + "_" + pose[i], count, duration);
		}
	}
	
	public void draw(Graphics pen) {
		updateRect();

		if (moving) {
			pen.drawImage(animation[pose].nextImage(), x, y, w, h, null);
		} else {
			pen.drawImage(animation[pose].stillImage(), x, y, w, h, null);
		}
		
//		hitBox.draw(pen);
//		hurtBox.draw(pen);
//		radius.draw(pen);
//		attackBox.draw(pen);

		moving = false;
	}
	
	public void moveUp(int dy) {
		y -= dy;
		moving = true;
		pose = UP;
	}
	
	public void moveDown(int dy) {
		y += dy;		
		moving = true;
		pose = DN;
	}
	
	public void moveLeft(int dx) {
		x -= dx;		
		moving = true;
		pose = LT;
	}
	
	public void moveRight(int dx) {
		x += dx;		
		moving = true;
		pose = RT;
	}
	
	public void chase(Sprite s) {
		if(x > s.x)  moveLeft(2);
		if(x < s.x)  moveRight(2);
		if(y > s.y)  moveUp(2);
		if(y < s.y)  moveDown(2);
	}
	
	public void setVelocityX(int vx) {
		this.vx = vx;
	}
	
	public void setVelocityY(int vy) {
		this.vy = vy;
	}
	
	public void moveX() {
		x += vx;
		moving = true;
		if (vx < 0) {
			pose = LT;
		} else {
			pose = RT;
		}
	}
	
	public void moveY() {
		y += vy;
		moving = true;
		if (vy < 0) {
			pose = UP;
		} else {
			pose = DN;
		}
	}
	
	public void bounceOffVerticalSurface() {
		vy = -vy;
	}
	
	public void bounceOffHorizontalSurface() {
		vx = -vx;
	}

	public abstract void update();

	public boolean isDead() {
		return health <= 0;
	}
	
	public void hitBox() { // the entire sprite
		hitBox = new Rect(x,y,w,h);
	}
	
	public void takeDamage(int amt) {
		 health -= amt;
	}
	
	public void hurtBox() { 
	    int offset = 1; // Distance the attack box extends
	    int attackWidth = w / 2;
	    int attackHeight = h / 2;

	    switch (pose) {
	        case UP:
	            hurtBox = new Rect(x + (w - attackWidth) / 2, y - offset - attackHeight, attackWidth, attackHeight);
	            break;
	        case DN:
	            hurtBox = new Rect(x + (w - attackWidth) / 2, y + h + offset, attackWidth, attackHeight);
	            break;
	        case LT:
	            hurtBox = new Rect(x - offset - attackWidth, y + (h - attackHeight) / 2, attackWidth, attackHeight);
	            break;
	        case RT:
	            hurtBox = new Rect(x + w + offset, y + (h - attackHeight) / 2, attackWidth, attackHeight);
	            break;
	        default:
	            // Default to character's body size (e.g. passive state)
	            hurtBox = new Rect(x, y, w, h);
	            break;
	    }
	}

	public void radius() { // Used for detection of other Sprites nearby
		
		int offset = 100;
		
		radius = new Rect(x-offset, y-offset  ,w + (offset*2),h + (offset*2));
	}
	
	public void attackBox() { // If within this box, enemy start attacking or inflecting damage.
		
		int offset = 50;

		attackBox = new Rect(x-offset, y-offset  ,w + (offset*2),h + (offset*2));
	}

	public void updateRect() {
		hitBox();
		hurtBox();
		radius();
		attackBox();
	}
	
}
	