/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wjp.alkocar;

import java.awt.Toolkit;

/**
 * AlkoCar
 * Prosta gra interaktywna prezentująca jak alkohol wpływa na prowadzenie 
 * pojazdów mechanicznych. 
 * @author Damian
 */
public class WJPAlkocar {

    /**
     * Metoda uruchamia gra, tworzy okno o wybranych wymiarach.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int gameWidth=1280;
        int gameHeight=745;
        
        //pobierz rozmiar ekranu
        int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
        
        //oblicz wspĂłĹ‚rzÄ™dne naroĹĽnika tak, aby pole gry byĹ‚o wyĹ›rodkowane
        int xCenter=(screenWidth-gameWidth)/2;
        int yCenter=((screenHeight-gameHeight)/2)-10;       
                
        //utwĂłrz obiekt klasy GameWindow - konstruktor wywoĹ‚uje dalszÄ… akcjÄ™
        GameWindow gw=new GameWindow(gameWidth,gameHeight,xCenter,yCenter);
        gw.setSize(gameWidth, gameHeight);
        gw.setTitle("AlkoCar");
    }
    
}
 