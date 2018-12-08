/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wjp.alkocar;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author Damian
 */
public class GPars {
    public static Image track; //Obraz trasy 
    public static Image logo;
    public static Image instruction;

    public static void loadInitialImages() {
        track = loadImage("./src/images/track.png");
        logo = loadImage("./src/images/logo.png");
        instruction = loadImage("./src/images/instruction.png");
            
            
            
        }//koniec loadInitialImages()

        /**
         * Metoda pobierania obiektu klasy Image na podstawie Ĺ›cieĹĽki
         * dostepu podanej jako String
         */
    public static Image loadImage(String fileName) {
            return new ImageIcon(fileName).getImage();
        }//koniec loadImage();
}