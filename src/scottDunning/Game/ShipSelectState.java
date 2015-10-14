package scottDunning.Game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class ShipSelectState extends BasicGameState {
	
	Vector<String> paths = new Vector<String>();
	Vector<Image> ships = new Vector<Image>();
	String str;
	int row = 0;
	
	public ShipSelectState() {
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader("images/ships.txt"));
		    while((str = in.readLine()) != null) { paths.add(str); }
	    }catch (FileNotFoundException e) { e.printStackTrace(); }
		 catch (IOException f) { f.printStackTrace(); }
	}

	@Override
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
		for(int i=0; i<paths.size(); i++) { ships.add(new Image(paths.get(i))); }
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		for(int i=0; i<ships.size(); i++) {
			if ((i+1)*128 >= container.getWidth()) row += 128;
			ships.get(i).draw(i*128, row, 2);
		}
	}

	

	@Override
	public int getID() { return 4; }

}
