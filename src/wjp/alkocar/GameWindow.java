/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wjp.alkocar;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
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
/**
 *
 * @author Damian
 */



public class GameWindow extends JFrame {
    public JPanel menu = new JPanel();
    public JPanel choose = new JPanel();
    public JPanel instruction = new JPanel();
    public JPanel game = new JPanel();
    public JPanel cardPanel = new JPanel();
    public CardLayout cl = new CardLayout();
    public Container pane = this.getContentPane();
    
    
    
    public GameWindow (int width, int height, int x, int y,int check)
    {        
        super(); //wywoĹ‚aj konstruktor klasy nadrzÄ™dnej - utwĂłrz okno
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height); //ustaw wymiary okna
        setLocation(x,y); //ustaw pozycjÄ™ okna
        setResizable(true); //zablokuj moĹĽliwoĹ›Ä‡ zmian rozmiaru okna
        setUndecorated(true); //ukryj ramkÄ™ okna i przyciski kontrolne
        menuGUI(width,height,check);
        chooseGUI(width,height,check);
        instructionGUI(width,height);
        GPars.loadInitialImages();
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
    
    public void menuGUI(int width, int height, int check){
        //setLayout(new GridLayout(1,1)); //ustaw rozkĹ‚ad 
        //ustaw zasoby i parametry poczÄ…tkowe
        //JLabel  title= new JLabel();
        BufferedImage image;
        
        
        
        JButton start=new JButton("Rozpocznij grę");
        JButton instruction=new JButton("Jak grać");
        JButton end=new JButton("Wyjdź z gry");

        menu.setPreferredSize(new java.awt.Dimension(width, height));


        end.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        end.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    endActionPerformed(evt);
                }
            });

        instruction.setFont(new java.awt.Font("Arial", 0, 30)); 
        instruction.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    instructionActionPerformed(evt);
                }
            });

        start.setFont(new java.awt.Font("Arial", 0, 30));
        start.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    startActionPerformed(evt);
                }
            }); 

        menu.setLayout(new FlowLayout(1, 150,0));
        //menu.add (title);
        try {
            image = ImageIO.read(new File("./src/images/logo.png"));
            JLabel logo = new JLabel(new ImageIcon(image));
            menu.add(logo);
        } catch (IOException ex) {
            Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        menu.add(start);
        menu.add(instruction);
        menu.add(end);
        
        //dodaj panel gry zawierajÄ…cy grafikÄ™ i akcjÄ™
    }//koniec initGUI()
    
    public void chooseGUI (int width, int height, int check){
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
        zero.setFont(new java.awt.Font("Arial", 0, 30));
        zero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zeroActionPerformed(evt);
            }
        });

        zero_six.setText("0,6‰");
        zero_six.setFont(new java.awt.Font("Arial", 0, 30));
        
        one_five.setText("1,5‰");
        one_five.setFont(new java.awt.Font("Arial", 0, 30));
        
        two_three.setText("2,3‰");
        two_three.setFont(new java.awt.Font("Arial", 0, 30));

        three_four.setText("3,4‰");
        three_four.setFont(new java.awt.Font("Arial", 0, 30));
        
        back.setText("Wróć do menu");
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
       
        
        BufferedImage image;
        JLabel under_title = new JLabel();
        JButton back = new JButton();
        
        instruction.setPreferredSize(new java.awt.Dimension(1024, 768));
        
        back.setText("Wróć do menu");
        back.setFont(new java.awt.Font("Arial", 0, 30));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
    });
       instruction.setLayout(new FlowLayout(1));

       try {
            image = ImageIO.read(new File("./src/images/instruction.png"));
            JLabel logo = new JLabel(new ImageIcon(image));
            instruction.add(logo);
        } catch (IOException ex) {
            Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
       instruction.add(back);
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
    
    private void zeroActionPerformed(java.awt.event.ActionEvent evt) {                                     
        cl.show(cardPanel,"GAME");
    }  

    private void backActionPerformed(java.awt.event.ActionEvent evt) {                                     
        cl.show(cardPanel,"MENU");
    }  
    

    
    
    
}
