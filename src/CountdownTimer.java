import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class CountdownTimer extends Rect{


	private long    timeLeft;
	private boolean isStarted;
	private boolean isPaused;
	private boolean hasEnded;
	private long    startTime;
	private long    elapsedTime;
	private long    maxTime;
	private String  timeAsString;
	private Image   borderImg;
	private Color   color;
	private boolean isEnabled;
	
	public final static int MILLISECONDS = 0;
	public final static int SECONDS      = 1;
	public final static int MINUTES      = 2;
	
	
	public CountdownTimer(int x, int y, int scale, long maxTime, int timeUnit) {
		super(x, y, 2 * scale, 1 * scale);
		reset(maxTime, timeUnit);
		
		borderImg = Toolkit.getDefaultToolkit().getImage("border_0.png");
		color     = new Color(255, 117, 24, 200);
		isEnabled = false;
	}
	
	public void inGameLoop() {
		if(isStarted && !isPaused && !hasEnded && isEnabled) {
			elapsedTime = System.currentTimeMillis() - startTime;
			timeLeft    = maxTime   - elapsedTime;
			
			if(timeLeft <= 0) {
				timeLeft   = 0;
				timeAsString = "0";
				hasEnded   = true;
			}
			else update();
			
		}
	}
	
	public void setForeground(Color color) {
		this.color = color;
	}
	
	public Color getForeground() {
		return color;
	}
	
	public boolean hasEnded() {
		return hasEnded;
	}
	
	public boolean isEnabled() {
		return isEnabled;
	}
	
	public boolean isStarted() {
		return isStarted;
	}
	
	public boolean isPaused() {
		return isPaused;
	}
	
	public String getTimeAsString() {
		return timeAsString;
	}
	
	//returns elapsedtime in milliseconds
	public long getElaspedTime() {
		return elapsedTime;
	}
	
	//returns timeLeft in milliseconds
	public long getTimeLeft() {
		return timeLeft;
	}
	
	//returns maxTime in milliseconds
	public long getMaxTime() {
		return maxTime;
	}
	
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	
	public void update() {
		long hrs = timeLeft / 3600000;
		long r   = timeLeft % 3600000;
			
		long mins =  r / 60000;
		r         =  r % 60000;
		
		long secs = r / 1000;
		r         = r % 1000;
		
		
		
		if(r    >   0)  
			secs += 1;
		
	    if(secs >= 60) {
	    	secs = 0;
	    	mins += 1;
	    }
	    if(mins >= 60) {
	    	mins  = 0;
	    	hrs  += 1;
	    }
		
		
			 if(hrs  > 0) timeAsString = String.format("%d:%02d:%02d", hrs, mins, secs);		
		else if(mins > 0) timeAsString = String.format(     "%d:%02d",      mins, secs);
		else              timeAsString = "" + secs;
		
		
	}
	
	public void start() {
		if(isEnabled && !isStarted && !hasEnded && !isPaused) {
			isStarted = true;
			startTime = System.currentTimeMillis();
		}
	}
	
	public void pause() {
		if(isEnabled && isStarted && !hasEnded && !isPaused) isPaused = true;
	}
	
	public void resume() {
		if(isEnabled && isStarted && !hasEnded && isPaused) {
			startTime = System.currentTimeMillis() - elapsedTime;
			isPaused  = false;
		}
	}
	
	
	public void reset() {
		isStarted   = false;
		isPaused    = false;
		hasEnded    = false;
		timeLeft    = maxTime;
		elapsedTime = 0;
		startTime   = 0;
		update();
	}
	
	public void reset(long maxTime, int timeUnit) {
		     if(maxTime <= 0)             this.maxTime = 0; //maxTime can only be positive
		else if(timeUnit == MILLISECONDS) this.maxTime = maxTime;
		else if(timeUnit == SECONDS     ) this.maxTime = maxTime * 1000;  //converts into ms
		else if(timeUnit == MINUTES     ) this.maxTime = maxTime * 60000; //converts into ms
		else                              this.maxTime = 0; // in case of a wrong time unit
		     
		timeLeft    = this.maxTime;
		elapsedTime = 0;
		startTime   = 0;
		isStarted   = false;
		isPaused    = false;
		hasEnded    = false;
		update();     //updates timeAsString
	}
	
	public void draw(Graphics pen) {
		Color c = pen.getColor();
		pen.setColor(color);
		
		pen.drawImage(borderImg, x, y, w, h, null);
		
		pen.setFont(new Font(Font.SANS_SERIF, Font.BOLD, w / 5));
		
	    int stringW = pen.getFontMetrics().stringWidth(timeAsString);
	    int stringX = x + (w - stringW) / 2;
	    int stringY = y + (h + pen.getFontMetrics().getAscent()) / 2;
	    
	    
		pen.drawString(timeAsString, stringX, stringY);
		
		pen.setColor(c);
	}
	
}
