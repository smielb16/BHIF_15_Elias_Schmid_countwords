/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author Elias
 */
@RunWith(Parameterized.class)
public class DataQueueTest {
/*
    @Parameter(value = 0)
    int queueSize;
    
    @Parameter(value = 1)
    int fill;
    
    @Parameter(value = 2)
    Object expected;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {0, 0, new Exception()}});
    }
*/
    public DataQueueTest() {
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
     * Test of get method, of class DataQueue.
     */
    @Test
    public void testGet() throws Exception {
        /*DataQueue instance = new DataQueue(queueSize);
        Book book = (Book) instance.get();
        assertEquals(expected, );*/
    }

    /**
     * Test of put method, of class DataQueue.
     */
    @Test
    public void testPut() throws Exception {
        /*DataQueue instance = new DataQueue(queueSize);
        for (int i = 0; i < fill; i++) {
            instance.put(new Book("test", "test"));
        }
        assertEquals(expected, );*/
    }

}
