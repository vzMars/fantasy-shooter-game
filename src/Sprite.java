import java.awt.Graphics;

public abstract class Sprite extends Rect {
	Animation[] animation;

	boolean moving = false;
	
	final int UP = 0;
	final int DN = 1;
	final int LT = 2;
	final int RT = 3;
	
	public String name;
	public int health, defaultHealth;

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
		this.defaultHealth = health;
		this.name = name;
		startingX = x;
		startingY = y;
		
		animation = new Animation[pose.length];
		
		for (int i = 0; i < pose.length; i++) {
			animation[i] = new Animation(name + "_" + pose[i], count, duration);
		}
	}

	public void chase(Sprite s) {
		if(x > s.x)  moveLeft(2);
		if(x < s.x)  moveRight(2);
		if(y > s.y)  moveUp(2);
		if(y < s.y)  moveDown(2);
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
	
	public String getName() {
		
		return this.name;
	}

	public void hitBox() { // the entire sprite
		hitBox = new Rect(x+5,y+10,w-15,h-15);
	}
	
	public void hurtBox() {
	    final int offset = 5;
	    final int extraOffset = 5;

	    final int halfW = w / 2;
	    final int halfH = h / 2;

	    switch (pose % 4) {
	        case UP:
	            hurtBox = new Rect(x, y - offset, w, halfH);
	            break;
	        case DN:
	            hurtBox = new Rect(x, y + halfH + offset + extraOffset, w, halfH);
	            break;
	        case LT:
	            hurtBox = new Rect(x - offset, y, halfH, h);
	            break;
	        case RT:
	            hurtBox = new Rect(x + halfW + extraOffset, y, halfH, h);
	            break;
	        default:
	            hurtBox = new Rect(x, y, w, h); // fallback
	            break;
	    }
	}


	
	public void radius() { // Used for detection of other Sprites nearby
		
		int offset = 48;
		
		radius = new Rect(x-offset, y-offset  ,w + (offset*2),h + (offset*2));
	}
	
	public void attackBox() { // If within this box, enemy start attacking or inflecting damage.
		
		int offset = 50;

		attackBox = new Rect(x-offset, y-offset  ,w + (offset*2),h + (offset*2));
	}
	
	
	public void takeDamage(int amt) {
	
		if(health < 0) {health = 0; return;}
		 
		health -= amt;

	}
	

	public void setVelocityX(int vx) {
		this.vx = vx;
	}
	
	public void setVelocityY(int vy) {
		this.vy = vy;
	}
	
	
	public void updateRect() {
		
		hitBox();
		hurtBox();
		radius();
		attackBox();
		
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

	public void update() {
		
		updateRect();
		
		
	}
		
	public void reset(int x, int y) {
		
		this.x = x;
		this.y = y;
		health = defaultHealth;
		
	}
		
	public boolean isDead() {
		
		return health <= 0;
	}	
	
	public void actions() {
		updateRect();
		
	}
		
		
	
	public boolean  checkNull() {
	
		return (this != null && this.attackBox != null  && this.hitBox != null && this.hurtBox !=null) ;
			
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
