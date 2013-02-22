package maalimanvahvimmat.tietomalli;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.AbstractListModel;

/**
 * Listaa käyttäjän harjoituskerrat. Tuntee käyttäjän sekä kaikki ks. käyttäjän
 * harjoituskerrat. Tallentaa harjoituskerrat yhteen rekistritiedostoon
 * harjoituskerran päivämäärän mukaan. Päivämäärä toimii viitteenä varsinaiseen
 * harjoituskertatiedostoon.
 */
public class Harjoituskertarekisteri extends AbstractListModel {

    public static void alusta(File alustettava) throws IOException {

        FileWriter kirjoittaja = new FileWriter(alustettava);
        kirjoittaja.write("");
        kirjoittaja.close();
    }
    private Kayttaja kayttaja;
    private List<Harjoituskerta> harjoituskerrat;
    private File rekisteritiedosto;

    /*
     * Lisää Harjoituskerta-olion listaan, sekä kutsuu tallennaHarjoituskertatiedosto-metodia.
     */
    public void lisaaHarjoituskertaRekisteriin(Harjoituskerta treeni) throws IOException {

        this.harjoituskerrat.add(treeni);
        kirjoitaRekisteriTiedostoon();
        treeni.tallennaHarjoituskertatiedosto(kayttaja);
    }

    public Harjoituskerta getHarjoituskerta(String pvm) {

        for (Harjoituskerta harjoituskerta : harjoituskerrat) {
            if (harjoituskerta.getPvm().equals(pvm)) {
                return harjoituskerta;
            }
        }
        return null;
    }

    public Kayttaja getKayttaja() {
        return this.kayttaja;
    }
    
    
    /*
     * Kirjoittaa harjoituskertarekisteritiedoston. Muotoa käyttäjä-harjoitukset.txt
     * tiedostossa harjoituskertojen päivämäärät listana.
     */
    public void kirjoitaRekisteriTiedostoon() throws IOException {

        FileWriter kirjoittaja = new FileWriter(rekisteritiedosto);

        for (Harjoituskerta harjoituskerta : harjoituskerrat) {
            kirjoittaja.write(harjoituskerta.getPvm() + "\r\n");
        }

        kirjoittaja.close();
    }
    /*
     * Konstruktori lukee rekisteritiedoston ja luo sen viittaamat harjoituskerrat olioiksi.
     */
    public Harjoituskertarekisteri(Kayttaja kayttaja, File rekisteritiedosto) throws FileNotFoundException {
        this.kayttaja = kayttaja;
        this.harjoituskerrat = new ArrayList<Harjoituskerta>();
        this.rekisteritiedosto = rekisteritiedosto;

        Scanner lukija = new Scanner(this.rekisteritiedosto);

        while (lukija.hasNextLine()) {

            String pvm = lukija.nextLine();

            if (pvm.isEmpty()) {
                break;
            }
            Scanner liikelukija = new Scanner(new File(pvm + "-" + kayttaja.getNimi() + ".txt"));
            Harjoituskerta h = new Harjoituskerta(pvm, liikelukija);

            harjoituskerrat.add(h);
        }

    }
    
    /*
     * tulostaa harjoituskerrat
     */
    public void listaaHarjoituskerrat() {
        if (this.harjoituskerrat.isEmpty()) {
            System.out.println("Ei aikaisempia harjoituksia");
        }
        for (Harjoituskerta harjoituskerta : harjoituskerrat) {
            System.out.println(harjoituskerta.getPvm());
        }
    }

    public List<Harjoituskerta> getRekisteri() {
        return this.harjoituskerrat;
    }

    @Override
    public int getSize() {
        return this.harjoituskerrat.size();
    }

    @Override
    public Object getElementAt(int index) {
        return this.harjoituskerrat.get(index).getPvm();
    }
}
