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
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Matteo Di Rienzo
 */
public class DivisionStackOperationTest {
   
    private CalculatorStack testStack;
    DivisionStackOperation div;
    private Complex actual, expected;
    
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    
    @Before
    public void init(){
        testStack = new CalculatorStack();
        div = new DivisionStackOperation(testStack);
    }
    
    /**
     * Test of execute method, testing the throw of the DivideByZeroException
     */
    @Test
    public void testExceptionExecute(){
        System.out.println("testing the exception throwing");
        exceptionRule.expect(ArithmeticException.class);
        testStack.push(new Complex(5.0, -5.0));
        testStack.push(Complex.ZERO);
        div.execute();
    }
    
    /**
     * Test of execute method when the stack is empty
     */
    @Test
    public void testExecuteEmptyStack() {
        System.out.println("testing the execution on a empty stack");
        div.execute();
        actual = testStack.pop();
        expected = Complex.ZERO;
        assertEquals(actual, expected); 
    }
    
    /**
     * Test of execute method on a one element stack
     */
    @Test
    public void testExecuteOneElementStack(){ 
        System.out.println("testing the execution on a one element stack");
        Complex z = new Complex(5.0, -5.0);
        testStack.push(z);
        div.execute();
        actual = testStack.pop();
        expected = z;
        assertEquals(actual, expected); 
    }
    
    /**
     * Test of execute method between elements of from the first quadrant
     */
    @Test  
    public void testExecuteFirstQuadrant(){ 
        System.out.println("testing the execution beetween elements of from the first quadrant");
        testStack.push(new Complex(1.0));
        testStack.push(new Complex(2.0, 1.0));
        div.execute();
        actual = testStack.pop();
        expected = new Complex(0.4, -0.2);
        assertEquals(actual, expected);
    }
    
    /**
     * Test of execute method between elements of from the first and second quadrant
     */
    @Test
    public void testExecuteFirstSecondQuadrant(){ 
        System.out.println("testing the execution beetween elements of from the first and second quadrants");
        testStack.push(new Complex(1.0));
        testStack.push(new Complex(-1.0, 1.0));
        div.execute();
        actual = testStack.pop();
        expected = new Complex(-0.5, -0.5);
        assertEquals(actual, expected);
    }
    
    /**
     * Test of execute method between elements of from the first and third quadrants
     */
    @Test
    public void testExecuteFirstThirdQuadrant(){
        System.out.println("testing the execution beetween elements of from the first and third quadrants");
        testStack.push(new Complex(1.0));
        testStack.push(new Complex(-1.0, -1.0));
        div.execute();
        actual = testStack.pop();
        expected = new Complex(-0.5, 0.5);
        assertEquals(actual, expected);
    }
    
    /**
     * Test of execute method between elements of from the first and fourth quadrants
     */
    @Test
    public void testExecuteFirstFourthQuadrant(){
        System.out.println("testing the execution beetween elements of from the first and fourth quadrants");
        testStack.push(new Complex(1.0));
        testStack.push(new Complex(1.0, -1.0)); 
        div.execute();
        actual = testStack.pop();
        expected = new Complex(0.5, +0.5);
        assertEquals(actual, expected);      
    }
    
    /**
     * Test of execute method between elements of from the second quadrant
     */
    @Test
    public void testExecuteSecondQuadrant(){
        System.out.println("testing the execution beetween elements of from the second quadrant");
        testStack.push(new Complex(-1.0, 3.0)); 
        testStack.push(new Complex(-2.0, 1.0)); 
        div.execute();
        actual = testStack.pop();
        expected = new Complex(1.0, -1.0);
        assertEquals(actual, expected); 
    }     
    
    /**
     * Test of execute method between elements of from the second and third quadrants
     */
    @Test 
    public void testExecuteSecondThirdQuadrant(){ 
        System.out.println("testing the execution beetween elements of from the second and third quadrants");
        testStack.push(new Complex(-1.0, 3.0)); 
        testStack.push(new Complex(-2.0, -1.0));  
        div.execute();
        actual = testStack.pop();
        expected = new Complex(-0.2, -1.4);
        assertEquals(actual, expected); 
    }
    
    /**
     * Test of execute method between elements of from the second and fourth quadrants
     */
    @Test
    public void testExecuteSecondFourthQuadrant(){
        System.out.println("testing the execution beetween elements of from the second and fourth quadrants");
        testStack.push(new Complex(-1.0, 3.0)); 
        testStack.push(new Complex(2.0, -1.0));
        div.execute();
        actual = testStack.pop();
        expected = new Complex(-1, 1);
        assertEquals(actual, expected);
    }
    
    /**
     * Test of execute method between elements of from the third quadrant
     */
    @Test
    public void testExecuteThirdQuadrant(){   
        System.out.println("testing the execution beetween elements of from the third quadrant");
        testStack.push(new Complex(-1.0, -2.0)); 
        testStack.push(new Complex(-2.0, -1.0));
        div.execute();
        actual = testStack.pop();
        expected = new Complex(0.8, 0.6);
        assertEquals(actual, expected); 
    }
    
    /**
     * Test of execute method between elements of from the third and fourth quadrants
     */
    @Test
    public void testExecuteThirdFourthQuadrant(){   
        System.out.println("testing the execution beetween elements of from the third and fourth quadrants");
        testStack.push(new Complex(-1.0, -2.0)); 
        testStack.push(new Complex(2.0, -1.0));
        div.execute();
        actual = testStack.pop();
        expected = new Complex(0, -1.0);
        assertEquals(actual, expected); 
    }
    
    /**
     * Test of execute method between elements of from the fourth quadrant
     */
    @Test
    public void testExecuteFourthQuadrant(){
        System.out.println("testing the execution beetween elements of from the fourth quadrant");
        testStack.push(new Complex(3.0, -3.0)); 
        testStack.push(new Complex(2.0, -1.0));  
        div.execute();
        actual = testStack.pop();
        expected = new Complex(1.8, -0.6);
        assertEquals(actual, expected);
    }
    
    /**
     * Test of execute method when the result is 1
     */
    @Test
    public void testExecuteResultOne(){
        System.out.println("testing the execution when the result is 1");
        testStack.push(new Complex(3.0, -1.0)); 
        testStack.push(new Complex(3.0, -1.0)); 
        div.execute();
        actual = testStack.pop();
        expected = Complex.ONE;
        assertEquals(actual, expected); 
     }      
    
    /**
     * Test of execute method when the result is 0
     */
    @Test
    public void testExecuteResultZero(){  
        System.out.println("testing the execution when the result is 0");
        testStack.push(Complex.ZERO);
        testStack.push(new Complex(1.0));
        div.execute();
        actual = testStack.pop();
        expected = Complex.ZERO;
        assertEquals(actual, expected);  
    }
}
