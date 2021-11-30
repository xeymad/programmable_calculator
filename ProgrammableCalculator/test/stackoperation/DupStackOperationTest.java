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
public class DupStackOperationTest {
    
    private CalculatorStack calculatorStack;
    private DupStackOperation dup;
    
    /**
     * Initialize a CalculatorStack and the DupStackOperationTest command.
     */
    @Before
    public void init(){
        calculatorStack = new CalculatorStack();
        dup= new DupStackOperation(calculatorStack);
    }
    
   
    /**
     * Test of execute method, with a empty stack.
     */
    @Test
    public void testExecuteEmptyStack() {
        System.out.println("execute with empty stack");
        int expectedSize = 0;
        dup.execute();
        int size = calculatorStack.size();
        assertEquals(size, expectedSize);
    }
    
    /**
     * Test of execute method, with a non-empty stack.
     */
    @Test
    public void testExecuteNonEmptyStack() {
        System.out.println("execute with non empty stack");
        calculatorStack.push(new Complex(-8.6, -23.1));
        calculatorStack.push(new Complex(1.5, -0.4));
        dup.execute();
        Complex c1=calculatorStack.pop();
        Complex c2=calculatorStack.pop();
        assertEquals(c1, c2);
    }
}
