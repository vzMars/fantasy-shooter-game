import java.awt.Graphics;
import java.util.ArrayList;

public class Player extends Sprite {

    public static final int FIREMAGIC = 0;
    public static final int ICEMAGIC = 1;
    public static final int LIGHTING = 2;
    public static final int SWORD = 3;

    public int AttackType;

    ArrayList<Sprite> spells = new ArrayList<>();

    static String[] direction = {
        "up", "dn", "lt", "rt",
        "up_magic", "dn_magic", "lt_magic", "rt_magic",
        "up_sword", "dn_sword", "lt_sword", "rt_sword",
        "up_dead", "dn_dead", "lt_dead", "rt_dead"
    };

    public Player(int x, int y, int scale) {
        super("player", x, y, scale, scale, direction, 4, 10);
        AttackType = SWORD;
        
        health = 100;
    }

    

    public void attack() {
	    moving = true;
	
	    int baseDirection = pose % 4; // Always gives you UP/DN/LT/RT regardless of current state
	
	    if (isMage()) {
	        drawProjection(baseDirection); // Pass only direction
	
	        pose = baseDirection + 4; // Magic pose
	    } else if (isSword()) {
	        drawProjection(baseDirection);
	        pose = baseDirection + 8; // Sword pose
	    }
	}

    public void drawProjection(int direction) {
        if (isFire()) {
            Fire fb = new Fire(x + w / 4, y + h / 4, w / 2, direction);
            spells.add(fb);
        }
        if(isIce()) {
        	
        	 Ice IB = new Ice(x + w / 4, y + h / 4, w / 2, direction); 
             spells.add(IB);
        	
        }
        if(isLighting()) {
        	
        	Lighting LB = new Lighting(x + w / 4, y + h / 4, w / 2, direction);
        	spells.add(LB);
        }
    }


    @Override
	public String toString() {
		final int maxLen = 10;
		return "Player [AttackType=" + AttackType + ", fireballs="
				+ (spells != null ? spells.subList(0, Math.min(spells.size(), maxLen)) : null) + ", pose="
				+ pose + ", x=" + x + ", y=" + y + ", w=" + w + ", h=" + h + "]";
	}



	public void draw(Graphics Screen) {
        super.draw(Screen);

        for(Sprite fb : new ArrayList<>(spells)) {
          
            fb.update();
            fb.draw(Screen);
            
        }
    }

    public void setAttackType(int Type) {
        AttackType = Type;
    }

    public boolean isSword() {
        return AttackType == SWORD;
    }

    public boolean isMage() {
        return AttackType == FIREMAGIC || AttackType == ICEMAGIC || AttackType == LIGHTING;
    }

    public boolean isFire() {
        return AttackType == FIREMAGIC;
    }

    public boolean isIce() {
        return AttackType == ICEMAGIC;
    }

    public boolean isLighting() {
        return AttackType == LIGHTING;
    }



	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
