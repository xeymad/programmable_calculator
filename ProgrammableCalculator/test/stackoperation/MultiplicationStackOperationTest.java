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
    

    /**
     * Test of execute method, of class MultiplicationStackOperation.
     */
    @Test
    public void testExecute() {
        MultiplicationStackOperation mul = new MultiplicationStackOperation(testStack);
        
        //Test Case 1: multiplication with a single number on the stack
        Complex x = new Complex(5,-5);
        testStack.push(x);
        mul.execute();
        Complex actual = testStack.pop();
        Complex expected = x;
        assertEquals(actual, expected);
        
        //Test Case 2: multiplication with no numbers on the stack
        mul.execute();
        actual = testStack.pop();
        expected = Complex.ZERO;
        assertEquals(actual, expected);
        
        //Test Case 3: multiplication between two complex numbers both belonging to the first quadrant
        testStack.push(new Complex( 2.0, 1.0));
        testStack.push(new Complex(1.0, 2.0));
        mul.execute();
        actual = testStack.pop();
        expected = new Complex(0.0, 5.0);
        assertEquals(actual, expected);
        
        //Test Case 4: multiplication between two complex numbers, one belonging to the second quadrant, the other to the first
        testStack.push(new Complex( -1.0, 1.0));
        testStack.push(new Complex(1.0, 2.0));
        mul.execute();
        actual = testStack.pop();
        expected = new Complex(-3.0, -1.0);
        assertEquals(actual, expected);
        
        //Test Case 5: multiplication between two complex numbers, one belonging to the third quadrant, the other to the first
        testStack.push(new Complex( -1.0, -1.0));
        testStack.push(new Complex(1.0, 2.0));
        mul.execute();
        actual = testStack.pop();
        expected = new Complex(1.0, -3.0);
        assertEquals(actual, expected);
        
        //Test Case 6: multiplication between two complex numbers, one belonging to the fourth quadrant, the other to the first
        testStack.push(new Complex(1.0, -1.0)); 
        testStack.push(new Complex(1.0, 3.0));
        mul.execute();
        actual = testStack.pop();
        expected = new Complex(4.0, 2.0);
        assertEquals(actual, expected);  
        
        //Test Case 7: multiplication between two complex numbers both belonging to the second quadrant
        testStack.push(new Complex(-2.0, 1.0)); 
        testStack.push(new Complex(-1.0, 3.0));
        mul.execute();
        actual = testStack.pop();
        expected = new Complex(-1.0, -7.0);
        assertEquals(actual, expected); 
        
        //Test Case 8: multiplication between two complex numbers, one belonging to the third quadrant, the other to the second
        testStack.push(new Complex(-2.0, -1.0));         
        testStack.push(new Complex(-1.0, 3.0)); 
        mul.execute();
        actual = testStack.pop();
        expected = new Complex(5.0, -5.0);
        assertEquals(actual, expected); 
        
        //Test Case 9: multiplication between two complex numbers, one belonging to the fourth quadrant, the other to the second
        testStack.push(new Complex(2.0, -1.0));
        testStack.push(new Complex(-1.0, 3.0)); 
        mul.execute();
        actual = testStack.pop();
        expected = new Complex(1.0, 7.0);
        assertEquals(actual, expected); 
        
        //Test Case 10: multiplication between two complex numbers both belonging to the third quadrant
        testStack.push(new Complex(-2.0, -1.0));
        testStack.push(new Complex(-1.0, -2.0)); 
        mul.execute();
        actual = testStack.pop();
        expected = new Complex(0.0, 5.0);
        assertEquals(actual, expected); 
        
        //Test Case 11: multiplication between two complex numbers,one belonging to the fourth quadrant, the other to the third
        testStack.push(new Complex(2.0, -1.0));
        testStack.push(new Complex(-1.0, -2.0)); 
        mul.execute();
        actual = testStack.pop();
        expected = new Complex(-4.0, -3.0);
        assertEquals(actual, expected); 
        
        //Test Case 12: multiplication between two complex numbers both belonging to the fourth quadrant
        testStack.push(new Complex(2.0, -1.0));
        testStack.push(new Complex(3.0, -3.0)); 
        mul.execute();
        actual = testStack.pop();
        expected = new Complex(3.0, -9.0);
        assertEquals(actual, expected); 
        
        //Test Case 14: multiplication between two complex numbers,one belonging to the second quadrant, the other to the fourth
        testStack.push(new Complex(-2.0, 1.0));  
        testStack.push(new Complex(3.0, -1.0)); 
        mul.execute();
        actual = testStack.pop();
        expected = new Complex(-5.0, 5.0);
        assertEquals(actual, expected);   
        
        //Test Case 15: multiplication between two complex numbers,one belonging to the third quadrant, the other to the first
        testStack.push(new Complex(-1.0, -1.0));
        testStack.push(new Complex(1.0, 1.0));
        mul.execute();
        actual = testStack.pop();
        expected =  new Complex(0.0, -2.0);
        assertEquals(actual, expected);
        
        //Test Case 16: multiplication between two zeros
        testStack.push(Complex.ZERO);
        testStack.push(Complex.ZERO);
        mul.execute();
        actual = testStack.pop();
        expected =Complex.ZERO;
        assertEquals(actual, expected);
        
        //Test Case 17: multiplication between zero and a complex number
        testStack.push(Complex.ZERO);
        testStack.push(new Complex(75.0, 5.0));
        mul.execute();
        actual = testStack.pop();
        expected =Complex.ZERO;
        assertEquals(actual, expected);
        
        //Test Case 18: multiplication between two ones
        testStack.push(Complex.ONE);
        testStack.push(Complex.ONE);
        mul.execute();
        actual = testStack.pop();
        expected =Complex.ONE;
        assertEquals(actual, expected);
        
    }
    
}
