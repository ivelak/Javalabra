/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maalimanvahvimmat.kali;

import maalimanvahvimmat.tietomalli.Harjoituskertarekisteri;
import javax.swing.JOptionPane;
import maalimanvahvimmat.tietomalli.Harjoituskerta;
import maalimanvahvimmat.tietomalli.Liike;

/**
 *
 * @author rantapel
 */
public class TreeninLisays extends javax.swing.JFrame {

    private Harjoituskertarekisteri rekisteri;
    private Harjoituskerta treeni = null;

    /**
     * Creates new form TreeninLisays
     */
    public TreeninLisays(Harjoituskertarekisteri rekisteri) {

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

        lisaaLiike = new javax.swing.JButton();
        valmis = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

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

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lisaaLiike, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valmis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
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
                        .addComponent(valmis))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void valmisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valmisActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_valmisActionPerformed

    private void lisaaLiikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lisaaLiikeActionPerformed
        if (this.treeni==null){
            alusta();
        }
        lisaaLiike();
        
    }//GEN-LAST:event_lisaaLiikeActionPerformed

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
            java.util.logging.Logger.getLogger(TreeninLisays.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TreeninLisays.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TreeninLisays.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TreeninLisays.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //   new TreeninLisays().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton lisaaLiike;
    private javax.swing.JButton valmis;
    // End of variables declaration//GEN-END:variables

    private void alusta() {
        String pvm = JOptionPane.showInputDialog("Anna harjoituksen päivämäärä (pp.kk.vvvv)");
        this.treeni = new Harjoituskerta(pvm);
    }

    private void lisaaLiike() {
        
        String nimi = JOptionPane.showInputDialog("Liikkeen nimi:");
        Liike liike = new Liike(nimi);

        while (true) {
            System.out.println("Lisää toistot ja painot, tyhjä rivi lopettaa");
            System.out.println("Toistomäärä: ");
            int toisto;
            int paino;

            String rivi = lukija.nextLine();
            try {
                toisto = Integer.parseInt(rivi);
            } catch (NumberFormatException e) {
                break;
            }



            System.out.println("Paino: ");
            rivi = lukija.nextLine();
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
