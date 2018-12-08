/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wjp.alkocar;

import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Damian
 */
public class WJPAlkocar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int gameWidth=1460;
        int gameHeight=755;
        int level =0;
        
        //pobierz rozmiar ekranu
        int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
        
        //oblicz wspĂłĹ‚rzÄ™dne naroĹĽnika tak, aby pole gry byĹ‚o wyĹ›rodkowane
        int xCenter=(screenWidth-gameWidth)/2;
        int yCenter=((screenHeight-gameHeight)/2)-5;       
                
        //utwĂłrz obiekt klasy GameWindow - konstruktor wywoĹ‚uje dalszÄ… akcjÄ™
        GameWindow gw=new GameWindow(gameWidth,gameHeight,xCenter,yCenter,level);
        gw.setSize(gameWidth, gameHeight);
        gw.setLocationRelativeTo(null);        
        gw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
 