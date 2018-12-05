/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wjp.alkocar;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import javax.swing.JFrame;
import java.awt.GridLayout;
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
        setUndecorated(false); //ukryj ramkÄ™ okna i przyciski kontrolne
        menuGUI(width,height,check);
        chooseGUI(width,height,check);
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
    
    public void menuGUI(int width, int height, int check){
        //setLayout(new GridLayout(1,1)); //ustaw rozkĹ‚ad 
        //ustaw zasoby i parametry poczÄ…tkowe
        GPars.loadInitialImages();
        JLabel  title= new JLabel();
        JButton start=new JButton("Rozpocznij grę");
        JButton instruction=new JButton("Jak grać");
        JButton end=new JButton("Wyjdź z gry");

        menu.setPreferredSize(new java.awt.Dimension(1024, 768));

        title.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("AlkoCar");
        title.setToolTipText("");

        end.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        end.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    endActionPerformed(evt);
                }
            });

        instruction.setFont(new java.awt.Font("Arial", 0, 18)); 
        instruction.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    instructionActionPerformed(evt);
                }
            });

        start.setFont(new java.awt.Font("Arial", 0, 18));
        start.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    startActionPerformed(evt);
                }
            }); 

        menu.setLayout(new GridLayout(4,1));
        menu.add (title);
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
        
        title.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Wybierz dawkę alkoholu");

        under_title.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        under_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        under_title.setText("Czym większa dawka alkoholu, tym trudniejsza będzie gra");

        zero.setText("0,0‰");
        zero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zeroActionPerformed(evt);
            }
        });

        zero_six.setText("0,6‰");

        one_five.setText("1,5‰");

        two_three.setText("2,3‰");

        three_four.setText("3,4‰");

        back.setText("Wróć do menu");
        back.setFont(new java.awt.Font("Arial", 0, 16));
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
        JLabel title = new JLabel();
        JLabel under_title = new JLabel();
        JTextArea howtoplay= new JTextArea();
        JButton back = new JButton();
        
        instruction.setPreferredSize(new java.awt.Dimension(1024, 768));
        
        title.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("AlkoCar");

        under_title.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        under_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        under_title.setText("Instrukcja do gry");
        
        howtoplay.setColumns(20);
        howtoplay.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        howtoplay.setRows(5);
        howtoplay.setText("Gra ma na celu zwrócenie uwagi na problem jakim jest prowadzenie \npojazdów mechanicznych pod wpływem alkoholu.\nCelem gracza jest dojechanie prowadzonym pojazdem do mety,\njednocześnie omijając napotykane przeszkody.\n\nUżywaj strzałek na klawiaturze, by poruszać autem. ");
        
        back.setText("Wróć do menu");
        back.setFont(new java.awt.Font("Arial", 0, 16));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
    });
       instruction.setLayout(new GridLayout(4,1));
       instruction.add(title);
       instruction.add(under_title);
       instruction.add(howtoplay);
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
