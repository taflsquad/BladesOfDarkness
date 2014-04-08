package main;



import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListner implements KeyListener {
	
	private Player player;
	
	
	public KeyListner(Player player) {
		this.player = player;
	}
	
	public void walk(int newX , int newY){
		
//		int oldX = player.getxPosition();
//		int oldY = player.getyPosition();
		
		player.setyPosition(newY);
		player.setxPosition(newX);
		System.out.println("New movement. X: " + newX + " Y: " + newY);
		
		
		
	}

	@Override
	public void keyPressed(KeyEvent k) {
		int x = player.getxPosition();
		int y = player.getyPosition();
		switch(k.getKeyCode()){
		
		case KeyEvent.VK_UP:
			walk(x,y-1);
			
			break;
			
		case KeyEvent.VK_S:
			walk(x,y+1);
			
			break;
		
		case KeyEvent.VK_A:
			walk(x+1,y);
			break;
			
		case KeyEvent.VK_D:
			walk(x-1,y);
			break;
			
		default:
			System.out.println("This key doesnt do a thing mmkay");
		break;
		
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		

	}

}
