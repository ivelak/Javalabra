package maalimanvahvimmat.tekstikali;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import maalimanvahvimmat.model.Kayttaja;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kayttajarekisteri {

    /**
     * alusta-metodi luo uuden kayttajarekisteri.txt-tiedoston.
     *
     * @param alustettava
     * @throws IOException
     */
    public static void alusta(File alustettava) throws IOException {

        FileWriter kirjoittaja = new FileWriter(alustettava);
        kirjoittaja.write("");
        kirjoittaja.close();
        // luo tyhjän kayttajarekisteri.txt -tiedoston.
    }
    private ArrayList<Kayttaja> rekisteri;
    private File rekisteritiedosto;

    public Kayttajarekisteri() {
        this.rekisteri = new ArrayList<Kayttaja>();

    }

    public Kayttajarekisteri(File tiedosto) throws FileNotFoundException {
        this.rekisteri = new ArrayList<Kayttaja>();
        this.rekisteritiedosto = tiedosto;
        lueRekisterista();
    }

    public void lisaaKayttaja(String nimi, String salasana) {
        Kayttaja kayttaja = new Kayttaja(nimi, salasana);
        this.rekisteri.add(kayttaja);
    }

    public void lisaaKayttaja(Kayttaja kayttaja) {
        this.rekisteri.add(kayttaja);
    }

    public void poistaKayttaja(Kayttaja kayttaja) {
        if (this.rekisteri.contains(kayttaja)) {
            this.rekisteri.remove(kayttaja);
        }
    }

    public boolean onkoKayttajaa(String kayttaja) {
        for (Kayttaja kayttaja1 : rekisteri) {
            if (kayttaja1.getNimi().equals(kayttaja)) {
                return true;
            }
        }
        return false;
    }

    public Kayttaja getKayttaja(String tunnus) {
        for (Kayttaja kayttaja : rekisteri) {
            if (kayttaja.getNimi().equals(tunnus)) {
                return kayttaja;
            }
        }
        return null;
    }

    /**
     * tarkastaSalasana-metodi tarkistaa täsmääkö annettu salasana kyseiseen
     * käyttäjään.
     *
     * @param kayttaja
     * @param salasana
     * @return
     */
    public boolean tarkistaSalasana(Kayttaja kayttaja, String salasana) {
        if (kayttaja.getSalasana().equals(salasana)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (rekisteri.isEmpty()) {
            return "EI KÄYTTÄJIÄ!!!";
        }
        String tulos = "";

        for (Kayttaja kayttaja : rekisteri) {
            tulos += ", " + kayttaja.getNimi();
        }
        return tulos.substring(2);
    }

    /**
     * luoKayttajatiedosto-metodi luo uuden tekstitiedoston uudelle
     * käyttäjätunnukselle. Tekstitiedostosta luetaan käyttäjätiedot ohjelmaa
     * avattaessa.
     *
     * @param kayttaja
     * @throws IOException
     */
    public void luoKayttajatiedosto(Kayttaja kayttaja) throws IOException {

        File kayttajatiedosto = new File(kayttaja.getNimi() + ".txt");
        FileWriter kirjoittaja = new FileWriter(kayttajatiedosto);
        kirjoittaja.write(kayttaja.getNimi() + "\n");
        kirjoittaja.write(kayttaja.getSalasana() + "\n");
        kirjoittaja.write(kayttaja.getIka() + "\n");
        kirjoittaja.write(kayttaja.getPaino() + "\n");
        kirjoittaja.write(kayttaja.getPituus() + "\n");
        kirjoittaja.close();
    }

    /**
     * kirjoitaKayttajatRekisteritiedostoon -metodi 
     * @param kayttaja
     * @throws IOException
     */
    public void kirjoitaKayttajatRekisteritiedostoon() throws IOException {

        FileWriter kirjoittaja = new FileWriter(rekisteritiedosto);

        for (Kayttaja lisattava : rekisteri) {
            kirjoittaja.write(lisattava.getNimi() + "\n");
        }

        kirjoittaja.close();
    }

    private void lueRekisterista() throws FileNotFoundException {
        Scanner lukija = new Scanner(rekisteritiedosto);

        while (lukija.hasNextLine()) {
            String kayttajanNimi = lukija.nextLine();
            lueKayttajatiedosto(kayttajanNimi);
        }
        lukija.close();
    }

    private void lueKayttajatiedosto(String kayttajaNimi) throws FileNotFoundException {
        File kayttajaTiedosto = new File(kayttajaNimi + ".txt");
        Scanner lukija = new Scanner(kayttajaTiedosto);
        String nimi = lukija.nextLine();
        String salasana = lukija.nextLine();
        int ika = Integer.parseInt(lukija.nextLine());
        int paino = Integer.parseInt(lukija.nextLine());
        int pituus = Integer.parseInt(lukija.nextLine());
        lukija.close();

        Kayttaja palautettava = new Kayttaja(nimi, salasana);

        palautettava.setIka(ika);
        palautettava.setPaino(paino);
        palautettava.setPituus(pituus);

        lisaaKayttaja(palautettava);
    }
}
