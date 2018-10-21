package strategy;

import model.GameObject;
import model.GameObject.STATE;


public class MoveEnemy implements Moveable
{

	@Override
	public void move(GameObject gobject)
	{
		gobject.y += gobject.speed;
		
		if (gobject.y < -200)
		{
			gobject.state = STATE.DIE;
		}
		

	}

}

