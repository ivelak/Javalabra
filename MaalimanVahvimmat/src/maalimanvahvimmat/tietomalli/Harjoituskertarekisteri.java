package maalimanvahvimmat.tietomalli;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
        this.rekisteritiedosto = rekisteritiedosto;
        this.harjoituskerrat = new ArrayList<Harjoituskerta>();

    }

    public void lisaaHarjoituskertaRekisteriin(Harjoituskerta treeni) throws IOException {
        
        this.harjoituskerrat.add(treeni);
        kirjoitaRekisteriTiedostoon();
        treeni.tallennaHarjoituskertatiedosto(kayttaja);
    }

    public void kirjoitaRekisteriTiedostoon() throws IOException {

        FileWriter kirjoittaja = new FileWriter(rekisteritiedosto);

        for (Harjoituskerta harjoituskerta : harjoituskerrat) {
            kirjoittaja.write(harjoituskerta.getPvm() + "\n");
        }

        kirjoittaja.close();
    }

    public Harjoituskertarekisteri(Kayttaja kayttaja) throws FileNotFoundException {

        Scanner lukija = new Scanner(kayttaja.getNimi() + "-harjoitukset.txt");

        while (lukija.hasNextLine()) {
            String pvm = lukija.nextLine();
            Scanner liikelukija = new Scanner(pvm + "-" + kayttaja.getNimi() + ".txt");
            Harjoituskerta h = new Harjoituskerta(pvm, liikelukija);

            harjoituskerrat.add(h);
        }

    }
}
