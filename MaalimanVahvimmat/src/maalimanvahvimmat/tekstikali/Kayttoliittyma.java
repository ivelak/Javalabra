package maalimanvahvimmat.tekstikali;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import maalimanvahvimmat.model.Kayttaja;
import maalimanvahvimmat.tiedostoonTallennin.Lataaja;
import maalimanvahvimmat.tiedostoonTallennin.Tallennin;

public class Kayttoliittyma {
    
    private Scanner lukija;
    private Kayttajarekisteri rekisteri;
    
    private Kayttoliittyma() {
    }
    
    public Kayttoliittyma(Kayttajarekisteri rekisteri) {
        this.rekisteri = rekisteri;
        this.lukija = new Scanner(System.in);
    }
    
    private int valitseToiminto() {
        System.out.println("Valitse seuraavista:");
        System.out.println("1. Kirjaudu sisään");
        System.out.println("2. Luo tili");
        System.out.println("3. Listaa käyttäjät");
        System.out.println("10. Poistu");
        System.out.print("> ");
        int valinta = lukija.nextInt();
        lukija.nextLine();
        return valinta;
    }
    
    public void kaynnista() throws IOException {
        System.out.println("Tervetuloa!");
        while (true) {
            int valinta = valitseToiminto();
            if (valinta == 2) {
                lisaaKayttaja();
            } else if (valinta == 1) {
                vanhanKayttajanKirjautuminen();
            } else if (valinta == 3) {
                listaaKayttajat();
            } else if (valinta == 10) {
                break;
            }
        }
    }
    
    private void vanhanKayttajanKirjautuminen() {
        System.out.println("käyttäjätunnus:");
        System.out.print("> ");
        System.out.println("salasana:");
        System.out.print("> ");
    }
    
    public void lisaaKayttaja() throws IOException {
        String nimi = kysyKayttajatunnus();
        String salasana = kysySalasana();
        Kayttaja uusiKayttaja = new Kayttaja(nimi, salasana);
        
        rekisteri.lisaaKayttaja(uusiKayttaja);
        rekisteri.tallennaKayttaja(uusiKayttaja);
        rekisteri.lisaaKayttajaKayttajalistatiedostoon(uusiKayttaja);      
    }
    
    private String kysySalasana() {
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
    
    private String kysyKayttajatunnus() {
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
}
