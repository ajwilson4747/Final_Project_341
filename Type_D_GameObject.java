import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;

public class Type_D_GameObject extends Game_Object implements KeyListener {

	// data member
	private int imageWidth;
	private int imageHeight;


	public Type_D_GameObject(int x, int y) {
		super(x, y);
		setVelocity(1);
		//setDirection(Direction.NONE);
		//myImage = new ImageIcon("image/NewDUpIcon.png");
		myImage = new ImageIcon("image/hunter-1.png");
		imageWidth = myImage.getIconWidth();
		imageHeight = myImage.getIconHeight();
	}

	public void move(Canvas canvas) {

		if (isChecked() == true) {
			
			switch (getDirection()) {
			
			case Direction.UP:
				setY(getY() - getVelocity());
				//myImage = new ImageIcon("image/DUp.png");
				myImage = new ImageIcon("image/hunter-4.png");
				if (getY() < 0) {
					setY(0);
				}
				break;
			case Direction.LEFT:
				setX(getX() - getVelocity());
				//myImage = new ImageIcon("image/DLeftIcon.png");
				myImage = new ImageIcon("image/hunter-3.png");
				if (getX() < 0) {
					setX(0);
				}
				break;

			case Direction.DOWN:
				setY(getY() + getVelocity());
				//myImage = new ImageIcon("image/DDownIcon.png");
				myImage = new ImageIcon("image/hunter-1.png");

				if (getY() + imageHeight > canvas.getSize().getHeight()) {
					setY((int) (canvas.getSize().getHeight() - imageHeight));
				}
				break;
			case Direction.RIGHT:
				//myImage = new ImageIcon("image/DRightIcon.png");
				myImage = new ImageIcon("image/hunter-2.png");
				setX(getX() + getVelocity());

				if (getX() + imageWidth > canvas.getSize().getWidth()) {
					setX((int) (canvas.getSize().getWidth() - imageWidth));
				}
				break;
			}
		}

		else {
			setDirection(Direction.NONE);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (isChecked() == true) {
			if (e.getKeyChar() == 'w') {
				setDirection(Direction.UP);
			}
			if (e.getKeyChar() == 's') {
				setDirection(Direction.DOWN);
			}
			if (e.getKeyChar() == 'a') {
				setDirection(Direction.LEFT);
			}
			if (e.getKeyChar() == 'd') {
				setDirection(Direction.RIGHT);
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
