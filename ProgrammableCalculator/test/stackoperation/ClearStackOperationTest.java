/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoperation;

import calculatorstack.CalculatorStack;
import org.apache.commons.math3.complex.Complex;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Utente
 */
public class ClearStackOperationTest {
    
    private CalculatorStack calculatorStack;
    private ClearStackOperation clear;
    
    /**
     * Initialize a CalculatorStack and the ClearStackOperationTest command.
     */
    @Before
    public void init(){
        calculatorStack = new CalculatorStack();
        clear = new ClearStackOperation(calculatorStack);
    }
   
    /**
     * Test of execute method, with a empty stack.
     */
    @Test
    public void testExecuteEmptyStack() {
        clear.execute();
        assertTrue(calculatorStack.isEmpty());
    }
    
    /**
     * Test of execute method, with a non-empty stack.
     */
    @Test
    public void testExecuteNonEmptyStack() {
        calculatorStack.push(new Complex(1, 1));
        calculatorStack.push(new Complex(-1, 1));
        calculatorStack.push(new Complex(-1, -1));
        calculatorStack.push(new Complex(1, -1));
        clear.execute();
        assertTrue(calculatorStack.isEmpty());
    }
    
}
