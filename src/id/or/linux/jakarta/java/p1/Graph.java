package id.or.linux.jakarta.java.p1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Graph extends JFrame implements KeyListener{
	Graph(){
		super();
		Context.getInstance().setGraph(this);
		Rect rect1 = new Rect(50,50,100,100);
		rect1.setActive(true);
		Rect rect2 = new Rect(200,200,100,100);
		Context.getInstance().setRect1(rect1);
		Context.getInstance().setRect2(rect2);
		addKeyListener(rect1);
		addKeyListener(rect2);
		addKeyListener(this);
	}
	
	public static void main(String a[]){
		Graph graph = new Graph();
		graph.addWindowListener(new WindowAdapter(){
		      public void windowClosing(WindowEvent we){
		        System.exit(0);
		      }
		    });
		graph.setTitle("Pertemuan1");
		graph.setResizable(false);
		graph.setSize(800, 700);
		graph.setVisible(true);
	}
	public void paint(Graphics g) {
	    Graphics2D g1 = (Graphics2D)g;
	    Graphics2D g2 = g1;
	    g1.clearRect(0, 0, 800, 700);
	    g1.draw(Context.getInstance().getRect1());
	    g1.setPaint(Color.black);
	    g1.fill(Context.getInstance().getRect1());
	    g2.draw(Context.getInstance().getRect2());
	    g2.setPaint(Color.yellow);
	    g2.fill(Context.getInstance().getRect2());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
	    switch( keyCode ) { 
	        case KeyEvent.VK_SPACE:	
	        	JOptionPane.showMessageDialog(Context.getGraph(), "Space Pressed, gantian jadi batu");
	        	Context.getRect1().setActive(!Context.getRect1().isActive());
	        	Context.getRect2().setActive(!Context.getRect2().isActive());
	        	break;
	    }
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}