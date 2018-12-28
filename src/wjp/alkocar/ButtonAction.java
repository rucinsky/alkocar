/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wjp.alkocar;

import java.awt.CardLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Damian
 */
public class ButtonAction{
    public ButtonAction(){
        
    }
    
    public static void endActionPerformed(java.awt.event.ActionEvent evt) {                                         
        System.exit(0);
    }                                        

    public static void instructionActionPerformed(java.awt.event.ActionEvent evt,CardLayout cl,JPanel cardPanel) {                                         
        cl.show(cardPanel,"INSTRUCTION");
    }                                        

   public static void startActionPerformed(java.awt.event.ActionEvent evt,CardLayout cl,JPanel cardPanel) {                                         
        
        cl.show(cardPanel,"CHOOSE");
        
    } 
    
    public static void zeroActionPerformed(java.awt.event.ActionEvent evt,CardLayout cl,JPanel cardPanel,int width, int height) {                                     
        
        GamePanel gp = new GamePanel(cl,cardPanel,width,height,1);
        GameGUI gg = new GameGUI(gp,cardPanel,cl);
        cardPanel.add(gg,"GAME");
        cl.show(cardPanel,"GAME");
    }  
    public static void zero_sixActionPerformed(java.awt.event.ActionEvent evt,CardLayout cl,JPanel cardPanel,int width, int height) {                                     
        
        GamePanel gp = new GamePanel(cl,cardPanel,width,height,2);
        GameGUI gg = new GameGUI(gp,cardPanel,cl);
        cardPanel.add(gg,"GAME");
        cl.show(cardPanel,"GAME");
    }
    public static void one_fiveActionPerformed(java.awt.event.ActionEvent evt,CardLayout cl,JPanel cardPanel,int width, int height) {                                     
        
        GamePanel gp = new GamePanel(cl,cardPanel,width,height,3);
        GameGUI gg = new GameGUI(gp,cardPanel,cl);
        cardPanel.add(gg,"GAME");
        cl.show(cardPanel,"GAME");
    }
    public static void two_threeActionPerformed(java.awt.event.ActionEvent evt,CardLayout cl,JPanel cardPanel,int width, int height) {                                     
        
        GamePanel gp = new GamePanel(cl,cardPanel,width,height,4);
        GameGUI gg = new GameGUI(gp,cardPanel,cl);
        cardPanel.add(gg,"GAME");
        cl.show(cardPanel,"GAME");
    }
    public static void three_fourActionPerformed(java.awt.event.ActionEvent evt,CardLayout cl,JPanel cardPanel,int width, int height) {                                     
        
        GamePanel gp = new GamePanel(cl,cardPanel,width,height,5);
        GameGUI gg = new GameGUI(gp,cardPanel,cl);
        cardPanel.add(gg,"GAME");
        cl.show(cardPanel,"GAME");
    }

    public static void backActionPerformed(java.awt.event.ActionEvent evt,CardLayout cl,JPanel cardPanel) {                                     
        
        cl.show(cardPanel,"MENU");
        
    }  
    
     public static void menuActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        //TU MUSI BYĆ INNE MENU KTÓRE BEDZIE KONTYNUOWALO GRE A NIE ZACZYNALO NOWA
        
    } 
}
