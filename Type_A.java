import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.Rectangle;

public class Type_A extends Game_Object implements KeyListener {

	// data members
	private int imageHeight;

	// constructor
	public Type_A(int x, int y) {
		super(x, y);
		setVelocity(3);
		
		myImage = new ImageIcon("image/ghost_1-1.png.png");
		//Image image = myImage.getImage();
		//Image newimage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		//myImage = new ImageIcon(newimage);
		
		imageHeight = myImage.getIconHeight();
		
		//objLabel = new JLabel(myImage);	
		//objLabel.setIcon(myImage);
		
		//myBorder = BorderFactory.createMatteBorder(getY() -myImage.getIconHeight(), getX() - myImage.getIconWidth(), getY() +myImage.getIconWidth(), getX() + imageHeight, Color.RED);
		//objLabel.setBorder(null);

	}

	// implement abstract method move
	public void move(Canvas canvas) {
		// if the velocity changes to 0 and the is isSelected variable is false
		
			if (isChecked() == true) {
				//objLabel.setBorder(myBorder);
			switch (getDirection()) {

			case Direction.DOWN:
				setY(getY() + getVelocity());
				myImage = new ImageIcon("image/ghost_1-2.png.png");
				//Canvas.myFrame.add(objLabel);
				if (getY() - imageHeight >  canvas.getSize().getHeight() - imageHeight) {
					setY((int) canvas.getSize().getHeight() -imageHeight);
					// setDirection(Direction.RIGHT);
					
					
				}
				break;

			case Direction.UP:
				//Canvas.myFrame.add(objLabel);
				setY(getY() - getVelocity());
				myImage = new ImageIcon("image/ghost_1-2.png.png");
				if (getY() <0) {
					setY(0);
					// setDirection(Direction.LEFT);
					//myImage = new ImageIcon("image/ghost_1-2.png.png");
					
				}
				break;
			}

		} else {
			
			//objLabel.setBorder(null);
			// move the left icon and check for collision
			if (getDirection() == Direction.DOWN) {
				setY(getY() + getVelocity());
				myImage = new ImageIcon("image/ghost_1-1.png.png");

				if (getY() - imageHeight > canvas.getSize().getHeight()) {
					setY((int) (canvas.getSize().getHeight() - imageHeight));
					setDirection(Direction.UP);
				}
			}
			// have the icon go towards the right
			else {
				setY(getY() - getVelocity());
				myImage = new ImageIcon("image/ghost_1-1.png.png");
				// if the icon is close to the barrier
				// have it go back to the left
				if (getY() < 0) {
					setY(0);
					setDirection(Direction.DOWN);
					//myImage = new ImageIcon("image/NewDown.png");
				}
			}
		}
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {
		if (isChecked() == true) {

			if (e.getKeyChar() == 'w') {
				setDirection(Direction.UP);
			}

			if (e.getKeyChar() == 's') {
				setDirection(Direction.DOWN);
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		if (isChecked() == true) {
			if (e.getKeyChar() != 't') {
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
