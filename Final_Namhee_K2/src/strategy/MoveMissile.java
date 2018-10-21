package strategy;

import model.GameObject;
import model.GameObject.STATE;

public class MoveMissile implements Moveable
{

	@Override
	public void move(GameObject gobject)
	{
		gobject.y -= gobject.speed;
		
		if (gobject.y > 780 || gobject.y < -100 )
		{
			gobject.state = STATE.DIE;
		}
	}
}
