/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wjp.alkocar;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
    
    public GamePanel(CardLayout cl, JPanel cardPanel,int width,int height){
        this.cardPanel = cardPanel;
        this.cl=cl;
        this.sHeight=height;
        this.sWidth=width;
        JPanel menu = new JPanel();
        back = new JButton();
        back.setIcon(GPars.back_button);
        back.setBorderPainted(true);
        back.setContentAreaFilled(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
    });
        this.setLayout(null);
        menu.add(back);
        this.add(menu,BorderLayout.SOUTH);
                }
   @Override
    protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        //Ustaw tryb lepszej jakoĹ›ci grafiki (wygĹ‚adzanie/antyaliasing)
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Narysuj tĹ‚o
        g.drawImage(GPars.track, 0, posY, null);
       
        validate();
        moveTrack();
    
}
    public void moveTrack(){
        
        if(posY>=0){ //if the road crossing has passed by
            
                posY = -749;
            
        }
        else{   //otherwise
            posY=posY+4; //keep moving the crossing across the window
        }
        try{
                    Thread.sleep(5);    //wait so that the road appears to be moving continously
                }
                catch(Exception e){
                    System.out.println(e);}
        repaint();
    }
    private void backActionPerformed(java.awt.event.ActionEvent evt) {                                     
        cl.show(cardPanel,"MENU");
    }  
}