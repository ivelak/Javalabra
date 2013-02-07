package maalimanvahvimmat.tietomalli;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Luokka liikkeitä varten
 *
 * @author rantapel
 */
public class Liike {

    private String nimi;
    private ArrayList<Integer> toistot = new ArrayList<Integer>();
    private ArrayList<Integer> painot = new ArrayList<Integer>();

    public Liike(String nimi) {

        this.nimi = nimi;

    }

    public String getNimi() {
        return this.nimi;
    }
    public void lisaaToistoJaPaino(int toisto, int paino){
        toistot.add(toisto);
        painot.add(paino);
    }

    /*public void listaaLiike() {
     System.out.println();
     System.out.println(getNimi() + ":");
     System.out.println("");
     for (int i = 0; i < sarjat; i++) {
     System.out.print(toistot[i] + " x ");
     System.out.println(painot[i] + " kg");
     }
     }*/
    void kirjoitaTiedostoon(FileWriter kirjoittaja) throws IOException {
        kirjoittaja.write(getNimi() + "\n");
        for (int i = 0; i < toistot.size(); i++) {
            kirjoittaja.write(toistot.get(i));
            kirjoittaja.write(" ");
        }
        kirjoittaja.write("\n");
        for (int i = 0; i < painot.size(); i++) {
            kirjoittaja.write(painot.get(i));
            kirjoittaja.write(" ");
        }
        kirjoittaja.write("\n");
    }

    public Liike (Scanner lukija) {
        Pattern hahmo = Pattern.compile("\\d+| ");
        
        this.nimi = lukija.nextLine();
        
        while (lukija.hasNext(hahmo)) {
            toistot.add(lukija.nextInt());
            lukija.next(" ");
        }
        lukija.nextLine();
        while (lukija.hasNext(hahmo)) {
            painot.add(lukija.nextInt());
            lukija.next(" ");
        }
        lukija.nextLine();
    }
}
