    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maailmanvahvimmat.tekstikali;

import maalimanvahvimmat.tietomalli.Kayttaja;
import maalimanvahvimmat.tietomalli.Kayttajarekisteri;
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
public class KayttajarekisteriTest {
    private Kayttajarekisteri rekisteri;
    
    public KayttajarekisteriTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        rekisteri = new Kayttajarekisteri();
        
    }
    @Test
    public void tyhjaRekisteri(){
        assertEquals("EI KÄYTTÄJIÄ!!!", rekisteri.toString());
    }
    @Test
    public void kayttajanLisaaminenRekisteriin(){
        Kayttaja kapistelija = new Kayttaja("kapistelija","password");
        rekisteri.lisaaKayttaja(kapistelija);
        
        assertEquals(kapistelija.getNimi(), rekisteri.toString());
    }
    @Test
    public void useanKayttajanLisaaminenRekisteriin(){
        Kayttaja kapistelija = new Kayttaja("kapistelija","password");
        Kayttaja fyysikko = new Kayttaja("fyysikko","password");
        rekisteri.lisaaKayttaja(kapistelija);
        rekisteri.lisaaKayttaja(fyysikko);
        
        assertEquals(kapistelija.getNimi()+", "+fyysikko.getNimi(), rekisteri.toString());
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
