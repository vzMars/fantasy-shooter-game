import java.awt.Graphics;

public class TrapArrow extends Rect {
	Animation animation;
	
	public TrapArrow(int x, int y, int scale) {
		super(x, y, scale, scale);
		
		animation = new Animation("trap_arrow", 4, 10);
	}
	
	public void draw(Graphics pen) {
		pen.drawImage(animation.nextImage(), x, y, w, h, null);
	}
	
}
