/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorstack;

import org.apache.commons.math3.complex.Complex;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
   
}
