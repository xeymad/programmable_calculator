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
/**
 *
 * @author Utente
 */
public class SubtractionStackOperationTest {
    
    private final CalculatorStack testStack = new CalculatorStack();
    
    
    /**
     * Test of execute method, of class SubtractionStackOperation.
     */
    @Test
    public void testExecute() {
       SubtractionStackOperation sub = new SubtractionStackOperation(testStack);
        
        sub.execute();
        Complex actual = testStack.pop();
        Complex expected = Complex.ZERO;
        assertEquals(actual, expected); 
       
        Complex z = new Complex(5.0, -5.0);
        testStack.push(z);
        sub.execute();
        actual = testStack.pop();
        expected = z;
        assertEquals(actual, expected); 
        
        testStack.push(new Complex(1.0));
        testStack.push(new Complex(2.0, 1.0));
        sub.execute();
        actual = testStack.pop();
        expected = new Complex(-1.0, -1.0);
        assertEquals(actual, expected);
        
        testStack.push(new Complex(1.0));
        testStack.push(new Complex(-1.0, 1.0));
        sub.execute();
        actual = testStack.pop();
        expected = new Complex(2.0 , -1.0);
        assertEquals(actual, expected);
        
        testStack.push(new Complex(1.0));
        testStack.push(new Complex(-1.0, -1.0));
        sub.execute();
        actual = testStack.pop();
        expected = new Complex(2.0, 1.0);
        assertEquals(actual, expected);
       
        testStack.push(new Complex(1.0));
        testStack.push(new Complex(1.0, -1.0)); 
        sub.execute();
        actual = testStack.pop();
        expected = new Complex(0.0, +1.0);
        assertEquals(actual, expected);      
                                                       
        testStack.push(new Complex(-1.0, 3.0)); 
        testStack.push(new Complex(-2.0, 1.0)); 
        sub.execute();
        actual = testStack.pop();
        expected = new Complex(1.0, 2.0);
        assertEquals(actual, expected); 
         
                                            
        testStack.push(new Complex(-1.0, 3.0)); 
        testStack.push(new Complex(-2.0, -1.0));  
        sub.execute();
        actual = testStack.pop();
        expected = new Complex(1.0, 4.0);
        assertEquals(actual, expected); 
                
        testStack.push(new Complex(-1.0, 3.0)); 
        testStack.push(new Complex(2.0, -1.0));
        sub.execute();
        actual = testStack.pop();
        expected = new Complex(-3.0, 4.0);
        assertEquals(actual, expected);
                
        testStack.push(new Complex(-1.0, -2.0)); 
        testStack.push(new Complex(-2.0, -1.0));
        sub.execute();
        actual = testStack.pop();
        expected = new Complex(1.0, -1.0);
        assertEquals(actual, expected); 
                
        testStack.push(new Complex(-1.0, -2.0)); 
        testStack.push(new Complex(2.0, -1.0));
        sub.execute();
        actual = testStack.pop();
        expected = new Complex(-3.0, -1.0);
        assertEquals(actual, expected); 
        
        testStack.push(new Complex(3.0, -3.0)); 
        testStack.push(new Complex(2.0, -1.0));  
        sub.execute();
        actual = testStack.pop();
        expected = new Complex(1.0, -2.0);
        assertEquals(actual, expected); 
        
        testStack.push(new Complex(3.0, -1.0)); 
        testStack.push(new Complex(2.0, -1.0)); 
        sub.execute();
        actual = testStack.pop();
        expected = Complex.ONE;
        assertEquals(actual, expected); 
        
                                                       
        testStack.push(new Complex(1.0));
        testStack.push(new Complex(1.0));
        sub.execute();
        actual = testStack.pop();
        expected = Complex.ZERO;
        assertEquals(actual, expected);
        
    }
    
}
