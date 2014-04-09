package main;

import java.awt.LayoutManager;
import java.awt.*;

import javax.swing.JPanel;


public class Map extends JPanel {
	private int mapSizeX, mapSizeY, blockSize;
	private int mapArray[][];
	private Player player;
	private KeyListner listner;
	
	public Map() {
		mapSizeX = 10;
		mapSizeY = 10;
		blockSize = ElFrame.BLOCKSIZE;
		mapArray = new int [mapSizeY][mapSizeX];
		defineMap();
		player = new Player(10,10);
		listner = new KeyListner(player);
		add(player);
		addKeyListener(listner);
		
		
	}
	
	public void draw(){
		repaint();
	}
	
	public void defineMap(){
		
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for (int row = 0; row < (mapSizeY*blockSize); row+=blockSize){
			for (int col = 0; col < (mapSizeX*blockSize);col+=blockSize){
				g.drawRect(row, col, blockSize, blockSize);
			}
		}
		
		
	}

}
