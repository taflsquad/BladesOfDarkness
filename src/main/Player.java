package main;

import java.awt.LayoutManager;

import javax.swing.JPanel;

public class Player extends JPanel {
	
	private int xPosition, yPoistion;
	
	public Player(int startX, int StartY) {
		setxPosition(startX);
		setyPoistion(StartY);
		
		
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPoistion() {
		return yPoistion;
	}

	public void setyPoistion(int yPoistion) {
		this.yPoistion = yPoistion;
	}

	
	
	

}
