/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wjp.alkocar;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Damian
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener{
    
    public int sWidth;
    /** WysokoĹ›Ä‡ pola graficznego gry*/
    public int sHeight;
    private JButton back;
    public JPanel cardPanel;
    public CardLayout cl;
    public int posY=-750;
    public int carX;
    public int carY;
    public int speedX,speedY;
    Timer t = new Timer (5, this);
    
    public GamePanel(CardLayout cl, JPanel cardPanel,int width,int height){
        this.cardPanel = cardPanel;
        this.cl=cl;
        this.sHeight=height;
        this.sWidth=width;
        carX=885;
        carY=470;
        speedX=0;
        speedY=0;
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
    }           
   @Override
    protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        //Ustaw tryb lepszej jakoĹ›ci grafiki (wygĹ‚adzanie/antyaliasing)
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Narysuj tĹ‚o
        g.drawImage(GPars.track, 0, posY, null);
        g.drawImage(GPars.car,carX,carY,this);
} 
    
    public void actionPerformed (ActionEvent e){
        repaint();
        if(posY>=0){ //if the road crossing has passed by
            
                posY = -749;
            
        }
        else
        {   //otherwise
            posY++; //keep moving the crossing across the window
        }
        
        carX += speedX; //update car x position
        carY += speedY; //update car y position
        
        if(carY <= 3)   //if the car has reached or gone under its min x axis value
        {carY = 3;}  //keep it at its min x axis value
        
        //case analysis to restrict car from going outside the right side of the screen
        if(carY >=480 ) //if the car has reached or gone over its max x axis value
        {carY = 480;} //keep it at its max x axis value
        
        //case analysis to restrict car from going outside the right side of the road
        if(carX <= 0)    //if the car has reached the the right side of the road or is trying to go further
        {carX = 0;}    //keep the car where it is
        
        //case analysis to restrict car from going outside the left side of the road
        if(carX >= 1168) //if the car has reached the the left side of the road or is trying to go further
        {carX = 1168;} //keep the car where it is
        
        if (carX<=234){
            t.stop();
            speedX=0;
            speedY=0;
            cl.show(cardPanel, "GAME OVER");
        }
    }
    
    public void up(){
        speedY= -1;
        //speedX=0;
    }
    public void down(){
        speedY= 1;
        //speedX=0;
    }
    public void left(){
        //speedY=0;
        speedX=-1;
    }
    public void right(){
        //speedY=0;
        speedX=1;
    }
    
    public void upSTOP(){
        speedY= 0;
        //speedX=0;
    }
    public void downSTOP(){
        speedY= 0;
        //speedX=0;
    }
    public void leftSTOP(){
        //speedY=0;
        speedX=0;
    }
    public void rightSTOP(){
        //speedY=0;
        speedX=0;
    }
    
    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();
        if (code== KeyEvent.VK_UP){
            up();
        }
        if (code== KeyEvent.VK_DOWN){
            down();
        }
        if (code== KeyEvent.VK_LEFT){
            left();
        }
        if (code== KeyEvent.VK_RIGHT){
            right();
        }
    }
    public void keyTyped(KeyEvent e){
        
    }
    public void keyReleased (KeyEvent e){
        int code = e.getKeyCode();
        if (code== KeyEvent.VK_UP){
            upSTOP();
        }
        if (code== KeyEvent.VK_DOWN){
            downSTOP();
        }
        if (code== KeyEvent.VK_LEFT){
            leftSTOP();
        }
        if (code== KeyEvent.VK_RIGHT){
            rightSTOP();
        }
    }
        
}