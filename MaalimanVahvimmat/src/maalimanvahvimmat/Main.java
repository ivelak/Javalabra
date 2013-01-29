package maalimanvahvimmat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import maalimanvahvimmat.tekstikali.Kayttajarekisteri;
import maalimanvahvimmat.tekstikali.Kayttoliittyma;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

        File kayttajat = new File("kayttajarekisteri.tmp");
        if (!kayttajat.exists()) {
            Kayttajarekisteri.alusta(kayttajat);
        }

        
        Kayttajarekisteri rekisteri = new Kayttajarekisteri(kayttajat);

        Kayttoliittyma kayttis = new Kayttoliittyma(rekisteri);
        kayttis.kaynnista();
    }
}
