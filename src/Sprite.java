import java.awt.Graphics;

public class Sprite extends Rect {
	Animation[] animation;

	boolean moving = false;
	
	final int UP = 0;
	final int DN = 1;
	final int LT = 2;
	final int RT = 3;

	int pose = DN;

	public Sprite(String name, int x, int y, int w, int h, String[] pose, int count, int duration) {
		super(x, y, w, h);
		
		animation = new Animation[pose.length];
		
		for (int i = 0; i < pose.length; i++) {
			animation[i] = new Animation(name + "_" + pose[i], count, duration);
		}
	}
	
	public void draw(Graphics pen) {
		if (moving) {
			pen.drawImage(animation[pose].nextImage(), x, y, w, h, null);
		} else {
			pen.drawImage(animation[pose].stillImage(), x, y, w, h, null);
		}
		
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
	
}