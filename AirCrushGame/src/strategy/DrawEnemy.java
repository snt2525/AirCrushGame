package strategy;

import model.GameObject;
import view.GameFrame;

public class DrawEnemy implements Drawable
{

	@Override
	public void draw(GameObject gobject, GameFrame gameFrame)
	{
		gameFrame.draw(gameFrame.enemy, gobject.x, gobject.y);
	}

}
