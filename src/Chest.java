import java.awt.Graphics;

public class Chest extends Rect {
	Animation animation;
	
	boolean open = false;
	
	public Chest(int x, int y, int scale) {
		super(x, y, scale, scale);
		
		animation = new Animation("chest", 2, 10);
	}
	
	public void draw(Graphics pen) {
		if (open) {
			pen.drawImage(animation.nextImage(), x, y, w, h, null);
		} else {
			pen.drawImage(animation.stillImage(), x, y, w, h, null);
		}
		
	}
	
	public void openChest() {
		open = true;
	}
	
	public void closeChest() {
		open = false;
	}
	
}
