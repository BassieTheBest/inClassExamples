package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Asteroid extends GameObject{
	BufferedImage img;
	
	public Asteroid(int x, int y, int speed) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		loadImage("a10000.png");
	}
	
	public Asteroid(int x, int y, int speed, String imageName) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		loadImage(imageName);
	}
	
	public void loadImage(String imageName) {
		File imageFile = new File("images/asteroids/medium/" + imageName);
		try {
			this.img = ImageIO.read(imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void update() {
		this.x = this.x + this.speed;
		if(this.x>800) {
			this.x = -50;
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(this.img,this.x,this.y,null);	
	}

}
