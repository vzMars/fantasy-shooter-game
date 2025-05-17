
public abstract class EnemySprite extends Sprite {

	public EnemySprite(String name, int x, int y, int w, int h, String[] pose, int count, int duration, int health) {
		super(name, x, y, w, h, pose, count, duration, health);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public abstract void attack();
	
}
