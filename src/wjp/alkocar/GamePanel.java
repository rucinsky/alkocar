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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Damian
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener{
    
    public int sWidth;
    public int sHeight;
    public int level;
    private JButton back;
    public JPanel cardPanel;
    public CardLayout cl;
    int posY=-750;
    int carX=885;
    int carY=470;
    int speedX=0,speedY=0;
    int car_ob_y, car_ob_y1, car_ob_y2;
    int car_ob_x,car_ob_x1,car_ob_x2;
    int tree_x,tree_y,tree_x1,tree_y1,tree_x2,tree_y2,tree_x3,tree_y3;
    Random rand = new Random();
    public Timer t = new Timer (5, this);
    
    public GamePanel(CardLayout cl, JPanel cardPanel,int width,int height, int level){
        this.cardPanel = cardPanel;
        this.cl=cl;
        this.sHeight=height;
        this.sWidth=width;
        this.level=level;
        car_ob_y=drawY(car_ob_y,1);
        car_ob_x=drawX(car_ob_x,1);
        car_ob_x1=drawX(car_ob_x1,1);
        car_ob_y1=drawY(car_ob_y1,1);
        car_ob_x2 = drawX(car_ob_x2,1);
        car_ob_y2 = drawY(car_ob_y2,1);
        tree_x = drawX(tree_x,2);
        tree_y = drawY (tree_y,2);
        tree_x1 = drawX(tree_x1,2);
        tree_y1 = drawY (tree_y1,2);
        tree_x2 = drawX(tree_x2,2);
        tree_y2 = drawY (tree_y2,2);
                
        t.start();
        addKeyListener(this);
        setFocusTraversalKeysEnabled(false);
        super.setFocusable(true);
        
    }           
   @Override
    protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(GPars.track, 0, posY, null);
        g.drawImage(GPars.car,carX,carY,this);
        if (level==1)
        {
            g.drawImage(GPars.obstacle1,car_ob_x,car_ob_y,this);
            g.drawImage(GPars.obstacle2,tree_x,tree_y,this);
            g.drawImage(GPars.obstacle2,tree_x1,tree_y1,this);
            /*g.drawImage(GPars.obstacle2,a,b,this);*/
        }
        if (level==2 || level==3)
        {
            g.drawImage(GPars.obstacle1,car_ob_x,car_ob_y,this);
            g.drawImage(GPars.obstacle1,car_ob_x1,car_ob_y1,this);
            g.drawImage(GPars.obstacle2,tree_x,tree_y,this);
            g.drawImage(GPars.obstacle2,tree_x1,tree_y1,this);
            g.drawImage(GPars.obstacle2,tree_x2,tree_y2,this);
        }
        if (level==4 || level==5)
        {
            g.drawImage(GPars.obstacle1,car_ob_x,car_ob_y,this);
            g.drawImage(GPars.obstacle1,car_ob_x1,car_ob_y1,this);
            g.drawImage(GPars.obstacle1,car_ob_x2,car_ob_y2,this);
            g.drawImage(GPars.obstacle2,tree_x,tree_y,this);
            g.drawImage(GPars.obstacle2,tree_x1,tree_y1,this);
            g.drawImage(GPars.obstacle2,tree_x2,tree_y2,this);
        }
} 
    
    public void actionPerformed (ActionEvent e){
        repaint();
        if(posY>=0){ 
            posY = -749;
        }
        else
        {  
            posY=posY+2; 
            
        }
        if(tree_y>1280){ 
            tree_y=drawY(tree_y,1);
            tree_x=drawX(tree_x,2);
        }
        else
        {  
            if (level<3)
                tree_y=tree_y+2; 
            else 
                tree_y=tree_y+3;
            
        }
        if(tree_y1>1280){ 
            tree_y1=drawY(tree_y1,1);
            tree_x1=drawX(tree_x1,2);
        }
        else
        {  
            if (level<3)
                tree_y1=tree_y1+2; 
            else 
                tree_y1=tree_y1+3;
            
        }
        if(tree_y2>1280){ 
            tree_y2=drawY(tree_y2,1);
            tree_x2=drawX(tree_x2,2);
        }
        else
        {  
            if (level<3)
                tree_y2=tree_y2+2; 
            else 
                tree_y2=tree_y2+3;
            
        }
        
        if (car_ob_y>=1280){
            car_ob_y=drawY(car_ob_y,1);
            car_ob_x=drawX(car_ob_x,1);
        }
        if (car_ob_y1>=1280){
            car_ob_y1=drawY(car_ob_y1,1);
            car_ob_x1=drawX(car_ob_x1,1);
        }
        if (car_ob_y2>=1280){
            car_ob_y2=drawY(car_ob_y2,1);
            car_ob_x2=drawX(car_ob_x2,1);
        }
        else 
        {
            if (level==1 || level ==2){
                car_ob_y=car_ob_y+2;
                car_ob_y1=car_ob_y1+2;
            }
            if (level==3){
                car_ob_y=car_ob_y+3;
                car_ob_y1=car_ob_y1+3;
            }
            if (level==4){
                car_ob_y=car_ob_y+3;
                car_ob_y1=car_ob_y1+3;
                car_ob_y1=car_ob_y2+3;
            }
            if (level==5){
                car_ob_y=car_ob_y+4;
                car_ob_y1=car_ob_y1+4;
                car_ob_y1=car_ob_y2+4;
            }
        }
            
        carX += speedX; 
        carY += speedY;
        
        if(carY <= 3) 
        {carY = 3;}  
        
        
        if(carY >=480 )
        {carY = 480;} 
        
        
        if(carX <= 0)  
        {carX = 0;}    
        
       
        if(carX >= 1168) 
        {carX = 1168;}
        
        if (carX<=234){ //auto wjeżdża do wody
            end();
        }

        if (((carX-car_ob_x)<80) & ((carX-car_ob_x)>-80) & ((carY-car_ob_y)<160) & ((carY-car_ob_y)>-160)){
            end();
        }
                    
        if (((carX-car_ob_x1)<80) & ((carX-car_ob_x1)>-80) & ((carY-car_ob_y1)<160) & ((carY-car_ob_y1)>-160)& level>1){
            end();
        }
        if (((carX-car_ob_x2)<80) & ((carX-car_ob_x2)>-80) & ((carY-car_ob_y2)<160) & ((carY-car_ob_y2)>-160)& level>3){
            end();
        }    
            
        
    }
    
    public void up(){
        if (level==1||level==2){
            speedY= -2;
        }
        if (level==3||level==4||level==5){
            speedY= -1;
        }
    }
    public void down(){
        if (level==1||level==2){
            speedY= 2;
        }
        if (level==3||level==4||level==5){
            speedY= 1;
        }
    }
    public void left(){
        if (level==1||level==2){
            speedX=-2;
        }
        if (level==3||level==4||level==5){
            speedX= -1;
        }
    }
    public void right(){
        if (level==1||level==2){
            speedX=2;
        }
        if (level==3||level==4||level==5){
            speedX= 1;
        }
    }
    
    public void upSTOP(){
        speedY= 0;
    }
    public void downSTOP(){
        speedY= 0;
    }
    public void leftSTOP(){
        speedX=0;
    }
    public void rightSTOP(){
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
    private int drawY (int Y,int option){
        if (option==1){
            Y = (rand.nextInt(433)+167)*(-1);
            return Y;
        }
        if (option==2){
            Y = rand.nextInt(745);
            return Y;
        }
        else return Y;
    }
    
    private int drawX (int X,int option){
        if (option==1){
            X = rand.nextInt(566)+420;
            return X;
        }
        if (option==2){
            X = rand.nextInt(125)+1075;
            return X;
        }
        else return X;
    } 
    public void stopPanel () throws InterruptedException, Throwable{
        super.finalize();
    }
    private void end(){
            t.stop();
            speedX=0;
            speedY=0;
            cl.show(cardPanel, "GAME OVER");
            try {
                super.wait();
                } catch (Throwable ex) {
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
     }
    
}