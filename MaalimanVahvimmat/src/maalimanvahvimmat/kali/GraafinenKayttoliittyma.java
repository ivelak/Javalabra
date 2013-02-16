/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maalimanvahvimmat.kali;

import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import maalimanvahvimmat.Kayttoliittyma;
import maalimanvahvimmat.tietomalli.Kayttajarekisteri;

/**
 *
 * @author rantapel
 */
public class GraafinenKayttoliittyma implements Kayttoliittyma {  
    private Kayttajarekisteri rekisteri;
    private final Kirjautuminen k = new Kirjautuminen(rekisteri);
    private final Treenit t = new Treenit();

    public GraafinenKayttoliittyma(Kayttajarekisteri rekisteri) {
        this.rekisteri=rekisteri;
        
    }
   
    @Override
    public void kaynnista(){
        k.setVisible(true);
        k.addHierarchyListener(new HierarchyListener() {

            @Override
            public void hierarchyChanged(HierarchyEvent he) {
                if (!k.isVisible()){
                    
                    t.setVisible(true);
                }
            }
        });
    }
}
