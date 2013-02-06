package maalimanvahvimmat.tekstikali;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import maalimanvahvimmat.model.Harjoituskerta;
import maalimanvahvimmat.model.Kayttaja;

/**
 * Kayttoliittyma-luokka.
 * 
 * Luo tekstikäyttöliittymän jonka kautta käyttäjä pystyy hallitsemaan sovellusta.
 * @author rantapel
 */

public class Kayttoliittyma {

    private Scanner lukija;
    private Kayttajarekisteri rekisteri;
    private Kayttaja kirjautunut;

    private Kayttoliittyma() {
    }

    public Kayttoliittyma(Kayttajarekisteri rekisteri) {
        this.kirjautunut = null;
        this.rekisteri = rekisteri;
        this.lukija = new Scanner(System.in);
    }
    
    /**
     * päävalikko
     * @return 
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
     * Metodi jolla sovellus käynnistetään
     * @throws IOException 
     */

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

    private void vanhanKayttajanKirjautuminen() {
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

    public void lisaaKayttaja() throws IOException {
        String nimi = kysyKayttajatunnusUudeltaKayttajalta();
        String salasana = kysySalasanaUudeltaKayttajalta();
        Kayttaja uusiKayttaja = new Kayttaja(nimi, salasana);

        rekisteri.lisaaKayttaja(uusiKayttaja);
        rekisteri.luoKayttajatiedosto(uusiKayttaja);
        rekisteri.kirjoitaKayttajatRekisteritiedostoon();
    }

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

    private int KirjautuneenToiminnot() {
        System.out.println("1. Lisää harjoitus");
        System.out.println("2. Tarkastele vanhoja harjoituksia");
        System.out.println("10. Kirjaudu ulos");
        System.out.println("> ");
        int valinta = lukija.nextInt();
        lukija.nextLine();
        return valinta;
    }
    
    /**
     * Valikko kirjautunutta käyttäjää varten.
     */

    private void kirjautuneenValikko() {
        while (true) {
            int valinta = KirjautuneenToiminnot();

            if (valinta == 1) {
                lisaaHarjoitus();
            } else if (valinta == 2) {
            }

            if (valinta == 10) {
                break;
            }
        }
    }

    private void lisaaHarjoitus() {
        System.out.println("Aseta päivämäärä");
        System.out.println("Vuosi: ");
        int vuosi = lukija.nextInt()-1900;
        lukija.nextLine();
        System.out.println("Kuukausi: ");
        int kk = lukija.nextInt()-1;
        lukija.nextLine();
        System.out.println("Päivä: ");
        int pva = lukija.nextInt();
        lukija.nextLine();
        
        Date pvm = new Date(vuosi,kk,pva);
        Harjoituskerta treeni = new Harjoituskerta(pvm);
        System.out.println("");
        System.out.println("Harjoitus: "+treeni.getPvm());
        System.out.println("Lisää liikkeet");
        lisaaLiikkeet(treeni);
        
    }

    private void lisaaLiikkeet(Harjoituskerta treeni) {
        System.out.println("");
    }
}
