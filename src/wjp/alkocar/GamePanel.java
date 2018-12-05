/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wjp.alkocar;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Damian
 */
public class GamePanel extends JPanel {
    /** SzerokoĹ›Ä‡ pola graficznego gry*/
    public int sWidth;
    /** WysokoĹ›Ä‡ pola graficznego gry*/
    public int sHeight;
    /** Liczba obiektĂłw/balonĂłw w linii*/
    public int objectsInLine;
    /** PrzesuniÄ™cie pomiÄ™dzy liniami z obiektami/bsalonami*/
    public int shiftBL;
    /** Obiekt reprezentujÄ…cy status gry*/
    //public GameStatus gStatus;
    /** WysokoĹ›Ä‡ paska menu*/
    public Font menuFont;
    /** Czcionki stosowane jako alert w polu gry*/
    public Font alertFont;
    /** Tablica obiektĂłw pierwszego planu - balony*/
    CardLayout cl = new CardLayout();
    
    public GamePanel(int width, int height,int check){
        this.sWidth=width;
        this.sHeight=height;
        
        
        if (check==0){
            ChooseOptionMenu(width,height,check);
        }
        if (check==1){
            ChooseAlcohol();
        }
    }
    
    public void ChooseOptionMenu (int width, int height,int check){ 
    
    JLabel  title= new JLabel();
    JButton start=new JButton("Rozpocznij grę");
    JButton instruction=new JButton("Jak grać");
    JButton end=new JButton("Wyjdź z gry");
    title.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
    title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    title.setText("AlkoCar");
    title.setToolTipText("");
    
    end.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    end.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endActionPerformed(evt,check);
            }
        });

    instruction.setFont(new java.awt.Font("Arial", 0, 18)); 
    instruction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructionActionPerformed(evt,check);
            }
        });

    start.setFont(new java.awt.Font("Arial", 0, 18));
    start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt,width,height,check);
            }
        }); 
    
    setLayout(new GridLayout(4,1));
    
    add (title);
    add(start);
    add(instruction);
    add(end);

    }
    
    public void ChooseAlcohol(){
    JLabel title= new JLabel();
    title.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
    title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    title.setText("AlkoCar");
    title.setToolTipText("");
    setLayout(new GridLayout(1,1));
    add(title);
    }
    
    
    private void endActionPerformed(java.awt.event.ActionEvent evt, int check) {                                         
        System.exit(0);
    }                                        

    private void instructionActionPerformed(java.awt.event.ActionEvent evt, int check) {                                         
        // TODO add your handling code here:
    }                                        

    private void startActionPerformed(java.awt.event.ActionEvent evt, int width, int height,int check) {                                         
        check = 1;
        GamePanel choose = new GamePanel(width,height,check);
        check = 2;
        GamePanel cont = new GamePanel(width,height,check);

        cont.add(choose, "1");
        cont.setLayout(cl);
        add(cont);
        cl.show(cont, "1");

        
                
    }
}
