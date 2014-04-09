package main;



import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.PaintContext;

import javax.swing.JPanel;

public class Player extends JPanel {
	
	private int xPosition, yPosition, rupeeCount, level;
	private KeyListner listner;
	
	public Player(int startX, int StartY) {
		setxPosition(startX);
		setyPosition(StartY);
		rupeeCount = 0;
		level = 1;
		
		
	}
	
	public void paintComponent(Graphics g){
		g.fillRect(64, 64, getxPosition(), getyPosition());
	}
	
	public void draw(){
		repaint();
	}
	
	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	
	
	

}
