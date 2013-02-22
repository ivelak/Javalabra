/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maailmanvahvimmat.tietomalli;

import maalimanvahvimmat.tietomalli.Harjoituskerta;
import maalimanvahvimmat.tietomalli.Kayttaja;
import maalimanvahvimmat.tietomalli.Liike;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author rantapel
 */
public class HarjoituskertaTest {
    
    private Harjoituskerta testitreeni;
    private Kayttaja testaaja;
    
    public HarjoituskertaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testitreeni = new Harjoituskerta("01.01.2001");
        testaaja = new Kayttaja("testaaja", "asdf");
    }

    @Test
    public void useanLiikkeenLisays() {
        Liike k = new Liike("kyykky");
        Liike p = new Liike("penkki");
        Liike y = new Liike("ylätalja");
        
        testitreeni.lisaaLiike(k);
        testitreeni.lisaaLiike(p);
        testitreeni.lisaaLiike(y);
        
        assertEquals(3, testitreeni.liikkeidenMaara());
    }
    
    @Test
    public void harjoituskerranTulostus() {
        Liike liike = new Liike("kyykky");
        liike.lisaaToistoJaPaino(10, 50);
        testitreeni.lisaaLiike(liike);
        String toString = testitreeni.listaaLiikkeet();
        String odotettu = "kyykky: 10x50kg "+"\n";
        assertEquals(odotettu, toString);
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
