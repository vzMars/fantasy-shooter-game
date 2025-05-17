import java.awt.Graphics;
import java.util.Random;

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
		if(wasLeftOf(r))	pushLeftOf(r, 1);
		if(wasRightOf(r))	pushRightOf(r, 1);
		if(wasAbove(r))	    pushAboveOf(r, 1);
		if(wasBelow(r))	    pushBelowOf(r, 1);
	}
	
	public void pushAwayFrom(Rect r, int amt) {
		if(wasLeftOf(r))	pushLeftOf(r, amt);
		if(wasRightOf(r))	pushRightOf(r, amt);
		if(wasAbove(r))	    pushAboveOf(r, amt);
		if(wasBelow(r))	    pushBelowOf(r, amt);
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

	public void pushLeftOf(Rect r, int amt) {
		x = r.x - w - amt;
	}
	
	public void pushRightOf(Rect r, int amt) {
		x = r.x + r.w + amt;
	}
	
	public void pushAboveOf(Rect r, int amt) {
		y = r.y - h - amt;
	}
	
	public void pushBelowOf(Rect r, int amt) {
		y = r.y + r.h + amt;
	}
	
	public void draw(Graphics pen) {
		pen.drawRect(x, y, w, h);
	}

}