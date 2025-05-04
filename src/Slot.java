import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
public class Slot extends Rect{
	
	private static Image borderImg = Toolkit.getDefaultToolkit().getImage("border_1.png");
	public boolean isSelected;
	private Image  img;
	public  int imgX, imgY, imgW, imgH;
	private int sRectX, sRectY, sRectSize;
	public Color bgColor;
	
	//sRect is the selection rectangle
	//it indicates if a slot is selected using color
	
	public Slot(int x, int y, int size) {
		super(x, y, size, size);
		
		isSelected = false;
		bgColor    = new Color(135, 206, 235, 200);
		img        = null;
		
		updateSRect();
		
	}
	
	public void update() {
		updateImage();
		updateSRect();
		
	}
	
	public void updateImage() {
		imgX = x + w / 6;
		imgY = y + h / 5;
		imgW = w * 5 / 8;
		imgH = h * 5 / 8;
	}
	
	public void updateSRect() {
		sRectSize = (int) (w /1.28);
		sRectX    = this.x + (w - sRectSize) / 2;
		sRectY    = this.y + (h - sRectSize) / 2;
	}
	
	//adds the image assuming the image has a 1:1 ratio
	public void addImage(Image image) {
		img  = image;
		update();
	}
	
	//adds the image assuming the image has a 1:1 ratio
	public void addImage(String name) {
		img = Toolkit.getDefaultToolkit().getImage(name);
		update();
	}
	
	public void addImage(Image image, int x, int y, int w, int h) {
		img  = image;
		imgX = x;
		imgY = y;
		imgW = w;
		imgH = h;
	}
	
	public void addImage(String name, int x, int y, int w, int h) {
		img  =  Toolkit.getDefaultToolkit().getImage(name);;
		imgX = x;
		imgY = y;
		imgW = w;
		imgH = h;
	}
	
	
	public void draw(Graphics pen) {
		if(isSelected) {
			Color c = pen.getColor();
			pen.setColor(bgColor);
			pen.fillRect(sRectX, sRectY, sRectSize, sRectSize);
			pen.setColor(c);
			
		}
		pen.drawImage(borderImg, x, y, w, h, null);
		
		if(img != null) {
			pen.drawImage(img, imgX, imgY, imgW, imgH, null);
		}
		
		
	}

}
