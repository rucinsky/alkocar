/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wjp.alkocar;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
/**
 *
 * @author Damian
 */
public class GameWindow extends JFrame {
    public GameWindow (int width, int height, int x, int y,int check)
    {
        super(); //wywoĹ‚aj konstruktor klasy nadrzÄ™dnej - utwĂłrz okno
        setSize(width, height); //ustaw wymiary okna
        setLocation(x,y); //ustaw pozycjÄ™ okna
        setResizable(false); //zablokuj moĹĽliwoĹ›Ä‡ zmian rozmiaru okna
        setUndecorated(false); //ukryj ramkÄ™ okna i przyciski kontrolne
        initGUI(width,height,check);
        //wywoĹ‚aj metodÄ™ budowy interfejsu
        setVisible(true); //pokaĹĽ okno
        //animationLoop(); //uruchom pÄ™tlÄ™ animacji gry
        
    }
    
    public void initGUI(int width, int height, int check){
        //setLayout(new GridLayout(1,1)); //ustaw rozkĹ‚ad 
        //ustaw zasoby i parametry poczÄ…tkowe
        GPars.loadInitialImages();
        add(new GamePanel(width,height,check));
       
        //dodaj panel gry zawierajÄ…cy grafikÄ™ i akcjÄ™
    }//koniec initGUI()
    

    
    
    
}
