import java.awt.Graphics;

public class TrapFireLeft extends Rect {
	Animation animation;
	
	public TrapFireLeft(int x, int y, int scale) {
		super(x, y, scale, scale);
		
		animation = new Animation("trap_fire_left", 9, 10);
	}
	
	public void draw(Graphics pen) {
		pen.drawImage(animation.nextImage(), x, y, w, h, null);
	}
	
}
