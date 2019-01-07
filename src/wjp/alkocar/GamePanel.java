/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wjp.alkocar;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Klasa zawierająca w sobie całą rozgrywkę. 
 * Rysuje trasę, pojazdy, przeszkody, wychwytuje zderzenia.
 * @author Damian
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener{
    
    /**  Level, czyli wybrana dawka alkoholu   */
    public int level;
    /**  Przycisk powrotu do menu   */
    private JButton back;
    /**  Panel zawierający wszystkie panele   */
    public JPanel cardPanel;
    /**  Layout umożliwiający przełączanie pomiędzy panelami   */
    public CardLayout cl;
    /**  Startowa pozycja trasy   */
    public int posY=-750;
    /**  Startowe położenie auta użytkownika */
    public int carX=885, carY=470;
    /**  Startowe prędkości poruszania auta   */
    public int speedX=0,speedY=0;
    /**  Położenia aut przeszkód*/
    public int car_ob_y, car_ob_y1, car_ob_y2,car_ob_y3, car_ob_x,car_ob_x1,car_ob_x2,car_ob_x3;
    /**  Położenie drzew (przeszkód) */ 
    public int tree_x,tree_y,tree_x1,tree_y1,tree_x2,tree_y2,tree_x3,tree_y3;
    /**  Położenie skał (przeszkód) */
    public int rock_x,rock_y,rock_x1,rock_y1,rock_x2,rock_y2;
    /**  Położenie człowieka (przeszkód) */
    public int human_x=1080,human_y;
    /**  Obiekt potrzebny do losowania położenia */
    public final Random rand = new Random();
    /**  Licznik odrysowywania */
    public final Timer t = new Timer (5, this);
    
    
    private long time, timer;
    
    /**
     * Konstruktor klasy wywołuje metodę rozpoczynającą rozgrywkę
     * @param cl Obiekt CardLayout zawierający w sobie cardPanel 
     * umożlwiiający dowolne wybieranie widocznego panelu.
     * @param cardPanel Obiekt JPanel zawierający w sobie zbiór 
     * wszystkich paneli 
     * @param width szerokość okna
     * @param height wysokość okna
     * @param level int pozwalający określić jaki stopień alkoholu wybrał gracz
     */
    public GamePanel(CardLayout cl, JPanel cardPanel,int width,int height, int level){
        super(); 
        this.cardPanel = cardPanel;
        this.cl=cl;
        this.level=level;
       
        start();
    }
    
    /**
     * Metoda służy do wystartowania gry, czyli odpalenia timera oraz
     * wylosowania położeń początkowych przeszkód
     */
    private void start(){
        addKeyListener(this);
        setFocusTraversalKeysEnabled(false);
        this.setFocusable(true); 
        
        /*Losowanie startowych położeń poszczególnych przeszkód*/
        car_ob_y=drawY(car_ob_y,1);
        car_ob_x=drawX(car_ob_x,1);
        car_ob_x1=drawX(car_ob_x1,1);
        car_ob_y1=drawY(car_ob_y1,1);
        car_ob_x2 = drawX(car_ob_x2,1);
        car_ob_y2 = drawY(car_ob_y2,1);
        car_ob_x3 = drawX(car_ob_x3,1);
        car_ob_y3 = drawY(car_ob_y3,1);
        tree_x = drawX(tree_x,2);
        tree_y = drawY (tree_y,2);
        tree_x1 = drawX(tree_x1,2);
        tree_y1 = drawY (tree_y1,2);
        tree_x2 = drawX(tree_x2,2);
        tree_y2 = drawY (tree_y2,2);
        tree_x3 = drawX(tree_x3,2);
        tree_y3 = drawY (tree_y3,2);
        rock_x = drawX (rock_x,3);
        rock_y = drawY (rock_y,2);
        rock_x1 = drawX (rock_x1,3);
        rock_y1 = drawY (rock_y1,2);
        rock_x2 = drawX (rock_x2,3);
        rock_y2 = drawY (rock_y2,2);
        human_y = drawY (human_y,1);
        
        if (level==5 || level==4)
        {
            time = drawTime(time);
        }
        t.start(); //uruchomienie zegara
    }
    
    /**
     * Metoda odpowiedzialna za odrysowywanie komponentów
     * Rysuje trasę, przeszkody i auto użytkownika, zgodnie ze zmieniającymi się 
     * współrzędnymi obiektów. Robi to zależnie od wybranego levelu. 
     * @param gs 
     */
   @Override
    public void paint(Graphics gs){
        Graphics2D g=(Graphics2D)gs;
        timer++;
        //g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(GPars.track, 0, posY, null);
        g.drawImage(GPars.car,carX,carY,this);
        g.drawImage(GPars.obstacle4,human_x,human_y,this);
        if (level==1)
        {
            g.drawImage(GPars.obstacle1,car_ob_x,car_ob_y,this);
            g.drawImage(GPars.obstacle1,car_ob_x1,car_ob_y1,this);
            g.drawImage(GPars.obstacle2,tree_x,tree_y,this);
            g.drawImage(GPars.obstacle2,tree_x1,tree_y1,this);
            g.drawImage(GPars.obstacle3,rock_x,rock_y,this);
            g.drawImage(GPars.obstacle3,rock_x1,rock_y1,this);
        }
        if (level==2 || level==3)
        {
            g.drawImage(GPars.obstacle1,car_ob_x,car_ob_y,this);
            g.drawImage(GPars.obstacle1,car_ob_x1,car_ob_y1,this);
            g.drawImage(GPars.obstacle1,car_ob_x2,car_ob_y2,this);
            g.drawImage(GPars.obstacle2,tree_x,tree_y,this);
            g.drawImage(GPars.obstacle2,tree_x1,tree_y1,this);
            g.drawImage(GPars.obstacle2,tree_x2,tree_y2,this);
            g.drawImage(GPars.obstacle3,rock_x,rock_y,this);
            g.drawImage(GPars.obstacle3,rock_x1,rock_y1,this); 
        }
        if (level==4 || level==5)
        {
            g.drawImage(GPars.obstacle1,car_ob_x,car_ob_y,this);
            g.drawImage(GPars.obstacle1,car_ob_x1,car_ob_y1,this);
            g.drawImage(GPars.obstacle1,car_ob_x2,car_ob_y2,this);
            g.drawImage(GPars.obstacle1,car_ob_x3,car_ob_y3,this);
            g.drawImage(GPars.obstacle2,tree_x,tree_y,this);
            g.drawImage(GPars.obstacle2,tree_x1,tree_y1,this);
            g.drawImage(GPars.obstacle2,tree_x2,tree_y2,this);
            g.drawImage(GPars.obstacle2,tree_x3,tree_y3,this);
            g.drawImage(GPars.obstacle3,rock_x,rock_y,this);
            g.drawImage(GPars.obstacle3,rock_x1,rock_y1,this);
            g.drawImage(GPars.obstacle3,rock_x2,rock_y2,this);
            
        }
        if (level==2)
            {
                g.drawImage(GPars.cover,0,0,this); //zniekształcenie obrazu
            }
        if (level==3)
            {
                g.drawImage(GPars.cover1,0,0,this); //zniekształcenie obrazu
            }
        if (level==4)
            {
                if (timer>=time){
                    g.drawImage(GPars.cover4,0,0,this); 
                    /*Wyświetlenie kompletnego zaciemnienia obrazu*/
                }
                if (timer==time+3*(10^9)){ 
                    timer=0;
                    time = drawTime(time);
                }
                g.drawImage(GPars.cover2,0,0,this); //zniekształcenie obrazu
            }
        if (level==5)
            {
                
                if (timer>=time){
                    g.drawImage(GPars.cover4,0,0,this); 
                    /*Wyświetlenie kompletnego zaciemnienia obrazu*/
                }
                if (timer==time+7*(10^9)){ 
                    timer=0;
                    time = drawTime(time);
                }
                
                g.drawImage(GPars.cover3,0,0,this); //zniekształcenie obrazu
                
            }
        this.repaint();
        this.requestFocus();
} 
    
    /**
     * Metoda zawiera odpowiedź na pojawiające się wydarzenie.
     * Wydarzenie to wciśnięcie przycisków strzałek na klawiaturze.
     * @param e 
     */
    @Override
    public void actionPerformed (ActionEvent e){
        
        /*Zapętlenie trasy*/
        if(posY>=0){ 
            posY = -749;
        }
        else
        {  
            posY=posY+2; 
            /*Poruszanie trasą trasy*/
            
        }
        /*Zapętlenie drzew, gdy znikną z planszy ponownie losujemy położenie 
        kolejnych, to samo dzieje się z resztą przeszkód poniżej*/
        if(tree_y>1280){ 
            tree_y=drawY(tree_y,1);
            tree_x=drawX(tree_x,2);
        }
        else
        {  
            if (level<3)
                tree_y=tree_y+2; 
            /*Poruszenie przeszkodą; dla levelu 1 i 2 wolniej*/
            else 
                tree_y=tree_y+3;
            /*Poruszenie przeszkodą; dla levelu 3,4 i 5 szybciej*/
            
        }
        if(tree_y1>1280){ 
            tree_y1=drawY(tree_y1,1);
            tree_x1=drawX(tree_x1,2);
        }
        else
        {  
            if (level<3)
                tree_y1=tree_y1+2; 
            else 
                tree_y1=tree_y1+3;
            
        }
        if(tree_y2>1280){ 
            tree_y2=drawY(tree_y2,1);
            tree_x2=drawX(tree_x2,2);
        }
        else
        {  
            if (level<3)
                tree_y2=tree_y2+2; 
            else 
                tree_y2=tree_y2+3;
            
        }
        if(tree_y3>1280){ 
            tree_y3=drawY(tree_y3,1);
            tree_x3=drawX(tree_x3,2);
        }
        else
        {  
            if (level<3)
                tree_y3=tree_y3+2; 
            else 
                tree_y3=tree_y3+3;
            
        }
        
        if(rock_y>1280){ 
            rock_y=drawY(rock_y,1);
            rock_x=drawX(rock_x,3);
        }
        else
        {  
            if (level<3)
                rock_y=rock_y+2; 
            else 
                rock_y=rock_y+3;
            
        }
        
        if(rock_y1>1280){ 
            rock_y1=drawY(rock_y1,1);
            rock_x1=drawX(rock_x1,3);
        }
        else
        {  
            if (level<3)
                rock_y1=rock_y1+2; 
            else 
                rock_y1=rock_y1+3;
            
        }
        
        if(rock_y2>1280){ 
            rock_y2=drawY(rock_y2,1);
            rock_x2=drawX(rock_x2,3);
        }
        else
        {  
            if (level<3)
                rock_y2=rock_y2+2; 
            else 
                rock_y2=rock_y2+3;
            
        }
        
         if(human_y>1280){ 
            human_y=drawY(rock_y,1);
            human_x = 1080;
        }
        else
        {  
            human_y=human_y+1;
        }
        if (car_ob_y>=1280){
            car_ob_y=drawY(car_ob_y,1);
            car_ob_x=drawX(car_ob_x,1);
        }
        if (car_ob_y1>=1280){
            car_ob_y1=drawY(car_ob_y1,1);
            car_ob_x1=drawX(car_ob_x1,1);
        }
        if (car_ob_y2>=1280){
            car_ob_y2=drawY(car_ob_y2,1);
            car_ob_x2=drawX(car_ob_x2,1);
        }
        if (car_ob_y3>=1280){
            car_ob_y3=drawY(car_ob_y3,1);
            car_ob_x3=drawX(car_ob_x3,1);
        }
        else 
        {
            if (level==1){
                car_ob_y=car_ob_y+2;
                car_ob_y1=car_ob_y1+2;
            }
            if (level==2 || level ==3){
                car_ob_y=car_ob_y+3;
                car_ob_y1=car_ob_y1+3;
                car_ob_y2=car_ob_y2+3;
            }
            if (level==4){
                car_ob_y=car_ob_y+3;
                car_ob_y1=car_ob_y1+3;
                car_ob_y2=car_ob_y2+3;
                car_ob_y3=car_ob_y3+3;
            }
            if (level==5){
                car_ob_y=car_ob_y+4;
                car_ob_y1=car_ob_y1+4;
                car_ob_y2=car_ob_y2+4;
                car_ob_y3=car_ob_y3+4;
            }
        }
          
        carX += speedX; 
        carY += speedY;
        /*Poruszanie autem użytkownika*/  
        
        if(carY <= 3) 
        {carY = 3;}  
        /*Nie pozwala wyjechać autu wyjechać poza obszar gry (w górę)*/  
        
        if(carY >=480 )
        {carY = 480;} 
        /*Nie pozwala wyjechać autu wyjechać poza obszar gry (w dół)*/ 
        
        if(carX <= 0)  
        {carX = 0;}    
        /*Nie pozwala wyjechać autu wyjechać poza obszar gry (w lewo)*/ 
       
        if(carX >= 1168) 
        {carX = 1168;}
        /*Nie pozwala wyjechać autu wyjechać poza obszar gry (w prawo)*/ 
        
        if (carX<=234){ 
            playSound(1); //odtwórz dźwięk wpadnięcia do wody
            end();
            /*Gdy auto użytkownika wjedzie w obszar wody*/ 
        }

        if (check()==true){
            playSound(2); // odtwórz dźwięk zderzenia
            end();
        } 
    }
    
    /**
     * Metoda opisująca co wydarzy się po wciśnięcu strzałki "w górę"
     * zależnie od levelu.
     */
    public void up(){
        if (level==1||level==2){
            speedY= -2;
        }
        if (level==3||level==4||level==5){
            speedY= -1;   
        }
    }
    /**
     * Metoda opisująca co wydarzy się po wciśnięcu strzałki "w dół"
     * zależnie od levelu.
     */
    public void down(){
        if (level==1||level==2){
            speedY= 2;
        }
        if (level==3||level==4||level==5){
            speedY= 1;
        }
    }
    /**
     * Metoda opisująca co wydarzy się po wciśnięcu strzałki "w lewo"
     * zależnie od levelu.
     */
    public void left(){
        if (level==1||level==2){
            speedX=-2;
        }
        if (level==3||level==4||level==5){
            speedX= -1;
        }
    }
    /**
     * Metoda opisująca co wydarzy się po wciśnięcu strzałki "w prawo"
     * zależnie od levelu.
     */
    public void right(){
        if (level==1||level==2){
            speedX=2;
        }
        if (level==3||level==4||level==5){
            speedX= 1;
        }
    }
    /**
     * Metoda opisująca co wydarzy się po puszczeniu strzałki "w górę"
     */
    public void upSTOP(){
        speedY= 0;
    }
    /**
     * Metoda opisująca co wydarzy się po puszczeniu strzałki "w dół"
     */
    public void downSTOP(){
        speedY= 0;
    }
    /**
     * Metoda opisująca co wydarzy się po puszczeniu strzałki "w lewo"
     */
    public void leftSTOP(){
        speedX=0;
    }
    /**
     * Metoda opisująca co wydarzy się po puszczeniu strzałki "w prawo"
     */
    public void rightSTOP(){
        speedX=0;
    }
    
    /**
     * Metoda zbierająca informację o tym jaki przycisk został wciśnięty, a
     * następnie wskazuje co należy zrobić w przypadku jego wciśnięcia
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();
        if (code== KeyEvent.VK_UP){
            up();
        }
        if (code== KeyEvent.VK_DOWN){
            down();
        }
        if (code== KeyEvent.VK_LEFT){
            left();
        }
        if (code== KeyEvent.VK_RIGHT){
            right();
        }
        setFocusable(true);
    }
    
    @Override
    public void keyTyped(KeyEvent e){
        
    }
    
    /**
     * Metoda zbierająca informację o tym jaki przycisk został puszczony, a
     * następnie wskazuje co należy zrobić w przypadku jego wyciśnięcia
     * @param e
     */
    @Override
    public void keyReleased (KeyEvent e){
        int code = e.getKeyCode();
        if (code== KeyEvent.VK_UP){
            upSTOP();
        }
        if (code== KeyEvent.VK_DOWN){
            downSTOP();
        }
        if (code== KeyEvent.VK_LEFT){
            leftSTOP();
        }
        if (code== KeyEvent.VK_RIGHT){
            rightSTOP();
        }
    }
    
    /**
     * Metoda sprawdza czy pojazd użytkownika nie wchodzi w kolizję z innym 
     * obiektem na trasie. Jeżeli występuje zderzenie, funkcja zwraca 
     * wartość true
     * @return 
     */
    public boolean check (){
      if (((carX-car_ob_x)<80) & ((carX-car_ob_x)>-80) & ((carY-car_ob_y)<160) & ((carY-car_ob_y)>-160)){
            return true;
        }
        /*Zderzenie auta użytkownika z przeszkodą w postaci auta nr 1*/ 
                    
        if (((carX-car_ob_x1)<80) & ((carX-car_ob_x1)>-80) & ((carY-car_ob_y1)<160) & ((carY-car_ob_y1)>-160)){
            return true;
        }
        /*Zderzenie auta użytkownika z przeszkodą w postaci auta nr 2*/ 
        
        if (((carX-car_ob_x2)<80) & ((carX-car_ob_x2)>-80) & ((carY-car_ob_y2)<160) & ((carY-car_ob_y2)>-160)& level>1){
            return true;
        } 
        /*Zderzenie auta użytkownika z przeszkodą w postaci auta nr 3*/ 
        
        if (((carX-car_ob_x3)<80) & ((carX-car_ob_x3)>-80) & ((carY-car_ob_y3)<160) & ((carY-car_ob_y3)>-160)& level>3){
            return true;
        } 
        /*Zderzenie auta użytkownika z przeszkodą w postaci auta nr 3*/ 
        
        if (((tree_y-carY)<73)& ((tree_y-carY)>-73)&((tree_x-carX)<81)&((tree_x-carX)>-81)){
            return true;
        }
        /*Zderzenie auta użytkownika z przeszkodą w postaci drzewa nr 1*/ 
        
        if (((tree_y1-carY)<66)& ((tree_y1-carY)>-66)&((tree_x1-carX)<81)&((tree_x1-carX)>-81)){
            return true;
        }
        /*Zderzenie auta użytkownika z przeszkodą w postaci drzewa nr 2*/ 
        
        if (((tree_y2-carY)<66)& ((tree_y2-carY)>-66)&((tree_x2-carX)<81)&((tree_x2-carX)>-81)&level>1){
            return true;
        }
        /*Zderzenie auta użytkownika z przeszkodą w postaci drzewa nr 3*/ 
        
        if (((tree_y3-carY)<66)& ((tree_y3-carY)>-66)&((tree_x3-carX)<81)&((tree_x3-carX)>-81)&level>3){
            return true;
        }
        /*Zderzenie auta użytkownika z przeszkodą w postaci drzewa nr 4*/ 
        
        if (((rock_y-carY)<43)& ((rock_y-carY)>-43)&((rock_x-carX)<89)&((rock_x-carX)>-89)){
            return true;
        }
        /*Zderzenie auta użytkownika z przeszkodą w postaci skały nr 1*/ 
        
        if (((rock_y1-carY)<43)& ((rock_y1-carY)>-43)&((rock_x1-carX)<89)&((rock_x1-carX)>-89)){
            return true;
        }  
        /*Zderzenie auta użytkownika z przeszkodą w postaci skały nr 2*/ 
        
        if (((rock_y2-carY)<43)& ((rock_y2-carY)>-43)&((rock_x2-carX)<89)&((rock_x2-carX)>-89)&level>3){
            return true;
        }  
         /*Zderzenie auta użytkownika z przeszkodą w postaci skały nr 3*/
        if (((human_y-carY)<156)& ((human_y-carY)>-156)&((human_x-carX)<60)&((human_x-carX)>-60)){
            return true;
        } 
         /*Zderzenie auta użytkownika z przeszkodą w postaci człowieka*/
        else 
            return false; // w przypadku braku kolizji
    }
    
    /**
     * Metoda losująca współrzędne Y przeszkód zależnie od wybranej opcji
     * @param Y współrzędna Y
     * @param option opcja, które losowanie ma się odbyć
     * @return 
     */
    public int drawY (int Y,int option){
        /*Opcja losowania współrzędnej Y dla aut przeszkód, dla reszty przeszkód
        dopiero przy drugim losowaniu*/
        if (option==1){
            Y = (rand.nextInt(543)+167)*(-1);
            return Y;
        }
        /*Opcja losowania współrzędnej Y przeszkody w postaci drzewa lub skały
        do pierwszego odpalenia gry, żeby od razu były widoczne na trasie*/
        if (option==2){
            Y = rand.nextInt(745);
            return Y;
        }

        else return Y;
    }
    /**
     * Metoda losująca współrzędne X przeszkód zależnie od wybranej opcji
     * @param X współrzędna X
     * @param option opcja, które losowanie ma się odbyć
     * @return 
     */
    public int drawX (int X,int option){
        /*Opcja dla losowania współrzędnej X przeszkody w postaci auta*/
        if (option==1){
            X = rand.nextInt(566)+420;
            return X;
        }
        /*Opcja dla losowania współrzędnej X przeszkody w postaci drzewa*/
        if (option==2){
            X = rand.nextInt(125)+1075;
            return X;
        }
        /*Opcja dla losowania współrzędnej X przeszkody w postaci skały*/
        if (option==3){
            X = rand.nextInt(70)+250;
            return X;
        }

        else return X;
    } 
    
    /**
     * Metoda losuje czas co jaki ma zostać zaciemniony obraz na poziomie 5
     * (dawka alkoholu 3,4 promila).
     * @param time
     * @return 
     */
    public long drawTime (long time){
        time = rand.nextInt(20)+25;
        return (long)time*(10^9);
    }
    /**
     * Metoda odtwarzająca dźwięki w grze
     * @param option wybór dźwięku do odegrania
     */
    public static synchronized void playSound(int option) {
        new Thread(new Runnable() {
          @Override
          public void run() {
            try {
                /*Włączenie dźwięku wpadnięcia do wody przez auto użytkownika*/
                if (option == 1){
              Clip clip = AudioSystem.getClip();
              AudioInputStream inputStream = AudioSystem.getAudioInputStream(GPars.f1);
              clip.open(inputStream);
              clip.start(); }
                /*Włączenie dźwięku zderzenia przez auto użytkownika*/
                if (option == 2){
              Clip clip = AudioSystem.getClip();
              AudioInputStream inputStream = AudioSystem.getAudioInputStream(GPars.f2);
              clip.open(inputStream);
              clip.start(); }
                
            } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
              System.err.println(e.getMessage());
            }
          }
        }).start();
    }
    
    /**
     * Metoda służąca do zakończenia gry
     */
    public void end(){
            t.stop();
            speedX=0;
            speedY=0;
            cl.show(cardPanel, "GAME OVER");
            try {
                super.finalize();
                } catch (Throwable ex) {
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
     }
    
}