import java.awt.Graphics;

public class Map {
	
	TileMap tileMap[];
	Rect[] wall;
	int index;
	int scale;

	public Map(String[] filename, int scale) {
		this.index = 0;
		this.scale = scale;
		this.tileMap = new TileMap[filename.length];
		
		for(int i = 0; i < tileMap.length; i++) {
			tileMap[i] = new TileMap(filename[i], scale);
		}
		
		loadWalls();
	}
	
	public void draw(Graphics pen) {
		for(int i = 0; i < tileMap.length; i++) {
			tileMap[i].draw(pen);
		}
	}
	
	public void loadWalls() {
		int count = 0;
		
		for(int i = 0; i < tileMap.length; i++) {
			count += getWallCount(tileMap[i].map);
		}

		wall = new Rect[count];
		
		for(int i = 0; i < tileMap.length; i++) {
			createWalls(tileMap[i].map);
		}
	}
	
	public int getWallCount(String[] map) {
		int count = 0;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length(); j++) {
				char c = map[i].charAt(j);
				
				if(c == 'B' ||
				   c == 'D' ||
				   c == 'E' || 
				   c == 'G' || 
				   c == 'J' ||
				   c == 'K' ||
				   c == 'L' ||
				   c == 'M' ||
				   c == 'N' ||
				   c == 'O' ||
				   c == 'P' ||
				   c == 'Q' ||
				   c == 'R' ||
				   c == 'S' ||
				   c == ']' ||
				   c == '^' ||
				   c == '_' ||
				   c == '`' ||
				   c == 'a' ||
				   c == 'b' ||
				   c == 'c' ||
				   c == 'd' ||
				   c == 'e' ||
				   c == 'i' ||
				   c == 'm') {
					count++;
				}
			}
		}
		
		return count;
	}
	
	public void createWalls(String[] map) {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length(); j++) {
				char c = map[i].charAt(j);
				
				if(c == 'B' ||
				   c == 'D' ||
				   c == 'E' || 
				   c == 'G' || 
				   c == 'J' ||
				   c == 'K' ||
				   c == 'L' ||
				   c == 'M' ||
				   c == 'N' ||
				   c == 'O' ||
				   c == 'P' ||
				   c == 'Q' ||
				   c == 'R' ||
				   c == 'S' ||
				   c == ']' ||
				   c == '^' ||
				   c == '_' ||
				   c == '`' ||
				   c == 'a' ||
				   c == 'b' ||
				   c == 'c' ||
				   c == 'd' ||
				   c == 'e' ||
				   c == 'i' ||
				   c == 'm') {
					wall[index] = new Rect(j * scale, i * scale, scale / 2, scale / 2);
					index++;
				}
			}
		}
	}

}
