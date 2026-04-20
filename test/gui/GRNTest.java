package gui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ASUS™
 */
public class GRNTest {

    public GRNTest() {
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

    @After
    public void tearDown() {
    }

    /**
     * Test of getjLabel21 method, of class GRN.
     */
    @Test
    public void testGetjLabel21() {
        System.out.println("getjLabel21");
        GRN instance = new GRN();
        String expResult = "SUPPLIER NAME";
        String result = instance.getjLabel21().getText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
}
