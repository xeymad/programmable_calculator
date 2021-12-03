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
import complexvariablesvector.ComplexVariablesVector;

/**
 *
 * @author Arianna Carratù
 */
public class SumStackVariableOperationTest {
    
    private CalculatorStack calculatorStack;
    private ComplexVariablesVector variablesVector;
    private char variable;
    private SumStackVariableOperation sumSVO;
    
    @Before
    public void init(){
        calculatorStack = new CalculatorStack();
        variablesVector = new ComplexVariablesVector();
        variable = 'a';
        sumSVO = new SumStackVariableOperation(calculatorStack, variablesVector, variable);
    }
    
    /**
     * Test of execute method on empty stack
     */
    @Test
    public void testExecuteEmptyStack() { 
        System.out.println("testing the execution on an empty stack");
        Complex variableNumber = new Complex(89, 42);
        variablesVector.setVarValue(variable, variableNumber);
        sumSVO.execute();
        
        Complex topNumber = calculatorStack.top();
        assertEquals(topNumber, variableNumber); 
    }
    
    /**
     * Test of execute method between elements of from the first quadrant
     */
    @Test  
    public void testExecuteFirstQuadrant(){ 
        System.out.println("testing the  execution beetween elements of from the first quadrant");
        Complex variableNumber = new Complex(1.0);
        Complex stackNumber = new Complex(2.0, 1.0);
        variablesVector.setVarValue(variable, variableNumber);
        calculatorStack.push(stackNumber);
        sumSVO.execute();
        
        Complex expectedNumber = new Complex(3.0, 1.0);
        Complex topNumber = calculatorStack.top();
        assertEquals(expectedNumber, topNumber);
    }
    /**
     * Test of execute method between elements of from the first and second quadrant
     */
    @Test
    public void testExecuteFirstSecondQuadrant(){ 
        System.out.println("testing the  execution beetween elements of from the first and second quadrants"); 
        Complex variableNumber = new Complex(1.0);
        Complex stackNumber = new Complex(-1.0, 1.0);
        variablesVector.setVarValue(variable, variableNumber);
        calculatorStack.push(stackNumber);
        sumSVO.execute();
        
        Complex expectedNumber = new Complex(0.0, 1.0);
        Complex topNumber = calculatorStack.top();
        assertEquals(expectedNumber, topNumber);
    }

    /**
    * Test of execute method between elements of from the first and third quadrants
    */
    @Test
    public void testExecuteFirstThirdQuadrant(){
        System.out.println("testing the  execution beetween elements of from the first and third quadrants");
        Complex variableNumber = new Complex(1.0);
        Complex stackNumber = new Complex(-1.0, -1.0);
        variablesVector.setVarValue(variable, variableNumber);
        calculatorStack.push(stackNumber);
        sumSVO.execute();
        
        Complex expectedNumber = new Complex(0.0, -1.0);
        Complex topNumber = calculatorStack.top();
        assertEquals(expectedNumber, topNumber);
    }

    /**
     * Test of execute method between elements of from the first and fourth quadrants
     */
    @Test
    public void testExecuteFirstFourthQuadrant(){
        System.out.println("testing the  execution beetween elements of from the first and fourth quadrants");
        Complex variableNumber = new Complex(1.0);
        Complex stackNumber = new Complex(1.0, -1.0);
        variablesVector.setVarValue(variable, variableNumber);
        calculatorStack.push(stackNumber);
        sumSVO.execute();
        
        Complex expectedNumber = new Complex(2.0, -1.0);
        Complex topNumber = calculatorStack.top();
        assertEquals(expectedNumber, topNumber);    
    }

    /**
     * Test of execute method between elements of from the second quadrant
     */
    @Test
    public void testExecuteSecondQuadrant(){
        System.out.println("testing the  execution beetween elements of from the second quadrant");
        Complex variableNumber = new Complex(-1.0, 3.0);
        Complex stackNumber = new Complex(-2.0, 1.0);
        variablesVector.setVarValue(variable, variableNumber);
        calculatorStack.push(stackNumber);
        sumSVO.execute();
        
        Complex expectedNumber = new Complex(-3.0, 4.0);
        Complex topNumber = calculatorStack.top();
        assertEquals(expectedNumber, topNumber);
    }
    
    /**
     * Test of execute method between elements of from the second and third quadrants
     */
    @Test 
    public void testExecuteSecondThirdQuadrant(){ 
        System.out.println("testing the  execution beetween elements of from the second and third quadrants");
        Complex variableNumber = new Complex(-1.0, 3.0);
        Complex stackNumber = new Complex(-2.0, -1.0);
        variablesVector.setVarValue(variable, variableNumber);
        calculatorStack.push(stackNumber);
        sumSVO.execute();
        
        Complex expectedNumber = new Complex(-3.0, 2.0);
        Complex topNumber = calculatorStack.top();
        assertEquals(expectedNumber, topNumber);
    }
    
    /**
     * Test of execute method between elements of from the second and fourth quadrants
     */
    @Test
    public void testExecuteSecondFourthQuadrant(){
        System.out.println("testing the  execution beetween elements of from the second and fourth quadrants");
        Complex variableNumber = new Complex(-1.0, 3.0);
        Complex stackNumber = new Complex(2.0, -1.0);
        variablesVector.setVarValue(variable, variableNumber);
        calculatorStack.push(stackNumber);
        sumSVO.execute();
        
        Complex expectedNumber = new Complex(1.0, 2.0);
        Complex topNumber = calculatorStack.top();
        assertEquals(expectedNumber, topNumber);
    }
    
    /**
     * Test of execute method between elements of from the third quadrant
     */
    @Test
    public void testExecuteThirdQuadrant(){   
        System.out.println("testing the  execution beetween elements of from the third quadrant");
        Complex variableNumber = new Complex(-1.0, -2.0);
        Complex stackNumber = new Complex(-2.0, -1.0);
        variablesVector.setVarValue(variable, variableNumber);
        calculatorStack.push(stackNumber);
        sumSVO.execute();
        
        Complex expectedNumber = new Complex(-3.0, -3.0);
        Complex topNumber = calculatorStack.top();
        assertEquals(expectedNumber, topNumber);
    }
    
    /**
     * Test of execute method between elements of from the third and fourth quadrants
     */
    @Test
    public void testExecuteThirdFourthQuadrant(){   
        System.out.println("testing the  execution beetween elements of from the third and fourth quadrants");
        Complex variableNumber = new Complex(-1.0, -2.0);
        Complex stackNumber = new Complex(2.0, -1.0);
        variablesVector.setVarValue(variable, variableNumber);
        calculatorStack.push(stackNumber);
        sumSVO.execute();
        
        Complex expectedNumber = new Complex(1.0, -3.0);
        Complex topNumber = calculatorStack.top();
        assertEquals(expectedNumber, topNumber);
    }
    
    /**
     * Test of execute method between elements of from the fourth quadrant
     */
    @Test
    public void testExecuteFourthQuadrant(){
        System.out.println("testing the  execution beetween elements of from the fourth quadrant");
        Complex variableNumber = new Complex(3.0, -3.0);
        Complex stackNumber = new Complex(2.0, -1.0);
        variablesVector.setVarValue(variable, variableNumber);
        calculatorStack.push(stackNumber);
        sumSVO.execute();
        
        Complex expectedNumber = new Complex(5.0, -4.0);
        Complex topNumber = calculatorStack.top();
        assertEquals(expectedNumber, topNumber);
    }
    
    
}
