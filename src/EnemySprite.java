import java.util.ArrayList;

public abstract class EnemySprite  extends Sprite{

	
	int damageGive ; 
	int forcePushBack;
	int chaseSpeed;
	
	int defaultChaseSpeed;
	
	//These vars are used to chase the player when shoot from afar
	boolean triggered = false; // Start off not chasing
	int triggerCooldown = 180;  //  Chage for a longer time
	int triggerTimer = 0;

	
	public EnemySprite(String name, int x, int y, int w, int h, String[] pose, int count, int duration, int health, int chaseSpeed) {
		super(name, x, y, w, h, pose, count, duration, health);

		//Default values unless changes in the Class
		 damageGive  = 3; 
		 forcePushBack = 20;
		 this.chaseSpeed = chaseSpeed;
		
		 defaultChaseSpeed = chaseSpeed;
		
		
	}

	
	
	
	
	
	public void chase(Sprite target) {
		
	    int speed = chaseSpeed;

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
	
	public void actions() {
	    Player player = Room.player;
	
	    if (!this.checkNull()) return;
	    if (isDead()) return;
	
	    //player attack outside
	    boolean hitBySpell = false;
	
	    if (player.isSword()) {//Sword
	    	
	        if (player.meleeAttack && player.hurtBox.overlaps(hitBox)) {
	            takeDamage(2);
	            triggered = true; 
	            triggerTimer = triggerCooldown;
	            return;
	        }
	    } else {//Spells
	    	
	        for (Spell spell : new ArrayList<>(player.spells)) {
	        	
	            if (spell.overlaps(hitBox)) {
	                takeDamage(spell.getDamage());
	                pushAwayFrom(spell, spell.pushBackAmount);
	                this.effect(spell.getName());
	                player.spells.remove(spell);
	                //Set the chase
	                triggered = true; 
	                triggerTimer = triggerCooldown;
	                hitBySpell = true;
	                break;
	            
	            }
	        }
	    }
	
	    if (!isDead() && this.attackBox.overlaps(player)) {
	        attack();
	    }
	
	    
	
	    if (radius.overlaps(player.radius)) {
	        triggered = true;
	        triggerTimer = triggerCooldown;
	    } else if (triggerTimer > 0) {
	        triggerTimer--;
	    } else {
	        triggered = false; // Stop chasing if time runs out and not in radius
	    }
	
	    if (!isDead() && triggered) {
	        chase(player);
	    }
	}
	
	
		
		int attackCounter =  0; // Counter is used to implement a cheap "missing feature" and a cool down for the attacks
		public void attack() { // default for all
			Player player = Room.player;
	
			if(this.hurtBox.overlaps(player.hitBox) && attackCounter %3  == 0) {
				player.takeDamage(this.damageGive);
				player.pushAwayFrom(this, forcePushBack);
			}
			
			System.out.println("Player Health: " + player.health);
			
			if(attackCounter > 10000) { attackCounter = 0;}
			attackCounter++;
	}
	
	
	public void setDamageGiven(int amt) {
		
		this.damageGive = amt;
		
	}

	public void setForcePushback(int amt) {
		this.forcePushBack = amt;
	}
	
	public void setChaseSpeed(int amt) {
		
		this.chaseSpeed = amt;
	}
	
	
	public void effect(String type) {
		
		switch(type) {
		
		case"fire":
			this.setChaseSpeed(defaultChaseSpeed);
			break;
		case"ice": // Slow the affected person down. 
			this.setChaseSpeed(  this.defaultChaseSpeed/2  );
			break;
		case"lighting":
			this.setChaseSpeed( this.defaultChaseSpeed + this.defaultChaseSpeed/2 ); // Gives the affected person speed. 
			break;
		
		}
		
		
	}

}
