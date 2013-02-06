package maalimanvahvimmat.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Listaa käyttäjän harjoituskerrat
 *
 */
public class Harjoituskertarekisteri {

    public static void alusta(File alustettava) throws IOException {

        FileWriter kirjoittaja = new FileWriter(alustettava);
        kirjoittaja.write("");
        kirjoittaja.close();
    }
    private Kayttaja kayttaja;
    private List<Harjoituskerta> harjoituskerrat;
    private File rekisteritiedosto;

    public Harjoituskertarekisteri(Kayttaja kayttaja, File rekisteritiedosto) {
        this.kayttaja = kayttaja;
        this.harjoituskerrat = new ArrayList<Harjoituskerta>();
        this.rekisteritiedosto = rekisteritiedosto;
    }

    public void lisaaHarjoituskertaRekisteriin(Harjoituskerta treeni) {
        this.harjoituskerrat.add(treeni);
    }

    public void kirjoitaRekisteriTiedostoon() throws IOException {

        FileWriter kirjoittaja = new FileWriter(rekisteritiedosto);

        for (Harjoituskerta harjoituskerta : harjoituskerrat) {
            kirjoittaja.write(harjoituskerta.getPvm() + "-" + this.kayttaja.getNimi() + "\n");
        }

        kirjoittaja.close();
    }
    
    
}
