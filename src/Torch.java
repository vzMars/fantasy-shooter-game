import java.awt.Graphics;

public class Torch extends Rect {
	Animation animation;
	
	public Torch(int x, int y, int scale) {
		super(x, y, scale, scale);
		
		animation = new Animation("torch", 8, 10);
	}
	
	public void draw(Graphics pen) {
		pen.drawImage(animation.nextImage(), x, y, w, h, null);
	}
	
}
