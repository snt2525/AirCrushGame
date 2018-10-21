package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.GameData;

public class ScoreFrame extends JFrame
{
	class grades extends JFrame
	{
		ImageIcon chobo = new ImageIcon("assets/1.png");
		ImageIcon joongsu = new ImageIcon("assets/2.png");
		ImageIcon gosu = new ImageIcon("assets/3.png");
		ImageIcon chogosu = new ImageIcon("assets/4.png");

		JLabel ch = new JLabel(chobo);
		JLabel jo = new JLabel(joongsu);
		JLabel go = new JLabel(gosu);
		JLabel cho = new JLabel(chogosu);

		ImageIcon chobo2 = new ImageIcon("assets/1.png");
		ImageIcon joongsu2 = new ImageIcon("assets/2.png");
		ImageIcon gosu2 = new ImageIcon("assets/3.png");
		ImageIcon chogosu2 = new ImageIcon("assets/4.png");

		JLabel ch2 = new JLabel(chobo);
		JLabel jo2 = new JLabel(joongsu);
		JLabel go2 = new JLabel(gosu);
		JLabel cho2 = new JLabel(chogosu);

		grades()
		{
			setTitle("Level");
			setLayout(null);
			setBackground(Color.WHITE);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			class gradesPanel extends JPanel
			{
				gradesPanel()
				{
					setLayout(null);
					if (presentScore < 1000)
					{
						JLabel k = new JLabel("Baby");
						k.setBounds(135, 20, 200, 15);
						add(k);
						ch2.setBounds(100, 35, 100, 100);
						add(ch2);
					} else if (1000 <= presentScore && presentScore < 2000)
					{
						JLabel k = new JLabel("Junior");
						k.setBounds(135, 20, 200, 15);
						add(k);
						jo2.setBounds(100, 35, 100, 100);
						add(jo2);
					} else if (2000 <= presentScore && presentScore < 4000)
					{
						JLabel k = new JLabel("Intermediate");
						k.setBounds(135, 20, 200, 15);
						add(k);
						go2.setBounds(100, 35, 100, 100);
						add(go2);
					} else
					{
						JLabel k = new JLabel("Master");
						k.setBounds(135, 20, 200, 15);
						add(k);
						cho2.setBounds(100, 35, 100, 100);
						add(cho2);
					}

				}
			}
			gradesPanel gP = new gradesPanel();
			gP.setBounds(0, 0, 300, 300);
			add(gP);
			JLabel l1 = new JLabel("Baby(under 1000)");
			JLabel l2 = new JLabel("Junior(more than 1000 under 2000)");
			JLabel l3 = new JLabel("Intermediate(more than 2000 under 4000)");
			JLabel l4 = new JLabel("Master(more than 4000)");

			ch.setBounds(10, 300, 100, 100);
			jo.setBounds(10, 350, 100, 100);
			go.setBounds(10, 400, 100, 100);
			cho.setBounds(10, 450, 100, 100);

			l1.setBounds(100, 350, 300, 20);
			l2.setBounds(100, 400, 300, 20);
			l3.setBounds(100, 450, 300, 20);
			l4.setBounds(100, 500, 300, 20);

			add(ch);
			add(jo);
			add(go);
			add(cho);

			add(l1);
			add(l2);
			add(l3);
			add(l4);
			setSize(300, 700);
			setVisible(true);
		}
	}

	JButton b1;
	private int presentScore;

	public ScoreFrame(int score)
	{
		super();
		presentScore = score;
		setTitle("Score");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String name = JOptionPane.showInputDialog("Enter your name: ");
		JLabel t1 = new JLabel(name + "'s socore is " + GameData.game_Score + ".");
		t1.setSize(200, 20);
		t1.setLocation(80, 100);
		add(t1);
		b1 = new JButton("Check my Level");
		MyAction l = new MyAction();
		b1.addActionListener(l);
		b1.setBounds(75, 150, 150, 50);
		add(b1);

		setSize(300, 300);
		setVisible(true);
	}

	class MyAction implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			new grades();
		}
	}
}