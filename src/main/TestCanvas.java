package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class TestCanvas {
	
	public static Rectangle getBounds(JPanel p) {
		
		return null;
	}

	public static void main(String[] args) {
		JFrame window = new JFrame("Canvas");
		window.setLayout(new BorderLayout());
		Canvas background = new Canvas(DefaultMap.BLADES_OF_DARKNESS);
		SecondFrame grid = new SecondFrame();
		Canvas tree = new Canvas(DefaultMap.LITTLE_TREE);
		tree.setOpaque(false);
		
		JLayeredPane box = new JLayeredPane();
		box.setPreferredSize(new Dimension(800, 600));
		tree.setBounds(100, 200, 200, 200);
		grid.setBounds(0, 0, 800, 600);
		background.setBounds(0, 0, 800, 600);
		
		grid.setOpaque(false);
		box.add(background, 0);
		box.add(tree,10,10);
		
		window.add(box);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setAlwaysOnTop(true);

		//int width = panel.getMapWidth() + 10;
		//int height = panel.getMapHeight() + 50;
		int width = 540;
		int height = 555;
		window.pack();
		//window.setSize(width, height);
		
	}

}

class MyFrame extends JPanel {
	private Image background;
	private int mapSizeY, mapSizeX, blockSize; 
	
	public MyFrame() {
		background = Toolkit.getDefaultToolkit().createImage("res/linkSheet.png");
		setSize(800, 600);
		blockSize = 30;
		mapSizeX = 16;
		mapSizeY = 16;
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}
	
}


class SecondFrame extends JPanel {
	private Image background;
	private int mapSizeY, mapSizeX, blockSize; 
	
	public SecondFrame() {
		background = Toolkit.getDefaultToolkit().createImage("res/tiles.png");
		
		blockSize = 32;
		mapSizeX = 16;
		mapSizeY = 16;
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//setBackground(Color.MAGENTA);
		//g.drawImage(background, 0, 0, getParent());
		for (int row = 0; row < (mapSizeY*blockSize); row+=blockSize){
			for (int col = 0; col < (mapSizeX*blockSize);col+=blockSize){
				g.drawRect(row, col, blockSize, blockSize);
			}
		}
	}
	
}
