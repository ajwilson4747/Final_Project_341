import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

public class Type_C_GameObject extends Game_Object implements KeyListener{

	// data members
	private int imageWidth;

	// constructor
	public Type_C_GameObject(int x, int y) {
		super(x, y);
		setVelocity(3);
		myImage = new ImageIcon("image/ghost_2.png.png");
		imageWidth = myImage.getIconWidth();
	}

	// implement abstract method move
	public void move(Canvas canvas) {
		
		if(isChecked()==true) {
			
			switch(getDirection()) {
			
			case Direction.LEFT:
				setX(getX() - getVelocity());
				myImage = new ImageIcon("image/ghost_1-2.png.png");
				
				if (getX() < 0) {
					setX(0);
					setDirection(Direction.RIGHT);
					
				}
				break; 
			
			case Direction.RIGHT:
				setX(getX() + getVelocity());
				myImage = new ImageIcon("image/ghost_1-2.png.png");
				
				if (getX() + imageWidth > canvas.getSize().getWidth()) {
					setX((int) (canvas.getSize().getWidth() - imageWidth));
					setDirection(Direction.LEFT);
				}
				break;
			}
			
		}
		else {
			setVelocity(2);
			myImage = new ImageIcon("image/ghost_2.png.png");
			// move the left icon and check for collision
			if (getDirection() == Direction.LEFT) {
				setX(getX() + getVelocity());
				if (getX() + imageWidth > canvas.getSize().getWidth()) {
					setX((int) (canvas.getSize().getWidth() - imageWidth));
					setDirection(Direction.RIGHT);
			}
			}
		// have the icon go towards the right
			else {
				setX(getX() - getVelocity());
				// if the icon is close to the barrier
				// have it go back to the left
				if (getX() < 0) {
					setX(0);
					setDirection(Direction.LEFT);
				}
			}
		}
		

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (isChecked() ==true) {
			if(e.getKeyChar()=='a') {
				setDirection(Direction.LEFT);
			}
			if(e.getKeyChar()=='d') {
				setDirection(Direction.RIGHT);
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(isChecked() ==true) {
			if(e.getKeyChar()!= 't') {
				setDirection(Direction.NONE);
			}
		}
	}

	@Override
	public void highlighting(Component c, Graphics g) {
		Image image = myImage.getImage();
		;int height = image.getHeight(c);
		int width = image.getWidth(c);
		
		if(isChecked() ==true) {
		g.setColor(Color.YELLOW);
		g.draw3DRect(getX(), getY(), width, height, true);
		}
		
	}	
}
