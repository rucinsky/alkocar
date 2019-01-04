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
    public static ImageIcon start_button;
    public static ImageIcon how_button;
    public static ImageIcon end_button;
    public static ImageIcon back_button;
    public static ImageIcon alc1_button;
    public static ImageIcon alc2_button;
    public static ImageIcon alc3_button;
    public static ImageIcon alc4_button;
    public static ImageIcon alc5_button;
    public static Image car;
    public static Image gameover;
    public static Image obstacle1,obstacle2,obstacle3;
    public static Image cover,cover1,cover2,cover3;
    

    public static void loadInitialImages() {
        track = loadImage("./src/images/track.png");
        logo = loadImage("./src/images/logo.png");
        instruction = loadImage("./src/images/instruction.png");
        start_button = new ImageIcon("./src/images/button1.png");
        how_button = new ImageIcon("./src/images/button2.png");
        end_button = new ImageIcon("./src/images/button3.png");
        back_button = new ImageIcon("./src/images/button4.png");
        alc1_button = new ImageIcon("./src/images/button5.png");
        alc2_button = new ImageIcon("./src/images/button6.png");
        alc3_button = new ImageIcon("./src/images/button7.png");
        alc4_button = new ImageIcon("./src/images/button8.png");
        alc5_button = new ImageIcon("./src/images/button9.png");
        car = loadImage("./src/images/car.png");
        gameover = loadImage("./src/images/gameover.png");
        obstacle1 = loadImage("./src/images/obstacle_car.png");
        obstacle2 = loadImage("./src/images/obstacle_tree.png");
        obstacle3 = loadImage("./src/images/obstacle_rock.png");
        cover = loadImage("./src/images/cover.png");
        cover1 = loadImage("./src/images/cover1.png");
        cover2 = loadImage("./src/images/cover2.png");
        cover3 = loadImage("./src/images/cover3.png");
            
            
        }//koniec loadInitialImages()

        /**
         * Metoda pobierania obiektu klasy Image na podstawie Ĺ›cieĹĽki
         * dostepu podanej jako String
         */
    public static Image loadImage(String fileName) {
            return new ImageIcon(fileName).getImage();
        }//koniec loadImage();
}