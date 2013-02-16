package maalimanvahvimmat;

import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import maalimanvahvimmat.kali.GraafinenKayttoliittyma;
import maalimanvahvimmat.kali.Kirjautuminen;
import maalimanvahvimmat.kali.Treenit;
import maalimanvahvimmat.tietomalli.Kayttaja;
import maalimanvahvimmat.tietomalli.Kayttajarekisteri;
import maalimanvahvimmat.tekstikali.TekstiKayttoliittyma;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        /**
         * Main-luokka käynnistää ohjelman. Alun ehtolause tarkistaa löytyykö kayttajarekisteri.txt-tiedostoa. 
         * Mikäli ei löydy, kutsutaan luokkan Kayttajarekisteri metodia alusta(File Kayttajat).
         */

        File kayttajat = new File("kayttajarekisteri.txt");
        if (!kayttajat.exists()) {
            Kayttajarekisteri.alusta(kayttajat);
        }

        
                
        Kayttajarekisteri rekisteri = new Kayttajarekisteri(kayttajat);
        
        
        Kayttoliittyma gkayttis = new GraafinenKayttoliittyma(rekisteri);
        Kayttoliittyma kayttis = new TekstiKayttoliittyma(rekisteri);
            
        try {
            gkayttis.kaynnista();
           //kayttis.kaynnista();
    
            
      } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

