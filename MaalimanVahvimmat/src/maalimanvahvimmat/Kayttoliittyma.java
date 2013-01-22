package maalimanvahvimmat;

import java.util.Scanner;

public class Kayttoliittyma {

    private Scanner lukija;

    public Kayttoliittyma() {
        this.lukija = new Scanner(System.in);
    }

    public void kaynnista() {
        System.out.println("Tervetuloa!");
        System.out.println("Valitse seuraavista:");
        System.out.println("1. Kirjaudu sisään");
        System.out.println("2. Luo tili");
        System.out.print("> ");
        int valinta = lukija.nextInt();
        if (valinta == 2) {
            uudenKayttajanLisays();
        } else if (valinta == 1){
            vanhanKayttajanKirjautuminen();
        } else {
            return;
        }

    }

    private void uudenKayttajanLisays() {
        
        
    }

    private void vanhanKayttajanKirjautuminen() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
