
package maalimanvahvimmat.tiedostoonTallennin;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Tallennin {
    
    private FileOutputStream tiedosto;
    private ObjectOutputStream oos;
            
    public Tallennin() throws FileNotFoundException, IOException{
        this.tiedosto = new FileOutputStream("kayttajarekisteri.tmp");
        this.oos = new ObjectOutputStream(this.tiedosto);
    }
    
    public void tallenna(Object tallennettava) throws IOException{
        this.oos.writeObject(tallennettava);
        this.oos.close();
    }
            
}
