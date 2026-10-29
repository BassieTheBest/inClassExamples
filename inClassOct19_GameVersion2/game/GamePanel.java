package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	private static final long serialVersionUID = 1L;
	Ball ball;
	Block block;
	Player player;
	Dimension dim;
	
	public GamePanel(Dimension dim) {
		this.setSize(dim);
		this.setBackground(Color.black);
		ball = new Ball("ball1",100,100,5,1,50,Color.red);
		block = new Block("block1",400,100,3,1,100,Color.blue);
		player = new Player("player",400,300,3,1,100,200,Color.blue);
		this.addKeyListener(player);
		this.setFocusable(true);
		this.setIgnoreRepaint(true);
	}
	
	public void update() {
		ball.update();
		block.update();
		player.update();
	}
	
	public void render(Graphics g) {
		ball.render(g);
		block.render(g);
		player.render(g);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.render(g);
		Toolkit.getDefaultToolkit().sync();
	}
	

	@Override
	public void run() {
		// GAMELOOP
		while(true) {
			this.update();
			this.repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
