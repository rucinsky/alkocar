/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wjp.alkocar;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import static wjp.alkocar.GPars.track;
/**
 *
 * @author Damian
 */



public class GameWindow extends JFrame implements ActionListener {
    public JPanel menu = new JPanel();
    public JPanel choose = new JPanel();
    public JPanel instruction = new JPanel();
    public JPanel game = new JPanel();
    public JPanel cardPanel = new JPanel();
    public CardLayout cl = new CardLayout();
    public Container pane = this.getContentPane();
    public Graphics g;
    public Timer tm = new Timer(5,this);
    public int y=0, dy=2;
    
    
    
    public GameWindow(int width, int height, int x, int y,int level)
    {        
        super(); //wywoĹ‚aj konstruktor klasy nadrzÄ™dnej - utwĂłrz okno
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height); //ustaw wymiary okna
        setLocation(x,y); //ustaw pozycjÄ™ okna
        setResizable(true); //zablokuj moĹĽliwoĹ›Ä‡ zmian rozmiaru okna
        setUndecorated(true); //ukryj ramkÄ™ okna i przyciski kontrolne
        GPars.loadInitialImages();
        menuGUI(width,height,level);
        chooseGUI(width,height,level,g);
        instructionGUI(width,height);
        
        cardPanel.setLayout(cl);
        cardPanel.add(menu,"MENU");
        cardPanel.add(choose,"CHOOSE");
        cardPanel.add(instruction,"INSTRUCTION");
        cardPanel.add(game,"GAME");
        pane.setLayout(new BorderLayout());
        pane.add(cardPanel,BorderLayout.CENTER);
        
        this.pack();
        this.setVisible(true);
        //animationLoop(); //uruchom pÄ™tlÄ™ animacji gry
        
    }
    
    public void menuGUI(int width, int height, int level){
        
        Image image;
        JButton start=new JButton("Rozpocznij grę");
        JButton instruction=new JButton("Jak grać");
        JButton end=new JButton("Wyjdź z gry");

        menu.setPreferredSize(new java.awt.Dimension(width, height));


        end.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        end.setBackground(Color.white);
        end.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    endActionPerformed(evt);
                }
            });

        instruction.setFont(new java.awt.Font("Arial", 0, 30));
        instruction.setBackground(Color.white);
        instruction.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    instructionActionPerformed(evt);
                }
            });

        start.setFont(new java.awt.Font("Arial", 0, 30));
        start.setBackground(Color.white);
        start.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    startActionPerformed(evt);
                }
            }); 

        menu.setLayout(new FlowLayout(1, 150,0));
        image = GPars.logo;
        JLabel logo = new JLabel(new ImageIcon(image));
        
        menu.add(logo);
        menu.add(start);
        menu.add(instruction);
        menu.add(end);
        
        //dodaj panel gry zawierajÄ…cy grafikÄ™ i akcjÄ™
    }//koniec initGUI()
    
    public void chooseGUI (int width, int height, int level,Graphics g){
        JLabel title = new JLabel();
        JLabel under_title = new JLabel();
        JButton zero = new JButton();
        JButton zero_six = new JButton();
        JButton one_five = new JButton();
        JButton two_three = new JButton();
        JButton three_four = new JButton();
        JButton back = new JButton();
        

        choose.setPreferredSize(new java.awt.Dimension(1024, 768));
        
        title.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Wybierz dawkę alkoholu");

        under_title.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        under_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        under_title.setText("Czym większa dawka alkoholu, tym trudniejsza będzie gra");

        zero.setText("0,0‰");
        zero.setBackground(Color.white);
        zero.setFont(new java.awt.Font("Arial", 0, 30));
        zero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zeroActionPerformed(evt,level,width,height,g);
            }
        });

        zero_six.setText("0,6‰");
        zero_six.setBackground(Color.white);
        zero_six.setFont(new java.awt.Font("Arial", 0, 30));
        
        one_five.setText("1,5‰");
        one_five.setBackground(Color.white);
        one_five.setFont(new java.awt.Font("Arial", 0, 30));
        
        two_three.setText("2,3‰");
        two_three.setBackground(Color.white);
        two_three.setFont(new java.awt.Font("Arial", 0, 30));

        three_four.setText("3,4‰");
        three_four.setBackground(Color.white);
        three_four.setFont(new java.awt.Font("Arial", 0, 30));
        
        back.setText("Wróć do menu");
        back.setBackground(Color.white);
        back.setFont(new java.awt.Font("Arial", 0, 30));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
    });
        choose.setLayout(new GridLayout(8,1));
    
        choose.add (title);
        choose.add(under_title);
        choose.add(zero);
        choose.add(zero_six);
        choose.add(one_five);
        choose.add(two_three);
        choose.add(three_four);
        choose.add(back);
    }
    
    public void instructionGUI (int width, int height){
       
        
        Image image;
        JLabel under_title = new JLabel();
        JButton back = new JButton();
        
        instruction.setPreferredSize(new java.awt.Dimension(1024, 768));
        
        back.setText("Wróć do menu");
        back.setBackground(Color.white);
        back.setFont(new java.awt.Font("Arial", 0, 30));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
    });
       instruction.setLayout(new FlowLayout(1));
       image = GPars.instruction;
       JLabel instructionImage = new JLabel(new ImageIcon(image));
       instruction.add(instructionImage);
       instruction.add(back);
    }
    
    public void gameGUI (int widht, int height, int level, Graphics g){
        
        JPanel play = new JPanel();
        JPanel buttons = new JPanel();
        Image trackImage;
        JButton menu = new JButton("Menu");
        menu.setFont(new java.awt.Font("Arial", 0, 30));
        menu.setBackground(Color.white);
        menu.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    backActionPerformed(evt);
                }
            }); 
        
        trackImage = GPars.track;
        //JLabel track = new JLabel(new ImageIcon(trackImage));
        //play.add();
        //buttons.add(menu);
        //game.add(play);
        //game.add(buttons);
        tm.start();
        
        
        
        /*while(posY>-200)
        {
            
            
            track.setLocation(0, CheckLocation(posY));
           
            
        }*/
        
   } 
    
    public void paintComponent(Graphics g) {
        this.paintComponent(g);

        drawStar(g);
    }

    private void drawStar(Graphics g) {

        g.drawImage(GPars.track, 0, y, this);
        Toolkit.getDefaultToolkit().sync();
    }
    
    @Override
    public void actionPerformed (ActionEvent e){
        y=y-dy;
        repaint();
    }
    
    private void endActionPerformed(java.awt.event.ActionEvent evt) {                                         
        System.exit(0);
    }                                        

    private void instructionActionPerformed(java.awt.event.ActionEvent evt) {                                         
        cl.show(cardPanel,"INSTRUCTION");
    }                                        

    private void startActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        cl.show(cardPanel,"CHOOSE");
        
    } 
    
    private void zeroActionPerformed(java.awt.event.ActionEvent evt, int level, int width, int height,Graphics g) {                                     
        
        level = 1;
        gameGUI(width,height,level,g);
        cl.show(cardPanel,"GAME");
    }  

    private void backActionPerformed(java.awt.event.ActionEvent evt) {                                     
        cl.show(cardPanel,"MENU");
    }  
    
     private void menuActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        //TU MUSI BYĆ INNE MENU KTÓRE BEDZIE KONTYNUOWALO GRE A NIE ZACZYNALO NOWA
        
    } 
    

   
    
    
}
