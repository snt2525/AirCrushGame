package strategy;

import java.awt.Image;

import javax.swing.ImageIcon;

import model.GameObject;
import model.GameObject.STATE;
import view.GameFrame;

public class DrawShip implements Drawable
{
	public Image[] me;
	private int  t= 0;
	public DrawShip()
	{
		me = new Image[3];
		for (int i = 0; i < me.length; ++i)
		{
			me[i] = new ImageIcon("assets/me_" + i + ".gif").getImage();
		}
	}
	
	@Override
	public void draw(GameObject gobject, GameFrame gameFrame)
	{
		switch (gobject.state)
		{
			case NORMAL:
				gameFrame.draw(me[0], gobject.x, gobject.y);
				break;

			case FIRE:
				if (((t++) / 5 % 2) == 0)
				{
					gameFrame.draw(me[1], gobject.x, gobject.y);
					
				} else
				{
					gameFrame.draw(me[2], gobject.x, gobject.y);
				}
				gobject.state = STATE.NORMAL;
				break;
			case DIE:
				break;
		}
	}

}
