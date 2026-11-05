package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel implements Runnable{
	private static final long serialVersionUID = 1544878978114485164L;
	public JFrame window;
	public Dimension dim;
	public boolean running;
	public Thread gameLoop;
	public Ball ball;
	public Ship ship;
	
	public Game() {}
	
	public Game(String title, int width, int height) {
		this.window = new JFrame(title);
		this.dim = new Dimension(width,height);
		this.window.setPreferredSize(this.dim);
		this.window.setMinimumSize(dim);
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setLocationRelativeTo(null);
		this.window.setResizable(false);
		this.setDoubleBuffered(true);
		this.setPreferredSize(dim);
		this.window.add(this);
		this.setBackground(Color.black);
		this.ball = new Ball(150,150,1,75,Color.blue);
		this.ship = new Ship(400,400,2);
		this.addKeyListener(this.ship);
		this.window.setVisible(true);
		this.requestFocusInWindow();
		this.start();
	}
	
	public void update() {
		ship.update();
		ball.update();
	}
	
	public void render(Graphics g) {
		ship.render(g);
		ball.render(g);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.render(g);
		g.dispose();
		Toolkit.getDefaultToolkit().sync();
	}
	
	@Override
	public void run() {
		while(running) {
			update();
			repaint();
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void start() {
		this.running=true;
		this.gameLoop =  new Thread(this);
		this.gameLoop.start();
	}
	
	public static void main(String[] args) {
		Game game = new Game("Game Fall 2026",800,640);
		
	}
}
