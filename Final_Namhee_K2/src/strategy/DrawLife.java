package strategy;

import model.GameObject;
import view.GameFrame;

public class DrawLife implements Drawable
{

	@Override
	public void draw(GameObject gobject, GameFrame gameFrame)
	{
		gameFrame.draw(gameFrame.life, gobject.x, gobject.y);

	}

}
