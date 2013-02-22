package maalimanvahvimmat.tietomalli;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import maalimanvahvimmat.Loki;

/**
 * Luokka liikkeitä varten.
 * Tallentaa liikkeen nimen, sekä ks. liikkeen toisto sekä painomäärät listoihin.
 *
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
        Loki.d("@ Liike.toString"+toistot.size()+","+painot.size());
        String liikedata = this.nimi+": ";
        for (int i = 0; i < toistot.size(); i++) {
            liikedata+=""+toistot.get(i)+"x"+painot.get(i)+"kg ";
        }
        return liikedata;
    }

    public String getNimi() {
        return this.nimi;
    }
    /*
     * Lisää parametrinä annetut toisto- sekä painomäärän listoihin.
     */
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

    /*
     * Kirjoittaa Liike-olion harjoituskertatiedostoon. Tiedosto on .txt-tiedosto, johon metodi kirjoittaa järjestyksessä
     * liikkeen nimi, toistot, painot kaikki kolme omille riveilleen.
     */
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
   
        this.nimi = lukija.nextLine();
        
        this.toistot = lueLuvut(lukija.nextLine());
        this.painot = lueLuvut(lukija.nextLine());
        assert (toistot.size()==painot.size());
        
    }
    /*
     * palauttaa annetun merkkijonon luvut.
     */
    private static ArrayList<Integer> lueLuvut(String rivi){
        
        ArrayList<Integer> tulos = new ArrayList<Integer>();
        Scanner lukija = new Scanner(rivi);
        
        while (lukija.hasNext()){
            int luku = lukija.nextInt();
            tulos.add(luku);
        }
        return tulos;
    }
}
