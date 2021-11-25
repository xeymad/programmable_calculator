/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorstack;

import java.util.Iterator;
import org.apache.commons.math3.complex.Complex;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arianna Carratù
 */
public class CalculatorStackTest {
    
    private CalculatorStack instance;
    
    public CalculatorStackTest() {
    }

    @Before
    public void setUp() {
        instance = new CalculatorStack();
    }

    /**
     * Test of isEmpty method, of class CalculatorStack.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        assertTrue(instance.isEmpty());
    }
    /**
     * Test of push method, of class CalculatorStack.
     */
    @Test
    public void testPush() {
        
        System.out.println("push");
        Complex c = new Complex(2,3);
        instance.push(c);
        assertFalse(instance.isEmpty());
        
    }

    /**
     * Test of pop method, of class CalculatorStack.
     */
    @Test
    public void testPop() {
        
        System.out.println("pop");
        Complex expResult = new Complex(7,39);
        instance.push(new Complex(1,2));
        instance.push(expResult);
        Complex result = instance.pop();
        assertEquals(expResult, result);
   
    }

    /**
     * Test of size method, of class CalculatorStack.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        instance.push(new Complex(45,66));
        instance.push(new Complex(9,34));
        instance.push(new Complex(21,4));
        int expResult = 3;
        int result = instance.size();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of iterator method, of class CalculatorStack.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        Complex expResult1=new Complex(3,213);
        Complex expResult2=new Complex(77,-12);
        Complex expResult3=new Complex(-9,8);
        instance.push(expResult3);
        instance.push(expResult2);
        instance.push(expResult1);
        Iterator<Complex> iterator = instance.iterator();
        assertEquals(expResult1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(expResult2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(expResult3, iterator.next());
        assertFalse(iterator.hasNext());
        
        
    }
   
}
