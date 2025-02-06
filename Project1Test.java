import org.junit.*;
import static org.junit.Assert.*;

/**
 * Testing the functions that run the array of ints.
 * 
 * @author Dylan Wilson
 * @version Jan 07, 2025
 */
public class Project1Test {

    private Project1 runner;

    /**
     * setup() method, runs before each of your test methods.
     * Use this method to recreate the objects needed for
     * testing your class.
     */
    @Before
    public void setup() {
        runner = new Project1(25);
    }

    // Put your test methods here
    // type "/junitTest" to get a skelleton of the code
    /**
     * Test of the getMinimum function.
     */
    @Test
    public void getMinimum() {
        // 1. set up initial conditions
        runner.addValue(1);
        runner.addValue(13);
        // 2. call the method
        int loc = runner.getMinimum();
        // 3. check expected results
        assertEquals(1, loc);
    }

    /**
     * Test of the getMaximum function.
     */
    @Test
    public void getMaximum() {
        // 1. set up initial conditions
        runner.addValue(55);
        runner.addValue(20);
        runner.addValue(70);
        // 2. call the method
        int loc = runner.getMaximum();
        // 3. check expected results
        assertEquals(70, loc);
    }

    /**
     * Test of the getAverage function.
     */
    @Test
    public void getAverage() throws IllegalStateException {
        // 1. set up initial conditions
        runner.addRandom(24);
        // 2. call the method
        double loc = runner.getAverage();
        // 3. check expected results
        assertEquals(loc, loc, .01);
    }

    /**
     * Test of the getRange function.
     */
    @Test
    public void getRange() {
        // 1. set up initial conditions
        runner.addValue(10);
        runner.addValue(2);
        runner.addValue(3);
        runner.addValue(4);
        runner.addValue(5);
        // 2. call the method
        int loc = runner.getRange();
        // 3. check expected results
        assertEquals(8, loc);
    }

    /**
     * Test of the size function.
     */
    @Test
    public void size() {
        // 1. set up initial conditions
        runner.addRandom(25);
        // 2. call the method
        int loc = runner.size();
        // 3. check expected results
        assertEquals(25, loc);
    }

    /**
     * Test of the capacity function.
     */
    @Test
    public void getCapacity() {
        // 1. set up initial conditions
        // 2. call the method
        int loc = runner.getCapacity();
        // 3. check expected results
        assertEquals(25, loc);
    }

    /**
     * Test of getValue function.
     */
    @Test
    public void getValue() throws IndexOutOfBoundsException {
        // 1. set up initial conditions
        runner.addValue(4);
        // 2. call the method
        int loc = runner.getValue(0);
        // 3. check expected results
        assertEquals(4, loc);
    }

    /**
     * Test of the setValue function.
     */
    @Test
    public void setValue() throws IndexOutOfBoundsException {
        // 1. set up initial conditions
        runner.addValue(7);
        // 2. call the method
        int loc = runner.setValue(0, 1);
        // 3. check expected results
        assertEquals(1, loc);
    }

    /**
     * Test of the addRandom function.
     */
    @Test
    public void addRandom() throws IllegalStateException {
        // 1. set up initial conditions
        runner.addRandom(25);
        // 2. call the method
        int loc = runner.size();
        // 3. check expected results
        assertEquals(25, loc);
    }

    /**
     * Test of the removeValueAt function.
     */
    @Test
    public void removeValueAt() throws IndexOutOfBoundsException {
        // 1. set up initial conditions
        runner.addValue(10);
        runner.addValue(2);
        runner.addValue(3);
        runner.addValue(10);
        // 2. call the method
        runner.removeValueAt(0);
        int loc = runner.getValue(0);
        // 3. check expected results
        assertEquals(2, loc);
    }

    /**
     * Test of the isEmpty function.
     */
    @Test
    public void isEmpty() {
        // 1. set up initial conditions
        // 2. call the method
        boolean loc = runner.isEmpty();
        // 3. check expected results
        assertTrue(loc);
    }

    /**
     * Test of the isFull function.
     */
    @Test
    public void isFull() {
        // 1. set up initial conditions
        runner.addRandom(5);
        // 2. call the method
        boolean loc = runner.isFull();
        // 3. check expected results
        assertFalse(loc);
    }

    /**
     * Test of the hasDuplicates function.
     */
    @Test
    public void noDuplicates() {
        // 1. set up initial conditions
        runner.addValue(0);
        runner.addValue(7);
        runner.addValue(6);
        runner.addValue(8);
        boolean loc = runner.hasDuplicates();
        // 3. check expected results
        assertFalse(loc);
    }

    /**
     * Test of the hasDuplicates function.
     */
    @Test
    public void hasDuplicates() {
        // 1. set up initial conditions
        runner.addValue(0);
        runner.addValue(7);
        runner.addValue(6);
        runner.addValue(0);
        // 2. call the method
        boolean loc = runner.hasDuplicates();
        // 3. check expected results
        assertTrue(loc);
    }

    /**
     * Testing average with empty array.
     */
    @Test
    public void emptyAverage()
    {
        try {
            runner.getAverage();
            fail("expected exception was not occured.");
        } catch(Exception e) {
            //if execution reaches here, 
            //it indicates this exception was occured.
            assertTrue(e instanceof IllegalStateException);
        }
    }

    /**
     * Testing minimum with empty array.
     */
    @Test
    public void emptyMin()
    {
        runner.getMinimum();
    }

    /**
     * Testing maximum with empty array.
     */
    @Test
    public void emptyMax()
    {
        runner.getMaximum();
    }

    /**
     * Testing addValue with full array.
     */
    @Test
    public void fullAddValue()
    {
        try {
            runner.addRandom(25);
            runner.addValue(4);
            fail("expected exception was not occured.");
        } catch(Exception e) {
            //if execution reaches here, 
            //it indicates this exception was occured.
            assertTrue(e instanceof IllegalStateException);
        }
    }

     /**
     * Testing getValue with wrong index.
     */
    @Test
    public void wrongGetValue()
    {
        try {
            runner.addRandom(25);
            runner.getValue(35);
            fail("expected exception was not occured.");
        } catch(Exception e) {
            //if execution reaches here, 
            //it indicates this exception was occured.
            assertTrue(e instanceof IndexOutOfBoundsException);
        }
    }

    /**
     * Testing setValue with wrong index.
     */
    @Test
    public void wrongSetValue()
    {
        try {
            runner.setValue(35, 20);
            fail("expected exception was not occured.");
        } catch(Exception e) {
            //if execution reaches here, 
            //it indicates this exception was occured.
            assertTrue(e instanceof IndexOutOfBoundsException);
        }
    }

    /**
     * Testing addRandom with wrong index.
     */
    @Test
    public void wrongAddRandom()
    {
        try {
            runner.addRandom(27);
            fail("expected exception was not occured.");
        } catch(Exception e) {
            //if execution reaches here, 
            //it indicates this exception was occured.
            assertTrue(e instanceof IllegalStateException);
        }
    }

    /**
     * Testing removeValueAt with wrong index.
     */
    @Test
    public void wrongRemoveValueAt()
    {
        try {
            runner.addRandom(25);
            runner.removeValueAt(35);
            fail("expected exception was not occured.");
        } catch(Exception e) {
            //if execution reaches here, 
            //it indicates this exception was occured.
            assertTrue(e instanceof IndexOutOfBoundsException);
        }
        try {
            runner.removeValueAt(-1);
            fail("expected exception was not occured.");
        } catch(Exception e) {
            //if execution reaches here, 
            //it indicates this exception was occured.
            assertTrue(e instanceof IndexOutOfBoundsException);
        }
    }
}