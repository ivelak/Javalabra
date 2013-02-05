
package maalimanvahvimmat.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Listaa käyttäjän harjoituskerrat
 * 
 */
public class Harjoituskertarekisteri {
    
    private Kayttaja kayttaja;
    private List<Harjoituskerta> harjoituskerrat;
    
    public Harjoituskertarekisteri(Kayttaja kayttaja) {
        this.kayttaja=kayttaja;
        this.harjoituskerrat = new ArrayList<Harjoituskerta>();
    }
    
    public void lisaaHarjoituskertaRekisteriin(Harjoituskerta treeni){
        this.harjoituskerrat.add(treeni);        
    }
    
    public void kirjoitaRekisteriTiedostoon(){
        
    }
    
}
