package game;

import java.awt.Graphics;
import java.util.Random;

public class Balls {
	RandomBall[] balls;
	int height;
	int width;
	
	public Balls(int width, int height) {
		Random rnd = new Random();
		this.balls = new RandomBall[rnd.nextInt(15)+4];
		this.width=width;
		this.height=height;
	}
	
	public void init() {
		int index;
		
		for(index=0;index<this.balls.length;index++){
			this.balls[index] = new RandomBall(this.width,this.height);
		}
		
	}
	
	public void update() {
		int index;
		
		for(index=0;index<this.balls.length;index++){
			this.balls[index].update();
		}
		
	}
	
	public void render(Graphics g) {
		int index;
		
		for(index=0;index<this.balls.length;index++){
			this.balls[index].render(g);
		}
		
	}
}
