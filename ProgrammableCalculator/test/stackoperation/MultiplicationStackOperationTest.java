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

/**
 *
 * @author Arianna Carratù
 */
public class MultiplicationStackOperationTest {
    
    private final CalculatorStack testStack = new CalculatorStack();
    MultiplicationStackOperation mul = new MultiplicationStackOperation(testStack);

    /**
     * Test Case 1: multiplication with a single number on the stack
     */
    @Test
    public void testSingleNumber() {
        
        Complex x = new Complex(5,-5);
        testStack.push(x);
        mul.execute();
        Complex actual = testStack.pop();
        Complex expected = x;
        assertEquals(actual, expected);
    }  
    
    /**
     *Test Case 2: multiplication with no numbers on the stack
     */
    @Test
    public void testNoNumbers() {
        mul.execute();
        Complex actual = testStack.pop();
        Complex expected = Complex.ZERO;
        assertEquals(actual, expected);
    } 
    
    /**
     *Test Case 3: multiplication between two complex numbers both belonging to the first quadrant
     */
    @Test
    public void testFirstQuadrant() {
        testStack.push(new Complex( 2.0, 1.0));
        testStack.push(new Complex(1.0, 2.0));
        mul.execute();
        Complex actual = testStack.pop();
        Complex expected = new Complex(0.0, 5.0);
        assertEquals(actual, expected);
    }  
    
    /**
     *Test Case 4: multiplication between two complex numbers, one belonging to the second quadrant, the other to the first
     */
    @Test
    public void testSecondFirstQuadrant() {
        testStack.push(new Complex( -1.0, 1.0));
        testStack.push(new Complex(1.0, 2.0));
        mul.execute();
        Complex actual = testStack.pop();
        Complex expected = new Complex(-3.0, -1.0);
        assertEquals(actual, expected);
    }   
    
    /**
     *Test Case 5: multiplication between two complex numbers, one belonging to the third quadrant, the other to the first
     */
    @Test
    public void testThirdFirstQuadrant() {
        testStack.push(new Complex( -1.0, -1.0));
        testStack.push(new Complex(1.0, 2.0));
        mul.execute();
        Complex actual = testStack.pop();
        Complex expected = new Complex(1.0, -3.0);
        assertEquals(actual, expected);
    }  
    
    /**
     *Test Case 6: multiplication between two complex numbers, one belonging to the fourth quadrant, the other to the first
     */
    @Test
    public void testFourthFirstQuadrant() {
        testStack.push(new Complex(1.0, -1.0)); 
        testStack.push(new Complex(1.0, 3.0));
        mul.execute();
        Complex actual = testStack.pop();
        Complex expected = new Complex(4.0, 2.0);
        assertEquals(actual, expected);  
    } 
    
    /**
     *Test Case 7: multiplication between two complex numbers both belonging to the second quadrant
     */
    @Test
    public void testSecondQuadrant() {
        testStack.push(new Complex(-2.0, 1.0)); 
        testStack.push(new Complex(-1.0, 3.0));
        mul.execute();
        Complex actual = testStack.pop();
        Complex expected = new Complex(-1.0, -7.0);
        assertEquals(actual, expected); 
    } 
    
    /**
     *Test Case 8: multiplication between two complex numbers, one belonging to the third quadrant, the other to the second
     */
    @Test
    public void testThirdSecondQuadrant() {
        testStack.push(new Complex(-2.0, -1.0));         
        testStack.push(new Complex(-1.0, 3.0)); 
        mul.execute();
        Complex actual = testStack.pop();
        Complex expected = new Complex(5.0, -5.0);
        assertEquals(actual, expected); 
    } 
    
    /**
     *Test Case 9: multiplication between two complex numbers, one belonging to the fourth quadrant, the other to the second
     */
    @Test
    public void testFourthSecondQuadrant() {
        testStack.push(new Complex(2.0, -1.0));
        testStack.push(new Complex(-1.0, 3.0)); 
        mul.execute();
        Complex actual = testStack.pop();
        Complex expected = new Complex(1.0, 7.0);
        assertEquals(actual, expected); 
    }  
    
    /**
     *Test Case 10: multiplication between two complex numbers both belonging to the third quadrant
     */
    @Test
    public void testThirdQuadrant() {
        testStack.push(new Complex(-2.0, -1.0));
        testStack.push(new Complex(-1.0, -2.0)); 
        mul.execute();
        Complex actual = testStack.pop();
        Complex expected = new Complex(0.0, 5.0);
        assertEquals(actual, expected); 
    }  
    
    /**
     *Test Case 11: multiplication between two complex numbers,one belonging to the fourth quadrant, the other to the third
     */
    @Test
    public void testFourthThirdQuadrant() {
        testStack.push(new Complex(2.0, -1.0));
        testStack.push(new Complex(-1.0, -2.0)); 
        mul.execute();
        Complex actual = testStack.pop();
        Complex expected = new Complex(-4.0, -3.0);
        assertEquals(actual, expected); 
    } 
    
    /**
     *Test Case 12: multiplication between two complex numbers both belonging to the fourth quadrant
     */
    @Test
    public void testFourthQuadrant() {
        testStack.push(new Complex(2.0, -1.0));
        testStack.push(new Complex(3.0, -3.0)); 
        mul.execute();
        Complex actual = testStack.pop();
        Complex expected = new Complex(3.0, -9.0);
        assertEquals(actual, expected); 
    }  
    
    /**
     *Test Case 13: multiplication between two zeros
     */
    @Test
    public void testTwoZeros() {
        testStack.push(Complex.ZERO);
        testStack.push(Complex.ZERO);
        mul.execute();
        Complex actual = testStack.pop();
        Complex expected =Complex.ZERO;
        assertEquals(actual, expected);
    } 
    
    /**
     *Test Case 14: multiplication between zero and a complex number
     */
    @Test
    public void testZero() {
        testStack.push(Complex.ZERO);
        testStack.push(new Complex(75.0, 5.0));
        mul.execute();
        Complex actual = testStack.pop();
        Complex expected =Complex.ZERO;
        assertEquals(actual, expected);
    }  
    
    /**
     *Test Case 15: multiplication between two ones
     */
    @Test
    public void testTwoOnes() { 
        testStack.push(Complex.ONE);
        testStack.push(Complex.ONE);
        mul.execute();
        Complex actual = testStack.pop();
        Complex expected =Complex.ONE;
        assertEquals(actual, expected);
    }    
    
    
}
