package main;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Collection;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class ElFrame extends JFrame implements Runnable {

	private boolean running;
	
	public static final int BLOCKSIZE = 64;
	private Map map;
	
	private Dimension leMapSize;
	

	
	public int tickCount;
	public static int speed;
	public static int nrSprite;
	
	
	public ElFrame(){
		
		tickCount = 0;
		
		setTitle("Blades of Darkness");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//leMapSize  = new Dimension(BLOCKSIZE*10+7,BLOCKSIZE*10+30);	
		initialize();
		
		
	}
	
	public void initialize(){
		setLayout((new GridLayout(1,1)));
		
		//FILL
		map = new Map();
		KeyListner listner = new KeyListner();
		JLayeredPane layeredPane = new JLayeredPane();
		Canvas background = new Canvas(DefaultMap.BLADES_OF_DARKNESS);
		int mapWidth = background.getMapWidth() + 7;
		int mapHeight = background.getMapHeight() + 30;
		leMapSize = new Dimension(mapWidth,mapHeight);
		layeredPane.setPreferredSize(leMapSize);
		addKeyListener(listner);
		
		add(layeredPane);
		
		nrSprite = 0;
		speed = 0;
		
		//add(map);
		KeyListner.player.setBounds(20, 20, mapWidth, mapHeight);
		KeyListner.player.setOpaque(false);
		layeredPane.add(KeyListner.player, 5, 10);
		
		background.setBounds(0, 0, mapWidth, mapHeight);
		Canvas tree = new Canvas(DefaultMap.LITTLE_TREE);
		tree.setBounds(100, 100, 64, 96);
	
		layeredPane.add(tree,10,100);
		layeredPane.add(background, JLayeredPane.DEFAULT_LAYER);
		//FILL
		
		setSize(leMapSize);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
	}
	public class BufferedImageLoader {
		private BufferedImage image;
		public BufferedImage loadImage(String path) throws IOException{
			image = ImageIO.read(getClass().getResource(path));
			return image;
		}
	}
	@Override
	public void run() {
		
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D/60D;
		
		int ticks = 0;
		int frames = 0;
		
		long lastTimer = System.currentTimeMillis();
		double delta = 0;
		
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = true;
			
			while (delta >= 1){
				ticks++;
				tick();
				delta -= 1;
				shouldRender = true;
			}
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (shouldRender){
			frames++;
			
			}
			
			if (System.currentTimeMillis() - lastTimer>=1000){
				lastTimer +=1000;
				//System.out.println("Ticks: " + ticks + " Frames: "+ frames);
				frames = 0;
				ticks = 0;
				
			}
		}
	}
	
	public void tick(){
		tickCount++;
		double x = KeyListner.player.getxPosition();
		double y = KeyListner.player.getyPosition();
		
		
		if(KeyListner.upPressed){
			if(!KeyListner.moveIsBlocked(x, y-2)){
				KeyListner.walk(x,y-2);
			}
		}
		if (KeyListner.downPressed){
			KeyListner.walk(x,y+2);
		}
		if (KeyListner.leftPressed){
			KeyListner.walk(x-2,y);
		}
		if (KeyListner.rightPressed){
			KeyListner.walk(x+2,y);
		}
		
		speed++;
		int rate = 4; //smaller == faster
		if (speed > rate)
			speed = 0;
		
		
		if (speed/rate == 1) {
			nrSprite++;
			//System.out.println("nrSprite: " + nrSprite);
			
		}
		if (nrSprite > 5){
			nrSprite = 0;
			//System.out.println("reset");
		}
		
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
