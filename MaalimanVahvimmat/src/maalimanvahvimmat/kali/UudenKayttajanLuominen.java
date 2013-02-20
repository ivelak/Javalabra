/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maalimanvahvimmat.kali;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import maalimanvahvimmat.tietomalli.Kayttaja;
import maalimanvahvimmat.tietomalli.Kayttajarekisteri;

/**
 *
 * @author rantapel
 */
public class UudenKayttajanLuominen extends javax.swing.JFrame {

    Kayttajarekisteri rekisteri;

    /**
     * Creates new form UudenKayttajanLuominen
     */
    public UudenKayttajanLuominen(Kayttajarekisteri rekisteri) {
        this.rekisteri = rekisteri;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tunnus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ika = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        pituus = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        paino = new javax.swing.JTextField();
        tallenna = new javax.swing.JButton();
        salasana = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tunnus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tunnusActionPerformed(evt);
            }
        });

        jLabel1.setText("käyttäjätunnus: ");

        jLabel2.setText("salasana:");

        jLabel4.setText("ikä:");

        ika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ikaActionPerformed(evt);
            }
        });

        jLabel5.setText("pituus:");

        jLabel6.setText("paino:");

        tallenna.setText("Tallenna");
        tallenna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tallennaActionPerformed(evt);
            }
        });

        salasana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salasanaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tallenna, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tunnus)
                                        .addComponent(salasana, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(paino, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                        .addComponent(pituus, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ika, javax.swing.GroupLayout.Alignment.LEADING)))))
                        .addContainerGap(81, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tunnus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(salasana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ika, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pituus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(paino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(tallenna)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tunnusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tunnusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tunnusActionPerformed

    private void ikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ikaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ikaActionPerformed

    private void tallennaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tallennaActionPerformed
        if (this.rekisteri.onkoKayttajaa(tunnus.getText())) {
            JOptionPane.showMessageDialog(UudenKayttajanLuominen.this, "Käyttäjätunnus on jo käytössä!");
        } else if (salasana.getText().isEmpty()) {
            JOptionPane.showMessageDialog(UudenKayttajanLuominen.this, "Aseta salasana!");
        } else {
            Kayttaja kayttaja = new Kayttaja(tunnus.getText(), salasana.getText());
            if (!ika.getText().isEmpty()) {
                kayttaja.setIka(Integer.parseInt(ika.getText()));
            } if (!paino.getText().isEmpty()) {
                kayttaja.setPaino(Integer.parseInt(paino.getText()));
            } if (!pituus.getText().isEmpty()) {
                kayttaja.setPituus(Integer.parseInt(pituus.getText()));
            }
            try {
                this.rekisteri.lisaaKayttaja(kayttaja);
            } catch (IOException ex) {
                Logger.getLogger(UudenKayttajanLuominen.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setVisible(false);
        }
        
    }//GEN-LAST:event_tallennaActionPerformed

    private void salasanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salasanaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salasanaActionPerformed

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
            java.util.logging.Logger.getLogger(UudenKayttajanLuominen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UudenKayttajanLuominen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UudenKayttajanLuominen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UudenKayttajanLuominen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            //    new UudenKayttajanLuominen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ika;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField paino;
    private javax.swing.JTextField pituus;
    private javax.swing.JTextField salasana;
    private javax.swing.JButton tallenna;
    private javax.swing.JTextField tunnus;
    // End of variables declaration//GEN-END:variables
}