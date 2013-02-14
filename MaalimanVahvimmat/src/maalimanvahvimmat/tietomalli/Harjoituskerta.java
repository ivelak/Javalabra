/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maalimanvahvimmat.tietomalli;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
        while (lukija.hasNextLine()) {
            Liike liike = new Liike(lukija);
            liikkeet.add(liike);

        }
    }

    public String getPvm() {
        return this.pvm;
    }

    public void lisaaLiike(Liike liike) {
        liikkeet.add(liike);
    }

    public void listaaLiikkeet() {
        for (Liike liike : liikkeet) {
            System.out.println(liike);
        }
    }

    public void tallennaHarjoituskertatiedosto(Kayttaja kayttaja) throws IOException {
        File treenitiedosto = new File(getPvm() + "-" + kayttaja.getNimi() + ".txt");
        FileWriter kirjoittaja = new FileWriter(treenitiedosto);
        
        for (Liike liike : liikkeet) {
            liike.kirjoitaTiedostoon(kirjoittaja);
        }
            
            /*kirjoittaja.write(liike.getNimi() + "\n");
        for (int i = 0; i < liike.getToistot().size(); i++) {
            String a = ""+liike.getToistot().get(i);
            kirjoittaja.write(a);
            kirjoittaja.write(" ");
        }
        kirjoittaja.write("\n");
        for (int i = 0; i < liike.getPainot().size(); i++) {
            String a = ""+liike.getPainot().get(i);
            kirjoittaja.write(a);
            kirjoittaja.write(" ");
        }
        kirjoittaja.write("\n");
    }*/
        kirjoittaja.close();

           
        
    }

    public static void alusta(File alustettava) throws IOException {
        
        FileWriter kirjoittaja = new FileWriter(alustettava);
        kirjoittaja.write("");
        kirjoittaja.close();
    }
}
