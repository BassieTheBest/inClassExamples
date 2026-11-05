package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ship extends GameObject implements KeyListener {
	BufferedImage image;
	int keyCode;

	
	public Ship(int x, int y, int speed) {
		this.x=x;
		this.y=y;
		this.speed=speed;
		loadImage();
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
	public void render(Graphics g) {
		g.drawImage(this.image,this.x,this.y,null);
		
	}
	
	public void loadImage() {
		File imageFile = new File("images/ship4.png");
		try {
			this.image = ImageIO.read(imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		this.keyCode = e.getKeyCode();
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
