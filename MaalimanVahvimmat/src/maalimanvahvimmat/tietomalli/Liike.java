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
    
    @Override
    public String toString(){
        String liikedata = this.nimi+": ";
        for (int i = 0; i < toistot.size(); i++) {
            liikedata+=""+toistot.get(i)+"x"+painot.get(i)+"kg ";
        }
        return liikedata;
    }

    public String getNimi() {
        return this.nimi;
    }
    public void lisaaToistoJaPaino(int toisto, int paino){
        toistot.add(toisto);
        painot.add(paino);
    }
    public ArrayList<Integer> getToistot(){
        return this.toistot;
    }
    public ArrayList<Integer> getPainot(){
        return this.painot;
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
        kirjoittaja.write(getNimi());
        kirjoittaja.write("\r\n");
        for (int i = 0; i < toistot.size(); i++) {
            String a = ""+toistot.get(i);
            kirjoittaja.write(a);
            kirjoittaja.write(" ");
        }
        kirjoittaja.write("\r\n");
        for (int i = 0; i < painot.size(); i++) {
            String a = ""+painot.get(i);
            kirjoittaja.write(a);
            kirjoittaja.write(" ");
        }
        kirjoittaja.write("\r\n");
    }

    public Liike (Scanner lukija) {
        Pattern hahmo = Pattern.compile("\\d+| ");
        
        this.nimi = lukija.next();
        lukija.nextLine();
        while (lukija.hasNext(hahmo)) {
            int a = Integer.parseInt(lukija.next());
            toistot.add(a);
            lukija.skip(" ");
        }
        lukija.nextLine();
        while (lukija.hasNext(hahmo)) {
            painot.add(lukija.nextInt());
            lukija.skip(" ");
        }
        if (lukija.hasNextLine()){
        lukija.nextLine();
        }
    }
}
