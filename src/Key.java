import java.awt.Graphics;

public class Key extends Rect {
	Animation animation;
	
	public Key(int x, int y, int scale) {
		super(x, y, scale, scale);
		
		animation = new Animation("key", 1, 10);
	}
	
	public void draw(Graphics pen) {
		pen.drawImage(animation.stillImage(), x, y, w, h, null);
	}
	
}