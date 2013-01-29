package maalimanvahvimmat.tekstikali;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import maalimanvahvimmat.model.Kayttaja;
import java.util.ArrayList;
import java.util.List;

public class Kayttajarekisteri {

    public static void alusta(File kayttajat) throws FileNotFoundException, IOException {
        FileOutputStream stream= new FileOutputStream(kayttajat);
        ObjectOutputStream oos = new ObjectOutputStream(stream);
        oos.writeObject(new ArrayList<Kayttaja>());
        oos.flush();
        oos.close();
        
    }

    private ArrayList<Kayttaja> rekisteri;
    private File tiedosto;

    public Kayttajarekisteri() {
        this.rekisteri = new ArrayList<Kayttaja>();
    }

    public Kayttajarekisteri(File tiedosto) throws IOException, ClassNotFoundException {
        this.tiedosto = tiedosto;
        FileInputStream fis = new FileInputStream(tiedosto);
        ObjectInputStream ois = new ObjectInputStream(fis);
        this.rekisteri = (ArrayList<Kayttaja>) ois.readObject();
        ois.close();
    }

    public void lisaaKayttaja(String nimi, String salasana) {
        Kayttaja kayttaja = new Kayttaja(nimi, salasana);
        this.rekisteri.add(kayttaja);
    }

    public boolean onkoKayttajaa(String kayttaja) {
        for (Kayttaja kayttaja1 : rekisteri) {
            if (kayttaja1.getNimi().equals(kayttaja)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public String toString() {
        if (rekisteri.isEmpty()) {
            return "EI KÄYTTÄJIÄ!!!";
        }

        String tulos = "";

        for (Kayttaja kayttaja : rekisteri) {
            tulos += ", " + kayttaja.getNimi();
        }

        return tulos.substring(2);
    }

    public void tallenna() throws IOException {
        //OutputStream os = new OutputStream(tiedosto);
        FileOutputStream fos = new FileOutputStream(this.tiedosto);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.flush();
        oos.close();
    }
}
