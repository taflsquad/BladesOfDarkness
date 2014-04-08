package main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestCanvas {

	public static void main(String[] args) {
		JFrame window = new JFrame("Canvas");
		window.setLayout(new GridLayout(1,1));
		MyFrame panel = new MyFrame();
		window.add(panel);
		window.setSize(540, 555);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setAlwaysOnTop(true);

		
	}

}

class MyFrame extends JPanel{
	private Image background;
	private int mapSizeY, mapSizeX, blockSize; 
	
	public MyFrame() {
		background = Toolkit.getDefaultToolkit().createImage("res/tiles.png");
		setSize(800, 600);
		setOpaque(true);
		blockSize = 32;
		mapSizeX = 16;
		mapSizeY = 16;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.MAGENTA);
		g.drawImage(background, 0, 0, getParent());
		for (int row = 0; row < (mapSizeY*blockSize); row+=blockSize){
			for (int col = 0; col < (mapSizeX*blockSize);col+=blockSize){
				g.drawRect(row, col, blockSize, blockSize);
			}
		}
	}
	
}
