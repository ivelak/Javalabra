
package maalimanvahvimmat.kali;

import java.io.File;
import java.io.FileNotFoundException;
import maalimanvahvimmat.Kayttoliittyma;
import maalimanvahvimmat.tietomalli.Harjoituskertarekisteri;
import maalimanvahvimmat.tietomalli.Kayttaja;
import maalimanvahvimmat.tietomalli.Kayttajarekisteri;

/**
 * GraafinenKayttoliittyma-luokka.
 *
 * Luo graafisen käyttöliittymän jonka kautta käyttäjä pystyy hallitsemaan
 * sovellusta graafisella pohjalla. Toteuttaa Kayttoliittyma-rajapinnan.
 *
 */
public class GraafinenKayttoliittyma implements Kayttoliittyma {  
    private Kayttajarekisteri rekisteri;
    private Kirjautuminen k;
    private Treenit t;
    private Kayttaja kayttaja;

    public GraafinenKayttoliittyma(Kayttajarekisteri rekisteri) {
        
        this.rekisteri=rekisteri;
        this.k=new Kirjautuminen(rekisteri, this);
        
    }
    public void asetaKayttaja(Kayttaja kayttaja) throws FileNotFoundException {
        this.kayttaja = kayttaja;
        this.t=new Treenit(new Harjoituskertarekisteri(kayttaja, new File(kayttaja.getNimi() + "-harjoitukset.txt")));
        k.setVisible(false);
        t.setVisible(true);
    }
   
    @Override
    public void kaynnista(){
        k.setVisible(true);
        
    }
}
