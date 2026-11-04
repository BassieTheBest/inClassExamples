package game;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends GameObject{
	
	public Ball() {}
	
	public Ball(int x, int y, int speed, int size, Color color) {
		super(x,y,speed,size,color);
	}
	
	public void update() {
		if(this.x>800) {
			this.x=-100;
		}else {
			this.x = this.x + this.speed;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(this.color);
		g.fillOval(this.x, this.y, this.size, this.size);
	}
}
