/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackvariableoperation;

import org.junit.*;
import static org.junit.Assert.*;
import calculatorstack.CalculatorStack;
import org.apache.commons.math3.complex.Complex;
import variablesvector.VariablesVector;

/**
 *
 * @author aferr
 */
public class StoreStackVariableOperationTest {
    
    private CalculatorStack calculatorStack;
    private VariablesVector variablesVector;
    private char variable;
    private StoreStackVariableOperation storeSVO;
    
    
    @Before
    public void init(){
        calculatorStack = new CalculatorStack();
        variablesVector = new VariablesVector();
        variable = 'a';
        storeSVO = new StoreStackVariableOperation(calculatorStack, variablesVector, variable);
    }
    
    /**
     * Test if the variable is being set to stack's top element.
     */
    @Test
    public void testExecute(){
        Complex number = new Complex(42, 9);
        calculatorStack.push(number);
        storeSVO.execute();
        Complex variableNumber = variablesVector.getVarValue(variable);
        assertEquals(number, variableNumber);
    }
    
    /**
     * Test if the variable remains unchanged when the stack is empty.
     */
    @Test
    public void testExecuteEmptyStack(){
        storeSVO.execute();
        Complex variableNumber = variablesVector.getVarValue(variable);
        assertEquals(variableNumber, Complex.ZERO); // variable's default value is 0
    }
    
}
