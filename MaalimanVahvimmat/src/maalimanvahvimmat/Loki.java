
package maalimanvahvimmat;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *Tämä luokka oli käytössä ohjelman kirjoituksen aikana vianmääritystarkoituksessa.
 * 
 */
public class Loki {
    public static void d(String rivi){
        System.err.println("DEBUG: "+rivi);
    }
}
