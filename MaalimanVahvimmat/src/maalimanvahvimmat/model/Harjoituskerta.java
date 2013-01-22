/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maalimanvahvimmat.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rantapel
 */
public class Harjoituskerta {

    private Date date;
    private List<Liike> liikkeet;

    public Harjoituskerta(Date date) {
        this.date = date;
        this.liikkeet = new ArrayList<Liike>();
    }

    public Harjoituskerta() {
        this.date = new Date();
    }

    public void lisaaLiike(Liike liike) {
        liikkeet.add(liike);
    }

    public void listaaLiikkeet() {
        for (Liike liike : liikkeet) {
            System.out.println(liike);
        }
    }
}
