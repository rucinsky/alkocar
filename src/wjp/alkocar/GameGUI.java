/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wjp.alkocar;

import java.awt.CardLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Damian
 */
public class GameGUI extends JPanel{
    public int level;
    public GameGUI(GamePanel gp,JPanel cardPanel, CardLayout cl, int level){
        this.level = level;
        initComponents(gp,cardPanel,cl, level);
    }
    private void initComponents(GamePanel gp, JPanel cardPanel, CardLayout cl, int level){
        JButton back;
        JLabel alcohol;
        back = new javax.swing.JButton();
        alcohol = new javax.swing.JLabel();
        

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(gp);
        gp.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        back.setIcon(GPars.back_button);
        back.setBorderPainted(true);
        back.setContentAreaFilled(false);
        back.addActionListener((java.awt.event.ActionEvent evt) -> {
            try {
                gp.end();
            } catch (Throwable ex) {
                Logger.getLogger(GameGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            cl.show(cardPanel,"MENU");
        });

        alcohol.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        
        if(level==1){
            alcohol.setText("Zawartość alkoholu we krwi: 0,0 ‰");
        }  
        if(level==2){
            alcohol.setText("Zawartość alkoholu we krwi: 0,6 ‰");
        } 
        if(level==3){
            alcohol.setText("Zawartość alkoholu we krwi: 1,5 ‰");
        } 
        if(level==4){
            alcohol.setText("Zawartość alkoholu we krwi: 2,3 ‰");
        } 
        if(level==5){
            alcohol.setText("Zawartość alkoholu we krwi: 3,4 ‰");
        } 
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(alcohol, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 486, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(alcohol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }
    
}
