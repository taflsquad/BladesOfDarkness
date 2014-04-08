package main;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.Collection;

import javax.swing.JFrame;

public class ElFrame extends JFrame implements Runnable {

	private boolean running;
	
	public static final int BLOCKSIZE = 64;
	private Map map;
	
	private Dimension leMapSize;
	
	
	public ElFrame(){
		setTitle("Blades of Darkness");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		leMapSize  = new Dimension(BLOCKSIZE*10+7,BLOCKSIZE*10+30);	
		initialize();
		
		
	}
	
	public void initialize(){
		setLayout((new GridLayout(1,1)));
		//FILL
		map = new Map();
		add(map);
		
		
		//FILL
		
		setSize(leMapSize);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	@Override
	public void run() {
		

	}
	
	public synchronized void start(){
		running = true;
		new Thread(this).start();
	}
	public synchronized void stop(){
		running = false;
	}
	public static void main(String[] args) {
		new ElFrame().start();

	}

}
