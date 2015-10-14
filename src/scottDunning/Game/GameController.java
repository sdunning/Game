package scottDunning.Game;

import java.util.LinkedList;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GameController {
	
	//Values Initiated//
	private boolean gameStarted = false;
	private Image background = null;
	private String ship1 = null;
	private String playerShip = null;
	private int width = 0, height = 0;
	private int wave = 0;
	
	private Player player1 = null;
	private LinkedList<Enemy> enemies = new LinkedList<Enemy>();
	
	//Constructors//
	public GameController(int width, int height) throws SlickException {
		this.width = width; this.height = height;
		ship1 ="images/green.png";
		playerShip = "images/red.png";
	}
	
	//Get Functions//
	public boolean getGameStarted()       { return gameStarted; }
	public Image getBackground()          { return background; }
	public Player getPlayer()             { return player1; }
	public LinkedList<Enemy> getEnemies() { return enemies; }
	//End Get Functions//
	
	//Set Functions//
	public void setGameStarted(boolean gameStarted)   {this.gameStarted = gameStarted; }
	public void setBackground(Image bg)               { background = bg; }
	public void setPlayer(Player player)              {player1 = player; }
	public void setEnemies(LinkedList<Enemy> enemies) { this.enemies = enemies; }
	//End Set Functions//
	
	//Player Handling//
	public void createPlayer(int type, String skinDestination) throws SlickException {
		int posX = width / 2;
		int posY = height - 100;
		int health = 0;
		int damage = 0;
		int speed = 0;
		if(type == Player.LIGHT)    { health = 75; damage = 2; speed = 7; }
		if(type == Player.BALANCED) { health = 100; damage = 5; speed = 5; }
		if(type == Player.HEAVY)    { health = 125; damage = 8; speed = 3; }
		
		player1 = new Player(type, posX, posY, health, damage, speed, skinDestination);
	}
	
	//Enemy Handling//
	public void createEnemy(int type) throws SlickException {
		Enemy enemy = null;
		if (type == Enemy.GRUNT) {
			enemy = new Enemy(Enemy.GRUNT, 250, 250, 1, 1, ship1);
		}
		if(type == Enemy.BRUTE) {}
		if(type == Enemy.BOSS) {}
		enemies.add(enemy);
		
	}
	public void destroyEnemy(Enemy enemy) {
		enemies.remove(enemy);
	}
	//End Enemy Handling//

}
