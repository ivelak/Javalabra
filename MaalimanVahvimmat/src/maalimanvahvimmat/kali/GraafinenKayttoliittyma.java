/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maalimanvahvimmat.kali;

import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import maalimanvahvimmat.Kayttoliittyma;
import maalimanvahvimmat.tietomalli.Kayttaja;
import maalimanvahvimmat.tietomalli.Kayttajarekisteri;

/**
 *
 * @author rantapel
 */
public class GraafinenKayttoliittyma implements Kayttoliittyma {  
    private Kayttajarekisteri rekisteri;
    private final Kirjautuminen k;
    private final Treenit t = new Treenit();
    private Kayttaja kayttaja;

    public GraafinenKayttoliittyma(Kayttajarekisteri rekisteri) {
        
        this.rekisteri=rekisteri;
        this.k=new Kirjautuminen(rekisteri, this);
    }
    public void asetaKayttaja(Kayttaja kayttaja) {
        this.kayttaja = kayttaja;
        k.setVisible(false);
        t.setVisible(true);
    }
   
    @Override
    public void kaynnista(){
        k.setVisible(true);
        
    }
}
