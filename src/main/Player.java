package main;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.PaintContext;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Player extends JPanel{
	
	private double xPosition, yPosition;
	private int rupeeCount, level;
	private KeyListner listner;
	private int x, y, spriteWidth, spriteHeight, spriteX, spriteY;
	private Image sprite;
	
	public Player(double startX, double StartY) {
		setxPosition(startX);
		setyPosition(StartY);
		rupeeCount = 0;
		level = 1;
		
		sprite = Toolkit.getDefaultToolkit().createImage("res/linkSheet.png");
		
	}
	public void tick(){
		
	}
	
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.setColor(Color.BLUE);
		//g.fillRect((int)getxPosition(),(int)getyPosition(),32,32);
		x = (int) xPosition;
		y = (int) yPosition;
		spriteWidth = 30;
		spriteHeight = 30;
		
		if (KeyListner.rightPressed){
		spriteY = 120;
		spriteX = 240+ElFrame.nrSprite*spriteWidth;
		g.drawImage(sprite, x, y, x+spriteWidth, y+spriteHeight,
				spriteX, spriteY, spriteX+spriteWidth, spriteY+spriteHeight, this);
		} else 
		if (KeyListner.leftPressed){
			spriteY = 30;
			spriteX = 240+ElFrame.nrSprite*spriteWidth;
			g.drawImage(sprite, x, y, x+spriteWidth, y+spriteHeight,
					spriteX, spriteY, spriteX+spriteWidth, spriteY+spriteHeight, this);
		} else
		if (KeyListner.downPressed){
			spriteY = 30;
			spriteX = 0+ElFrame.nrSprite*spriteWidth;
			g.drawImage(sprite, x, y, x+spriteWidth, y+spriteHeight, 
					spriteX, spriteY, spriteX+spriteWidth, spriteY+spriteHeight, this);
		} else
		if (KeyListner.upPressed){
			spriteY = 120;
			spriteX = 0+ElFrame.nrSprite*spriteWidth;
			g.drawImage(sprite, x, y, x+spriteWidth, y+spriteHeight, 
					spriteX, spriteY, spriteX+spriteWidth, spriteY+spriteHeight, this);
		} else {
			spriteY = 2;
			spriteX = 32;
			g.drawImage(sprite, x, y, x+spriteWidth, y+spriteHeight,
					spriteX, spriteY, spriteX+spriteWidth, spriteY+spriteHeight, this);
		}
	}
	
	
	
	
	public double getxPosition() {
		return xPosition;
	}

	public void setxPosition(double xPosition) {
		this.xPosition = xPosition;
	}

	public double getyPosition() {
		return yPosition;
	}

	public void setyPosition(double yPosition) {
		this.yPosition = yPosition;
	}

	
	
	

}
