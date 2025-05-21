import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Healthbar extends Rect{
	
	public static final Image green  = Toolkit.getDefaultToolkit().getImage("healthbar_green.png");
	public static final Image yellow = Toolkit.getDefaultToolkit().getImage("healthbar_yellow.png");
	public static final Image orange = Toolkit.getDefaultToolkit().getImage("healthbar_orange.png");
	public static final Image red    = Toolkit.getDefaultToolkit().getImage("healthbar_red.png");
	public static final Image border = Toolkit.getDefaultToolkit().getImage("border_3.png");
	 
	
	Image bar;
	int barX;
	int barY;
	int barW;
	int barH;
	int maxBarW;
	//96 x 12 border
	//89 * 4 bars
	
	public Healthbar(int x, int y) {
		this(x, y, 64);
	}
	public Healthbar(int x, int y, int scale) {
		super(x, y, 8 * scale, scale);
		bar     = green;
		maxBarW = (89 * w) / 96;
		barX    = x + (w / 24);
		barY    = y + (h / 3);
		barW    = maxBarW;
		barH    = h / 3;
		
	}
	
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
		
		barX = x + (w / 24);
		barY = y + (h / 3);
		
	}
	
	public void update() {
		double hpPercent = (double) Room.player.health / Room.player.defaultHealth;
		
		barW = (int) (maxBarW * hpPercent);
		
			 if(hpPercent <= 0.25) bar = red;
		else if(hpPercent <= 0.50) bar = orange;
		else if(hpPercent <= 0.75) bar = yellow;
		else                       bar = green;
		
	}
	
	@Override
	public void draw(Graphics pen) {
		Color old_color = pen.getColor();
		pen.setColor(Color.DARK_GRAY);
		pen.fillRect(x, y, w, h);
		pen.drawImage(bar,    barX, barY, barW, barH, null);
		pen.drawImage(border,    x,    y,    w,    h, null);
		
		pen.setColor(old_color);
		
		
	}
	
	

}
