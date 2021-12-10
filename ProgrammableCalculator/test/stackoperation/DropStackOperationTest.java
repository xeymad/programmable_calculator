/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperation;

import calculatorstack.CalculatorStack;
import org.apache.commons.math3.complex.Complex;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author aferr
 */
public class DropStackOperationTest {
    
    private CalculatorStack calculatorStack;
    private DropStackOperation dropStackOperation;
    
    /**
     * Initializes the stack and the operation
     */
    @Before
    public void init(){
        calculatorStack = new CalculatorStack();
        dropStackOperation = new DropStackOperation(calculatorStack);
    }
    
    /**
     * Test case for empty stack
     */
    @Test
    public void testExecuteEmpty(){
        int expectedSize = 0;
        dropStackOperation.execute();
        int size = calculatorStack.size();
        assertEquals(size, expectedSize);
    }
    
    /**
     * Test case for NOT empty stack
     */
    @Test
    public void testExecuteNotEmpty(){
        Complex complex1 = new Complex(42);
        Complex complex2 = new Complex(4242);
        Complex complex3 = new Complex(424242);
        calculatorStack.push(complex1);
        calculatorStack.push(complex2);
        calculatorStack.push(complex3);
        dropStackOperation.execute();
        
        int expectedSize = 2;
        int size = calculatorStack.size();
        assertEquals(expectedSize, size);
        
        Complex expectedPopped = complex2;
        Complex popped = calculatorStack.pop();
        assertEquals(expectedPopped, popped);
    }
}
