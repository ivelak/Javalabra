package maalimanvahvimmat.tietomalli;

public class Kayttaja {
    
    /**
     * Luo Kayttaja-olion
     */

    private String nimi;
    private String salasana;
    private int ika;
    private int pituus;
    private int paino;

    public Kayttaja(String nimi, String salasana) {
        this.nimi = nimi;
        this.salasana = salasana;
        this.ika = -1;
        this.pituus = -1;
        this.paino = -1;
    }

    public void setIka(int ika) {
        this.ika = ika;
    }
    public void setSalasana(String salasana){
        this.salasana = salasana;
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
    public String getSalasana() {
        return this.salasana;
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
    @Override
    public String toString(){
        return getNimi()+", "+getIka()+" vuotta, "+getPaino()+" kg, "+getPituus()+" cm";
    }
}