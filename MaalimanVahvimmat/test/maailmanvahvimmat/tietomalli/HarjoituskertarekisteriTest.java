/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maailmanvahvimmat.tietomalli;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import maalimanvahvimmat.tietomalli.Harjoituskerta;
import maalimanvahvimmat.tietomalli.Harjoituskertarekisteri;
import maalimanvahvimmat.tietomalli.Kayttaja;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rantapel
 */
public class HarjoituskertarekisteriTest {

    public Harjoituskertarekisteri rekisteri;
    public File tiedosto;

    public HarjoituskertarekisteriTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws FileNotFoundException, IOException {
        this.tiedosto = new File("testi-harjoitukset.txt");
        Kayttaja testikayttaja = new Kayttaja("testi", "testi");
        this.rekisteri = new Harjoituskertarekisteri(testikayttaja, tiedosto);
        Harjoituskertarekisteri.alusta(tiedosto);

    }

    @Test
    public void rekisterinAlustusToimii() throws IOException {
        assertTrue(this.tiedosto.exists());
    }

    @Test
    public void harjoituksenLisaysToimii() throws IOException{
        Harjoituskerta treeni = new Harjoituskerta("01.01.2001");
        rekisteri.lisaaHarjoituskertaRekisteriin(treeni);
        assertEquals(treeni, rekisteri.getHarjoituskerta("01.01.2001"));
    }
    
    @After
    public void tearDown() {
    }


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
