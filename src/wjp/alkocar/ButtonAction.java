/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wjp.alkocar;

import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 * Klasa zbierająca w sobie wszystkie akcje, które zostają wykonane 
 * po wciśnięciu określonego przycisku.
 * @author Damian
 */
public class ButtonAction{
    public ButtonAction(){
        
    }
    
    /**
     * Akcja do przycisku wyjscia z gry
     * @param evt ActionEvent wytworzony przez wciśnięcie LPM w przycisk
     */
    public static void endActionPerformed(java.awt.event.ActionEvent evt) {                                         
        System.exit(0);
    }                                        
    
    /**
     * Akcja do przycisku "Jak grać"
     * @param evt ActionEvent wytworzony przez wciśnięcie LPM w przycisk
     */
    public static void instructionActionPerformed(java.awt.event.ActionEvent evt,CardLayout cl,JPanel cardPanel) {                                     
        cl.show(cardPanel,"INSTRUCTION");
    }                                        
    /**
     * Akcja do przycisku "Rozpocznij grę"
     * @param evt ActionEvent wytworzony przez wciśnięcie LPM w przycisk
     */
   public static void startActionPerformed(java.awt.event.ActionEvent evt,CardLayout cl,JPanel cardPanel) {                                
        
        cl.show(cardPanel,"CHOOSE");
        
    } 
    /**
     * Akcja dla przycisku "Trzeźwy"  
     * @param evt ActionEvent wytworzony przez wciśnięcie LPM w przycisk
     */
    public static void zeroActionPerformed(java.awt.event.ActionEvent evt,CardLayout cl,JPanel cardPanel,int width, int height) {                                   
        
        GamePanel gp = new GamePanel(cl,cardPanel,width,height,1);
        GameGUI gg = new GameGUI(gp,cardPanel,cl,1);
        cardPanel.add(gg,"GAME");
        cl.show(cardPanel,"GAME");
    } 
    /**
     * Akcja dla przycisku "0,6 promila"  
     * @param evt ActionEvent wytworzony przez wciśnięcie LPM w przycisk
     */
    public static void zero_sixActionPerformed(java.awt.event.ActionEvent evt,CardLayout cl,JPanel cardPanel,int width, int height) {                              
        
        GamePanel gp = new GamePanel(cl,cardPanel,width,height,2);
        GameGUI gg = new GameGUI(gp,cardPanel,cl,2);
        cardPanel.add(gg,"GAME");
        cl.show(cardPanel,"GAME");
    }
    /**
     * Akcja dla przycisku "1,5 promila"  
     * @param evt ActionEvent wytworzony przez wciśnięcie LPM w przycisk
     */
    public static void one_fiveActionPerformed(java.awt.event.ActionEvent evt,CardLayout cl,JPanel cardPanel,int width, int height) {                                
        
        GamePanel gp = new GamePanel(cl,cardPanel,width,height,3);
        GameGUI gg = new GameGUI(gp,cardPanel,cl,3);
        cardPanel.add(gg,"GAME");
        cl.show(cardPanel,"GAME");
    }
    /**
     * Akcja dla przycisku "2,3 promila"  
     * @param evt ActionEvent wytworzony przez wciśnięcie LPM w przycisk
     */
    public static void two_threeActionPerformed(java.awt.event.ActionEvent evt,CardLayout cl,JPanel cardPanel,int width, int height) {                                 
        
        GamePanel gp = new GamePanel(cl,cardPanel,width,height,4);
        GameGUI gg = new GameGUI(gp,cardPanel,cl,4);
        cardPanel.add(gg,"GAME");
        cl.show(cardPanel,"GAME");
    }
    /**
     * Akcja dla przycisku "3,4 promila"  
     * @param evt ActionEvent wytworzony przez wciśnięcie LPM w przycisk
     */
    public static void three_fourActionPerformed(java.awt.event.ActionEvent evt,CardLayout cl,JPanel cardPanel,int width, int height) {                        
        
        GamePanel gp = new GamePanel(cl,cardPanel,width,height,5);
        GameGUI gg = new GameGUI(gp,cardPanel,cl,5);
        cardPanel.add(gg,"GAME");
        cl.show(cardPanel,"GAME");
    }
    /**
     * Akcja dla przycisku powrotu do menu  
     * @param evt ActionEvent wytworzony przez wciśnięcie LPM w przycisk
     */
    public static void backActionPerformed(java.awt.event.ActionEvent evt,CardLayout cl,JPanel cardPanel) {                                     
        
        cl.show(cardPanel,"MENU");
        
    }  
    
}
