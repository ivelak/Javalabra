package maalimanvahvimmat.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Luokka liikkeitä varten
 *
 * @author rantapel
 */
public class Liike {

    private String nimi;
    private int sarjat;
    private int[] toistot;
    private int[] painot;

    public Liike(String nimi, int sarjat) {
        this.sarjat = sarjat;
        this.nimi = nimi;

    }

    public void setToistotJaPainot(int[] toistot, int[] painot) {
        this.toistot = toistot;
        this.painot = painot;
    }

    public String getNimi() {
        return this.nimi;
    }
    public int[] getToistot() {
        return this.toistot;
    }
    public int[] getPainot() {
        return this.painot;
    }

    public void listaaLiike() {
        System.out.println();
        System.out.println(getNimi() + ":");
        System.out.println("");
        for (int i = 0; i < sarjat; i++) {
            System.out.print(toistot[i] + " x ");
            System.out.println(painot[i] + " kg");
        }
    }
}
