/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stackoperation;

import org.apache.commons.math3.complex.Complex;
import org.junit.Test;
import static org.junit.Assert.*;
import calculatorstack.CalculatorStack;
import org.junit.Before;
/**
 *
 * @author Utente
 */
public class SubtractionStackOperationTest {
    
    private CalculatorStack testStack;
    SubtractionStackOperation sub;
    private Complex actual, expected;
      
    @Before
    public void init(){
        testStack = new CalculatorStack();
        sub = new SubtractionStackOperation(testStack);
    }
    
    /**
     * Test of execute method, of class SubtractionStackOperation.
     */
    @Test
    public void testExecuteEmptyStack() { 
        System.out.println("testing the execution on a empty stack");
        sub.execute();
        actual = testStack.pop();
        expected = Complex.ZERO;
        assertEquals(actual, expected); 
    }
    
    /**
     * Test of execute method with a one element stack
     */
    @Test
    public void testExecuteOneElementStack() { 
        System.out.println("testing the execution on a one element stack");
        Complex z = new Complex(5.0, -5.0);
        testStack.push(z);
        sub.execute();
        actual = testStack.pop();
        expected = z;
        assertEquals(actual, expected); 
    }
    
    /**
     * Test of execute method beetween elements of from the first quadrant
     */
    @Test  
    public void testExecuteFirstQuadrant(){ 
        System.out.println("testing the execution beetween elements of from the first quadrant");
        testStack.push(new Complex(1.0));
        testStack.push(new Complex(2.0, 1.0));
        sub.execute();
        actual = testStack.pop();
        expected = new Complex(-1.0, -1.0);
        assertEquals(actual, expected);
    }
    /**
     * Test of execute method beetween elements of from the first and second quadrant
     */
    @Test
    public void testExecuteFirstSecondQuadrant(){ 
        System.out.println("testing the execution beetween elements of from the first and second quadrants");    
        testStack.push(new Complex(1.0));
        testStack.push(new Complex(-1.0, 1.0));
        sub.execute();
        actual = testStack.pop();
        expected = new Complex(2.0 , -1.0);
        assertEquals(actual, expected);
    }

    /**
    * Test of execute method beetween elements of from the first and third quadrants
    */
    @Test
    public void testExecuteFirstThirdQuadrant(){
        System.out.println("testing the execution beetween elements of from the first and third quadrants");
        testStack.push(new Complex(1.0));
        testStack.push(new Complex(-1.0, -1.0));
        sub.execute();
        actual = testStack.pop();
        expected = new Complex(2.0, 1.0);
        assertEquals(actual, expected);
    }

    /**
     * Test of execute method beetween elements of from the first and fourth quadrants
     */
    @Test
    public void testExecuteFirstFourthQuadrant(){
        System.out.println("testing the execution beetween elements of from the first and fourth quadrants");
        testStack.push(new Complex(1.0));
        testStack.push(new Complex(1.0, -1.0)); 
        sub.execute();
        actual = testStack.pop();
        expected = new Complex(0.0, +1.0);
        assertEquals(actual, expected);      
    }

    /**
     * Test of execute method beetween elements of from the second quadrant
     */
    @Test
    public void testExecuteSecondQuadrant(){
        System.out.println("testing the execution beetween elements of from the second quadrant");
        testStack.push(new Complex(-1.0, 3.0)); 
        testStack.push(new Complex(-2.0, 1.0)); 
        sub.execute();
        actual = testStack.pop();
        expected = new Complex(1.0, 2.0);
        assertEquals(actual, expected); 
    }
    
    /**
     * Test of execute method beetween elements of from the second and third quadrants
     */
    @Test 
    public void testExecuteSecondThirdQuadrant(){ 
        System.out.println("testing the execution beetween elements of from the second and third quadrants");                                        
        testStack.push(new Complex(-1.0, 3.0)); 
        testStack.push(new Complex(-2.0, -1.0));  
        sub.execute();
        actual = testStack.pop();
        expected = new Complex(1.0, 4.0);
        assertEquals(actual, expected); 
    }
    
    /**
     * Test of execute method beetween elements of from the second and fourth quadrants
     */
    @Test
    public void testExecuteSecondFourthQuadrant(){
        System.out.println("testing the execution beetween elements of from the second and fourth quadrants");
        testStack.push(new Complex(-1.0, 3.0)); 
        testStack.push(new Complex(2.0, -1.0));
        sub.execute();
        actual = testStack.pop();
        expected = new Complex(-3.0, 4.0);
        assertEquals(actual, expected);
    }
    
    /**
     * Test of execute method beetween elements of from the third quadrant
     */
    @Test
    public void testExecuteThirdQuadrant(){   
        System.out.println("testing the execution beetween elements of from the third quadrant");
        testStack.push(new Complex(-1.0, -2.0)); 
        testStack.push(new Complex(-2.0, -1.0));
        sub.execute();
        actual = testStack.pop();
        expected = new Complex(1.0, -1.0);
        assertEquals(actual, expected); 
    }
    
    /**
     * Test of execute method beetween elements of from the third and fourth quadrants
     */
    @Test
    public void testExecuteThirdFourthQuadrant(){   
        System.out.println("testing the execution beetween elements of from the third and fourth quadrants");
        testStack.push(new Complex(-1.0, -2.0)); 
        testStack.push(new Complex(2.0, -1.0));
        sub.execute();
        actual = testStack.pop();
        expected = new Complex(-3.0, -1.0);
        assertEquals(actual, expected); 
    }
    
    /**
     * Test of execute method beetween elements of from the fourth quadrant
     */
    @Test
    public void testExecuteFourthQuadrant(){
        System.out.println("testing the execution beetween elements of from the fourth quadrant");
        testStack.push(new Complex(3.0, -3.0)); 
        testStack.push(new Complex(2.0, -1.0));  
        sub.execute();
        actual = testStack.pop();
        expected = new Complex(1.0, -2.0);
        assertEquals(actual, expected); 
    }
    
    /**
     * Test of execute method when the result is 1
     */
    @Test
    public void testExecuteResultOne(){
        System.out.println("testing the  execution when the result is 1");    
        testStack.push(new Complex(3.0, -1.0)); 
        testStack.push(new Complex(2.0, -1.0)); 
        sub.execute();
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
        testStack.push(new Complex(1.0));
        testStack.push(new Complex(1.0));
        sub.execute();
        actual = testStack.pop();
        expected = Complex.ZERO;
        assertEquals(actual, expected); 
    }
}
