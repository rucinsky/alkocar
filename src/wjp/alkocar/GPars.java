/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wjp.alkocar;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;

/**
 * Klasa służąca jako kontener zasobów gry. 
 * @author Damian
 */
public class GPars {
    /**  Grafika trasy   */
    public static Image track; 
    /**  Grafika logo gry   */
    public static Image logo;
    /**  Grafika ekranu instrukcji   */
    public static Image instruction;
    /**  Grafika przycisku rozpoczynającego grę   */
    public static ImageIcon start_button;
    /**  Grafika przycisku prowadzącego do instrukcji gry   */
    public static ImageIcon how_button;
    /**  Grafika przycisku wyłączającego grę   */
    public static ImageIcon end_button;
    /**  Grafika przycisku powrotu do menu   */
    public static ImageIcon back_button;
    /**  Grafika przycisków wyboru dawki alkoholu   */
    public static ImageIcon alc1_button,alc2_button,alc3_button,alc4_button,alc5_button;
    /**  Grafika samochodu prowadzonego przez użytkownika   */
    public static Image car;
    /**  Grafika ekranu "Game Over"   */
    public static Image gameover;
    /**  Grafika przeszkód drogowych   */
    public static Image obstacle1,obstacle2,obstacle3,obstacle4;
    /**  Grafika przesłon, psujących wizję   */
    public static Image cover,cover1,cover2,cover3,cover4;
    /**  Pliki ścieżek dźwiękowych   */
    public static File f1 ,f2;
    

    /**
     * Metoda wczytywania zasobow gry, takich jak grafika czy dzwieki
     */
    public static void loadInitialResources() { 
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
        obstacle4 = loadImage("./src/images/obstacle_human.png");
        cover = loadImage("./src/images/cover.png");
        cover1 = loadImage("./src/images/cover1.png");
        cover2 = loadImage("./src/images/cover2.png");
        cover3 = loadImage("./src/images/cover3.png");
        cover4 = loadImage("./src/images/cover4.png");
        f1 = loadFile("./src/sounds/water_sound.wav"); 
        f2 = loadFile("./src/sounds/car_crash.wav");
        
            
        }

    /**
     * Metoda pobierania obiektu klasy Image na podstawie podanej sciezki
     * dostepu podanej jako String
     */
    public static Image loadImage(String fileName) { 
            return new ImageIcon(fileName).getImage();
    }
    
    /**
     * Metoda pobierania obiektu klasy File na podstawie podanej sciezki
     * dostepu podanej jako String
     */
    public static File loadFile (String fileName){
        return new File(fileName).getAbsoluteFile();
    }
}