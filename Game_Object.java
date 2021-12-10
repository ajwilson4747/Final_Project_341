import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public abstract class Game_Object {
	
	//data members 
	private int x; 
	private int y; 
	private int velocity; 
	private int direction; 
	protected ImageIcon myImage;
	private boolean isChecked;
	
	public Game_Object(int x, int y) {
		this.x = x; 
		this.y = y; 
		velocity =1; 
		isChecked = false; 
		}

	public void draw (Component c, Graphics g) {
		myImage.paintIcon(c, g, x, y);
	}

	//abstract method: movement of the game obj 
	public abstract void move (Canvas canvas);

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	
	//to highlight a specific object 
	public abstract void highlighting(Component c, Graphics g);
}
	
