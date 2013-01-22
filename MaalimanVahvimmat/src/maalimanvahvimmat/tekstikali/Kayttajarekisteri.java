package maalimanvahvimmat.tekstikali;

import maalimanvahvimmat.model.Kayttaja;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kayttajarekisteri {

    private List<Kayttaja> rekisteri;
    private Scanner lukija;

    public Kayttajarekisteri() {
        this.rekisteri = new ArrayList<Kayttaja>();
        this.lukija = new Scanner(System.in);
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
}
