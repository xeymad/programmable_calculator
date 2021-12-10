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
 * @author Matteo Di Rienzo
 */
public class PushStackOperationTest {
    
    private CalculatorStack calculatorStack;
    private PushStackOperation pushStackOperation;
    Complex c;
    
    /**
     * Initialize a CalculatorStack and the PushStackOperation command.
     */
    @Before
    public void init(){
        calculatorStack = new CalculatorStack();
        c = new Complex(42, 99);
        pushStackOperation = new PushStackOperation(calculatorStack, c);
    }
    
    /**
     * Tests PushStackOperation by inserting a ComplexNumber into a empty Stack
     */
    @Test
    public void testPushEmptyStack() {
        pushStackOperation.execute();
        assertEquals(c, calculatorStack.pop());
    }

    /*
    * Tests PushStackOperation by inserting a ComplexNumber into a non empty Stack
    */
    @Test
    public void testPushNonEmptyStack() {
        calculatorStack.push(new Complex(42, 42));
        calculatorStack.push(new Complex(42, -42));
        calculatorStack.push(new Complex(-42, 42));
        pushStackOperation.execute();
        assertEquals(c, calculatorStack.pop());
        
    }    
}
