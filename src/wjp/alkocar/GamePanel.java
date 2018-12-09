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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Damian
 */
public class GamePanel extends JPanel{
    
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
    public boolean isUp, isDown, isRight, isLeft; 
    
    public GamePanel(CardLayout cl, JPanel cardPanel,int width,int height){
        this.cardPanel = cardPanel;
        this.cl=cl;
        this.sHeight=height;
        this.sWidth=width;
        
        check();
        //setFocusable(true);
        isUp = isDown = isLeft = isRight = false;
        carX=885;
        carY=470;
        speedX=0;
        speedY=0;
    }           
   @Override
    protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        //Ustaw tryb lepszej jakoĹ›ci grafiki (wygĹ‚adzanie/antyaliasing)
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Narysuj tĹ‚o
        g.drawImage(GPars.track, 0, posY, null);
        g.drawImage(GPars.car,carX,carY,this); 
        validate();
}
    public void check(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) { //when a key is released
                stopCar(e); //stop movement of car
            }
            @Override
            public void keyPressed(KeyEvent e) { //when a key is pressed
                moveCar(e); //move the car in the direction given by the key
            }
        
    });
    }
    public void moveTrack(){
        if(posY>=0){ //if the road crossing has passed by
            
                posY = -749;
            
        }
        else
        {   //otherwise
            posY++; //keep moving the crossing across the window
        }
        try{
                    Thread.sleep(5);    //wait so that the road appears to be moving continously
                }
                catch(Exception e){
                    System.out.println(e);}
        
        
        carX += speedX; //update car x position
        carY += speedY; //update car y position
        
        if(carY < 0)   //if the car has reached or gone under its min x axis value
        {carY = 0;}  //keep it at its min x axis value
        
        //case analysis to restrict car from going outside the right side of the screen
        if(carY-167 <=650 ) //if the car has reached or gone over its max x axis value
        {carY = 650-167;} //keep it at its max x axis value
        
        //case analysis to restrict car from going outside the right side of the road
        if(carX <= 0)    //if the car has reached the the right side of the road or is trying to go further
        {carX = 0;}    //keep the car where it is
        
        //case analysis to restrict car from going outside the left side of the road
        if(carX >= 1280-90) //if the car has reached the the left side of the road or is trying to go further
        {carX = 1280-90;} //keep the car where it is
        
        repaint();
        revalidate();
    } 
    public void moveCar(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_UP){   //if user clicks on the up arrow key
            isUp = true;
            speedY = -1;
            moveTrack();
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){ //if user clicks on the down arrow key
            isDown = true;
            speedY = 1;
            moveTrack();
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){ //if user clicks on the right arrow key
            isRight = true;
            speedX = 1; 
            moveTrack();
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){ //if user clicks on the left arrow key
            isLeft = true;
            speedX = -1;
            moveTrack();
        }
    }
    public void stopCar(KeyEvent e){
        check();
        if(e.getKeyCode() == KeyEvent.VK_UP){   //if user clicks on the up arrow key
            isUp = false;
            speedY = 0;
            moveTrack();
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){    //if user clicks on the down arrow key
            isDown = false;
            speedY = 0;
            moveTrack();
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){    //if user clicks on the left arrow key
            isLeft = false;
            speedX = 0;
            moveTrack();
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT){   //if user clicks on the right arrow key
            isRight = false;
            speedX = 0;
            moveTrack();
        }
    }
}