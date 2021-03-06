package maalimanvahvimmat.tietomalli;

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
import maalimanvahvimmat.tietomalli.Kayttaja;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import maalimanvahvimmat.Loki;

/**
 * Luokka pitää muistissaan listan käyttäjistä ja luo kayttajarekisteri.txt
 * tiedoston pohjalta Kayttaja-oliot ohjelman käynnistyessä.
 */
public class Kayttajarekisteri {
    /**
     * luo tyhjän kayttajarekisteri.txt-tiedoston.
     */

    public static void alusta(File alustettava) throws IOException {
        Loki.d("@ Kayttajarekisteri.alusta");

        FileWriter kirjoittaja = new FileWriter(alustettava);
        kirjoittaja.write("");
        kirjoittaja.close();
        
    }
    private ArrayList<Kayttaja> rekisteri;
    private File rekisteritiedosto;

    public Kayttajarekisteri() {

        this.rekisteri = new ArrayList<Kayttaja>();

    }

    public Kayttajarekisteri(File tiedosto) throws FileNotFoundException, IOException {

        this.rekisteri = new ArrayList<Kayttaja>();
        this.rekisteritiedosto = tiedosto;
        lueRekisterista();
    }
    /**
     * lisää Kayttaja-olion ArrayListiin, sekä alustaa käyttäjälle harjoitusrekisteritiedoston
     */
    public void lisaaKayttaja(Kayttaja kayttaja) throws IOException {

        this.rekisteri.add(kayttaja);

        luoKayttajatiedosto(kayttaja);
        File harjoitusrekisteritiedosto = new File(kayttaja.getNimi() + "-harjoitukset.txt");

        if (!harjoitusrekisteritiedosto.exists()) {
            Harjoituskertarekisteri.alusta(harjoitusrekisteritiedosto);
        }
        Harjoituskertarekisteri harjoitusrekisteri = new Harjoituskertarekisteri(kayttaja, harjoitusrekisteritiedosto);

        kirjoitaKayttajatRekisteritiedostoon();
    }
    /**
     * poistaa käyttäjän listasta
     */
    public void poistaKayttaja(Kayttaja kayttaja) {
        if (this.rekisteri.contains(kayttaja)) {
            this.rekisteri.remove(kayttaja);
        }
    }
    /**
     * tarkistaa onko annettua Kayttaja-olioa olemassa
     */
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
     * tarkistaa täsmääkö annettu salasana kyseiseen
     * käyttäjään.
     *
     * 
     */
    public boolean tarkistaSalasana(Kayttaja kayttaja, String salasana) {

        if (kayttaja != null && kayttaja.getSalasana().equals(salasana)) {
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
     * luo uuden tekstitiedoston uudelle
     * käyttäjätunnukselle. Tekstitiedostosta luetaan käyttäjätiedot ohjelmaa
     * avattaessa. 
     */
    private void luoKayttajatiedosto(Kayttaja kayttaja) throws IOException {

        File kayttajatiedosto = new File(kayttaja.getNimi() + ".txt");
        FileWriter kirjoittaja = new FileWriter(kayttajatiedosto);
        kirjoittaja.write(kayttaja.getNimi() + "\r\n");
        kirjoittaja.write(kayttaja.getSalasana() + "\r\n");
        kirjoittaja.write(kayttaja.getIka() + "\r\n");
        kirjoittaja.write(kayttaja.getPaino() + "\r\n");
        kirjoittaja.write(kayttaja.getPituus() + "\r\n");
        kirjoittaja.close();


    }

    /**
     * kirjoittaa Kayttaja-oliot rekisteritiedostoon kayttajarekisteri.txt.
     * kirjoitetaan olioiden nimet tiedostoon omille riveilleen.        
     */
    private void kirjoitaKayttajatRekisteritiedostoon() throws IOException {

        FileWriter kirjoittaja = new FileWriter(rekisteritiedosto);

        for (Kayttaja lisattava : rekisteri) {
            kirjoittaja.write(lisattava.getNimi() + "\r\n");
        }

        kirjoittaja.close();
    }
    /**
     * Lukee rekisteritiedostosta käyttäjien nimet ja kutsuu kullekin lueKayttajatiedosto-metodia
     */
    private void lueRekisterista() throws FileNotFoundException, IOException {
        Scanner lukija = new Scanner(rekisteritiedosto);

        while (lukija.hasNextLine()) {
            String kayttajanNimi = lukija.nextLine();
            lueKayttajatiedosto(kayttajanNimi);
        }
        lukija.close();
    }
    /**
     * lukee annetun merkkijonon mukaisen käyttäjätiedoston ja luo sen mukaisesti uuden Kayttaja-olion.
     */
    private void lueKayttajatiedosto(String kayttajaNimi) throws FileNotFoundException, IOException {
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
