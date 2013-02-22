
package maalimanvahvimmat.kali;

import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import maalimanvahvimmat.tietomalli.Harjoituskertarekisteri;
import javax.swing.event.ListSelectionListener;
import maalimanvahvimmat.tietomalli.Harjoituskerta;

/**
 * Luokka Harjoitusten graafiselle hallinnalle.
 * Näkymässä voi tarkastella vanhoja harjoituksia, sekä edetä luomaan uutta merkintää.
 *
 */
public class Treenit extends javax.swing.JFrame {
    private Harjoituskertarekisteri rekisteri;

   
    public Treenit(Harjoituskertarekisteri rekisteri) {
        this.rekisteri=rekisteri;
        initComponents();

        taytaTreenilista();
        asetaLisaystoiminto();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        treenilista = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        treeniData = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        treeniValikko = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        treenilista.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(treenilista);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jScrollPane2.setViewportView(treeniData);

        jSplitPane1.setRightComponent(jScrollPane2);

        treeniValikko.setText("Treeni");
        jMenuBar1.add(treeniValikko);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextPane treeniData;
    private javax.swing.JMenu treeniValikko;
    private javax.swing.JList treenilista;
    // End of variables declaration//GEN-END:variables

    /**
     * Tuo näkymän vasempaan laitaan harjoituskertarekisterin harjoituskertojen päivämäärät.
     * Kunkin harjoituksen voi valita, jolloin metodi kutsuu naytaTreeni()-metodia.
     */
    private void taytaTreenilista() {
        treenilista.setModel(rekisteri);
        
        treenilista.addListSelectionListener(new ListSelectionListener() {
            

            @Override
            public void valueChanged(ListSelectionEvent e) {
                
                naytaTreeni((String)treenilista.getSelectedValue());
            }
        });
    }
    /**
     * tulostaa valitun harjoituksen tiedot näkymän oikeaan reunaan.
     */
    public void naytaTreeni(String pvm) {
        Harjoituskerta treeni = this.rekisteri.getHarjoituskerta(pvm);
        String treeniTeksti = treeni.listaaLiikkeet();
        treeniData.setText(treeniTeksti);
        
    }
    /**
     * Lisää treenivalikkoon painikkeen "lisää treeni".
     */
    private void asetaLisaystoiminto() {
        
        JMenuItem lisaa= new JMenuItem("lisää treeni");
        treeniValikko.add(lisaa);
        
        lisaa.addActionListener(new ActionListener() {

            /**
             * luo TreeninLisays-olion ja asettaa sen näkyviin.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                TreeninLisays l = new TreeninLisays(rekisteri);
                l.setVisible(true);
                
                taytaTreenilista();
                                
            }
        });
        
        
        
        
    }
}
