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
 * @author Arianna Carratù
 */
public class OverStackOperationTest {
    
    private CalculatorStack calculatorStack;
    private OverStackOperation over;
    
    /**
     * Initialize a CalculatorStack and the OverStackOperationTest command.
     */
    @Before
    public void init(){
        calculatorStack = new CalculatorStack();
        over = new OverStackOperation(calculatorStack);
    }
    
   
    /**
     * Test of execute method, with a empty stack.
     */
    @Test
    public void testExecuteEmptyStack() {
        System.out.println("execute with empty stack");
        int expectedSize = 0;
        over.execute();
        int size = calculatorStack.size();
        assertEquals(size, expectedSize);
    }
    
    /**
     * Test of execute method, with a single element stack.
     */
    @Test
    public void testExecuteOneElementStack() {
        System.out.println("execute with a single element stack");
        calculatorStack.push(new Complex(-8.6, -23.1));
        int expectedSize = 1;
        over.execute();
        int size = calculatorStack.size();
        assertEquals(size, expectedSize);
    }
    
    /**
     * Test of execute method, with a non-empty stack.
     */
    @Test
    public void testExecuteAtLeastTwoElementsStack() {
        System.out.println("execute with at least two elements stack");
        Complex c1 = new Complex(-8.6, -23.1);
        Complex c2 = new Complex(89, -7);
        Complex c3 = new Complex(55, 4);
        calculatorStack.push(c1);
        calculatorStack.push(c2);
        calculatorStack.push(c3);
        over.execute();
        Complex result = calculatorStack.top();
        assertEquals(c2, result);
    }
}
