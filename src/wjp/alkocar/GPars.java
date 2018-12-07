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
    public static BufferedImage track; //Obraz trasy 

    public static void loadInitialImages() {

            
            
            
        }//koniec loadInitialImages()

        /**
         * Metoda pobierania obiektu klasy Image na podstawie Ĺ›cieĹĽki
         * dostepu podanej jako String
         */
    public static Image loadImage(String fileName) {
            return new ImageIcon(fileName).getImage();
        }//koniec loadImage();
}