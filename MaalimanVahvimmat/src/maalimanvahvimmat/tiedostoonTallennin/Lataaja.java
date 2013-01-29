
package maalimanvahvimmat.tiedostoonTallennin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Lataaja {
    private FileInputStream tiedosto;
    private ObjectInputStream ois;
    
    public Lataaja() throws FileNotFoundException, IOException{
        
        this.tiedosto = new FileInputStream("kayttajarekisteri.tmp");
        this.ois = new ObjectInputStream(tiedosto);
    }
    
    public Object lataa() throws IOException, ClassNotFoundException  {
        
        Object palautettava = (Object) ois.readObject();
        ois.close();
        return palautettava;
    }
    
    
}
