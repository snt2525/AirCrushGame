package controller;

import java.util.ArrayList;

import model.GameData;
import model.GameObject;
import model.GameObject.STATE;
import view.GameFrame;
import view.ScoreFrame;

public enum GameController implements Runnable
{
	INSTANCE;

	public Thread th;
	int t, t2, t3;
	public GameFrame gameFrame;

	public void start()
	{
		th = new Thread(this);
		th.start();
	}

	public void run()
	{
		try
		{
			while (true)
			{
				InputController.INSTANCE.KeyProcess();
				EnemyOrLifeProcess();
				MissileProcess();
				gameFrame.repaintUpdate();
				gameFrame.repaint();
				Thread.sleep(20);
				t++;
				t2 += 133;
				t3++;
			}

		} catch (Exception e)
		{
		}

	}

	public boolean Crash(GameObject o1, GameObject o2)
	{
		if (Math.abs((o1.x + o1.w / 2) - (o2.x + o2.w / 2)) < (o2.w / 2 + o1.w / 2)
				&& Math.abs((o1.y + o1.h / 2) - (o2.y + o2.h / 2)) < (o2.h / 2 + o1.h / 2))
		{
			return true;
		}

		return false;
	}

	public void MissileProcess()
	{
		if (InputController.INSTANCE.KeySpace == true)
		{
			gameFrame.ship.state = STATE.FIRE;

			if ((t % GameData.fire_Speed) == 0)
			{
				gameFrame.addMissle();
			}
		}

		crashProcess(gameFrame.missileList, gameFrame.enemyList, 10, 0);
		crashProcess(gameFrame.missileList, gameFrame.lifeList, 0, 1);

		dieProcess(gameFrame.missileList);
		dieProcess(gameFrame.enemyList);
		dieProcess(gameFrame.lifeList);
	}

	private void crashProcess(ArrayList<GameObject> list1,
			ArrayList<GameObject> list2, int score, int hit_point)
	{
		for (int i = 0; i < list1.size(); ++i)
		{
			for (int j = 0; j < list2.size(); ++j)
			{
				if (Crash(list1.get(i), list2.get(j)) == true)
				{
					list1.get(i).state = STATE.DIE;
					list2.get(j).state = STATE.DIE;
					GameData.game_Score += score;
					GameData.player_HitPoint += hit_point;
				}
			}
		}
	}

	private void dieProcess(ArrayList<GameObject> list)
	{
		for (int i = list.size() - 1; i >= 0; --i)
		{
			if (list.get(i).state == STATE.DIE)
			{
				list.remove(i);
			}
		}
	}

	public void EnemyOrLifeProcess()
	{
		GameObject e = null;
		for (int i = gameFrame.enemyList.size() - 1; i >= 0; --i)
		{
			e = gameFrame.enemyList.get(i);

			if (Crash(gameFrame.ship, e))
			{
				GameData.player_HitPoint--;

				gameFrame.enemyList.remove(i);
				if (GameData.player_HitPoint == 0)
				{
					new ScoreFrame(GameData.game_Score);
				}
				GameData.game_Score += 10;
			}

		}
		if (t % 50 == 0)
		{
			gameFrame.addEnemy(10);
			gameFrame.addEnemy(120);
			gameFrame.addEnemy(300);
			gameFrame.addEnemy(490);
		}
		if (t2 % 120 == 0)
		{
			gameFrame.addEnemy(200);
			gameFrame.addEnemy(400);
			gameFrame.addEnemy(560);

		}
		if (t3 % 1000 == 0)
		{
			gameFrame.addLife();
		}

	}
}
