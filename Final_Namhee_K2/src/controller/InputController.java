package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.GameObject;
	
public enum InputController implements KeyListener
{
	INSTANCE;
	
	public GameObject ship=null;
	private boolean KeyUp = false;
	private boolean KeyDown = false;
	private boolean KeyLeft = false;
	private boolean KeyRight = false;
	public boolean KeySpace = false;
	
	
	public void KeyProcess()
	{
		if (KeyUp == true)	ship.y -= 8;
		
		if (KeyDown == true) ship.y += 8;
		
		if (KeyLeft == true) ship.x -= 8;
		
		if (KeyRight == true) ship.x += 8;
	}

	
	public void keyPressed(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_UP:
				KeyUp = true;
				break;
			case KeyEvent.VK_DOWN:
				KeyDown = true;
				break;
			case KeyEvent.VK_LEFT:
				KeyLeft = true;
				break;
			case KeyEvent.VK_RIGHT:
				KeyRight = true;
				break;
			case KeyEvent.VK_SPACE:
				KeySpace = true;
				break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_UP:
				KeyUp = false;
				break;
			case KeyEvent.VK_DOWN:
				KeyDown = false;
				break;
			case KeyEvent.VK_LEFT:
				KeyLeft = false;
				break;
			case KeyEvent.VK_RIGHT:
				KeyRight = false;
				break;
			case KeyEvent.VK_SPACE:
				KeySpace = false;
				break;
		}
	}

	public void keyTyped(KeyEvent e)
	{
	}


}
