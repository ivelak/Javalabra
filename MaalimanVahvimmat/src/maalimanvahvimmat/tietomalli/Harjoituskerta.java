
package maalimanvahvimmat.tietomalli;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Päiväkirjaan lisättävä olio joka sisältää tiedon suorituspäivästä sekä listan
 * liikkeistä joita käyttäjä on kyseisenä päivänä suorittanut.
 *
 * @author rantapel
 */
public class Harjoituskerta {

    private String pvm;
    private List<Liike> liikkeet;

    public Harjoituskerta(String pvm) {
        this.pvm = pvm;
        this.liikkeet = new ArrayList<Liike>();


    }

    public Harjoituskerta(String pvm, Scanner lukija) {
        this.pvm = pvm;
        this.liikkeet = new ArrayList<Liike>();
        while (lukija.hasNextLine()) {
            Liike liike = new Liike(lukija);
            liikkeet.add(liike);

        }
    }

    public String getPvm() {
        return this.pvm;
    }
    /*
     * lisää Liike-olion Harjoituskertaan
     */
    public void lisaaLiike(Liike liike) {
        liikkeet.add(liike);
    }
    /*
     * Palauttaa merkkijonona Harjoituskertaan lisätyt Liikkeet
     */
    public String listaaLiikkeet() {
        String tulos = "";
        for (Liike liike : liikkeet) {
            tulos+=liike.toString()+"\n";
        }
        return tulos;
    }
    
    /*
     * Kirjoittaa .txt-tiedoston harjoituskerrasta nimellä: päivämäärä-käyttäjätunnus.txt (esim. 01.01.2013-testaaja.txt).
     * Kutsuu kunkin Liike-olion omaa kirjoitaTiedostoon-metodia.
     */
    public void tallennaHarjoituskertatiedosto(Kayttaja kayttaja) throws IOException {
        File treenitiedosto = new File(getPvm() + "-" + kayttaja.getNimi() + ".txt");
        FileWriter kirjoittaja = new FileWriter(treenitiedosto);
        
        for (Liike liike : liikkeet) {
            liike.kirjoitaTiedostoon(kirjoittaja);
        }
            
           
        kirjoittaja.close();

           
        
    }
    
    /*
     * Luo harjoituskertatiedoston
     */

    public static void alusta(File alustettava) throws IOException {
        
        FileWriter kirjoittaja = new FileWriter(alustettava);
        kirjoittaja.write("");
        kirjoittaja.close();
    }

    
}
