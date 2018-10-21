package model;

import strategy.Drawable;
import strategy.Moveable;
import view.GameFrame;

public class GameObject
{
	public static GameFrame gameFrame;
	public int x, y;
	public int w, h;
	public int speed;

	public Drawable drawComponent;
	private Moveable moveComponent;

	public enum STATE
	{
		NORMAL, FIRE, DIE;
	}

	public STATE state = STATE.NORMAL;

	public void setStrategy(Drawable dc, Moveable mc)
	{
		drawComponent = dc;
		moveComponent = mc;
	}

	public void update()
	{
		moveComponent.move(this);
	}

	public void draw()
	{
		drawComponent.draw(this, gameFrame);
	}

}
