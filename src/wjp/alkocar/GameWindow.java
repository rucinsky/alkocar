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
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author Damian
 */



public class GameWindow extends JFrame {
    
    public int width;
    public int height;
    public JPanel menu = new JPanel();
    public JPanel choose = new JPanel();
    public JPanel instruction = new JPanel();
    public JPanel game = new JPanel();
    public JPanel cardPanel = new JPanel();
    public CardLayout cl = new CardLayout();
    public Container pane = this.getContentPane();
    public Graphics g;
    //public Timer tm = new Timer(5,this);
    public int y=0, dy=2;
    
    
    
    public GameWindow(int width, int height, int x, int y,int level)
    {        
        super();
        this.width=width;
        this.height=height;//wywoĹ‚aj konstruktor klasy nadrzÄ™dnej - utwĂłrz okno
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height); //ustaw wymiary okna
        setLocation(x,y); //ustaw pozycjÄ™ okna
        setResizable(true); //zablokuj moĹĽliwoĹ›Ä‡ zmian rozmiaru okna
        setUndecorated(true); //ukryj ramkÄ™ okna i przyciski kontrolne
        GPars.loadInitialImages();
        menuGUI(width,height,level);
        chooseGUI(width,height,level,g); 
        //gameGUI(width,height,level);  
        instructionGUI(width,height);
        
        cardPanel.setLayout(cl);
        cardPanel.add(menu,"MENU");
        cardPanel.add(choose,"CHOOSE");
        cardPanel.add(instruction,"INSTRUCTION");
        pane.setLayout(new BorderLayout());
        pane.add(cardPanel,BorderLayout.CENTER);
        
        this.pack();
        this.setVisible(true);
        //animationLoop(); //uruchom pÄ™tlÄ™ animacji gry
        
    }
    
    public void menuGUI(int width, int height, int level){
        
        Image image;
        JButton start=new JButton();
        JButton instruction=new JButton();
        JButton end=new JButton();

        menu.setPreferredSize(new java.awt.Dimension(width, height));


        end.setIcon(GPars.end_button);
        end.setBorderPainted(true);
        end.setContentAreaFilled(false);
        end.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ButtonAction.endActionPerformed(evt);
                }
            });

        instruction.setIcon(GPars.how_button);
        instruction.setBorderPainted(true);
        instruction.setContentAreaFilled(false);
        instruction.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ButtonAction.instructionActionPerformed(evt, cl, cardPanel);
                }
            });

        //start.setFont(new java.awt.Font("Arial", 0, 30));
        
        start.setIcon(GPars.start_button);
        start.setBorderPainted(true);
        start.setContentAreaFilled(false);
        start.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ButtonAction.startActionPerformed(evt, cl, cardPanel);
                }
            }); 

        menu.setLayout(new FlowLayout(1, 150,0));
        image = GPars.logo;
        JLabel logo = new JLabel(new ImageIcon(image));
        
        menu.add(logo);
        menu.add(start);
        menu.add(instruction);
        menu.add(end);
        
        validate();
        
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
        
        one_five.setIcon(GPars.alc3_button);
        one_five.setBorderPainted(true);
        one_five.setContentAreaFilled(false);
        
        two_three.setIcon(GPars.alc4_button);
        two_three.setBorderPainted(true);
        two_three.setContentAreaFilled(false);

        three_four.setIcon(GPars.alc5_button);
        three_four.setBorderPainted(true);
        three_four.setContentAreaFilled(false);
        
        back.setIcon(GPars.back_button);
        back.setBorderPainted(true);
        back.setContentAreaFilled(false);
        back.addActionListener(new java.awt.event.ActionListener() {
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
    
    public void instructionGUI (int width, int height){
       
        
        Image image;
        JLabel under_title = new JLabel();
        JButton back = new JButton();
        
        instruction.setPreferredSize(new java.awt.Dimension(1024, 768));
        
        back.setIcon(GPars.back_button);
        back.setBorderPainted(true);
        back.setContentAreaFilled(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAction.backActionPerformed(evt, cl, cardPanel);
            }
    });
       instruction.setLayout(new FlowLayout(1));
       image = GPars.instruction;
       JLabel instructionImage = new JLabel(new ImageIcon(image));
       instruction.add(instructionImage);
       instruction.add(back);
    }
    
    /*public void gameGUI (int widht, int height, int level){
        JButton back;
        JLabel alcohol;
        JPanel play = new JPanel();
        JPanel buttons = new JPanel();
        
        //buttons.add(back);
        //game.add(gp);
        //gp.repaint();
        //game.add(buttons);
        
        
        
        
        
        
        /*while(true){
            
            while(c <= 1){
                gp.moveTrack(count);
                gp.repaint();//redraw road to match new locations
                try{
                    Thread.sleep(5);    //wait so that the road appears to be moving continously
                }
                catch(Exception e){
                    System.out.println(e);
                }
                c++;
            }
            c = 1;
            count++;}*/
    
        /*JPanel play = new JPanel();
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
        JLabel track = new JLabel(new ImageIcon(trackImage));
        play.add(track);
        buttons.add(menu);
        game.add(play);
        game.add(buttons);
        //tm.start();
        
        
        
        while(posY>-200)
        {
            
            
            track.setLocation(0, CheckLocation(posY));
           
            
        }*/
        
 
    

    
    
    

   
    
    
}
