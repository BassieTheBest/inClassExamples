package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends GameObject implements KeyListener{
	int keyCode;
	
	public Player(int x, int y, int speed, int size, Color color) {
		super(x,y,speed,size,color);
	}

	@Override
	public void update() {
		if(this.keyCode == 37) {
			this.x = this.x - this.speed;
		}
		if(this.keyCode == 39) {
			this.x = this.x + this.speed;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		this.keyCode = e.getKeyCode();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.size, this.size);	
	}

}
