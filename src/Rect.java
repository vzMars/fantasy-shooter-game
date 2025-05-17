import java.awt.Graphics;

public class Rect {
	int x;
	int y;
	
	int w;
	int h;
	
	public Rect(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public boolean overlaps(Rect r) {
		return (x <= r.x + r.w) &&
			   (x + w >= r.x)   &&
			   (y <= r.y + r.h) &&
			   (y + h >= r.y);
	}
	
	public void pushAwayFrom(Rect r) {
		if(wasLeftOf(r))	pushLeftOf(r);
		if(wasRightOf(r))	pushRightOf(r);
		if(wasAbove(r))	    pushAbove(r);
		if(wasBelow(r))	    pushBelow(r);
	}
	
	public boolean wasLeftOf(Rect r) {
		return x - 4 < r.x - w + 1;
	}
	
	public boolean wasRightOf(Rect r) {
		return x + 4 > r.x + r.w - 1;
	}

	public boolean wasAbove(Rect r) {
		return y - 4 < r.y - h + 1;
	}
	
	public boolean wasBelow(Rect r) {
		return y + 4 > r.y + r.h - 1;
	}

	public void pushLeftOf(Rect r) {
		x = r.x - w - 1;
	}
	
	public void pushRightOf(Rect r) {
		x = r.x + r.w + 1;
	}
	
	public void pushAbove(Rect r) {
		y = r.y - h - 1;
	}
	
	public void pushBelow(Rect r) {
		y = r.y + r.h + 1;
	}
	
	public void chase(Rect r)
	{
		if(x > r.x)  x -= 2;
		if(x < r.x)  x += 2;
		if(y > r.y)  y -= 2;
		if(y < r.y)  y += 2;
	}
	
	public void evade(Rect r)
	{
		if(x > r.x)  x += 2;
		if(x < r.x)  x -= 2;
		if(y > r.y)  y += 2;
		if(y < r.y)  y -= 2;
	}
	
	
	public void draw(Graphics pen) {
		pen.drawRect(x, y, w, h);
	}

}