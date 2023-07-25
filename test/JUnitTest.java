/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import mygraphiclib.PerspectiveVertex;
import mygraphiclib.Vector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tukalov
 */
public class JUnitTest {
    
    public JUnitTest() {
        new PerspectiveVertex(new Vector(10, 10, 0)).getX();
    }
    
    @BeforeClass
    public static void setUpClass() {
        new PerspectiveVertex(new Vector(10, 10, 0)).getX();
    }
    
    @AfterClass
    public static void tearDownClass() {
        new PerspectiveVertex(new Vector(10, 10, 0)).getX();
    }
    
    @Before
    public void setUp() {
        new PerspectiveVertex(new Vector(10, 10, 0)).getX();
    }
    
    @After
    public void tearDown() {
        new PerspectiveVertex(new Vector(10, 10, 0)).getX();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    
     @Test
     public void hello() {
        new PerspectiveVertex(new Vector(0, 0, 0)).getX();
     }
}
