package main;



import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListner implements KeyListener {
	
	public static Player player;
	public boolean isValidMove;
	
	public static boolean upPressed;
	public static boolean downPressed;
	public static boolean leftPressed;
	public static boolean rightPressed;
	
	public KeyListner() {
		player = new Player(32.0,32.0);
		isValidMove = false;
		
		upPressed = false;
		downPressed = false;
		leftPressed = false;
		rightPressed = false;
	}
	
	public static boolean moveIsBlocked(double x, double y){
		if (/*x>=Map.mapSizeX+1 || y>=Map.mapSizeY+1 ||*/ x<=(32) || y<=(32)){
			return true;
		}else{
			return false;
		}
	}
	
	public static void walk(double newX , double newY){
//		int oldX = player.getxPosition();
//		int oldY = player.getyPosition();
		
		player.setyPosition(newY);
		player.setxPosition(newX);
		//System.out.println("New movement. X: " + newX + " Y: " + newY);
		player.repaint();
	}

	@Override
	public void keyPressed(KeyEvent k) {
		double x = player.getxPosition();
		double y = player.getyPosition();
		
		switch(k.getKeyCode()){
		
		case KeyEvent.VK_W:
		case KeyEvent.VK_UP:
			if(!moveIsBlocked(x,y-2.0)){
				upPressed = true;
				System.out.println("Up press");
				
			}else{
				System.out.println("Out of bounds");
				
			}
			//upPressed = true;
			break;
			
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			/*if(!moveIsBlocked(x,y+0.4)){
				System.out.println("Down press");
				walk(x,y+1);
			}else{
				
			}*/
			downPressed = true;
			break;
		
		case KeyEvent.VK_A:
		case KeyEvent.VK_LEFT:
			/*if(!moveIsBlocked(x-0.4,y)){
				System.out.println("Left press");
				walk(x-1,y);
			}else{
				System.out.println("Out of bounds");
				walk(x-1,y);
			}*/
			leftPressed = true;
			break;
			
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT:
			/*if(!moveIsBlocked(x+0.4, y)){
				System.out.println("Right press");
				walk(x+1,y);
			}else{
				System.out.println("Out of bounds");
				walk(x+1,y);
			}*/
			rightPressed = true;
			break;
			
		default:
			System.out.println("This key doesnt do a thing mmkay");
		break;
		
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		switch(arg0.getKeyCode()){
		
		case KeyEvent.VK_W:
		case KeyEvent.VK_UP:
				upPressed=false;
				
			break;
			
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
				downPressed = false;
			break;
		
		case KeyEvent.VK_A:
		case KeyEvent.VK_LEFT:
				leftPressed = false;
			break;
			
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT:
				rightPressed = false;
			break;
			
		default:
			System.out.println("This key doesnt do a thing mmkay");
		break;
		
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		

	}

}
