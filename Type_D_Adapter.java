import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;

public class Type_D_Adapter extends Game_Object implements KeyListener {

	private Type_B_GameObject obj;
	private ImageIcon myNewImage;
	//private boolean changeMove = false; 
	
	public Type_D_Adapter( Type_B_GameObject obj) {
		super(obj.getX(), obj.getY());
		this.obj = obj;
		myImage = new ImageIcon("image/ghost_3.png");
		//isChecked();
		//myNewImage.loadImage("image/");;
		//setVelocity(0);
	}

	public void move(Canvas canvas) {
		
		if(obj.isChecked() ==true) {
		
			switch (getDirection()) {
			
			case Direction.RIGHT:
				//setDirection(Direction.RIGHT);
				obj.setX(getX() + getVelocity());
				myImage = new ImageIcon("image/ghost_1-2.png.png");

				if (getX() + myImage.getIconWidth() > canvas.getSize().getWidth()) {
					obj.setX((int) canvas.getSize().getWidth() - myImage.getIconWidth());
					//myImage = new ImageIcon("image/BUptIcon.png");
					//setDirection(Direction.UP);
				}
				break;
			case Direction.LEFT:
				obj.setX(getX() - getVelocity());
				myImage = new ImageIcon("image/ghost_1-2.png.png");

				if (getX() < 0) {
					obj.setX(0);
					//setDirection(Direction.DOWN);
					//myImage = new ImageIcon("image/BDownIcon.png");
				}
				break;

			case Direction.UP:

				obj.setY(getY() - getVelocity());
				myImage = new ImageIcon("image/ghost_1-2.png.png");
				
				if (getY() < 0) {
					obj.setY(0);
					//setDirection(Direction.LEFT);
					setX(getX() - getVelocity());
					//myImage = new ImageIcon("image/BLeftIcon.png");
				}

				break;
			case Direction.DOWN:
				obj.setY(getY() + getVelocity());
				myImage = new ImageIcon("image/ghost_1-2.png.png");
				
				if (getY() + myImage.getIconHeight()> canvas.getSize().getHeight()) {
					obj.setY((int) canvas.getSize().getHeight() - myImage.getIconHeight());
					//setDirection(Direction.RIGHT);
					//myImage = new ImageIcon("image/BRightIcon.png");
				}
				break;
			}
		
	}
	}

	@Override
	public void highlighting(Component c, Graphics g) {		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		if(obj.isChecked() ==true) {
			if(e.getKeyChar()=='w') {
				obj.setDirection(Direction.UP);
				//System.out.print("w has been pressed");
			}
			if(e.getKeyChar()=='s') {
				obj.setDirection(Direction.DOWN);
			}
			if(e.getKeyChar()=='a') {
				obj.setDirection(Direction.LEFT);
			}
			if(e.getKeyChar()=='d') {
				obj.setDirection(Direction.RIGHT);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(isChecked() ==true) {
			if(e.getKeyChar()!= 't') {
				obj.setDirection(Direction.NONE);
			}
		}
		
	}

}
