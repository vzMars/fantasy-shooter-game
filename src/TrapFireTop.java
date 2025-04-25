import java.awt.Graphics;

public class TrapFireTop extends Rect {
	Animation animation;
	
	public TrapFireTop(int x, int y, int scale) {
		super(x, y, scale, scale);
		
		animation = new Animation("trap_fire_top", 9, 10);
	}
	
	public void draw(Graphics pen) {
		pen.drawImage(animation.nextImage(), x, y, w, h, null);
	}
	
}
