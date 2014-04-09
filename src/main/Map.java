package main;

import java.awt.LayoutManager;
import java.awt.*;

import javax.swing.JPanel;


public class Map extends JPanel {
	public static final int mapSizeX = 10;
	public static final int mapSizeY = 10;
	
	private int blockSize;
	private int mapArray[][];
	private Player player;
	private KeyListner listner;
	
	public Map() {
		
		blockSize = ElFrame.BLOCKSIZE;
		mapArray = new int [mapSizeY][mapSizeX];
		defineMap();
		
		try{
		add(KeyListner.player);
		}catch(NullPointerException e){
			System.out.println("Feil med å legge til Spiller i Map-Classen, sjekk ut Maps constructor");
		}
		
		
		
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
