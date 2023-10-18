/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leecottrell;

import javax.swing.DefaultListModel;

/**
 *
 * @author lee_c
 */
public class JFrameCardGame extends javax.swing.JFrame {

    protected Card newCard = new Card();
    protected Card lastCard = new Card();
    /**
     * Creates new form JFrameCardGame
     */

    DefaultListModel cards = new DefaultListModel();

    public JFrameCardGame() {
        initComponents();
        this.lstCards.setModel(cards);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstCards = new javax.swing.JList();
        btnDeal = new javax.swing.JButton();
        lblWin = new javax.swing.JLabel();
        btnHigh = new javax.swing.JButton();
        btnLow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lstCards.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lstCards.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstCards);

        btnDeal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnDeal.setText("New Deal");
        btnDeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDealActionPerformed(evt);
            }
        });

        lblWin.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btnHigh.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnHigh.setText("High");
        btnHigh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHighActionPerformed(evt);
            }
        });

        btnLow.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnLow.setText("Low");
        btnLow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeal, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnHigh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLow, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblWin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblWin, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDeal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHigh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLow)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDealActionPerformed
        // TODO add your handling code here:
        cards.clear();
        newCard.pickCard();
        cards.addElement(newCard);
        this.btnDeal.setVisible(false);
        this.btnHigh.setVisible(true);
        this.btnLow.setVisible(true);
    }//GEN-LAST:event_btnDealActionPerformed

    private void btnHighActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHighActionPerformed
        // TODO add your handling code here:
        dealACard();
        displayWin(checkBet(1));

    }//GEN-LAST:event_btnHighActionPerformed

    private void btnLowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLowActionPerformed
        // TODO add your handling code here:
        dealACard();
        displayWin(checkBet(2));
    }//GEN-LAST:event_btnLowActionPerformed

    private void displayWin(boolean winner){
        if(winner){
            this.lblWin.setText("Good");
            if(cards.size() > 6){
               this.lblWin.setText("Winner"); 
            }
        }
        else{
            this.lblWin.setText("Bad");
            this.btnDeal.setVisible(true);
        }
    }
    private boolean checkBet(int compare) {
        switch (compare) {
            case 1:
                //bet higher
                if (lastCard.getValue() < newCard.getValue()) {
                    return true;
                } else {
                    return false;
                }

            case 2:
                //bet lower
                 if (lastCard.getValue() > newCard.getValue()) {
                    return true;
                } else {
                    return false;
                }
                
            default:

                break;
        }
        return true;
    }

    private void dealACard() {
        lastCard = new Card();
        lastCard.setSuit(newCard.getSuit());
        lastCard.setValue(newCard.getValue());
        newCard = new Card();
        do {
            newCard.pickCard();
        } while (lastCard.equals(newCard));
        //this.cards.addElement(newCard);
        this.cards.addElement(newCard);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameCardGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameCardGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameCardGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameCardGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameCardGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnDeal;
    public javax.swing.JButton btnHigh;
    public javax.swing.JButton btnLow;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblWin;
    public javax.swing.JList lstCards;
    // End of variables declaration//GEN-END:variables
    //add getters
    public javax.swing.JButton getBtnDeal(){
        return btnDeal;
    }
}
