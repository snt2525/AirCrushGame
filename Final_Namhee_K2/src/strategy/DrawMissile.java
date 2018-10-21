package strategy;

import model.GameObject;
import view.GameFrame;

public class DrawMissile implements Drawable
{

	@Override
	public void draw(GameObject gobject, GameFrame gameFrame)
	{
		gameFrame.draw(gameFrame.missile, gobject.x, gobject.y);
	}

}
