/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maailmanvahvimmat.model;

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
public class KayttajaTest {
    
    public KayttajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    @Test
    public void kayttajanLuominen(){
        Kayttaja kayttaja = new Kayttaja("Testaaja", "asdf");
        
        assertEquals("Testaaja", kayttaja.getNimi());    
    }
    @Test
    public void muidenOminaisuuksienLisaysKayttajalleToimii(){
        Kayttaja kayttaja = new Kayttaja("Testaaja", "asdf");
        kayttaja.setIka(20);
        kayttaja.setPaino(75);
        kayttaja.setPituus(175);
        
        assertEquals("Testaaja, 20 vuotta, 75 kg, 175 cm", kayttaja.toString());
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
