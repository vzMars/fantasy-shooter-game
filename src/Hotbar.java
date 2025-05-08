import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

public class Hotbar {
	static int slotSize  = 100;
	static int slotDist  = slotSize + 100; //distance between slots
	
	private int x;
	private int y;
	private int w;
	private int h;
	public  Slot[] slots;
	
	public Slot currentSlot;
	public int currentIndex;
	
	public Hotbar() {
		this(0, 0);
	}
	
	public Hotbar(int x, int y) {
		this(x, y, 3);
		
		slots[0].addImage(Toolkit.getDefaultToolkit().getImage("fire_up_0.png"));
		slots[1].addImage(Toolkit.getDefaultToolkit().getImage("ice_up_0.png"));
		slots[2].addImage(Toolkit.getDefaultToolkit().getImage("lighting_up_0.png"));
		
		slots[0].bgColor = new Color(220,  20,  60, 200);
		slots[1].bgColor = new Color(135, 206, 235, 200);
		slots[2].bgColor = new Color(148,   0, 211, 200);
		
	}
	
	public Hotbar(int x, int y, int numSlots) {
		this.x = x;
		this.y = y;
		slots  = new Slot[numSlots];
		
		
		for(int i = 0; i < slots.length; ++i) {
			slots[i] =  new Slot(x + (i * slotDist), y, slotSize);
		}
		
		if(slots.length == 0) w = 0;
		else                  w = slots[slots.length - 1].x + slotSize - slots[0].x;
		h = slotSize;
		currentIndex = -1;
		
	}
	
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
		
		for(int i = 0; i < slots.length; ++i) {
			slots[i].x = x + (i * slotDist);
			slots[i].y = y;
			slots[i].update();
		}
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return w;
	}
	
	public int getHeight() {
		return h;
	}
	
	public void setCurrentSlot(int index) {
		if(index >= 0 && index < slots.length) {
			if(currentSlot != null) currentSlot.isSelected = false;
			
			currentSlot            = slots[index];
			currentSlot.isSelected = true;
			currentIndex           = index;
		}
		
	}
	
	public Slot getCurrentSlot() {
		return currentSlot;
	}
	
	public int getCurrentIndex() {
		return currentIndex;
	}
	
	public void draw(Graphics pen) {
		for(int i = 0; i < slots.length; ++i)
			slots[i].draw(pen);
	}

}
