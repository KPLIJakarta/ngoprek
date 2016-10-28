package id.or.linux.jakarta.java.p1;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

public class Rect extends Rectangle implements KeyListener {
	private static final long serialVersionUID = 1L;
	private boolean active=false;
	int n=0;
	Rect(int x, int y,int width,int height){
		setBounds(x, y, width, height);
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	private void up(){
		this.y-=25;
		if(collide()){ 
			JOptionPane.showMessageDialog(Context.getGraph(), "Tabrakan Terjadi.");
		}else{
			Context.getGraph().repaint();
		}
		
	}
	
	private void down(){
		this.y+=25;
		if(collide()){ 
			JOptionPane.showMessageDialog(Context.getGraph(), "Tabrakan Terjadi.");
		}else{
			Context.getGraph().repaint();
		}
	}
	
	private void right(){
		this.x+=25;
		if(collide()){ 
			JOptionPane.showMessageDialog(Context.getGraph(), "Tabrakan terjadi.");
		}else{
			Context.getGraph().repaint();
		}
	}
	
	private void left(){
		this.x-=25;
		if(collide()){ 
			JOptionPane.showMessageDialog(Context.getGraph(), "Tabrakan terjadi.");
		}else{
			Context.getGraph().repaint();
		}
	}
	private boolean collide(){
		boolean coll = false;
		Rect r1 = Context.getRect1();
		Rect r2 = Context.getRect2();
		if(r1.intersects(r2))coll=true;
		return coll;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
	    switch( keyCode ) { 
	        case KeyEvent.VK_UP:
	            if(isActive())up(); 
	            break;
	        case KeyEvent.VK_DOWN:
	        	if(isActive())down(); 
	            break;
	        case KeyEvent.VK_LEFT:
	        	if(isActive())left();
	            break;
	        case KeyEvent.VK_RIGHT:
	        	if(isActive())right();
	            break;
	    }
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
