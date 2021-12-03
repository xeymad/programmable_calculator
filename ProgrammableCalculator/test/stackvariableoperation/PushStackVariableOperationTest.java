/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackvariableoperation;

import calculatorstack.CalculatorStack;
import org.apache.commons.math3.complex.Complex;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import complexvariablesvector.ComplexVariablesVector;

/**
 *
 * @author Utente
 */
public class PushStackVariableOperationTest {
    
    private CalculatorStack calculatorStack;
    private ComplexVariablesVector variablesVector;
    private char variable;
    private PushStackVariableOperation pushSVO;
    
    
    @Before
    public void init(){
        calculatorStack = new CalculatorStack();
        variablesVector = new ComplexVariablesVector();
        variable = 'a';
        pushSVO = new PushStackVariableOperation(calculatorStack, variablesVector, variable);
    }
    
    /**
     * Test if the variable's value is being pushed to stack's top.
     */
    @Test
    public void testExecute(){
        Complex z = new Complex(42, 0);
        variablesVector.setVarValue(variable, z);
        pushSVO.execute();
        Complex insertedValue = calculatorStack.top();
        assertEquals(insertedValue, z);
    }
    
}
