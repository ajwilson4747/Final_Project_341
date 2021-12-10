import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;

public class Type_B_GameObject extends Game_Object{

	private int imageHeight;
	private int imageWidth;

	public Type_B_GameObject(int x, int y) {
		super(x, y);
		myImage = new ImageIcon("image/ghost_3.png");
		imageHeight = myImage.getIconHeight();
		imageWidth = myImage.getIconWidth();
		setVelocity(2);
	}

	@Override
	public void move(Canvas canvas) {
		
			//setChecked(false);

			if (getDirection() == Direction.RIGHT || getDirection() == Direction.NONE) {
				setDirection(Direction.RIGHT);
				setX(getX() + getVelocity());
				myImage = new ImageIcon("image/ghost_3.png");
				
				// if the icon is approaching the right barrier
				if (getX() + imageWidth > canvas.getSize().getWidth()) {
					setX((int) canvas.getSize().getWidth() - imageWidth);
					
					setDirection(Direction.UP);
				}
			}

			if (getDirection() == Direction.UP) {

				setY(getY() - getVelocity());

				if (getY() < 0) {
					setY(0);
					setDirection(Direction.LEFT);
					setX(getX() - getVelocity());
					//myImage = new ImageIcon("image/BLeftIcon.png");
				}
			}

			if (getDirection() == Direction.LEFT) {
				setX(getX() - getVelocity());

				if (getX() < 0) {
					setX(0);
					setDirection(Direction.DOWN);
					//myImage = new ImageIcon("image/BDownIcon.png");
				}
			}

			if (getDirection() == Direction.DOWN) {
				setY(getY() + getVelocity());

				if (getY() + imageHeight > canvas.getSize().getHeight()) {
					setY((int) canvas.getSize().getHeight() - imageHeight);
					setDirection(Direction.RIGHT);
					//myImage = new ImageIcon("image/BRightIcon.png");
				}
			}

	} // end of move canvas
	
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
