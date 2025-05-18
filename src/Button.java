import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Button extends Rect{
	Image btnReleased;
	Image btnPressed;
	Image btn;
	
	private int stringX;
	private int stringY;
	private String text;
	private boolean isPressed;
	public  boolean isVisible;
	
	public Button(String name, String text, int x, int y, int w, int h) {
		super(x, y, w, h);
		
		this.text = text;
		
		btnReleased = Toolkit.getDefaultToolkit().getImage("btn_" + name + "_released.png");
		btnPressed  = Toolkit.getDefaultToolkit().getImage("btn_" + name + "_pressed.png");
		btn        = btnReleased;
		
	}
	
	
	public boolean isPressed() {
		return isPressed;
	}
	
	public boolean isPressed(int mx, int my) {
		if(!isVisible) return false;
		if((mx >= x && mx <= x + w) && (my >= y && my <= y + h)){
			btn = btnPressed;
			isPressed = true;
			return true;
		}
		
		return false;
	}
	
	public void release() {
		btn       = btnReleased;
		isPressed = false;
	}
	
	public void draw(Graphics pen) {
		
		if(!isVisible) return;
		
		
		pen.setFont(new Font(Font.SANS_SERIF, Font.BOLD, w / 7));
	    int stringW = pen.getFontMetrics().stringWidth(text);
	    stringX = x + (w - stringW) / 2;
		
		if(isPressed)  stringY = y + (h + pen.getFontMetrics().getAscent()) * 9 / 20;
		else           stringY = y + (h + pen.getFontMetrics().getAscent()) * 2 / 5;    
		
		
		pen.drawImage(btn, x, y, w, h, null);
		pen.drawString(text, stringX, stringY);
	}
	
	

}
