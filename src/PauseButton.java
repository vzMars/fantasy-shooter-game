import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class PauseButton extends Button{
	
	private Image pause;
	private Image resume;
	private Image img;
	
	public PauseButton() {
		this(0, 0, 50);
	}
	public PauseButton(int x, int y, int scale) {
		super("short", "", x, y, scale, scale);
		
		pause  = Toolkit.getDefaultToolkit().getImage("pause.png");
		resume = Toolkit.getDefaultToolkit().getImage("resume.png");
		
		img       = pause;
		isVisible = true;
	}
	
	public void inGameLoop() {
		//Pause is plauer dies to restart or retry
		if(Room.player.isDead()) {pause();}
		
		if(Game.mousePressed && !isPressed() && isPressed(Game.mx, Game.my));
		
		else if(!Game.mousePressed && isPressed()) {
			release();
			
			if(Game.isPaused) resume();
			else              pause();
		}
	}
	
	public void pause() {
		if(Game.isPaused) return;
		img = resume;
		Game.isPaused = true;
		Room.timer.pause();
	}
	
	public void resume() {
		if(Room.timer.hasEnded()) return;
		img = pause;
		Game.isPaused = false;
		if(Room.timer.isStarted()) Room.timer.resume();
		else                       Room.timer.start();
	}
	
	
	
	public void draw(Graphics pen) {
		super.draw(pen);
		if(isVisible) pen.drawImage(img, x, y - 5, w, h, null);
	}
	
}
