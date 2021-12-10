import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;
import java.awt.Rectangle;

public class Canvas extends JComponent implements ActionListener, KeyListener {
	//data members: window, game loop, list of game objs 
	static JFrame myFrame; 
	private Timer gameLoopTimer; 
	private List<Game_Object> gameObjectList; 
	private int checked=0;
	private static final long serialVersionUID =1L;
	//constructor 
	public Canvas() {
		setForeground(Color.BLACK);
		setBackground(new Color(0, 0, 0));
		//create list of gameobjs 
		gameObjectList = new LinkedList<Game_Object>();
		
		//create window (the actual canvas) 
		myFrame = new JFrame("Final Project");
		myFrame.setSize(800,800);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.getContentPane().add(this);
		myFrame.getContentPane().setBackground( Color.BLACK);
		//construct timer and start it 
		gameLoopTimer = new Timer(10, (ActionListener) this);
		gameLoopTimer.start();
		
		
		//constructing keylistener from scratch 
		setFocusTraversalKeysEnabled(false);
		addKeyListener(this);
		
		
		//set frame visibility to true 
		//myFrame.pack();
		myFrame.setVisible(true);
	
		
	}
	
	//methods that we need 
	//adding gameObjects 
	public synchronized void addGameObjs(Game_Object g) {
		gameObjectList.add(g);
	}
	
	//method paint 
	public synchronized void paint (Graphics f) {
	
		for (Game_Object g: gameObjectList) {
			g.draw(this, f);
			g.highlighting(this, f);
		}
	}
	
	//canvas must implement inherited abstract method 
	public synchronized void actionPerformed(ActionEvent e) {
	
		//loop through all the gameObjs 
		for (	Game_Object g: gameObjectList) {
			g.move(this);
		}
		repaint();	
	}


	public void keyTyped(KeyEvent e) {
	}


	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}


	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar() == 't') {
			checked++; 
			
			checked = checked % gameObjectList.size();
		}
			//manually resets the isChecked parameter 
			for(int i=0; i<gameObjectList.size(); i++) {
				Game_Object temp = gameObjectList.get(i);
				temp.setChecked(false);
			}
			
			//if drawnObject is selected 
			Game_Object g = gameObjectList.get(checked);
			g.setVelocity(g.getVelocity());
			g.setChecked(true);	
		
	}
	public void setChecked(int checked) {
		this.checked = checked;
	}

	public int getChecked() {
		return checked;
	}
	

	
	
	
	
	
}
