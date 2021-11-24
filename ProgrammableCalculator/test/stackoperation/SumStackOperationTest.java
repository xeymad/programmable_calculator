package stackoperation;

import org.apache.commons.math3.complex.Complex;
import org.junit.Test;
import static org.junit.Assert.*;
import calculatorstack.CalculatorStack;
/**
 *
 * @author Utente
 */
public class SumStackOperationTest {

    private final CalculatorStack testStack = new CalculatorStack();
      
    /**
     * Test of execute method, of class SumStackOperation.
     */
    @Test
    public void testExecute() {
        SumStackOperation sum = new SumStackOperation(testStack);
        
        Complex x = new Complex(5,-5);
        testStack.push(x);
        sum.execute();
        Complex actual = testStack.pop();
        Complex expected = x;
        assertEquals(actual, expected);
        
        sum.execute();
        actual = testStack.pop();
        expected = Complex.ZERO;
        assertEquals(actual, expected);
        
        testStack.push(new Complex( 2.0, 1.0));
        testStack.push(new Complex(1.0, 2.0));
        sum.execute();
        actual = testStack.pop();
        expected = new Complex(3.0, 3.0);
        assertEquals(actual, expected);
        
        testStack.push(new Complex( -1.0, 1.0));
        testStack.push(new Complex(1.0, 2.0));
        sum.execute();
        actual = testStack.pop();
        expected = new Complex(0.0 , 3.0);
        assertEquals(actual, expected);
        
        testStack.push(new Complex( -1.0, -1.0));
        testStack.push(new Complex(1.0, 2.0));
        sum.execute();
        actual = testStack.pop();
        expected = new Complex(0.0, 1.0);
        assertEquals(actual, expected);

        testStack.push(new Complex(1.0, -1.0)); 
        testStack.push(new Complex(1.0, 3.0));
        sum.execute();
        actual = testStack.pop();
        expected = new Complex(2.0, 2.0);
        assertEquals(actual, expected);  
        
        testStack.push(new Complex(-2.0, 1.0)); 
        testStack.push(new Complex(-1.0, 3.0));
        sum.execute();
        actual = testStack.pop();
        expected = new Complex(-3.0, 4.0);
        assertEquals(actual, expected); 
        
        testStack.push(new Complex(-2.0, -1.0));         
        testStack.push(new Complex(-1.0, 3.0)); 
        sum.execute();
        actual = testStack.pop();
        expected = new Complex(-3.0, 2.0);
        assertEquals(actual, expected); 
        
        testStack.push(new Complex(2.0, -1.0));
        testStack.push(new Complex(-1.0, 3.0)); 
        sum.execute();
        actual = testStack.pop();
        expected = new Complex(1.0, 2.0);
        assertEquals(actual, expected); 
        
        testStack.push(new Complex(-2.0, -1.0));
        testStack.push(new Complex(-1.0, -2.0)); 
        sum.execute();
        actual = testStack.pop();
        expected = new Complex(-3.0, -3.0);
        assertEquals(actual, expected); 
        
        testStack.push(new Complex(2.0, -1.0));
        testStack.push(new Complex(-1.0, -2.0)); 
        sum.execute();
        actual = testStack.pop();
        expected = new Complex(1.0, -3.0);
        assertEquals(actual, expected); 
        
        testStack.push(new Complex(2.0, -1.0));
        testStack.push(new Complex(3.0, -3.0)); 
        sum.execute();
        actual = testStack.pop();
        expected = new Complex(5.0, -4.0);
        assertEquals(actual, expected); 
        
        testStack.push(new Complex(-2.0, 1.0));  
        testStack.push(new Complex(3.0, -1.0)); 
        sum.execute();
        actual = testStack.pop();
        expected = Complex.ONE;
        assertEquals(actual, expected);   
        
        testStack.push(new Complex(-1.0, -1.0));
        testStack.push(new Complex(1.0, 1.0));
        sum.execute();
        actual = testStack.pop();
        expected = Complex.ZERO;
        assertEquals(actual, expected);
        
    }
    
}
