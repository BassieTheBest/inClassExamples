package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class RandomBall extends GameObject {
	int speedX;
	int speedY;
	int height;
	int width;
	
	public RandomBall(int width, int height) {
		this.width=width;
		this.height=height;
		Random rnd = new Random();
		this.x = rnd.nextInt(400) + 50;
		this.y = rnd.nextInt(400) + 50;
		this.size = rnd.nextInt(50) + 20;
		this.speedX = rnd.nextInt(5) + 1;
		this.speedY = rnd.nextInt(5) + 1;
		this.color = new Color(rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256));
	}
	
	@Override
	public void update() {
		if((this.x+this.size)>=this.width || this.x<=0) {
			this.speedX = this.speedX * -1;
		}
		this.x = this.x +this.speedX;
		
		if((this.y+this.size)>=this.height-40 || this.y<=0) {
			this.speedY = this.speedY * -1;
		}
		this.y = this.y +this.speedY;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(this.color);
		g.fillOval(this.x, this.y, this.size, this.size);	
	}

}
