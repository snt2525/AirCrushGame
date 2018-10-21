import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.GameFrame;

public class Project_namhee_K extends JFrame
{
	Container cp;

	Project_namhee_K()
	{
		setTitle("Final_Namhee_k");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		cp = getContentPane();

		ImgPanel p = new ImgPanel();
		cp.add(p, BorderLayout.CENTER);

		JButton start = new JButton("Game Start");
		startAction l = new startAction();
		start.addActionListener(l);
		cp.add(start, BorderLayout.SOUTH);

		setSize(500, 700);
		setVisible(true);
	}

	class ImgPanel extends JPanel
	{
		ImageIcon icon = new ImageIcon("assets/aa.png");
		Image main_img = icon.getImage();

		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);

			g.drawImage(main_img, 0, 0, getWidth(), getHeight(), this);
		}
	}

	class startAction implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			new GameFrame();
		}
	}

	public static void main(String[] ar)
	{
		new Project_namhee_K();
	}
}
