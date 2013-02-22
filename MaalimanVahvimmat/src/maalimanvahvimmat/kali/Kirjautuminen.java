
package maalimanvahvimmat.kali;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import maalimanvahvimmat.tietomalli.Kayttaja;
import maalimanvahvimmat.tietomalli.Kayttajarekisteri;

/**
 * Graafinen näkymä kirjautumista varten.
 * 
 */

public class Kirjautuminen extends javax.swing.JFrame {

    public Kirjautuminen(final Kayttajarekisteri rekisteri, final GraafinenKayttoliittyma kali) {

        initComponents();
        /**
         * Asettaa Kayttaja-olion ja kutsuu GraafinenKayttoliittyma-olion asetaKayttaja()-metodia.
         */
        kirjaudu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String tunnus = kayttajatunnus.getText();
                String salis = new String(salasana.getPassword());

                Kayttaja kayttaja = rekisteri.getKayttaja(tunnus);
                if (kayttaja != null && rekisteri.tarkistaSalasana(kayttaja, salis)) {
                    try {
                        kali.asetaKayttaja(kayttaja);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Kirjautuminen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(Kirjautuminen.this, "Väärä käyttäjätunnus tai salasana");
                }
            }
        });
        /**
         * Avaa näkymän uuden käyttäjän luomista varten.
         */
        uusiTunnus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                UudenKayttajanLuominen ukl = new UudenKayttajanLuominen(rekisteri);
                ukl.setVisible(true);
            }
        
        
        });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        kayttajatunnus = new javax.swing.JTextField();
        salasana = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        kirjaudu = new javax.swing.JButton();
        uusiTunnus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Treenipäiväkirja");

        jLabel2.setText("käyttäjätunnus");

        jLabel3.setText("salasana");

        kirjaudu.setText("Kirjaudu");
        kirjaudu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kirjauduActionPerformed(evt);
            }
        });

        uusiTunnus.setText("Luo uusi tunnus");
        uusiTunnus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uusiTunnusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(salasana, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kirjaudu, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uusiTunnus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(kayttajatunnus))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kayttajatunnus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salasana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kirjaudu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(uusiTunnus)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kirjauduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kirjauduActionPerformed
    }//GEN-LAST:event_kirjauduActionPerformed

    private void uusiTunnusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uusiTunnusActionPerformed
    
    }//GEN-LAST:event_uusiTunnusActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField kayttajatunnus;
    private javax.swing.JButton kirjaudu;
    private javax.swing.JPasswordField salasana;
    private javax.swing.JButton uusiTunnus;
    // End of variables declaration//GEN-END:variables
}
