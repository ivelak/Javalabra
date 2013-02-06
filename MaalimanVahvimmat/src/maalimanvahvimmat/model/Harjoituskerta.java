/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maalimanvahvimmat.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Päiväkirjaan lisättävä olio joka sisältää tiedon 
 * suorituspäivästä sekä listan liikkeistä joita käyttäjä on kyseisenä päivänä suorittanut.
 * @author rantapel
 */
public class Harjoituskerta {

    private Date pvm;
    private List<Liike> liikkeet;
   

    public Harjoituskerta(Date pvm) {
        this.pvm = pvm;
        this.liikkeet = new ArrayList<Liike>();
        
        
    }

    public Harjoituskerta() {
        this.pvm = new Date();
        
    }
    
    public Date getPvm(){
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
}
