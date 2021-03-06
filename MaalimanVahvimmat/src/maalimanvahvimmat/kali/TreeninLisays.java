/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maalimanvahvimmat.kali;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import maalimanvahvimmat.tietomalli.Harjoituskertarekisteri;
import javax.swing.JOptionPane;
import maalimanvahvimmat.tietomalli.Harjoituskerta;
import maalimanvahvimmat.tietomalli.Liike;

/**
 * Näkymä uuden harjoituksen lisäystä varten.
 * 
 * 
 */
public class TreeninLisays extends javax.swing.JFrame {

    private Harjoituskertarekisteri rekisteri;
    private Harjoituskerta treeni = null;

   
    public TreeninLisays(Harjoituskertarekisteri rekisteri) {

        this.rekisteri = rekisteri;


        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        lisaaLiike = new javax.swing.JButton();
        valmis = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lisatytLiikkeet = new javax.swing.JTextArea();
        motivaattori = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lisaaLiike.setText("Lisää liike");
        lisaaLiike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lisaaLiikeActionPerformed(evt);
            }
        });

        valmis.setText("Valmis");
        valmis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valmisActionPerformed(evt);
            }
        });

        lisatytLiikkeet.setColumns(20);
        lisatytLiikkeet.setRows(5);
        jScrollPane1.setViewportView(lisatytLiikkeet);

        motivaattori.setText("Motivaattori");
        motivaattori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motivaattoriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lisaaLiike, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(valmis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(motivaattori))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lisaaLiike)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(motivaattori)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valmis))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Valmis-näppäimen funktio. Mikäli harjoituskerta on luotu, tallentaa Harjoituskerta-olion ja lisää sen harjoituskertarekisteriin.
     * tuo Treenit-olion näkyviin.
     */
    
    private void valmisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valmisActionPerformed
        if (treeni != null) {
            try {
                treeni.tallennaHarjoituskertatiedosto(rekisteri.getKayttaja());
                rekisteri.lisaaHarjoituskertaRekisteriin(treeni);

            } catch (IOException ex) {
                Logger.getLogger(TreeninLisays.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Treenit t = new Treenit(rekisteri);
        this.setVisible(false);
        t.setVisible(true);
        
    }//GEN-LAST:event_valmisActionPerformed

    /**
     * mikäli harjoituskertaa ei ole alustettu, kutsuu alusta()-metodia.
     * Kutsuu lisaaLiike()-metodia ja tallentaa sen palauttaman Liike-olion Harjoituskertaan.
     * Tulostaa lisätyn Liike-olion tiedot näkyviin.
     */
    private void lisaaLiikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lisaaLiikeActionPerformed
        if (this.treeni == null) {
            alusta();
        }
        treeni.lisaaLiike(lisaaLiike());
        lisatytLiikkeet.setText(treeni.listaaLiikkeet());

    }//GEN-LAST:event_lisaaLiikeActionPerformed
    /**
     * Avaa selaimelle näkyviin verkkosivun jonka sisältö tarjoaa vinkkejä niin harjoitteluun, kuin myös elämään aktiiviuran jälkeen.
     * Maailman vahvimmille miehille on tärkeää aktiiviuran jälkeen pitää mieli virkeänä. Tähän voi auttaa muun muassa krypto. Mitään en oo ottanu...
     */
    private void motivaattoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motivaattoriActionPerformed
        final String Url = "http://www.youtube.com/watch?v=rRU0DPxHH8Q";
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(Url));
        } catch (IOException ex) {
            Logger.getLogger(TreeninLisays.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_motivaattoriActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lisaaLiike;
    private javax.swing.JTextArea lisatytLiikkeet;
    private javax.swing.JButton motivaattori;
    private javax.swing.JButton valmis;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Kysyy harjoituksen päivämäärän sekä alustaa Harjoituskerta-olion.
     */
    private void alusta() {

        String pvm = JOptionPane.showInputDialog("Anna harjoituksen päivämäärä (pp.kk.vvvv)");
        if (pvm.isEmpty()) {
            alusta();
        }
        this.treeni = new Harjoituskerta(pvm);
    }
    /**
     * Kysyy liikkeen nimen, toistot ja painot sekä tallentaa ne luomaansa Liike-olioon, jonka se myös palauttaa metodin kutsujalle.
     */
    private Liike lisaaLiike() {
        String nimi;
        Liike liike;
        while (true) {
            nimi = JOptionPane.showInputDialog("Liikkeen nimi:");
            if (!nimi.isEmpty()) {
                break;
            }
        }
        liike = new Liike(nimi);

        while (true) {

            int toisto;
            int paino;

            String rivi = JOptionPane.showInputDialog("Lisää toistot ja painot, tyhjä kenttä lopettaa" + "\n" + "Toistomäärä:");
            try {
                toisto = Integer.parseInt(rivi);
            } catch (NumberFormatException e) {
                break;
            }


            rivi = JOptionPane.showInputDialog("Lisää toistot ja painot, tyhjä kenttä lopettaa" + "\n" + "Painot:");
            try {
                paino = Integer.parseInt(rivi);
            } catch (NumberFormatException e) {
                break;
            }
            liike.lisaaToistoJaPaino(toisto, paino);

        }
        return liike;


    }
}
