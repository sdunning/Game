package scottDunning.Game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MenuState extends BasicGameState {
	
	private int width = 0, height = 0,
			    halfW = 0, halfH = 0,
			    hImageW = 0, hImageH = 0;
	
	private Image play = null;
	private Image play2 = null;
	private Image options = null;
	private Image options2 = null;
	private Image chooseShip = null;
	private Image quit = null;
	
	private boolean playDetection = false;
	private boolean optionsDetection = false;
	private boolean chooseShipDetection = false;
	private boolean quitDetection = false;

	@Override
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
		width = container.getWidth(); height = container.getHeight();
		halfW = width/2; halfH = height/2;
		play = new Image("images/Play.png");
		play2 = new Image("images/Play2.png");
		options = new Image("images/Options.png");
		options2 = new Image("images/Options2.png");
		chooseShip = new Image("images/chooseShip.png");
		quit = new Image("images/Quit.png");
		hImageW = play.getWidth()/2;
		hImageH = play.getHeight()/2;
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
		if(container.getInput().isKeyPressed(Input.KEY_P)) sbg.enterState(2);
		if(container.getInput().isKeyPressed(Input.KEY_S)) sbg.enterState(4);
		if(container.getInput().getMouseX() > (halfW - hImageW) && 
		   container.getInput().getMouseX() < (halfW + hImageW)) {
			if(container.getInput().getMouseY() > ((halfH - hImageH) - play.getHeight()*2) &&
			   container.getInput().getMouseY() < ((halfH - hImageH) - play.getHeight())) {
				playDetection= true;
				optionsDetection = false;
				chooseShipDetection = false;
				quitDetection = false;
				if(container.getInput().isKeyPressed(Input.MOUSE_LEFT_BUTTON)) {
					sbg.enterState(2);
				}
			}
			if(container.getInput().getMouseY() > (((halfH - hImageH) - hImageH) - (hImageH)/2) &&
			   container.getInput().getMouseY() < (((halfH - hImageH) - hImageH) - ((hImageH)/2) - options.getHeight())) {
				playDetection= false;
				optionsDetection = true;
				chooseShipDetection = false;
				quitDetection = false;
				if(container.getInput().isKeyPressed(Input.MOUSE_LEFT_BUTTON)) {
					//sbg.enterState(2);
				}
			}
		}
		else {
			playDetection = false;
			optionsDetection = false;
			chooseShipDetection = false;
			quitDetection = false;
		}
		
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		if(playDetection) play2.draw(halfW - hImageW, (halfH - hImageH) - play.getHeight()*2);
		else play.draw(halfW - hImageW, (halfH - hImageH) - play.getHeight()*2);
		if(optionsDetection) options2.draw(halfW - hImageW, ((halfH - hImageH) - hImageH) - (hImageH)/2);
		else options.draw(halfW - hImageW, ((halfH - hImageH) - hImageH) - (hImageH)/2);
		chooseShip.draw(halfW - hImageW, ((halfH - hImageH) + hImageH) + (hImageH)/2);
		quit.draw(halfW - hImageW, (halfH - hImageH) + quit.getHeight()*2);
	}

	@Override
	public int getID() { return 1; }

}
