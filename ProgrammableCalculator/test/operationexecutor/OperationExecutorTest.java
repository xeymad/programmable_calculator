/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operationexecutor;

import calculatorstack.CalculatorStack;
import org.apache.commons.math3.complex.Complex;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import stackoperation.*;


/**
 *
 * @author matteo
 */
public class OperationExecutorTest {
    
    private OperationExecutor opExecutor;
    private CalculatorStack calculatorStack;
    
    @Before
    public void init() {
        calculatorStack = new CalculatorStack();
    }
    
    /**
    * Tests the execution with the empty Operation
    */
    @Test(expected = UndefinedOperationException.class)
    public void testOperationExecutorEmptyConstructor() {
        opExecutor = new OperationExecutor();
        opExecutor.execute();
    }
    
    /**
     * Tests the non empty constructor of the OperationExecutor
     */
    @Test
    public void testOperationExecutorNonEmptyConstructor() {
        StackOperation op = new PushStackOperation(calculatorStack, new Complex(42,42)); 
        opExecutor = new OperationExecutor(op);
        opExecutor.execute();
        assertEquals(calculatorStack.pop(), new Complex(42, 42));
    }
    
    /**
     * Tests the Setter of the OperatorExecutor
     */
    @Test
    public void testOperationExecutorSet() {
        StackOperation op = new PushStackOperation(calculatorStack, new Complex(42,42)); 
        opExecutor = new OperationExecutor();
        opExecutor.setCommand(op);
        opExecutor.execute();
        assertEquals(calculatorStack.pop(), new Complex(42, 42));
    }
    
}
