package maalimanvahvimmat.model;

public class Kayttaja {

    private String nimi;
    private String salasana;
    private int ika;
    private int pituus;
    private int paino;

    public Kayttaja(String nimi, String salasana) {
        this.nimi = nimi;
        this.salasana = salasana;
    }

    public void setIka(int ika) {
        this.ika = ika;
    }

    public void setPituus(int pituus) {
        this.pituus = pituus;
    }

    public void setPaino(int paino) {
        this.paino = paino;
    }

    public String getNimi() {
        return this.nimi;
    }

    public int getIka() {
        return this.ika;
    }

    public int getPituus() {
        return this.pituus;
    }

    public int getPaino() {
        return this.paino;
    }
}