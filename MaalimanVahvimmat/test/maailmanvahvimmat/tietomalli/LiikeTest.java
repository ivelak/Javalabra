/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maailmanvahvimmat.tietomalli;

import maalimanvahvimmat.tietomalli.Liike;
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
public class LiikeTest {
    
    public LiikeTest() {
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
    public void toistojenJaPainojenLiaysToimii(){
        Liike liike = new Liike("testiliike");
        liike.lisaaToistoJaPaino(10, 50);
        liike.lisaaToistoJaPaino(8, 60);
        assertEquals(2, liike.getToistot().size());
        assertEquals(2, liike.getPainot().size());
        
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
