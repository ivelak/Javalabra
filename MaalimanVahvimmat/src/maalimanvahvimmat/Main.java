package maalimanvahvimmat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import maalimanvahvimmat.tietomalli.Kayttaja;
import maalimanvahvimmat.tietomalli.Kayttajarekisteri;
import maalimanvahvimmat.tekstikali.Kayttoliittyma;

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

        Kayttoliittyma kayttis = new Kayttoliittyma(rekisteri);
        kayttis.kaynnista();
        
        
    }
}

