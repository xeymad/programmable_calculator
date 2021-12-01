/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperation;

import calculatorstack.CalculatorStack;
import org.apache.commons.math3.complex.Complex;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Matteo Di Rienzo
 */
public class SwapStackOperationTest {
    
    private CalculatorStack calculatorStack;
    private SwapStackOperation swap;
    
    
    /**
     * Initialize a CalculatorStack and the SwapStackOperationTest command.
     */
    @Before
    public void init(){
        calculatorStack = new CalculatorStack();
        swap= new SwapStackOperation(calculatorStack);
    }
    
    
    /**
     * Test of execute method, with a empty stack.
     */
    @Test
    public void testExecuteEmptyStack(){
        System.out.println("execute with empty stack");
        int expected = 0;
        swap.execute();
        int actual = calculatorStack.size();
        assertEquals(actual, expected);
    }
    
    /**
     * Test of execute method, with a single element stack.
     */
    @Test
    public void testExecuteOneElementStack() {
        System.out.println("execute with a single element stack");
        calculatorStack.push(new Complex(6.2, -1.3));
        int expectedSize = 1;
        swap.execute();
        int size = calculatorStack.size();
        assertEquals(size, expectedSize);
    }
    
    /**
    * Test of execute method, with at least two element stack
    */
    @Test
    public void testExecuteAtLeastTwoElementsStack() {
        System.out.println("execute with at least two elements stack");
        Complex c1 =new Complex(-8.6, -23.1);
        Complex c2 =new Complex(89, -7);
        Complex c3 =new Complex(55, 4);
        calculatorStack.push(c1);
        calculatorStack.push(c2);
        calculatorStack.push(c3);
        swap.execute();
        Complex result=calculatorStack.top();
        assertEquals(c2, result);
    }
    
}
