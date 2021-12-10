/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperation;

import calculatorstack.CalculatorStack;
import java.util.NoSuchElementException;
import org.apache.commons.math3.complex.Complex;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Giuseppe
 */
public class InvertSignStackOperationTest {
    
    private final CalculatorStack testStack = new CalculatorStack();
    private final InvertSignStackOperation is = new InvertSignStackOperation(testStack);
    
    /**
     * Test Case 1: test on a simple complexNum
     */
    @Test
    public void simpleTest(){
        testStack.push(new Complex(10,1));
        is.execute();
        assertEquals(new Complex(-10,-1),testStack.pop());
    }
    
    /**
     * Test Case 2: test on a double complexNum
     */
    @Test
    public void decimalTest(){
        testStack.push(new Complex(10.5534,-31.254326));
        is.execute();
        assertEquals(new Complex(-10.5534,31.254326),testStack.pop());     
    }
    
    /**
     * Test Case 3: test on a 0 complexNum
     */
    @Test
    public void zeroTest(){
        testStack.push(new Complex(0,0));
        is.execute();
        assertEquals(new Complex(-0.0,-0.0),testStack.pop());
    }
    
    /**
     * Test Case 4: test on a real complexNum
     */
    @Test
    public void realTest(){
        testStack.push(new Complex(-10,0));
        is.execute();
        assertEquals(new Complex(10,-0.0),testStack.pop());        
    }
    
    /**
     * Test case 5: test on an imaginary complexNum
     */
    @Test
    public void imaginaryTest(){
        testStack.push(new Complex(0,-20));
        is.execute();
        assertEquals(new Complex(-0.0,20),testStack.pop());        
    }
    
    /**
     * Test case 6: test on an empty Stack
     */
    @Test
    public void emptyTest(){
        CalculatorStack emptyStack = new CalculatorStack();
        InvertSignStackOperation none = new InvertSignStackOperation(emptyStack);
        none.execute();
        assertTrue(emptyStack.isEmpty());
    }
}
