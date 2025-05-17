
public abstract class EnemySprite  extends Sprite{

	public EnemySprite(String name, int x, int y, int w, int h, String[] pose, int count, int duration) {
		super(name, x, y, w, h, pose, count, duration);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	public void chase(Sprite target) {
	    int speed = 2;
	    moving =true;
	    if (target.x < this.x) {
	        x -= speed;
	        pose = LT;
	    } else if (target.x > this.x) {
	        x += speed;
	        pose = RT;
	    }

	    if (target.y < this.y) {
	        y -= speed;
	        pose = UP;
	    } else if (target.y > this.y) {
	        y += speed;
	        pose = DN;
	    }

	}

	
	
	
	
	
	
	
	public abstract void takeDamage(int amt);
	
	public abstract void attack();
	
	
	
	
	
	
	
	
	
	

}
