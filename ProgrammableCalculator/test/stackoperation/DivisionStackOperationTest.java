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
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Matteo Di Rienzo
 */
public class DivisionStackOperationTest {
   
    private final CalculatorStack testStack = new CalculatorStack();
    DivisionStackOperation div = new DivisionStackOperation(testStack);
    
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    
    @Test
    public void testExceptionExecute(){
        exceptionRule.expect(DivideByZeroException.class);
        testStack.push(new Complex(5.0, -5.0));
        testStack.push(Complex.ZERO);
        div.execute();
    }
    
    
    /**
     * Test of execute method, of class divtractionStackOperation.
     */
    @Test
    public void testExecute() {
        div.execute();
        Complex actual = testStack.pop();
        Complex expected = Complex.ZERO;
        assertEquals(actual, expected); 
       
        
        Complex z = new Complex(5.0, -5.0);
        testStack.push(z);
        div.execute();
        actual = testStack.pop();
        expected = z;
        assertEquals(actual, expected); 
        
        
        testStack.push(new Complex(1.0));
        testStack.push(new Complex(2.0, 1.0));
        div.execute();
        actual = testStack.pop();
        expected = new Complex(0.4, -0.2);
        assertEquals(actual, expected);
        
        testStack.push(new Complex(1.0));
        testStack.push(new Complex(1.0, 1.0));
        div.execute();
        actual = testStack.pop();
        expected = new Complex(0.5, -0.5);
        assertEquals(actual, expected);
        
        testStack.push(new Complex(1.0));
        testStack.push(new Complex(-1.0, -1.0));
        div.execute();
        actual = testStack.pop();
        expected = new Complex(-0.5, 0.5);
        assertEquals(actual, expected);
       
        testStack.push(new Complex(1.0));
        testStack.push(new Complex(1.0, -1.0)); 
        div.execute();
        actual = testStack.pop();
        expected = new Complex(0.5, +0.5);
        assertEquals(actual, expected);      
                                                       
        testStack.push(new Complex(-1.0, 3.0)); 
        testStack.push(new Complex(-2.0, 1.0)); 
        div.execute();
        actual = testStack.pop();
        expected = new Complex(1.0, -1.0);
        assertEquals(actual, expected); 
         
                                            
        testStack.push(new Complex(-1.0, 3.0)); 
        testStack.push(new Complex(-2.0, -1.0));  
        div.execute();
        actual = testStack.pop();
        expected = new Complex(-0.2, -1.4);
        assertEquals(actual, expected); 
                
        testStack.push(new Complex(-1.0, 3.0)); 
        testStack.push(new Complex(2.0, -1.0));
        div.execute();
        actual = testStack.pop();
        expected = new Complex(-1, 1);
        assertEquals(actual, expected);
        
        testStack.push(new Complex(-1.0, -2.0)); 
        testStack.push(new Complex(-2.0, -1.0));
        div.execute();
        actual = testStack.pop();
        expected = new Complex(0.8, 0.6);
        assertEquals(actual, expected); 
              
        testStack.push(new Complex(-1.0, -2.0)); 
        testStack.push(new Complex(2.0, -1.0));
        div.execute();
        actual = testStack.pop();
        expected = new Complex(0, -1.0);
        assertEquals(actual, expected); 
        
        testStack.push(new Complex(3.0, -3.0)); 
        testStack.push(new Complex(2.0, -1.0));  
        div.execute();
        actual = testStack.pop();
        expected = new Complex(1.8, -0.6);
        assertEquals(actual, expected);
        
        
        testStack.push(new Complex(3.0, -1.0)); 
        testStack.push(new Complex(3.0, -1.0)); 
        div.execute();
        actual = testStack.pop();
        expected = Complex.ONE;
        assertEquals(actual, expected); 
          
                                                       
        testStack.push(Complex.ZERO);
        testStack.push(new Complex(1.0));
        div.execute();
        actual = testStack.pop();
        expected = Complex.ZERO;
        assertEquals(actual, expected);
        
       
    }
}
