package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;

import model.GameData;
import model.GameObject;
import strategy.DrawEnemy;
import strategy.DrawLife;
import strategy.DrawMissile;
import strategy.DrawShip;
import strategy.MoveEnemy;
import strategy.MoveLife;
import strategy.MoveMissile;
import strategy.MoveShip;
import controller.GameController;
import controller.InputController;

public class GameFrame extends JFrame
{
	Toolkit tk = Toolkit.getDefaultToolkit();

	public GameObject ship;

	public Image missile;
	public Image enemy;
	public Image life;

	public DrawMissile drawMissile;
	public MoveMissile moveMissile;
	public DrawEnemy drawEnemy;
	public MoveEnemy moveEnemy;
	public DrawLife drawLife;
	public MoveLife moveLife;

	public ArrayList<GameObject> missileList = new ArrayList<GameObject>();
	public ArrayList<GameObject> enemyList = new ArrayList<GameObject>();
	public ArrayList<GameObject> lifeList = new ArrayList<GameObject>();

	private Image buffImage;
	private Graphics buffg;

	public GameFrame()
	{
		init();
		start();

		setTitle("Final_Namhee_K");
		setSize(600, 700);
		setBackground(Color.WHITE);

		setResizable(false);
		setVisible(true);
	}

	public void init()
	{
		GameObject.gameFrame = this;
		GameController.INSTANCE.gameFrame = this;

		ship = new GameObject();
		ship.setStrategy(new DrawShip(), new MoveShip());
		ship.w = ((DrawShip) (ship.drawComponent)).me[0].getWidth(null);
		ship.h = ((DrawShip) (ship.drawComponent)).me[0].getHeight(null);
		ship.x = 280;
		ship.y = 630;

		drawMissile = new DrawMissile();
		moveMissile = new MoveMissile();
		drawEnemy = new DrawEnemy();
		moveEnemy = new MoveEnemy();
		drawLife = new DrawLife();
		moveLife = new MoveLife();

		InputController.INSTANCE.ship = ship;

		missile = tk.getImage("assets/missile.gif");
		enemy = tk.getImage("assets/enemy.gif");
		life = tk.getImage("assets/life.gif");

		GameData.init();
	}

	public void start()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(InputController.INSTANCE);

		GameController.INSTANCE.start();
	}

	public void addMissle()
	{
		GameObject gobject = new GameObject();
		gobject.x = ship.x + 20;
		gobject.y = ship.y;
		gobject.w = missile.getWidth(null);
		gobject.h = missile.getHeight(null);

		gobject.speed = GameData.missile_Speed;
		gobject.setStrategy(drawMissile, moveMissile);
		missileList.add(gobject);
	}

	public void addEnemy(int posx)
	{
		GameObject gobject = new GameObject();
		gobject.x = posx;
		gobject.y = 0;
		gobject.w = enemy.getWidth(null);
		gobject.h = enemy.getHeight(null);

		gobject.speed = GameData.enemy_Speed;
		gobject.setStrategy(drawEnemy, moveEnemy);
		enemyList.add(gobject);
	}

	public void addLife()
	{
		GameObject gobject = new GameObject();
		gobject.x = (int) (Math.random() * 570 + 1);
		gobject.y = 0;
		gobject.w = life.getWidth(null);
		gobject.h = life.getHeight(null);
		gobject.speed = GameData.life_Speed;
		gobject.setStrategy(drawLife, moveLife);
		lifeList.add(gobject);
	}

	public void paint(Graphics g)
	{
		buffImage = createImage(600, 800);
		buffg = buffImage.getGraphics();
		update(g);
	}

	public void repaintUpdate()
	{
		ship.update();

		for (int i = 0; i < missileList.size(); ++i)
		{
			missileList.get(i).update();
		}

		for (int i = 0; i < enemyList.size(); ++i)
		{
			enemyList.get(i).update();
		}

		for (int i = 0; i < lifeList.size(); ++i)
		{
			lifeList.get(i).update();
		}

	}

	public void update(Graphics g)
	{
		ship.draw();

		for (int i = 0; i < missileList.size(); ++i)
		{
			missileList.get(i).draw();
		}

		for (int i = 0; i < enemyList.size(); ++i)
		{
			enemyList.get(i).draw();
		}

		for (int i = 0; i < lifeList.size(); ++i)
		{
			lifeList.get(i).draw();
		}

		Draw_StatusText();

		g.drawImage(buffImage, 0, 0, this);
	}

	// int t=0;

	public void draw(Image img, int x, int y)
	{
		buffg.drawImage(img, x, y, this);
	}

	public void Draw_StatusText()
	{
		buffg.setFont(new Font("Defualt", Font.BOLD, 20));
		buffg.drawString("Score: " + GameData.game_Score, 50, 50);
		buffg.drawString("Life : " + GameData.player_HitPoint, 50, 70);
	}

}
