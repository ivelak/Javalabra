package maalimanvahvimmat.tekstikali;

import maalimanvahvimmat.tietomalli.Kayttajarekisteri;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import maalimanvahvimmat.Kayttoliittyma;
import maalimanvahvimmat.tietomalli.Harjoituskerta;
import maalimanvahvimmat.tietomalli.Harjoituskertarekisteri;
import maalimanvahvimmat.tietomalli.Kayttaja;
import maalimanvahvimmat.tietomalli.Liike;

/**
 * TekstiKayttoliittyma-luokka.
 *
 * Luo tekstikäyttöliittymän jonka kautta käyttäjä pystyy hallitsemaan
 * sovellusta tekstipohjalla. Toteuttaa Kayttoliittyma-rajapinnan.
 *
 */
public class TekstiKayttoliittyma implements Kayttoliittyma {

    private Scanner lukija;
    private Kayttajarekisteri rekisteri;
    private Kayttaja kirjautunut;
    private Harjoituskertarekisteri kirjautuneenHarjoituskertarekisteri;

    private TekstiKayttoliittyma() {
    }

    public TekstiKayttoliittyma(Kayttajarekisteri rekisteri) {
        this.kirjautunut = null;
        this.rekisteri = rekisteri;
        this.lukija = new Scanner(System.in);
        this.kirjautuneenHarjoituskertarekisteri = null;
    }

    /**
     * päävalikko.
     *
     */
    private int valitseToiminto() {
        System.out.println("Valitse seuraavista:");
        System.out.println("1. Kirjaudu sisään");
        System.out.println("2. Luo tili");
        System.out.println("3. Listaa käyttäjät"); // poistuu julkisesta käytöstä ohjelman valmistuessa
        System.out.println("10. Poistu");
        System.out.print("> ");
        int valinta = lukija.nextInt();
        lukija.nextLine();
        return valinta;
    }

    /**
     * Metodi jolla päävalikko käynnistetään.
     *
     */
    @Override
    public void kaynnista() throws IOException {
        System.out.println("Tervetuloa!");
        while (true) {
            int valinta = valitseToiminto();
            if (valinta == 2) {
                lisaaKayttaja();
            } else if (valinta == 1) {
                vanhanKayttajanKirjautuminen();
                if (this.kirjautunut != null) {
                    kirjautuneenValikko();
                }
            } else if (valinta == 3) {
                listaaKayttajat();
            } else if (valinta == 10) {
                break;
            }
        }
    }

    /**
     *
     * Tarkistaa kayttajatunnuksen ja salasanan sisäänkirjautumista varten.
     *
     */
    private void vanhanKayttajanKirjautuminen() throws FileNotFoundException {
        while (true) {
            System.out.println("Anna käyttäjätunnus ja salasana");
            System.out.println("(Palaa päävalikkoon valitsemalla 10");
            System.out.println("");
            System.out.println("käyttäjätunnus:");
            System.out.print("> ");
            String kayttajatunnus = lukija.nextLine();
            if (kayttajatunnus.equals("10")) {
                break;
            }

            System.out.println("salasana:");
            System.out.print("> ");
            String salasana = lukija.nextLine();
            if (rekisteri.onkoKayttajaa(kayttajatunnus)) {
                Kayttaja apuKayttaja = rekisteri.getKayttaja(kayttajatunnus);
                if (rekisteri.tarkistaSalasana(apuKayttaja, salasana)) {
                    this.kirjautunut = rekisteri.getKayttaja(kayttajatunnus);
                    this.kirjautuneenHarjoituskertarekisteri = new Harjoituskertarekisteri(this.kirjautunut, new File(this.kirjautunut.getNimi() + "-harjoitukset.txt"));
                    System.out.println("");
                    System.out.println("Sisäänkirjautuminen onnistui!");
                    System.out.println("Olet kirjautunut sisään käyttäjätunnuksella " + this.kirjautunut.getNimi());
                    System.out.println("");
                    break;
                } else {
                    System.out.println("käyttäjätunnus tai salasana ei täsmännyt!");
                    System.out.println("");
                }
            }
        }
    }
    /**
     * Kutsuu kysyKayttajatunnusUudeltaKayttajalta()- sekä kysySalasanaUudeltaKayttajalta() -metodeita ja luo uuden Kayttaja-olion niiden 
     * palauttamien merkkijonojen mukaan. Lisää Kayttajan Kayttajarekisteriin.
     */
    public void lisaaKayttaja() throws IOException {
        String nimi = kysyKayttajatunnusUudeltaKayttajalta();
        String salasana = kysySalasanaUudeltaKayttajalta();
        Kayttaja uusiKayttaja = new Kayttaja(nimi, salasana);


        rekisteri.lisaaKayttaja(uusiKayttaja);

    }
    
    /**
     * Kysyy salasanaa uudelta käyttäjältä ja palauttaa sen mikäli ehdot toteutuvat.
     */
    private String kysySalasanaUudeltaKayttajalta() {
        String salasana;
        while (true) {
            System.out.println("Anna salasana: ");
            System.out.print("> ");
            salasana = lukija.nextLine();
            System.out.println("");
            System.out.println("Vahvista salasana: ");
            System.out.print("> ");
            String salasanaVarmistus = lukija.nextLine();

            if (salasana.equals(salasanaVarmistus)) {
                System.out.println("Onnistui!");
                break;
            } else {
                System.out.println("Antamasi salasanat eivät täsmänneet!");
            }
        }
        return salasana;
    }
    /**
     * Kysyy käyttäjätunnusta uudelta käyttäjältä ja palauttaa sen merkkijonona mikäli ehdot toteutuvat.
     */
    private String kysyKayttajatunnusUudeltaKayttajalta() {
        String nimi;
        while (true) {
            System.out.println("Anna uusi käyttäjätunnus: ");
            System.out.print("> ");
            nimi = lukija.nextLine();

            if (nimi.length() < 3) {
                System.out.println("Antamasi käyttäjätunnus on liian lyhyt.");
            } else if (rekisteri.onkoKayttajaa(nimi)) {
                System.out.println("Antamasi käyttäjätunnus on jo käytössä.");
            } else {
                break;
            }
        }
        return nimi;
    }
    
    private void listaaKayttajat() {
        System.out.println(rekisteri);
    }
    /**
     * Antaa ohjeet kirjautuneelle.
     */
    private int KirjautuneenToiminnot() {
        System.out.println("1. Lisää harjoitus");
        System.out.println("2. Tarkastele vanhoja harjoituksia");
        System.out.println("10. Kirjaudu ulos");
        System.out.print("> ");
        int valinta = lukija.nextInt();
        lukija.nextLine();
        return valinta;
    }

    /**
     * Valikko kirjautunutta käyttäjää varten.
     */
    private void kirjautuneenValikko() throws IOException {
        while (true) {
            int valinta = KirjautuneenToiminnot();

            if (valinta == 1) {
                lisaaHarjoitus();
            } else if (valinta == 2) {
                vanhatHarjoitukset();

            }

            if (valinta == 10) {
                break;
            }
        }
    }
    /**
     * Kysyy tarvittavat tiedot harjoituskertaa varten ja luo Harjoituskerta-olion.
     * kutsuu liikevalikko()-metodia.
     */
    private void lisaaHarjoitus() throws IOException {
        System.out.println("Aseta päivämäärä (muotoa pp.kk.vvvv)");
        System.out.print("> ");

        String pvm = lukija.nextLine();
        Harjoituskerta treeni = new Harjoituskerta(pvm);

        System.out.println("");
        System.out.println("Harjoitus: " + treeni.getPvm());
        liikevalikko(treeni);
        kirjautuneenHarjoituskertarekisteri.lisaaHarjoituskertaRekisteriin(treeni);




    }
    /**
     * Valikko yksittäisen harjoituksen hallintaan.
     */
    private void liikevalikko(Harjoituskerta treeni) throws IOException {
        while (true) {

            System.out.println("");
            System.out.println("1. Lisää liikke");
            System.out.println("2. Tulosta liikkeet");
            System.out.println("10. Lopeta");
            System.out.print(treeni.getPvm() + "> ");
            int valinta = lukija.nextInt();
            lukija.nextLine();
            if (valinta == 10) {
                treeni.tallennaHarjoituskertatiedosto(kirjautunut);
                break;

            } else if (valinta == 2) {
                treeni.listaaLiikkeet();
            } else if (valinta == 1) {
                treeni.lisaaLiike(lisaaLiike());

            }
        }
    }
    /**
     * Kysyy liikkeen tiedot ja palauttaa luomansa Liike-olion.
     */
    private Liike lisaaLiike() {

        System.out.println("Anna liikkeen nimi: ");
        String nimi = lukija.nextLine();
        Liike liike = new Liike(nimi);

        while (true) {
            System.out.println("Lisää toistot ja painot, tyhjä rivi lopettaa");
            System.out.println("Toistomäärä: ");
            int toisto;
            int paino;

            String rivi = lukija.nextLine();
            try {
                toisto = Integer.parseInt(rivi);
            } catch (NumberFormatException e) {
                break;
            }



            System.out.println("Paino: ");
            rivi = lukija.nextLine();
            try {
                paino = Integer.parseInt(rivi);
            } catch (NumberFormatException e) {
                break;
            }
            liike.lisaaToistoJaPaino(toisto, paino);

        }
        return liike;
    }
    /**
     * metodi vanhojen harjoitusten tarkastelua varten.
     */
    private void vanhatHarjoitukset() {
        kirjautuneenHarjoituskertarekisteri.listaaHarjoituskerrat();
        System.out.println("");
        System.out.println("Valitse harjoitus jota haluat tarkastella (pp.kk.vvvv)");
        System.out.print("> ");
        String valittuHarjoitus = lukija.nextLine();
        Harjoituskerta treeni = kirjautuneenHarjoituskertarekisteri.getHarjoituskerta(valittuHarjoitus);
        if (treeni != null) {
            System.out.print(treeni.listaaLiikkeet());

        } else {
            System.out.println("Harjoitusta ei löytynyt");
        }
    }
}
