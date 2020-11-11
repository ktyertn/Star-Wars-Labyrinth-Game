import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Oyun extends JFrame implements KeyListener {
    public Arayuz draw;
    private int secim=0;
    public void setSecim(int secim) {
    draw.setSecim(secim);
    }
    public Oyun(){
        this.draw=new Arayuz();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }
    public void setMatris(String []a[]){
        draw.matris=a;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped");


    }
    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_RIGHT){
            repaint();
            draw.moveRight();
            }
        else if(e.getKeyCode()== KeyEvent.VK_LEFT){
            repaint();
            draw.moveLeft();
        }
        else if(e.getKeyCode()== KeyEvent.VK_DOWN){
            repaint();
            draw.moveDown();
    }
        else if(e.getKeyCode()== KeyEvent.VK_UP) {
            repaint();
            draw.moveUp();
        }
    }
}
