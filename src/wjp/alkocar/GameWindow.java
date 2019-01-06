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
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Klasa, w której tworzone są wszystkie mniej skomplikowane panele takie jak
 * menu, instrukcja, game over. Wyświetla także okno główne gry.
 * @author Damian
 */



public class GameWindow extends JFrame {
    
    public int width;
    public int height;
    public JPanel menu = new JPanel();
    public JPanel choose = new JPanel();
    public JPanel instruction = new JPanel();
    public JPanel game = new JPanel();
    public JPanel gameover = new JPanel();
    public JPanel cardPanel = new JPanel();
    public CardLayout cl = new CardLayout();
    public Container pane = this.getContentPane();
    
    /**
     * Konstruktor klasy, ładuje wszystkie panele i dodaje je do layoutu.
     * @param width szerokość okna
     * @param height wysokość okna
     * @param x położenie okna na osi x
     * @param y położenie okna na osi y
     */
    
    public GameWindow(int width, int height, int x, int y)
    {        
        super(); //wywołaj konstruktor klasy nadrzędnej
        this.width=width;
        this.height=height;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height); //ustaw wymiary okna
        setLocation(x,y); //ustaw pozycję okna
        setResizable(true); //zablokuj możliwość zmian rozmiaru okna
        setUndecorated(true); //ukryj ramkę okna i przyciski kontrolne
        GPars.loadInitialResources(); // załadowanie niezbędnych zasobów
        menuGUI(width,height); //załadowanie panelu MENU
        chooseGUI(width,height); // załadowanie panelu WYBORU DAWKI ALKOHOLU
        gameoverGUI(width,height);  //załadowanie panelu GAME OVER
        instructionGUI(width,height); //załadowanie panelu INSTRUKCJI
        
        cardPanel.setLayout(cl); //ustawienie w cardPanelu layoutu CardLayout
        cardPanel.add(menu,"MENU"); 
        cardPanel.add(choose,"CHOOSE");
        cardPanel.add(instruction,"INSTRUCTION");
        cardPanel.add(gameover,"GAME OVER");
        pane.setLayout(new BorderLayout());
        pane.add(cardPanel,BorderLayout.CENTER);
        
        this.pack();
        this.setVisible(true);
        
    }
    /**
     * Metoda ładująca komponenty panelu MENU
     * @param width szerokość okna
     * @param height wysokość okna
     */
    public void menuGUI(int width, int height){
        
        Image image;
        JButton start=new JButton(); //przycisk "Rozpocznij grę"
        JButton instruction=new JButton(); //przycisk "Jak grać"
        JButton end=new JButton(); //przycisk "Wyjdź z gry"
        image = GPars.logo; //wczytanie grafiki
        JLabel logo = new JLabel(new ImageIcon(image)); //obraz loga

        menu.setPreferredSize(new java.awt.Dimension(width, height));


        end.setIcon(GPars.end_button); //wstawienie grafiki na przycisk
        end.setBorderPainted(true);
        end.setContentAreaFilled(false);
        end.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ButtonAction.endActionPerformed(evt);
                }
            });

        instruction.setIcon(GPars.how_button);
        instruction.setBorderPainted(true);
        instruction.setContentAreaFilled(false);
        instruction.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ButtonAction.instructionActionPerformed(evt, cl, cardPanel);
                }
            });

        //start.setFont(new java.awt.Font("Arial", 0, 30));
        
        start.setIcon(GPars.start_button);
        start.setBorderPainted(true);
        start.setContentAreaFilled(false);
        start.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ButtonAction.startActionPerformed(evt, cl, cardPanel);
                }
            }); 

        menu.setLayout(new FlowLayout(1, 150,0));
        
        
        /*Dodanie do panelu wcześniej utworzonych komponentów*/
        menu.add(logo);
        menu.add(start);
        menu.add(instruction);
        menu.add(end);

    }
    
    /**
     * Metoda ładująca komponenty panelu wyboru dawki alkoholu
     * @param width szerokość okna
     * @param height wysokość okna
     */
    public void chooseGUI (int width, int height){
        JLabel title = new JLabel(); //tytuł panelu
        JLabel under_title = new JLabel(); // tekst pod tytułem
        JButton zero = new JButton(); // przycisk "trzeźwy"
        JButton zero_six = new JButton(); // przycisk "0,6 promila"
        JButton one_five = new JButton(); // przycisk "1,5 promila"
        JButton two_three = new JButton(); // przycisk "2,3 promila"
        JButton three_four = new JButton(); // przycisk "3,4 promila"
        JButton back = new JButton(); // przycisk powrotu do menu
        

        choose.setPreferredSize(new java.awt.Dimension(width, height));
        
        title.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Wybierz dawkę alkoholu");

        under_title.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        under_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        under_title.setText("Czym większa dawka alkoholu, tym trudniejsza będzie gra");

        zero.setIcon(GPars.alc1_button);
        zero.setBorderPainted(true);
        zero.setContentAreaFilled(false);
        zero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAction.zeroActionPerformed(evt, cl, cardPanel,width,height);
            }
        });

        zero_six.setIcon(GPars.alc2_button);
        zero_six.setBorderPainted(true);
        zero_six.setContentAreaFilled(false);
        zero_six.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAction.zero_sixActionPerformed(evt, cl, cardPanel,width,height);
            }
        });
        
        one_five.setIcon(GPars.alc3_button);
        one_five.setBorderPainted(true);
        one_five.setContentAreaFilled(false);
        one_five.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAction.one_fiveActionPerformed(evt, cl, cardPanel,width,height);
            }
        });
        
        two_three.setIcon(GPars.alc4_button);
        two_three.setBorderPainted(true);
        two_three.setContentAreaFilled(false);
        two_three.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAction.two_threeActionPerformed(evt, cl, cardPanel,width,height);
            }
        });

        three_four.setIcon(GPars.alc5_button);
        three_four.setBorderPainted(true);
        three_four.setContentAreaFilled(false);
        three_four.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAction.three_fourActionPerformed(evt, cl, cardPanel,width,height);
            }
        });
        
        back.setIcon(GPars.back_button);
        back.setBorderPainted(true);
        back.setContentAreaFilled(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAction.backActionPerformed(evt, cl, cardPanel);
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
    /**
     * Metoda ładująca komponenty panelu instrukcji
     * @param width szerokość okna
     * @param height wysokość okna
     */
    public void instructionGUI (int width, int height){
        Image image; //grafika z opisem rozgrywki
        JButton back = new JButton(); //przycisk powrotu do menu
        image = GPars.instruction; // wczytanie grafiki
        JLabel instructionImage = new JLabel(new ImageIcon(image)); 
        instruction.setPreferredSize(new java.awt.Dimension(width, height));
        
        back.setIcon(GPars.back_button);
        back.setBorderPainted(true);
        back.setContentAreaFilled(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAction.backActionPerformed(evt, cl, cardPanel);
            }
    });
       instruction.setLayout(new FlowLayout(1));
       
       instruction.add(instructionImage);
       instruction.add(back);
    }
   /**
     * Metoda ładująca komponenty panelu Game Over
     * @param width szerokość okna
     * @param height wysokość okna
    */ 
    public void gameoverGUI (int width, int height){
        Image image;
        JButton back = new JButton(); //przycisk powrotu do menu
        image = GPars.gameover; //wczytanie grafiki
        JLabel gameoverImage = new JLabel(new ImageIcon(image)); //grafika game over
        gameover.setPreferredSize(new java.awt.Dimension(width, height));
        back.setIcon(GPars.back_button);
        back.setBorderPainted(true);
        back.setContentAreaFilled(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAction.backActionPerformed(evt, cl, cardPanel);
            }
    });
       gameover.add(gameoverImage);
       gameover.add(back);
    }
    
}
